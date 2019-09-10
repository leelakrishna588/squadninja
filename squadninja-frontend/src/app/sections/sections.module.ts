import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import { SectionsComponent } from './sections.component';
import {RouterModule} from '@angular/router';


@NgModule({
  declarations: [SectionsComponent],
  imports: [
    CommonModule,
    NgbModule,
    FormsModule,
    RouterModule
  ],
  exports:[SectionsComponent]
})
export class SectionsModule { }
