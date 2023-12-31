import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BranchOfficeSelectionComponent } from './components/branch-office-selection/branch-office-selection/branch-office-selection.component';
import { BranchOfficeSwitcherComponent } from './components/movie-listing/branch-office-switcher/branch-office-switcher.component';
import { BillingTicketsInformationComponent } from './components/movie-listing/billing-tickets-information/billing-tickets-information.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo:'branchOfficeSelection' },
  { path: 'branchOfficeSelection', component: BranchOfficeSelectionComponent },
  { 
    path: 'branchOfficeSwitcher/:id',
    component: BranchOfficeSwitcherComponent, 
    children: [
      { path: '', pathMatch: 'full', redirectTo: 'branchOfficeSwitcher' },
      { path: 'billingTicketInformation', component: BillingTicketsInformationComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
