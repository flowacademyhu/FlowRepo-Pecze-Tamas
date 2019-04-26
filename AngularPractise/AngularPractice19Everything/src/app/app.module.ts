import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { KidoneComponent } from './kidone/kidone.component';
import { KidtwoComponent } from './kidtwo/kidtwo.component';

@NgModule({
  declarations: [
    AppComponent,
    KidoneComponent,
    KidtwoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
