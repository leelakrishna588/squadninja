import { TestBed } from '@angular/core/testing';

import { IhdashboardserService } from './ihdashboardser.service';

describe('IhdashboardserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IhdashboardserService = TestBed.get(IhdashboardserService);
    expect(service).toBeTruthy();
  });
});
