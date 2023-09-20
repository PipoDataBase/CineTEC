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
import { BranchOfficeSelectionComponent } from './components/branch-office-selection/branch-office-selection/branch-office-selection.component';
import { BranchOfficeSwitcherComponent } from './components/movie-listing/branch-office-switcher/branch-office-switcher.component';
import { MovieListingComponent } from './components/movie-listing/movie-listing/movie-listing.component';
import { BillingTicketsInformationComponent } from './components/movie-listing/billing-tickets-information/billing-tickets-information.component';

@NgModule({
  declarations: [
    AppComponent,
    BranchOfficeSelectionComponent,
    BranchOfficeSwitcherComponent,
    MovieListingComponent,
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
    CalendarModule,  DatePickerModule, TimePickerModule, DateRangePickerModule, DateTimePickerModule,
    AngularFireModule.initializeApp(environment.firebaseConfig)
  ],
  providers: [
    DatePipe
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
