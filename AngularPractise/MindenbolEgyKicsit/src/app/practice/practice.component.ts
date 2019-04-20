import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-practice',
  templateUrl: './practice.component.html',
  styleUrls: ['./practice.component.css']
})
export class PracticeComponent implements OnInit {
  val1: number;
  val2: number;
  val3 = '';
  isCollapsed = false;
  SimpleTestMessage = 'Hello, I`ve been transfered from Practise to second';
  valSUM: number;
  decidion1: boolean;
  checked: boolean;
  array: string[] = [];
  booleanValue = false;
  booleanForbidden = false;
  receivedFun = '';
  sendingBackFun = '';
  
  constructor() { }

  ngOnInit() {
    
  }
  RECEIVER(ADAT: string) {
    this.array.push(ADAT);
  }
  FUNNYRECEIVER(FUN: string) {
    this.receivedFun = FUN;
  }
  sum() {
    this.valSUM = this.val1 + this.val2;
    if (this.valSUM < 100) {
      this.decidion1 = true;
    } else {
      this.decidion1 = false;
    }
  }
  check() {
    if (this.checked === true) {
      this.checked = false;
    } else {
      this.checked = true;
    }
  }
  sumToArray() {
    if(this.array.length < 5) {
      this.array.push(this.val3);
    } else {
      this.booleanForbidden = true;
    }
    this.val3 =  '';
  }
  show() {
    if (this.isCollapsed === true) {
      this.isCollapsed = false;
    } else {
      this.isCollapsed = true;
    }
  }
  funnyVISSZAMENNYE() {
    this.sendingBackFun = this.receivedFun;
    this.DeleteFUN();
  }
  DeleteFUN() {
    this.receivedFun = '';
  }
}
