import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IhprofileComponent } from './ihprofile.component';

describe('IhprofileComponent', () => {
  let component: IhprofileComponent;
  let fixture: ComponentFixture<IhprofileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IhprofileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IhprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
