import { TestBed } from '@angular/core/testing';

import { IhprofileserService } from './ihprofileser.service';

describe('IhprofileserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IhprofileserService = TestBed.get(IhprofileserService);
    expect(service).toBeTruthy();
  });
});
