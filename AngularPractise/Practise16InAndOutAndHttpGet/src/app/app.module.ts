import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { TheKidComponent } from './the-kid/the-kid.component';
import { TheServiceService } from './the-service.service';

@NgModule({
  declarations: [
    AppComponent,
    TheKidComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [TheServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
