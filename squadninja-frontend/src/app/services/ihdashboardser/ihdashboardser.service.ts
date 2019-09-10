import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Ideas } from './Ideas';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IhdashboardserService {

  private _url : string= 'http://localhost:3000/IdeasData';

  constructor(private http:HttpClient) {
    this.http=http;
   }

  getServiceProviders(): Observable<Ideas[]> {
    return this.http.get<Ideas[]>(this._url);
}
}
