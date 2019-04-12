import { Injectable } from '@angular/core';

@Injectable()
export class LogServiceService {

  constructor() { }
  log(message: string) {
    console.log(message);
  }
}
