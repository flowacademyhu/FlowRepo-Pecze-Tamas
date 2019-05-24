import { Component, OnInit } from '@angular/core';
import { CarListService } from '../car.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  public listItems: Array<any> = new Array<any>();

  constructor(private carListService: CarListService) { }

  ngOnInit() {
    this.carListService.getAllItems().subscribe(res => {
      this.listItems = res;
});
  }

}
