import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BranchOffice } from 'src/app/models/branch-office.module';
import { BranchOfficesService } from 'src/app/services/branch-offices.service';

@Component({
  selector: 'app-branch-office-selection',
  templateUrl: './branch-office-selection.component.html',
  styleUrls: ['./branch-office-selection.component.css']
})
export class BranchOfficeSelectionComponent {
  branches: BranchOffice[] = [];
  locations: string[] = [];
  names: string[] = [];
  currentLocation: string = '';
  currentName: string = '';
  selectedBranchId: string = '';

  constructor(private branchOfficesService: BranchOfficesService, private router: Router) { }

  ngOnInit(): void {
    this.branchOfficesService.getAllBranches().subscribe({
      next: (branches) => {
        this.branches = branches;
        this.locations = [...new Set(branches.map(branch => branch.location))];
      },
      error: (response) => {
        console.log(response);
      }
    })
  }

  onLocationSelectionChange(location: string) {
    this.currentLocation = location;

    // Filter names based on selected location
    this.names = this.branches
      .filter(branch => branch.location === this.currentLocation)
      .map(branch => branch.name);
  }

  onNameSelectionChange(name: string) {
    this.currentName = name;

    // Find branch based on selected location and name
    const selectedBranch = this.branches.find(branch =>
      branch.location === this.currentLocation && branch.name === this.currentName
    );

    if (selectedBranch) {
      this.selectedBranchId = selectedBranch.id;
    }
  }

  movieListing(): void {
    if (this.selectedBranchId != '') {
      this.router.navigate(["branchOfficeSwitcher", this.selectedBranchId]);
    }
  }
}
