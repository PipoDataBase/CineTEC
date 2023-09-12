import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProjectionComponent } from './add-projection.component';

describe('AddProjectionComponent', () => {
  let component: AddProjectionComponent;
  let fixture: ComponentFixture<AddProjectionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddProjectionComponent]
    });
    fixture = TestBed.createComponent(AddProjectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
