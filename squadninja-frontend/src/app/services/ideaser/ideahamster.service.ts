import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IDomain } from 'src/app/domain';
import { ISubDomain } from 'src/app/subdomain';
import { ISkill } from 'src/app/skill';
import { IRole } from 'src/app/role';


@Injectable({
  providedIn: 'root'
})
export class IdeahamsterService {

  private _url:string='/assets/data/domains.json';
  private _url1:string='/assets/data/subdomains.json';
  private _url2:string='/assets/data/skills.json';
  private _url3:string='/assets/data/roles.json';

    constructor(private http : HttpClient){
       //  this.http=http;
    }
    getDomains():Observable<IDomain[]>{
        return this.http.get<IDomain[]>(this._url);
    }
    getSubDomains():Observable<ISubDomain[]>{
        return this.http.get<ISubDomain[]>(this._url1);
    }
    getSkills():Observable<ISkill[]>{
      return this.http.get<ISkill[]>(this._url2);
    }    
    
    getroles():Observable<IRole[]>{
      return this.http.get<IRole[]>(this._url3);
    }
   
  
    save(obj):Observable<any>{ 
         console.log(obj)
        return this.http.post('http://13.235.10.115:8090/api/v1/idea',obj);
        
    }
}
