import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BranchOffice } from 'src/app/models/branch-office.module';
import { Room } from 'src/app/models/room.module';
import { BranchOfficesService } from 'src/app/services/branch-offices.service';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css']
})
export class AddRoomComponent {
  branchDetails: BranchOffice = {
    id: '00000000-0000-0000-0000-000000000000',
    location: '',
    name: '',
    restriction: '',
    n_Rooms: 0
  }
  addRoomRequest: Room = {
    id: '00000000-0000-0000-0000-000000000000',
    branch_Id: '00000000-0000-0000-0000-000000000000',
    n_Rows: 0,
    n_Columns: 0,
    n_Projections: 0
  }

  constructor(private roomsService: RoomsService, private branchOfficesService: BranchOfficesService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const branchId = params.get('branch_Id');
      if (branchId) {
        this.branchOfficesService.getBranch(branchId).subscribe({
          next: (response) => {
            this.branchDetails = response;
          }
        })
      }
    });
  }

  addRoom() {
    this.addRoomRequest.branch_Id = this.branchDetails.id;
    if (this.addRoomRequest.branch_Id && this.addRoomRequest.id &&
      (this.addRoomRequest.n_Rows >= 0 && this.addRoomRequest.n_Rows <= 20) &&
      (this.addRoomRequest.n_Columns >= 0 && this.addRoomRequest.n_Columns <= 20)) {
      this.roomsService.addRoom(this.addRoomRequest).subscribe({
        next: (response) => {
          const branchId = this.route.snapshot.paramMap.get('branch_Id');
          if (branchId) {
            this.roomsService.selectedBranchId = branchId;
          }
          this.router.navigate(["cinetec/rooms"]);
        }
      })
    }
    else {
      alert("Debe indicar los valores solicitados y de forma correcta");
    }
  }

  back() {
    const branchId = this.route.snapshot.paramMap.get('branch_Id');
    if (branchId) {
      this.roomsService.selectedBranchId = branchId;
    }
    this.router.navigate(['cinetec/rooms']);
  }
}
