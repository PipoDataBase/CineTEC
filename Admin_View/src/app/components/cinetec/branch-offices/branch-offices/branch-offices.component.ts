import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BranchOffice } from 'src/app/models/branch-office.module';
import { BranchOfficesService } from 'src/app/services/branch-offices.service';

@Component({
  selector: 'app-branch-offices',
  templateUrl: './branch-offices.component.html',
  styleUrls: ['./branch-offices.component.css']
})
export class BranchOfficesComponent {
  branchoffices: BranchOffice[] = [];

  constructor(private branchOfficesService: BranchOfficesService, private router: Router) { }

  updateBranchOffices(): void {
    this.branchOfficesService.getAllBranches().subscribe({
      next: (branchoffices) => {
        this.branchoffices = branchoffices;
      },
      error: (response) => {
        console.log(response);
      }
    })
  }

  ngOnInit(): void {
    this.updateBranchOffices();
  }

  addBranch(): void {
    this.router.navigate(["cinetec/add-branch"]);
  }

  deleteBranch(id: string) {
    this.branchOfficesService.deleteBranch(id).subscribe({
      next: (response) => {
        this.updateBranchOffices();
      },
      error: (error) => {
        console.log(error);
      }
    })
  }
}
