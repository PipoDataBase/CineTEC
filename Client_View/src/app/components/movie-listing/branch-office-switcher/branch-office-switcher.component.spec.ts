import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BranchOfficeSwitcherComponent } from './branch-office-switcher.component';

describe('BranchOfficeSwitcherComponent', () => {
  let component: BranchOfficeSwitcherComponent;
  let fixture: ComponentFixture<BranchOfficeSwitcherComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BranchOfficeSwitcherComponent]
    });
    fixture = TestBed.createComponent(BranchOfficeSwitcherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
