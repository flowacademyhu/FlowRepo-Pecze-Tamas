import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonHTMLComponent } from './pokemon-html.component';

describe('PokemonHTMLComponent', () => {
  let component: PokemonHTMLComponent;
  let fixture: ComponentFixture<PokemonHTMLComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PokemonHTMLComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PokemonHTMLComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
