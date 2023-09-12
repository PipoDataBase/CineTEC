import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login/login.component';
import { CinetecComponent } from './components/cinetec/cinetec/cinetec.component';
import { BranchOfficesComponent } from './components/cinetec/branch-offices/branch-offices/branch-offices.component';
import { MoviesComponent } from './components/cinetec/movies/movies/movies.component';
import { RoomsComponent } from './components/cinetec/rooms/rooms/rooms.component';
import { ProjectionsComponent } from './components/cinetec/projections/projections/projections.component';
import { AddBranchComponent } from './components/cinetec/branch-offices/add-branch/add-branch.component';
import { EditBranchComponent } from './components/cinetec/branch-offices/edit-branch/edit-branch.component';
import { AddMovieComponent } from './components/cinetec/movies/add-movie/add-movie.component';
import { EditMovieComponent } from './components/cinetec/movies/edit-movie/edit-movie.component';
import { AddRoomComponent } from './components/cinetec/rooms/add-room/add-room.component';
import { EditRoomComponent } from './components/cinetec/rooms/edit-room/edit-room.component';
import { AddProjectionComponent } from './components/cinetec/projections/add-projection/add-projection.component';
import { EditProjectionComponent } from './components/cinetec/projections/edit-projection/edit-projection.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo:'login' },
  { path: 'login', component: LoginComponent },
  {
    path: 'cinetec',
    component: CinetecComponent,
    children: [
      { path: '', pathMatch: 'full', redirectTo: 'branch-offices' },
      { path: 'branch-offices', component: BranchOfficesComponent },
      { path: 'movies', component: MoviesComponent },
      { path: 'rooms', component: RoomsComponent },
      { path: 'projections', component: ProjectionsComponent },
      { path: 'add-branch', component: AddBranchComponent },
      { path: 'edit-branch/:id', component: EditBranchComponent },
      { path: 'add-movie', component: AddMovieComponent },
      { path: 'edit-movie/:id', component: EditMovieComponent },
      { path: 'add-room/:branch_Id', component: AddRoomComponent },
      { path: 'edit-room/:branch_Id/:id', component: EditRoomComponent },
      { path: 'add-projection/:room_Id', component: AddProjectionComponent },
      { path: 'edit-projection/:room_Id/:id', component: EditProjectionComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
