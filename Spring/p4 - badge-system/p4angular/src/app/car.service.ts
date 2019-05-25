import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  public baseUrl: string = '//localhost:8080';

  constructor(private http: HttpClient) { }
  public getAllItems(): Observable<any> {
    return this.http.get(this.baseUrl + '/todolist/list-items');
}
}
