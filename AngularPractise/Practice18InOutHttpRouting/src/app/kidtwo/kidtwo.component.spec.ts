import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KidtwoComponent } from './kidtwo.component';

describe('KidtwoComponent', () => {
  let component: KidtwoComponent;
  let fixture: ComponentFixture<KidtwoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KidtwoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KidtwoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
