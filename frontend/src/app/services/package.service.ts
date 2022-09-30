import {Injectable} from '@angular/core';
import {packageData} from "../../data";
import {Package} from "../models/package_service.model";
import {SearchService} from "./search.service";

@Injectable({
  providedIn: 'root'
})
export class PackageService {

  constructor(private _searchService: SearchService) { }

  getAllPackages(): Package[] {
    return packageData;
  }

  getPackagesBySearch = (query: string): Package[] => this._searchService.getDataBySearch(packageData, query);
}
