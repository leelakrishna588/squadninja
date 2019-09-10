import { TestBed } from '@angular/core/testing';

import { IdeahamsterService } from './ideahamster.service';

describe('IdeahamsterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IdeahamsterService = TestBed.get(IdeahamsterService);
    expect(service).toBeTruthy();
  });
});
