import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostideaComponent } from './postidea.component';

describe('PostideaComponent', () => {
  let component: PostideaComponent;
  let fixture: ComponentFixture<PostideaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostideaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostideaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
