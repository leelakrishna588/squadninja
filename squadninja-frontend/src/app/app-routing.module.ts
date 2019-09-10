import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { LoginComponent } from './login/login.component';
import { IhdashboardComponent } from './layouts/ihdashboard/ihdashboard.component';
import { RegisterComponent } from './register/register.component';
import { RegisterspComponent } from './registersp/registersp.component';
import { SpdashboardComponent } from './layouts/spdashboard/spdashboard.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path:'registersp',component:RegisterspComponent},
  {path: 'ihdashboard',
  component: IhdashboardComponent,
  children: [
    {
     path: '',
     loadChildren: './layouts/ihdashboard/ihdashboard.module#IhdashboardModule'
   }
 ]
},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'spdashboard',
  component: SpdashboardComponent,
  children: [
    {
     path: '',
     loadChildren: './layouts/spdashboard/spdashboard.module#SpdashboardModule'
   }
 ]
}
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true
    })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
