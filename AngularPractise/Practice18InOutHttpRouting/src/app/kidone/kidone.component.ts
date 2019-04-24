import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { InfoService } from '../info.service';

@Component({
  selector: 'app-kidone',
  templateUrl: './kidone.component.html',
  styleUrls: ['./kidone.component.css']
})
export class KidoneComponent implements OnInit {

  constructor(private info: InfoService) { }
  @Input()
  projectname = 'Waiting...';
  @Output()
  e = new EventEmitter();
  kuldes = 'titkos uzenet, szall a szellel...';
  infoserviceinfo = '';
  receive: any;
  ngOnInit() {
    this.infoserviceinfo = this.info.getInfo();
    this.info.getData().subscribe(data => this.receive = data)
  }
  send() {
    this.e.emit(this.kuldes);
  }
}
