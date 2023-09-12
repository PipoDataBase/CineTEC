import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CinetecComponent } from './cinetec.component';

describe('CinetecComponent', () => {
  let component: CinetecComponent;
  let fixture: ComponentFixture<CinetecComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CinetecComponent]
    });
    fixture = TestBed.createComponent(CinetecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
