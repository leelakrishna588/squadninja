import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from './sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { IhnavbarComponent } from './ihnavbar/ihnavbar.component';
import { SpsidebarComponent } from './spsidebar/spsidebar.component';

@NgModule({
  declarations: [
    SidebarComponent,
    IhnavbarComponent,
    SpsidebarComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    NgbModule
  ],
  exports:[
    SidebarComponent,
    IhnavbarComponent,
    SpsidebarComponent
  ]
})
export class DashboardModule { }
