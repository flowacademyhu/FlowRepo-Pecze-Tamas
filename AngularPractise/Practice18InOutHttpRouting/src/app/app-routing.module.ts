import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KidoneComponent } from './kidone/kidone.component';
import { KidtwoComponent } from './kidtwo/kidtwo.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  { path: 'landingcomponent', redirectTo: '/landingcomponent', pathMatch: 'full'},
  { path: 'kidone', component: KidoneComponent },
  { path: 'kidtwo', component: KidtwoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
