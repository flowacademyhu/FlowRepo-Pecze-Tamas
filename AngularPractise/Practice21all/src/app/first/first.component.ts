import { Component, OnInit, Input } from '@angular/core';
import { InfoService } from '../info.service';
import { Iinfo } from '../iInfo';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {
  @Input()
  variable = '';
  emsg = 'no error has occured!';
  information: Iinfo;
  constructor(private info: InfoService) { }

  ngOnInit() {
    this.info.getData().subscribe(data => this.information = data,
      error => this.emsg = error);
  }

}
