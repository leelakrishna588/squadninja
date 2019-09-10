import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IhdashboardComponent } from './ihdashboard.component';

describe('IhdashboardComponent', () => {
  let component: IhdashboardComponent;
  let fixture: ComponentFixture<IhdashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IhdashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IhdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
