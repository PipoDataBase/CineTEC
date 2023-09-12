import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

// Routing
import { AppRoutingModule } from './app-routing.module';

// Angular Material
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material.module';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

// Syncfusion
import { CalendarModule, DatePickerModule, TimePickerModule, DateRangePickerModule, DateTimePickerModule } from '@syncfusion/ej2-angular-calendars';
import { DatePipe } from '@angular/common';

// FormsModule
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// Angular Flex Layout
import { FlexLayoutModule } from "@angular/flex-layout";

// Firebase
import { AngularFireModule, FirebaseApp } from '@angular/fire/compat';
import { environment } from 'src/environments/environment';

// Components
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login/login.component';
import { CinetecComponent } from './components/cinetec/cinetec/cinetec.component';
import { BranchOfficesComponent } from './components/cinetec/branch-offices/branch-offices/branch-offices.component';
import { AddBranchComponent } from './components/cinetec/branch-offices/add-branch/add-branch.component';
import { EditBranchComponent } from './components/cinetec/branch-offices/edit-branch/edit-branch.component';
import { RoomsComponent } from './components/cinetec/rooms/rooms/rooms.component';
import { AddRoomComponent } from './components/cinetec/rooms/add-room/add-room.component';
import { EditRoomComponent } from './components/cinetec/rooms/edit-room/edit-room.component';
import { MoviesComponent } from './components/cinetec/movies/movies/movies.component';
import { AddMovieComponent } from './components/cinetec/movies/add-movie/add-movie.component';
import { EditMovieComponent } from './components/cinetec/movies/edit-movie/edit-movie.component';
import { ProjectionsComponent } from './components/cinetec/projections/projections/projections.component';
import { AddProjectionComponent } from './components/cinetec/projections/add-projection/add-projection.component';
import { EditProjectionComponent } from './components/cinetec/projections/edit-projection/edit-projection.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CinetecComponent,
    BranchOfficesComponent,
    AddBranchComponent,
    EditBranchComponent,
    RoomsComponent,
    AddRoomComponent,
    EditRoomComponent,
    MoviesComponent,
    AddMovieComponent,
    EditMovieComponent,
    ProjectionsComponent,
    AddProjectionComponent,
    EditProjectionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    ReactiveFormsModule,
    FormsModule,
    FlexLayoutModule,
    HttpClientModule,
    CalendarModule, DatePickerModule, TimePickerModule, DateRangePickerModule, DateTimePickerModule,
    AngularFireModule.initializeApp(environment.firebaseConfig)
  ],
  providers: [
    DatePipe
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
