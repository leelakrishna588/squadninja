import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: 'ihdashboardcards', title: 'Dashboard',  icon: 'ni-tv-2 text-primary', class: '' },
  { path: 'user-profile', title: 'User profile',  icon:'ni-single-02 text-yellow', class: '' }
];

@Component({
  selector: 'app-spsidebar',
  templateUrl: './spsidebar.component.html',
  styleUrls: ['./spsidebar.component.scss']
})
export class SpsidebarComponent implements OnInit {

  public menuItems: any[];
  public isCollapsed = true;
  constructor(private router: Router) { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
    this.router.events.subscribe((event) => {
      this.isCollapsed = true;
   });
  }

}
