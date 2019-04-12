import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CarService } from './car.service';
import { AppComponent } from './app.component';
import { CarsComponent } from './cars/cars.component';

@NgModule({
  declarations: [
    AppComponent, CarService, CarsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
