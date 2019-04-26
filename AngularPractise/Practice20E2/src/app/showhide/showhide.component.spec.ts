import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowhideComponent } from './showhide.component';

describe('ShowhideComponent', () => {
  let component: ShowhideComponent;
  let fixture: ComponentFixture<ShowhideComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowhideComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowhideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
