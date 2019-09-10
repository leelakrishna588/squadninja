import { Component, OnInit } from '@angular/core';
import { Register } from './register.model';
import { FormGroup } from '@angular/forms';
import {IhserviceService} from '../services/ihservice/ihservice.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm:FormGroup;
  submitted=false;
  user:Register=new Register();
  
  constructor(private ihservice:IhserviceService) { }

  ngOnInit() {
  }

  getf(){return this.registerForm.controls;}
  saveDetails(){
    this.ihservice.createUser(this.user)
    .subscribe(data=>{
      console.log(data);
      this.submitted=true;
    },
    error=>console.log(error));
  }

}
