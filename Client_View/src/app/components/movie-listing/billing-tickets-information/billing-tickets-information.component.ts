import { Component } from '@angular/core';
import { FormBuilder, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatStepperModule } from '@angular/material/stepper';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { NgClass, NgFor, NgForOf, NgIf } from "@angular/common";
import { MatIconModule } from '@angular/material/icon';
import { Tickets } from 'src/app/models/tickets.module';
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService } from 'src/app/services/shared.service';
import { MovieProjection } from 'src/app/models/movie-projection.module';
import { RoomsService } from 'src/app/services/rooms.service';
import { Client } from 'src/app/models/client.module';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';

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
    MatSelectModule,
    MatOptionModule,
    NgForOf,
    NgIf,
    NgClass,
    MatIconModule
  ],
})
export class BillingTicketsInformationComponent {
  movieProjection: MovieProjection = {
    ImagePath: '',
    CommercialTitle: '',
    OriginalTitle: '',
    Duration: 0,
    Clasification: '',
    Director: '',
    Protagonists: '',
    ProjectionType: '',
    Language: '',
    DateTime: '',
    RoomId: '',
  }
  tickets: Tickets = {
    kidsTickets: 0,
    adultsTickets: 0,
    elderlyTickets: 0
  }
  client: Client = {
    names: '',
    lastnames: '',
    email: '',
    paymentMethod: ''
  }
  enableButton: boolean = false;
  enablePay: boolean = false;
  selectedBranchId: string = '';
  roomRows: number = 0;
  roomColumns: number = 0;
  seats: { id: string, isSelected: boolean }[] = [];
  paymentMethod: string = '';

  constructor(private _formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router, private sharedService: SharedService, private roomsService: RoomsService) { }

  ngOnInit() {
    this.movieProjection = this.sharedService.sharedMoviesData;

    this.route.parent?.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');
        if (id) {
          this.selectedBranchId = id;
        }
      }
    })

    this.roomsService.getRoom(this.selectedBranchId, this.movieProjection.RoomId).subscribe({
      next: (response) => {
        this.roomRows = response.n_Rows;
        this.roomColumns = response.n_Columns;
        for (let i = 0; i < this.roomRows; i++) {
          for (let j = 0; j < this.roomColumns; j++) {
            this.seats.push({ id: `F${i + 1}C${j + 1}`, isSelected: false });
          }
        }
      }
    })
  }

  uptateTotalTickets() {
    const totalTickets = this.tickets.kidsTickets + this.tickets.adultsTickets + this.tickets.elderlyTickets;
    this.enableButton = totalTickets >= 1;
  }

  onSeatClick(seat: { id: string, isSelected: boolean }) {
    console.log(`Asiento seleccionado: ${seat}`);
    seat.isSelected = !seat.isSelected;
  }

  checkClientInfo() {
    const isNotDefault = Object.values(this.client).every(value => value !== '');
    if (isNotDefault) {
      this.enablePay = true;
    }
    else {
      this.enablePay = false;
    }
  }

  pay() {
    alert("Pago realizado, disfruta de la película");
    this.router.navigate(["branchOfficeSelection"]);
  }

  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required],
  });
  isLinear = false;
}
