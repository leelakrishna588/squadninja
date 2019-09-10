import { TestBed } from '@angular/core/testing';

import { SpprofileserService } from './spprofileser.service';

describe('SpprofileserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SpprofileserService = TestBed.get(SpprofileserService);
    expect(service).toBeTruthy();
  });
});
