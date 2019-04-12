import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { TaskComponent } from './tasks/task/task.component';
import { TaskListComponent } from './tasks/task-list/task-list.component';
import { AttrDirective } from './shared/attr.directive';
import { GoodAttrDirective } from './shared/good-attr.directive';
import { LoggerService } from './shared/logger.service';
import { TaskService } from './tasks/task.service';
import { HttpClientModule } from '../../node_modules/@angular/common/http';
import { TaskEditComponent } from './tasks/task-edit/task-edit.component';
import { LandingComponentComponent } from './landing-component/landing-component.component';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './landing/landing.component';

const VALTOZO: Routes = [
  {path:'', component: LandingComponentComponent},
  {path:'tasks', component: TaskListComponent},
  {path:'tasks/:id', component: TaskEditComponent},
  {path: 'meetings', component: LandingComponentComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TaskComponent,
    TaskListComponent,
    AttrDirective,
    GoodAttrDirective,
    TaskEditComponent,
    LandingComponentComponent,
    LandingComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(VALTOZO)
  ],
  providers: [LoggerService, TaskService],
  bootstrap: [AppComponent]
})
export class AppModule { }
