import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from 'src/app/models/room.module';
import { ProjectionsService } from 'src/app/services/projections.service';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-edit-room',
  templateUrl: './edit-room.component.html',
  styleUrls: ['./edit-room.component.css']
})
export class EditRoomComponent {
  roomDetails: Room = {
    id: '00000000-0000-0000-0000-000000000000',
    branch_Id: '00000000-0000-0000-0000-000000000000',
    n_Rows: 0,
    n_Columns: 0,
    n_Projections: 0
  }

  constructor(private route: ActivatedRoute, private roomsService: RoomsService, private projectionsService: ProjectionsService, private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe({
      next: (params) => {
        const branch_Id = params.get('branch_Id');
        const id = params.get('id');

        if (branch_Id && id) {
          this.roomsService.getRoom(branch_Id, id).subscribe({
            next: (response) => {
              this.roomDetails = response;
              console.log(this.roomDetails);
            }
          })
        }
      }
    })
  }

  updateRoom() {
    if (this.roomDetails.branch_Id && this.roomDetails.id &&
      (this.roomDetails.n_Rows >= 0 && this.roomDetails.n_Rows <= 20) &&
      (this.roomDetails.n_Columns >= 0 && this.roomDetails.n_Columns <= 20)) {
      this.roomsService.updateRoom(this.roomDetails.branch_Id, this.roomDetails.id, this.roomDetails).subscribe({
        next: (response) => {
          const branchId = this.route.snapshot.paramMap.get('branch_Id');
          if (branchId) {
            this.roomsService.selectedBranchId = branchId;
          }
          this.router.navigate(["cinetec/rooms"]);
        }
      });
    }
    else {
      alert("Debe indicar los valores solicitados y de forma correcta");
    }
  }

  editProjections() {
    this.roomsService.selectedBranchId = this.roomDetails.branch_Id;
    this.projectionsService.selectedRoomId = this.roomDetails.id;
    this.projectionsService.roomChecked = true;
    this.router.navigate(["cinetec/projections"]);
  }

  back() {
    const branchId = this.route.snapshot.paramMap.get('branch_Id');
    if (branchId) {
      this.roomsService.selectedBranchId = branchId;
    }
    this.router.navigate(['cinetec/rooms']);
  }
}
