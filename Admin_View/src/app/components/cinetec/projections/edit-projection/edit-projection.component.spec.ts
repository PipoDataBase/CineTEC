import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProjectionComponent } from './edit-projection.component';

describe('EditProjectionComponent', () => {
  let component: EditProjectionComponent;
  let fixture: ComponentFixture<EditProjectionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditProjectionComponent]
    });
    fixture = TestBed.createComponent(EditProjectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
