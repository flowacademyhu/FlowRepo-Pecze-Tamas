import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KiddoComponent } from './kiddo.component';

describe('KiddoComponent', () => {
  let component: KiddoComponent;
  let fixture: ComponentFixture<KiddoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KiddoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KiddoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
