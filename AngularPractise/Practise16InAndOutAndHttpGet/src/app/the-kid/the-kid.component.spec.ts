import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TheKidComponent } from './the-kid.component';

describe('TheKidComponent', () => {
  let component: TheKidComponent;
  let fixture: ComponentFixture<TheKidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TheKidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TheKidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
