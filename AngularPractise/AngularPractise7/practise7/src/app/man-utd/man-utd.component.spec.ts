import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManUtdComponent } from './man-utd.component';

describe('ManUtdComponent', () => {
  let component: ManUtdComponent;
  let fixture: ComponentFixture<ManUtdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManUtdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManUtdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
