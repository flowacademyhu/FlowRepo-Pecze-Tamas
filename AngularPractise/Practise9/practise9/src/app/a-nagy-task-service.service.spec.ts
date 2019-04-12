import { TestBed } from '@angular/core/testing';

import { ANagyTaskServiceService } from './a-nagy-task-service.service';

describe('ANagyTaskServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ANagyTaskServiceService = TestBed.get(ANagyTaskServiceService);
    expect(service).toBeTruthy();
  });
});
