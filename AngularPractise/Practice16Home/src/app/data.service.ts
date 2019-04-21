import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IPokemon } from './pokemonReceiver';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }
  
  sending() {
    return 'kuldemeny';
  }
  getData(): Observable<IPokemon[]> {
    return this.http.get<IPokemon[]>('https://swapi.co/api/planets/3/')
    .pipe(catchError(this.errorHandler));
  }
  errorHandler(error: HttpErrorResponse) {
    return throwError(error.message);
  }
}
