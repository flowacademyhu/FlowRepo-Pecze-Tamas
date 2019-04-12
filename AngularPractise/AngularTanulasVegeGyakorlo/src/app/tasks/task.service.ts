import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ITask } from './task.model';
@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private httpClient: HttpClient) { }
  getAll() {
    return this.httpClient.get('http://192.168.5.20:4005/tasks/');
  }
  getById(id: number) {
    return this.httpClient.get('http://192.168.5.20:4005/tasks/' + id);
  }
  deleteById(id: number) {
    return this.httpClient.delete('http://192.168.5.20:4005/tasks/' + id);
  }
  save(task: ITask) {
    return this.httpClient.put('http://192.168.5.20:4005/tasks/' + task.id, task);
  }
  create(task: ITask) {
    return this.httpClient.post('http://192.168.5.20:4005/tasks/' , task);
  }
}
