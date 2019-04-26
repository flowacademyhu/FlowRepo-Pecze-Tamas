import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Iinterface } from './interface1';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
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
    return this.http.get<Iinterface>('Qhttps://jsonplaceholder.typicode.com/todos')
    .pipe(catchError(this.ErrorHandler));
  }
  ErrorHandler(error: HttpErrorResponse) {
    return throwError(error.message);
  }
}
