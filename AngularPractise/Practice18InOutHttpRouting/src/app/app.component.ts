import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Practice18InOutHttpRouting';
  message = 'empty!';
  check() {
    alert(this.message);
  }
}
