import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BranchOfficeSelectionComponent } from './components/branch-office-selection/branch-office-selection/branch-office-selection.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo:'branchOfficeSelection' },
  { path: 'branchOfficeSelection', component: BranchOfficeSelectionComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
