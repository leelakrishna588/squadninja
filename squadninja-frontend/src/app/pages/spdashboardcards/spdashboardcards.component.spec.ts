import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpdashboardcardsComponent } from './spdashboardcards.component';

describe('SpdashboardcardsComponent', () => {
  let component: SpdashboardcardsComponent;
  let fixture: ComponentFixture<SpdashboardcardsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpdashboardcardsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpdashboardcardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
