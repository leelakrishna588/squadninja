import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpsidebarComponent } from './spsidebar.component';

describe('SpsidebarComponent', () => {
  let component: SpsidebarComponent;
  let fixture: ComponentFixture<SpsidebarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpsidebarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpsidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
