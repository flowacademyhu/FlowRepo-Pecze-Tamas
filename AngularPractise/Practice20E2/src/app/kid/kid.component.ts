import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { TaskService } from '../task.service';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-kid',
  templateUrl: './kid.component.html',
  styleUrls: ['./kid.component.css']
})
export class KidComponent implements OnInit {

  constructor(private task: TaskService, private router: Router, private AR: ActivatedRoute) { }
  @Output()
  e = new EventEmitter();
  @Input()
  message = '';
  logged = '';
  incoming: any;
  emessage = 'ERROR SHOULD BE HERE';
  routeruzenet = 123;
  ngOnInit() {
    this.e.emit('hey, this should be working!');
    this.task.getData().subscribe(data => this.incoming = data,
      error => this.emessage = error);
    this.AR.params.subscribe(
      (params: Params) => {
        this.routeruzenet = params.id;
      });
  }
  logging() {
    this.task.log(this.logged);
  }
  happen() {
    this.router.navigate(['showhide']);
  }

}
