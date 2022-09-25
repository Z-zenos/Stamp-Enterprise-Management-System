import { Component, OnInit } from '@angular/core';
import {User} from "../../../models/user.model";
import {EnterpriseService} from "../../../services/enterprise.service";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})
export class TableComponent implements OnInit {

  i = 0;

  enterprises: User[];

  constructor(private _enterpriseService: EnterpriseService) {
    this.enterprises = this._enterpriseService.getAllEnterprises();
  }

  addRow(): void {
    this.enterprises = [
      ...this.enterprises,
      ...this.enterprises,
      ...this.enterprises,
      ...this.enterprises,
      ...this.enterprises,
      ...this.enterprises,
      ...this.enterprises,
      ...this.enterprises,
    ];
    this.i++;
  }

  ngOnInit(): void {
    this.addRow();
  }
}
