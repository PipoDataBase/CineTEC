import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingTicketsInformationComponent } from './billing-tickets-information.component';

describe('BillingTicketsInformationComponent', () => {
  let component: BillingTicketsInformationComponent;
  let fixture: ComponentFixture<BillingTicketsInformationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BillingTicketsInformationComponent]
    });
    fixture = TestBed.createComponent(BillingTicketsInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
