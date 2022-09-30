import { Component, OnInit } from '@angular/core';
import {User} from "../../../../models/user.model";
import {EnterpriseService} from "../../../../services/enterprise.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'ic-enterprise-table',
  templateUrl: './enterprise-table.component.html',
  styleUrls: ['./enterprise-table.component.scss']
})
export class EnterpriseTableComponent implements OnInit {
  i = 0;
  enterprises!: User[];

  constructor(
    private _enterpriseService: EnterpriseService,
    private _activatedRoute: ActivatedRoute
  ) {
    this._activatedRoute.queryParamMap.subscribe((queryObj: ParamMap) => {
      if(queryObj) {
        this.enterprises = this._enterpriseService.getEnterprisesBySearch(queryObj['params']);
      }
      else {
        this.enterprises = this._enterpriseService.getAllEnterprises();
      }
    });

  }

  addRow(): void {
    this.enterprises = [
      ...this.enterprises
    ];
    this.i++;
  }

  ngOnInit(): void {
    this.addRow();
  }
}
