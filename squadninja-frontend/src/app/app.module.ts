import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeModule } from './home/home.module';
import { FormsModule } from '@angular/forms';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SectionsComponent } from './sections/sections.component';
import { LoginComponent } from './login/login.component';

import { IhdashboardComponent } from './layouts/ihdashboard/ihdashboard.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { MatTabsModule} from '@angular/material';
import { CommonModule } from '@angular/common';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { IhdashboardserService } from './services/ihdashboardser/ihdashboardser.service';
import { IhserviceService } from './services/ihservice/ihservice.service';
import { IhprofileserService } from './services/ihprofileser/ihprofileser.service';
import { SpdashboardComponent } from './layouts/spdashboard/spdashboard.component';
import { SpdashboardcardsComponent } from './pages/spdashboardcards/spdashboardcards.component';
import { SpprofileComponent } from './pages/spprofile/spprofile.component';
import { SpprofileserService } from './services/spprofileser/spprofileser.service';
import { RegisterserService } from './services/registerser/registerser.service';
import { RegisterspComponent } from './registersp/registersp.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    IhdashboardComponent,
    RegisterComponent,
    SpdashboardComponent,
    RegisterspComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    NgbModule,
    BrowserAnimationsModule,
    DashboardModule,
    RouterModule,
    FormsModule,
    CommonModule,
    HttpClientModule
  ],
  providers: [
    HttpClient,
    IhserviceService,
    IhprofileserService,
    SpprofileserService,
    RegisterserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
