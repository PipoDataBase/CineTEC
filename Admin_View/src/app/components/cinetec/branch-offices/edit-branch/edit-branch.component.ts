import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BranchOffice } from 'src/app/models/branch-office.module';
import { BranchOfficesService } from 'src/app/services/branch-offices.service';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-edit-branch',
  templateUrl: './edit-branch.component.html',
  styleUrls: ['./edit-branch.component.css']
})
export class EditBranchComponent {
  branchDetails: BranchOffice = {
    id: '00000000-0000-0000-0000-000000000000',
    location: '',
    name: '',
    restriction: '',
    n_Rooms: 0
  }

  constructor(private route: ActivatedRoute, private branchOfficesService: BranchOfficesService, private roomsService: RoomsService, private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');
        if (id) {
          this.branchOfficesService.getBranch(id).subscribe({
            next: (response) => {
              this.branchDetails = response;
            }
          })
        }
      }
    })
  }

  updateBranch() {
    if (this.branchDetails.location != '' && this.branchDetails.name != '') {
      this.branchOfficesService.updateBranch(this.branchDetails.id, this.branchDetails).subscribe({
        next: (response) => {
          this.router.navigate(["cinetec/branch-offices"]);
        }
      });
    }
    else {
      alert("Debe indicar los valores solicitados y de forma correcta");
    }
  }

  editRooms() {
    this.roomsService.selectedBranchId = this.branchDetails.id;
    this.router.navigate(["cinetec/rooms"]);
  }

  back() {
    this.router.navigate(["cinetec/branch-offices"]);
  }
}
