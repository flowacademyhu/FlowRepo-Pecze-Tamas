import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Iinterface } from './interface1';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InfoService {
  info = 'WTF?';
  constructor(private http: HttpClient) { }
  getInfo() {
    return this.info;
  }
  getData(): Observable<Iinterface> {
    return this.http.get<Iinterface>('https://jsonplaceholder.typicode.com/todos');
  }
}
