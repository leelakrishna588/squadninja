import {
  Component,
  HostListener,
  Renderer,
  Inject,
  ElementRef
} from "@angular/core";
import { Subscription } from "rxjs";
import { Router, NavigationEnd } from "@angular/router";
import { DOCUMENT } from "@angular/common";
import {filter} from 'rxjs/operators';
import {Location} from '@angular/common';

var didScroll;
var lastScrollTop = 0;
var delta = 5;
var navbarHeight = 0;

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent {
  private _router: Subscription;

  constructor(
    private renderer: Renderer,
    private router: Router,
    @Inject(DOCUMENT) private document: any,
    private element: ElementRef,
    public location: Location
  ) {}

  @HostListener("window:scroll", ["$event"])
  hasScrolled() {
    var st = window.pageYOffset;

    if (Math.abs(lastScrollTop - st) <= delta) return;

    var navbar = document.getElementsByTagName("nav")[0];


    if (st > lastScrollTop && st > navbarHeight) {

      // if (navbar.classList.contains("headroom--pinned")) {
      //   navbar.classList.remove("headroom--pinned");
      //   navbar.classList.add("headroom--unpinned");
      // }

    } else {

      if (st + window.innerHeight < document.body.scrollHeight) {
        // if (navbar.classList.contains("headroom--unpinned")) {
        //   navbar.classList.remove("headroom--unpinned");
        //   navbar.classList.add("headroom--pinned");
        // }
      }
    }

    lastScrollTop = st;
  }
  ngOnInit() {
    var navbar: HTMLElement = this.element.nativeElement.children[0]
      .children[0];
    this._router = this.router.events.pipe(
      filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        if (window.outerWidth > 991) {
          window.document.children[0].scrollTop = 0;
        } else {
          window.document.activeElement.scrollTop = 0;
        }
        this.renderer.listenGlobal("window", "scroll", event => {
          const number = window.scrollY;
          if (number > 150 || window.pageYOffset > 150) {
            // navbar.classList.add("headroom--not-top");
          } else {
            // navbar.classList.remove("headroom--not-top");
          }
        });
      });
    this.hasScrolled();
  }
}
