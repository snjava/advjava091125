import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task.model';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  createTask(task: Task): Observable<any> {
    return this.http.post(`${this.baseUrl}/save-task`, task);
  }

  updateTask(task: Task): Observable<any> {
    return this.http.put(`${this.baseUrl}/update-task`, task);
  }

  getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.baseUrl}/get-all-task`);
  }

  deleteTask(taskId: number): Observable<any> {
    const params = new HttpParams().set('id', taskId.toString());
    return this.http.delete(`${this.baseUrl}/delete-task`, { params });
  }
}