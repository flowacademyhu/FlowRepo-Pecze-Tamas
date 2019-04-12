import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PearComponent } from './pear.component';

describe('PearComponent', () => {
  let component: PearComponent;
  let fixture: ComponentFixture<PearComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PearComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
