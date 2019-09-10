import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormControl } from '@angular/forms';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MatChipInputEvent } from '@angular/material/chips';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { MatAutocomplete, MatAutocompleteSelectedEvent } from '@angular/material';
import { IDomain } from 'src/app/domain';
import { ISubDomain } from 'src/app/subdomain';
import { IRole } from 'src/app/role';
import { ISkill } from 'src/app/skill';
import { IdeahamsterService } from 'src/app/services/ideaser/ideahamster.service';

@Component({
  selector: 'app-postidea',
  templateUrl: './postidea.component.html',
  styleUrls: ['./postidea.component.scss']
})
export class PostideaComponent implements OnInit {

  title: any;
  description: any;
  duration: any;
  domain: any;
  subdomain: any;
  roleName: any;
  skills: any;
  noofpeople: any;
  experience: any;
  location: any;
  cost: any;

  private fieldArray: Array<any> = [];
  private newAttribute: any = {};
  public domains: IDomain[] = [];
  public subdomains: any[];
  public roles: any[];


  myControl = new FormControl();
  filteredOptions: Observable<IDomain[]>;


  myControls = new FormControl();
  filteredOptions1: Observable<ISubDomain[]>;

  myControlrole = new FormControl();
  filteredRoles: Observable<IRole[]>;

  skillCtrl = new FormControl();
  filteredSkills: Observable<ISkill[]>;

  @ViewChild('skillInput', { static: false }) skillInput: ElementRef<HTMLInputElement>;
  @ViewChild('auto2', { static: false }) matAutocomplete: MatAutocomplete;

  constructor(private _ideahamsterservice: IdeahamsterService) { }

  ngOnInit() {
    //reading data from JSON file for domain
    this._ideahamsterservice.getDomains()
      .subscribe(data => {
        this.domains = data
      });

    //reading data from JSON file for subdomains   
    this._ideahamsterservice.getSubDomains()
      .subscribe(data => {
        this.subdomains = data.map(e => e.name);
        this.filteredOptions1 = this.myControls.valueChanges
          .pipe(
            startWith(''),
            map(value => this._filter(value))
          );

      });

    //reading data from JSON file for role
    this._ideahamsterservice.getroles()
      .subscribe(data => {
        this.roles = data.map(m => m.rolename);
        this.filteredRoles = this.myControlrole.valueChanges
          .pipe(
            startWith(''),
            map((role: string | null) => role ? this._filter1(role) : this.roles.slice())
          );
      });

    //reading data from JSON file for skills
    this._ideahamsterservice.getSkills()
      .subscribe(data => {
        this.skills = data.map(e => e.name);
        this.filteredSkills = this.skillCtrl.valueChanges
          .pipe(
            startWith(''),
            map((skill: string | null) => skill ? this._filter2(skill) : this.skills.slice()));
      });
    this.newAttribute.skills = [];

  }

  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  
  add(event: MatChipInputEvent): void {
    if (!this.matAutocomplete.isOpen) {
      const input = event.input;
      const value = event.value;

      if ((value || '').trim()) {
        this.newAttribute.skills.push(value.trim());
      }
      
      if (input) {
        input.value = '';
      }
      this.skillCtrl.setValue(null);
    }
  }

  remove(skill: any): void {
    const index = this.newAttribute.skills.indexOf(skill);

    if (index >= 0) {
      this.newAttribute.skills.splice(index, 1);
    }
  }

  save() {
    let obj = {
      title: this.title,
      description: this.description,
      duration: this.duration,
      domain: this.domain,
      subDomain: this.subdomain,
      cost: this.cost,
      role: [{
        role: this.newAttribute.role,
        skills: this.newAttribute.skills,
        noOfPeople: this.newAttribute.noofpeople,
        experience: this.newAttribute.experience,
      }],
      location: this.location
    }
    if (this.fieldArray.length >= 1 && this.newAttribute.skills > 0) {
      this.fieldArray.push(this.newAttribute);
      obj.role = this.fieldArray;
    }
    else if (this.fieldArray.length >= 1) {
      obj.role = this.fieldArray;
    }
    this._ideahamsterservice.save(obj)
      .subscribe((response) => {
        console.log(response);
        if (response) { }
      }, (err) => {
        console.log(err);
      });
  }

  addFieldValue() {

    this.fieldArray.push(this.newAttribute)
    this.newAttribute = {};
    this.newAttribute.skills = [];
  }
  deleteFieldValue(index) {
    this.fieldArray.splice(index, 1);
  }


  //filter method for subdomain
  private _filter(value: any) {
    const filterValue = value.toLowerCase();
    return this.subdomains.filter(subdomain => subdomain.toLowerCase().includes(filterValue));
  }

  //filter method for role
  private _filter1(value1: any) {
    const filterValue1 = value1.toLowerCase();
    return this.roles.filter(role => role.toLowerCase().includes(filterValue1));
  }


  selected(event: MatAutocompleteSelectedEvent): void {
    this.newAttribute.skills.push(event.option.viewValue);
    this.skillInput.nativeElement.value = '';
    this.skillCtrl.setValue(null);
  }
//filter method for skills
  private _filter2(value2: any) {
    const filterValue2 = value2.toLowerCase();
    return this.skills.filter(fruit => fruit.toLowerCase().indexOf(filterValue2) === 0);
  }


}
