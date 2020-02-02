import { TestBed } from '@angular/core/testing';

import { ApiEbooksService } from './api-ebooks.service';

describe('ApiEbooksService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiEbooksService = TestBed.get(ApiEbooksService);
    expect(service).toBeTruthy();
  });
});
