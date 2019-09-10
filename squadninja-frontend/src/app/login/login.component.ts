import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../services/userser/userservice.service';
import {Router} from '@angular/router';
import * as jwt_decode from 'jwt-decode';


import { RegisterserService } from '../services/registerser/registerser.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  // private router:Router;
  public decodedTokenWithRoleSub: any;

   // decode token
constructor(private registerser: RegisterserService, private userservice: UserserviceService, private router: Router) { }

  focus;
  focus1;

  public role: any;
  // public roles: any;
  public email: any;
  public password: any;
  public token: any;
  public decodedroletoken: any;

  public ideaHamster:any = "ideaHamster";

  public hello:any;

  ngOnInit() {
  }
   // show decoded token object in console




  getDecodedAccessToken(token: string): any {
    try {
        console.log(jwt_decode(token));
        return jwt_decode(token) ;
    } catch (Error) {
        return Error;
    }
  }

  selectIh() {
    // console.log(this.tokenInfo);
    this.role = 'ideahamster';
  }

  selectSp() {
    this.role = 'serviceprovider';
  }
  // selectIh(){
  //   this.registerser.selectIh();
  // }

Login() {
    this.userservice.Login (this.email, this.password).subscribe((response) => {
      if (response) {
        this.token = response;
        console.log(this.getDecodedAccessToken(this.token.token));
        this.decodedroletoken = this.getDecodedAccessToken(this.token.token);
        this.decodedTokenWithRoleSub = this.decodedroletoken.sub;
        console.log(this.decodedTokenWithRoleSub);


if (this.decodedTokenWithRoleSub === "ideaHamster") {
  // console.log('ideahamster');
  this.router.navigate(['/spdashboard']);
}
 else {

 this.router.navigate(['/ihdashboard']);
}
     
  }},
  (err) => {
    console.log(err);
});

if (this.decodedTokenWithRoleSub === "ideaHamster") {
  // console.log('ideahamster');
  this.router.navigate(['/spdashboard']);
}
 else {

 this.router.navigate(['/ihdashboard']);
}
}
}
