import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-branch-office-switcher',
  templateUrl: './branch-office-switcher.component.html',
  styleUrls: ['./branch-office-switcher.component.css']
})
export class BranchOfficeSwitcherComponent {
  constructor(private router: Router) {}

  goToMovieListing() {
    this.router.navigate(['/branchOfficeSwitcher/movieListing']);
  }
}
