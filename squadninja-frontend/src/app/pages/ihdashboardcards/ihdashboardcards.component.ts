import { Component, OnInit } from '@angular/core';
import {$} from 'protractor';
import { protractor } from 'protractor/built/ptor';
import { FormControl } from '@angular/forms';
import { IhdashboardserService } from 'src/app/services/ihdashboardser/ihdashboardser.service';

@Component({
  selector: 'app-ihdashboardcards',
  templateUrl: './ihdashboardcards.component.html',
  styleUrls: ['./ihdashboardcards.component.scss']
})
export class IhdashboardcardsComponent implements OnInit {

  tabs = ['Devloper', 'Tester', 'Designer'];
  selected = new FormControl(0);
  

  cards = ['Idea1', 'Idea2'];
  sel = new FormControl(0);

  public ideas = [];

  private _ideas : IhdashboardserService;
  constructor() {}

  ngOnInit() {
    //  this._ideas.getServiceProviders()
    //  .subscribe(data => this.ideas = data);
  }

  addTab() {
    this.tabs.push('Role ');

    this.selected.setValue(this.tabs.length - 1);
    }
  

  addCard() {
    this.cards.push('{{ideas.name}}');
    this.sel.setValue(this.cards.length - 1);
  
  }

  removeTab(index: number) {
    this.tabs.splice(index, 1);
  }

  removeCard(cardindex: number) {
    this.ideas.splice(cardindex, 1);
  }

}
 