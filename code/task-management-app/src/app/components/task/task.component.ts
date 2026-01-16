import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TaskService } from '../../services/task.service';
import { Task } from '../../models/task.model';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  taskForm: FormGroup;
  tasks: Task[] = [];
  isEditMode = false;
  selectedTaskId: number | null = null;
  statusOptions = ['Open', 'Inprogress', 'Completed'];

  constructor(
    private fb: FormBuilder,
    private taskService: TaskService
  ) {
    this.taskForm = this.fb.group({
      task_title: ['', Validators.required],
      taskDesc: ['', Validators.required],
      taskStatus: ['Open', Validators.required],
      scheduledDate: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks(): void {
    this.taskService.getAllTasks().subscribe(
      (data: Task[]) => {
        this.tasks = data;
      },
      (error: any) => {
        console.error('Error fetching tasks:', error);
        alert('Failed to load tasks');
      }
    );
  }

  onSubmit(): void {
    if (this.taskForm.valid) {
      const taskData: Task = this.taskForm.value;

      if (this.isEditMode && this.selectedTaskId) {
        taskData.taskId = this.selectedTaskId;
        this.taskService.updateTask(taskData).subscribe(
          (response: any) => {
            alert('Task updated successfully!');
            this.resetForm();
            this.loadTasks();
          },
          (error: any) => {
            console.error('Error updating task:', error);
            alert('Failed to update task');
          }
        );
      } else {
        this.taskService.createTask(taskData).subscribe(
          (response: any) => {
            alert('Task created successfully!');
            this.resetForm();
            this.loadTasks();
          },
          (error: any) => {
            console.error('Error creating task:', error);
            alert('Failed to create task');
          }
        );
      }
    } else {
      alert('Please fill all required fields');
    }
  }

  editTask(task: Task): void {
    this.isEditMode = true;
    this.selectedTaskId = task.taskId || null;
    this.taskForm.patchValue({
      task_title: task.task_title,
      taskDesc: task.taskDesc,
      taskStatus: task.taskStatus,
      scheduledDate: task.scheduledDate
    });
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  deleteTask(taskId: number): void {
    if (confirm('Are you sure you want to delete this task?')) {
      this.taskService.deleteTask(taskId).subscribe(
        (response: any) => {
          alert('Task deleted successfully!');
          this.loadTasks();
        },
        (error: any) => {
          console.error('Error deleting task:', error);
          alert('Failed to delete task');
        }
      );
    }
  }

  resetForm(): void {
    this.taskForm.reset({
      task_title: '',
      taskDesc: '',
      taskStatus: 'Open',
      scheduledDate: ''
    });
    this.isEditMode = false;
    this.selectedTaskId = null;
  }

  getStatusClass(status: string): string {
    switch (status) {
      case 'Open':
        return 'status-open';
      case 'Inprogress':
        return 'status-inprogress';
      case 'Completed':
        return 'status-completed';
      default:
        return '';
    }
  }
}