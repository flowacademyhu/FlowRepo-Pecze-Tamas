import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FruitsComponent } from './fruits/fruits.component';
import { AppleComponent } from './apple/apple.component';
import { PearComponent } from './pear/pear.component';
import { PeachComponent } from './peach/peach.component';

const route: Routes = [
  {path: '', component: FruitsComponent},
  {path: 'apple', component: AppleComponent},
  {path: 'pear', component: PearComponent},
  {path: 'peach', component: PeachComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    FruitsComponent,
    AppleComponent,
    PearComponent,
    PeachComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(route)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
