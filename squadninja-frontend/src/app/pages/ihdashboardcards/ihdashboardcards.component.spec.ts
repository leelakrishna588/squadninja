import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IhdashboardcardsComponent } from './ihdashboardcards.component';

describe('IhdashboardcardsComponent', () => {
  let component: IhdashboardcardsComponent;
  let fixture: ComponentFixture<IhdashboardcardsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IhdashboardcardsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IhdashboardcardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
