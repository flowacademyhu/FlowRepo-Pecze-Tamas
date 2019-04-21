import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-kidtwo',
  templateUrl: './kidtwo.component.html',
  styleUrls: ['./kidtwo.component.css']
})
export class KidtwoComponent implements OnInit {
  @Input()
  titlesent = '';
  @Output()
  Antenna = new EventEmitter();
  ertek = 'Waiting for DataService';
  pokemonparty = [];
  errorMsg = '';
  constructor(private incoming: DataService) { }

  ngOnInit() {
    this.ertek = this.incoming.sending();
    this.incoming.getData().subscribe(data => this.pokemonparty = data,
      error => this.errorMsg = error);
  }
  mouseHasEntered() {
    this.SendingDataToParent();
  }
  SendingDataToParent() {
    this.Antenna.emit('I came from kid two!');
  }

}
