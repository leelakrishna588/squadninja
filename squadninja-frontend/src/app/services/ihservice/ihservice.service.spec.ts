import { TestBed } from '@angular/core/testing';

import { IhserviceService } from './ihservice.service';

describe('IhserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IhserviceService = TestBed.get(IhserviceService);
    expect(service).toBeTruthy();
  });
});
