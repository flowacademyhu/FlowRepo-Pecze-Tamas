import { TestBed } from '@angular/core/testing';

import { SzerviszeljService } from './szerviszelj.service';

describe('SzerviszeljService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SzerviszeljService = TestBed.get(SzerviszeljService);
    expect(service).toBeTruthy();
  });
});
