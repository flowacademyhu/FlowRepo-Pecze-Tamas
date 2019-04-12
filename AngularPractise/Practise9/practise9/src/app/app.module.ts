import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ANagyTaskServiceService } from './a-nagy-task-service.service';
import { AppComponent } from './app.component';
import { AKomponensComponent } from './a-komponens/a-komponens.component';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    AKomponensComponent
  ],
  imports: [
    BrowserModule, HttpClientModule
  ],
  providers: [ANagyTaskServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
