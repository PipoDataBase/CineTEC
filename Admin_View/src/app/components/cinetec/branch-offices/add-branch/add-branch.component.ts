import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BranchOffice } from 'src/app/models/branch-office.module';
import { BranchOfficesService } from 'src/app/services/branch-offices.service';

@Component({
  selector: 'app-add-branch',
  templateUrl: './add-branch.component.html',
  styleUrls: ['./add-branch.component.css']
})
export class AddBranchComponent {
  addBranchRequest: BranchOffice = {
    id: '00000000-0000-0000-0000-000000000000',
    location: '',
    name: '',
    restriction: '',
    n_Rooms: 0
  }

  constructor(private branchOfficesService: BranchOfficesService, private router: Router) { }

  addBranch() {
    if (this.addBranchRequest.location != '' && this.addBranchRequest.name != '') {
      this.branchOfficesService.addBranch(this.addBranchRequest).subscribe({
        next: (response) => {
          this.router.navigate(["cinetec/branch-offices"]);
        }
      })
    }
    else {
      alert("Debe indicar los valores solicitados y de forma correcta");
    }
  }

  back() {
    this.router.navigate(["cinetec/branch-offices"]);
  }
}
