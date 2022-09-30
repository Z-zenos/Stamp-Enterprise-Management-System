import { Injectable } from '@angular/core';
import {User} from "../models/user.model";
import {enterpriseData} from "../../data";
import {SearchService} from "./search.service";

@Injectable({
  providedIn: 'root'
})
export class EnterpriseService {

  constructor(private _searchService: SearchService) { }

  getAllEnterprises(): User[] {
    return enterpriseData;
  }

  getEnterprisesBySearch = (query: string): User[] => this._searchService.getDataBySearch(enterpriseData, query);
}
