import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable()
export class StarWarsService {

  getPeople() {
    return this.http.get('https://swapi.co/api/people/');
  }
  constructor(private http: HttpClient) { }
}
