import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  status = 'doneweq';
  name = 'Pecze';
  counter:number = 0;
  tomby: Array<string> = ['falevel', 'salata', 'repa', 'feherrepa'];
  greeter () {
    alert("Hello " + this.name + "!" + this.counter);
    this.counter++;
} 
alert2 () {
  alert('Kutya');
}
deleter () {
  this.name = '';
}
methody():String {
  if (this.name.length > 3) {
return 'blue';
  }
}
tasks() {

}
}
