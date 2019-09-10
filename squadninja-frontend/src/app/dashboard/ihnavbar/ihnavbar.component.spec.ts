import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IhnavbarComponent } from './ihnavbar.component';

describe('IhnavbarComponent', () => {
  let component: IhnavbarComponent;
  let fixture: ComponentFixture<IhnavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IhnavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IhnavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
