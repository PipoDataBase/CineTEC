import {Component} from '@angular/core';
import {FormBuilder, Validators, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatStepperModule} from '@angular/material/stepper';
import {MatButtonModule} from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { NgClass, NgFor, NgForOf, NgIf } from "@angular/common";
import { MatIconModule } from '@angular/material/icon';
import { Tickets } from 'src/app/models/tickets.module';
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService } from 'src/app/services/shared.service';
import { MovieProjection } from 'src/app/models/movie-projection.module';
import { RoomsService } from 'src/app/services/rooms.service';

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
    NgIf,
    NgClass,
    MatIconModule
  ],
})
export class BillingTicketsInformationComponent {
  tickets: Tickets = {
    kidsTickets: 0,
    adultsTickets: 0,
    elderlyTickets: 0
  }
  selectedBranchId: string = '';
  roomRows: number = 2;
  roomColumns: number = 2;
  seats: { id: string, isSelected: boolean }[] = [];
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

  constructor(private _formBuilder: FormBuilder, private route: ActivatedRoute, private sharedService: SharedService, private roomsService: RoomsService) {}

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

  updateTicketsCuantity(){
   console.log(this.tickets.kidsTickets); 
   console.log(this.tickets.adultsTickets);
   console.log(this.tickets.elderlyTickets);
  }

  onSeatClick(seat: { id: string, isSelected: boolean }) {
    console.log(`Asiento seleccionado: ${seat}`);
    seat.isSelected = !seat.isSelected;
  }

  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required],
  });
  isLinear = false;
}
