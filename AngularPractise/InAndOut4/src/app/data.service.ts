import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor() { }
  getData() {
    return [
      'sajt', 3,
      'kolbasz', 3,
      'coca-cola', 2,
      'iskolabusz', 1,
      'szivinfarkt', 0
    ];
  }
}
