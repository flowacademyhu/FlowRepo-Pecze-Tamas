import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowhideComponent } from './showhide/showhide.component';
import { KidComponent } from './kid/kid.component';

const routes: Routes = [
  { path: 'showhide', component: ShowhideComponent },
  { path: 'kid/:id', component: KidComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
