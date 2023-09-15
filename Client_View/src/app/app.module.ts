import { BrowserModule } from '@angular/platform-browser';

// Routing
import { AppRoutingModule } from './app-routing.module';

// Angular Material
import { AngularMaterialModule } from './angular-material.module';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BranchOfficeSelectionComponent } from './components/branch-office-selection/branch-office-selection/branch-office-selection.component';

// Syncfusion
import { CalendarModule, DatePickerModule, TimePickerModule, DateRangePickerModule, DateTimePickerModule } from '@syncfusion/ej2-angular-calendars';
import { DatePipe } from '@angular/common';

// FormsModule
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// Angular Flex Layout
import { FlexLayoutModule } from "@angular/flex-layout";

// Firebase
import { AngularFireModule, FirebaseApp } from '@angular/fire/compat';
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
    CalendarModule,  DatePickerModule, TimePickerModule, DateRangePickerModule, DateTimePickerModule,
    FormsModule, ReactiveFormsModule,
    FlexLayoutModule,
    AngularFireModule
  ],
  providers: [
    DatePipe
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
