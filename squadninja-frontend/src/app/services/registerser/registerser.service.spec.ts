import { TestBed } from '@angular/core/testing';

import { RegisterserService } from './registerser.service';

describe('RegisterserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegisterserService = TestBed.get(RegisterserService);
    expect(service).toBeTruthy();
  });
});
