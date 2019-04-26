import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KidtwoComponent } from './kidtwo/kidtwo.component';
import { PokemonHTMLComponent } from './pokemon-html/pokemon-html.component';

const routes: Routes = [
  { path: 'kidtwo/:id', component: KidtwoComponent },
  { path: 'pokemon-html', component: PokemonHTMLComponent},
  { path: 'pokemon-html/:stringholder', component: PokemonHTMLComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
