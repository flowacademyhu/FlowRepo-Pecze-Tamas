import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KidoneComponent } from './kidone.component';

describe('KidoneComponent', () => {
  let component: KidoneComponent;
  let fixture: ComponentFixture<KidoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KidoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KidoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
