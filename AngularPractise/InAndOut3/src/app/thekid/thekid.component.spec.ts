import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThekidComponent } from './thekid.component';

describe('ThekidComponent', () => {
  let component: ThekidComponent;
  let fixture: ComponentFixture<ThekidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThekidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThekidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
