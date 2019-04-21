import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { KidoneComponent } from './kidone/kidone.component';
import { KidtwoComponent } from './kidtwo/kidtwo.component';
import { DataService } from './data.service';

@NgModule({
  declarations: [
    AppComponent,
    KidoneComponent,
    KidtwoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
