import { Component, OnInit } from '@angular/core';
import { InfoService } from '../info.service';
@Component({
  selector: 'app-pokemon-html',
  templateUrl: './pokemon-html.component.html',
  styleUrls: ['./pokemon-html.component.css']
})
export class PokemonHTMLComponent implements OnInit {
  data: any;
  constructor(private service: InfoService) { }

  ngOnInit() {
    this.service.getData().subscribe(data => this.data = data);
  }

}
