export interface Task {
  taskId?: number;
  task_title: string;
  taskDesc: string;
  taskStatus: 'Open' | 'Inprogress' | 'Completed';
  scheduledDate: string;
  createdDt?: string;
  updatedDt?: string;
}