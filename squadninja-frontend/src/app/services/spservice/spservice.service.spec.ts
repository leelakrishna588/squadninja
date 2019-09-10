import { TestBed } from '@angular/core/testing';

import { SpserviceService } from './spservice.service';

describe('SpserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SpserviceService = TestBed.get(SpserviceService);
    expect(service).toBeTruthy();
  });
});
