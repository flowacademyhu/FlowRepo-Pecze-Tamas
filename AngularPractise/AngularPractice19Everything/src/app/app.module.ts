import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { KidoneComponent } from './kidone/kidone.component';
import { KidtwoComponent } from './kidtwo/kidtwo.component';
import { PokemonHTMLComponent } from './pokemon-html/pokemon-html.component';
import { InfoService } from './info.service';

@NgModule({
  declarations: [
    AppComponent,
    KidoneComponent,
    KidtwoComponent,
    PokemonHTMLComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [InfoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
