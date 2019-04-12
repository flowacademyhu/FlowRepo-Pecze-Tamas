import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable()
export class ANagyTaskServiceService {
// tslint:disable-next-line: align

user = [{
  id: 1,
  name: 'sajt',
  halasz: true
},{
  id : 2,
  name : 'sajt2',
  halasz : false
}];

  getAll() {
    console.log('siker');
    return this.user;
  }

  constructor(private http: HttpClient) {}
}
