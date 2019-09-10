import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SpprofileComponent } from 'src/app/pages/spprofile/spprofile.component';
import { SpdashboardcardsComponent } from 'src/app/pages/spdashboardcards/spdashboardcards.component';

export const SpDashboardRoutes: Routes = [
  {path:'spdashboardcards',component:SpdashboardcardsComponent},
  {path: 'user-profile', component: SpprofileComponent},
];


