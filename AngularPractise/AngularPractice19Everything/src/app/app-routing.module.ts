import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KidoneComponent } from './kidone/kidone.component';
import { KidtwoComponent } from './kidtwo/kidtwo.component';

const routes: Routes = [
  { path: 'kidtwo/:id', component: KidtwoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
