import { Component, OnInit } from '@angular/core';
import {PackageService} from "../../../../services/package.service";
import {Package} from "../../../../models/package_service.model";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'ic-package-table',
  templateUrl: './package-table.component.html',
  styleUrls: ['./package-table.component.scss']
})
export class PackageTableComponent implements OnInit {
  i = 0;
  packages!: Package[];

  constructor(
    private _packageService: PackageService,
    private _activatedRoute: ActivatedRoute
  ) {
    this._activatedRoute.queryParamMap.subscribe((queryObj: ParamMap) => {
      if(queryObj) {
        this.packages = this._packageService.getPackagesBySearch(queryObj['params']);
      }
      else {
        this.packages = this._packageService.getAllPackages();
      }
    });

  }

  addRow(): void {
    this.packages = [
      ...this.packages,
    ];
    this.i++;
  }

  ngOnInit(): void {
    this.addRow();
  }

}
