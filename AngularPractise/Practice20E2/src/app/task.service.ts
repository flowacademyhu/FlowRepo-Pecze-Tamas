import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Ipokemon } from 'src/app/Ipokemon';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class TaskService {
  constructor(private http: HttpClient) { }
  log(message: string) {
    console.log(message);
  }
  errorParty(error: HttpErrorResponse) {
    return throwError(error.message);
  }
  getData(): Observable <Ipokemon> {
    return this.http.get<Ipokemon>('https://pokeapi.co/api/v2/pokemon/')
    .pipe(catchError(this.errorParty));
  }
}
