import { Component, OnInit } from '@angular/core';
import { SpprofileserService } from 'src/app/services/spprofileser/spprofileser.service';

@Component({
  selector: 'app-spprofile',
  templateUrl: './spprofile.component.html',
  styleUrls: ['./spprofile.component.scss']
})
export class SpprofileComponent implements OnInit {

  serviceProviderData: SpprofileserService;
  updated: any;
  // private dialog: MatDialog
  constructor(private serviceProviderProfile: SpprofileserService) { }
  public emailId = "aniketh@gmail.com";
  ngOnInit() {
    this.getTheProfile();
  }
  getTheProfile(){
    this.serviceProviderProfile.getByEmailIdForServiceProvider(this.emailId)
    .subscribe((data)=> {
      console.log("data fetched..", data);
      this.serviceProviderData=data;
      console.log("after getting back from service",this.serviceProviderData);
    });
  }
    onSubmitUpdate(){
      console.log(this.serviceProviderData);
      this.serviceProviderProfile.updateTheProfile(this.serviceProviderData).subscribe((data)=> {
        console.log("data updated..", data);
        this.updated=data;
        console.log("after getting back from service",this.updated);
    });
      this.getTheProfile();
    }

}
