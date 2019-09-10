import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterspComponent } from './registersp.component';

describe('RegisterspComponent', () => {
  let component: RegisterspComponent;
  let fixture: ComponentFixture<RegisterspComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterspComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterspComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
