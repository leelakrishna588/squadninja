import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SpProfile } from './spprofile.model';
import { Register } from 'src/app/register/register.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SpprofileserService {
  

  private _url: string = "http://13.235.10.115:8084/api/v1/serviceprovider";
  constructor(private http: HttpClient) { }
  getByEmailIdForServiceProvider(emailId):any{
    console.log("in getbyemail of reg service "+emailId);
    return this.http.get<SpProfile>(`http://13.235.10.115:8084/api/v1/serviceprovider/${emailId}`);
  }
  createUser(user: any):Observable<any> {
    return this.http.post<Register>(this._url, user);
  }
  updateTheProfile(profile: any):Observable<any> {
    return this.http.put<SpProfile>(`http://13.235.10.115:8084/api/v1/serviceprovider`,(profile));
  }
}
