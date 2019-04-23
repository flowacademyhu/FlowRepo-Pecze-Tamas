import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Iinterface } from './theinterface';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TheServiceService {
  constructor(private http: HttpClient) { }
  getServiceInfo() {
    return 'Offline';
  }
  errorHandler(error: HttpErrorResponse) {
    alert(error.message);
    return throwError(error.message);
  }
  getDataHttpParty(): Observable<Iinterface> {
    return this.http.get<Iinterface>('httpes://pokeapi.co/api/v2/pokemon/')
    .pipe(catchError(this.errorHandler));
  }
}
