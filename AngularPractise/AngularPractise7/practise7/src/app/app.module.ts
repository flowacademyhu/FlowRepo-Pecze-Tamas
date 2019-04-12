import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { ChampionshipComponent } from './championship/championship.component';
import { ManUtdComponent } from './man-utd/man-utd.component';
import { ArsenalComponent } from './arsenal/arsenal.component';
import { LiverpoolComponent } from './liverpool/liverpool.component';

@NgModule({
  declarations: [
    AppComponent,
    ChampionshipComponent,
    ManUtdComponent,
    ArsenalComponent,
    LiverpoolComponent
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
