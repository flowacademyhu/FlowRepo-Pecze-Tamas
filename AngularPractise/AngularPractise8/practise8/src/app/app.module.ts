import { BrowserModule } from '@angular/platform-browser';
import { NgModule, EventEmitter, Injectable, HostListener } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { TaskListComponent } from './tasks/task-list/task-list.component';
import { TaskComponent } from './tasks/task/task.component';
import { TaskServiceService } from './task-service.service';
import { HttpClientModule } from '@angular/common/http';
import { Task6Directive } from './task6.directive';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TaskListComponent,
    TaskComponent,
    Task6Directive
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule
  ],
  providers: [TaskServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
