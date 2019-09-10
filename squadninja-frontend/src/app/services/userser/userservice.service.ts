import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService{


  constructor(private http: HttpClient) {
    this.http = http;
  }

  // tslint:disable-next-line:adjacent-overload-signatures
  Login(email: string, pass: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };

    const obj: any = {
      emailId : email,
      password : pass
    };
    //  JSON.stringify(obj);

    console.log(JSON.stringify(obj));

    // this.http.get("http://localhost:8080/hello", {responseType: 'text'}).subscribe(console.log)
    return this.http.post(`http://13.235.10.115:8085/api/v1/user`, JSON.stringify(obj), httpOptions);

  }
}

