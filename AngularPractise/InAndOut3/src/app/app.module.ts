import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ThekidComponent } from './thekid/thekid.component';
import { SzerviszeljService } from './szerviszelj.service';

@NgModule({
  declarations: [
    AppComponent,
    ThekidComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [SzerviszeljService],
  bootstrap: [AppComponent]
})
export class AppModule { }
