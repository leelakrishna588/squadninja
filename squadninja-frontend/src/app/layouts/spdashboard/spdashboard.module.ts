import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SpDashboardRoutes } from './spdashboard-routing.module';
import { SpdashboardComponent } from './spdashboard.component';
import { SpprofileComponent } from 'src/app/pages/spprofile/spprofile.component';
import { SpdashboardcardsComponent } from 'src/app/pages/spdashboardcards/spdashboardcards.component';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatTabsModule, MatCardModule, MatFormFieldModule, MatSelectModule, MatChipsModule, MatInputModule, MatIconModule, MatAutocompleteModule } from '@angular/material';
import { ClipboardModule } from 'ngx-clipboard';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SpprofileserService } from 'src/app/services/spprofileser/spprofileser.service';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    SpdashboardcardsComponent,
    SpprofileComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(SpDashboardRoutes),
    NgbModule,
    FormsModule,
    HttpClientModule,
    ClipboardModule,
    MatTabsModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatChipsModule,
    MatIconModule,
    MatInputModule,
    MatAutocompleteModule ,
    ReactiveFormsModule,
  ],
  providers:[
    SpprofileserService
  ]
})
export class SpdashboardModule { }
