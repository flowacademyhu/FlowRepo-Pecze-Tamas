import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AKomponensComponent } from './a-komponens.component';

describe('AKomponensComponent', () => {
  let component: AKomponensComponent;
  let fixture: ComponentFixture<AKomponensComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AKomponensComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AKomponensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
