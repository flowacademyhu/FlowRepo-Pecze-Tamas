import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Iinfo } from './iInfo';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class InfoService {

  constructor(private http: HttpClient) { }

  getInfo() {
    return 'important info';
  }
  Errorhandler(error: HttpErrorResponse) {
    return throwError(error.message);
  }
  getData(): Observable<Iinfo> {
    return this.http.get<Iinfo>('https://pokeaewqpi.co/api/v2/pokemon/')
    .pipe(catchError(this.Errorhandler));
  }
}
