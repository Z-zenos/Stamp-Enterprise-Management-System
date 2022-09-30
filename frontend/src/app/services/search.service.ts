import { Injectable } from '@angular/core';
import {FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {Package} from "../models/package_service.model";
import {packageData} from "../../data";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(
    private _router: Router
  ) { }


  search(form: FormGroup, pathName: string): void {
    const controls = form.controls;
    const filterQuery = {};

    // Create filter object from keys of package model
    Object.keys(controls).forEach(p => filterQuery[p] = controls[p].value);

    if(filterQuery)
      this._router?.navigate([pathName], { queryParams: filterQuery, skipLocationChange: true });
  }

  getDataBySearch(data: any[], query: any): any[] {

    // Clear fields that haven't value
    query = Object
      .entries(query)
      .reduce(
        (queryCleared,[key,val]) =>
          val
            ? (queryCleared[key] = val, queryCleared)
            : queryCleared
          ,
        {}
      );

    return data.filter(p =>
      Object.keys(query).every(key =>
        !(
          p[key] === undefined ||
          (typeof p[key] === 'number' && p[key] != query[key]) ||
          (typeof p[key] === 'string' && !p[key].includes(query[key]))
        )
      )
    );
  }
}
