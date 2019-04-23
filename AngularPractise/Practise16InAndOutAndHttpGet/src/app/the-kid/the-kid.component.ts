import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { TheServiceService } from '../the-service.service';

@Component({
  selector: 'app-the-kid',
  templateUrl: './the-kid.component.html',
  styleUrls: ['./the-kid.component.css']
})
export class TheKidComponent implements OnInit {
  @Output()
  Antenna = new EventEmitter();
  thekidvariable = 'hello, i`m kiddo';
  serverinfo = 'Waiting for server information...';
  httpData;
  errorMsg = 'Error?';
  constructor(private service: TheServiceService) { }

  ngOnInit() {
    this.serverinfo = this.service.getServiceInfo();
    this.service.getDataHttpParty().subscribe(data => this.httpData = data,
                                              error => this.errorMsg = error);
  }
  happening() {
    this.Antenna.emit(this.thekidvariable);
  }
  getKeys() {

  }
}
