import {Component} from '@angular/core';
import {FormBuilder, Validators, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatStepperModule} from '@angular/material/stepper';
import {MatButtonModule} from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { NgFor, NgForOf } from "@angular/common";
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-billing-tickets-information',
  templateUrl: './billing-tickets-information.component.html',
  styleUrls: ['./billing-tickets-information.component.css'],
  standalone: true,
  imports: [
    MatButtonModule,
    MatStepperModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    NgForOf,
    MatIconModule
  ],
})
export class BillingTicketsInformationComponent {
  kidsTickets: number = 0;
  adultsTickets: number = 0;
  elderlyTickets: number = 0;
  roomRows: number = 10;
  roomColumns: number = 10;
  seats: string[] = ["a", "A1", "A2", "A3","A1", "A2", "A3","A1", "A2", "A3","A1", "A2", "A3","A1", "A2", "A3","A1", "A2", "A3"];

  updateTicketsCuantity(){
    
  }


  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required],
  });
  isLinear = false;

  constructor(private _formBuilder: FormBuilder) {}
}
