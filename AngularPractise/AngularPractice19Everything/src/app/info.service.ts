import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ipokemon } from './Ipokemon';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InfoService {

  constructor(private http: HttpClient) { }

  info() {
    return 'fontosInfo!!! hujuj!';
  }
  log(message: string) {
    console.log(message);
  }
  getData(): Observable <Ipokemon> {
    return this.http.get<Ipokemon>('https://pokeapi.co/api/v2/pokemon/');
  }
}
