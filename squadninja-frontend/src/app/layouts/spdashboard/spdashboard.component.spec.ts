import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpdashboardComponent } from './spdashboard.component';

describe('SpdashboardComponent', () => {
  let component: SpdashboardComponent;
  let fixture: ComponentFixture<SpdashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpdashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
