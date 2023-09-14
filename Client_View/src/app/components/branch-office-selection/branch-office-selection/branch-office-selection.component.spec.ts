import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BranchOfficeSelectionComponent } from './branch-office-selection.component';

describe('BranchOfficeSelectionComponent', () => {
  let component: BranchOfficeSelectionComponent;
  let fixture: ComponentFixture<BranchOfficeSelectionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BranchOfficeSelectionComponent]
    });
    fixture = TestBed.createComponent(BranchOfficeSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
