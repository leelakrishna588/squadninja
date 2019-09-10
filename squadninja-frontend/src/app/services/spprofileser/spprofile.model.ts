export class SpProfile{
   name : string;
   mobileNo : number;
   email : string;
   domain : string;
   role : [{
       roleName : string,
       skills : [string],
       experience : string
   }];
   workedIdeas : [string];
   chargePerHour : string;
   currentLocation : string;
   preferredLocation : [string];
}