import { Injectable } from '@angular/core';
import { InforMATION } from 'src/app/inforMATION.module';

@Injectable()

export class TaskService {

  constructor() { }

  save(incoming: InforMATION) {
    console.log(incoming.name);
  }
}
