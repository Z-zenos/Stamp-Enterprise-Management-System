import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {SearchService} from "../../../../services/search.service";

@Component({
  selector: 'ic-enterprise-box-search',
  templateUrl: './enterprise-box-search.component.html',
  styleUrls: ['./enterprise-box-search.component.scss']
})
export class EnterpriseBoxSearchComponent implements OnInit {

  enterpriseForm!: FormGroup;

  constructor(
    private _fb: FormBuilder,
    public searchService: SearchService
  ) {
    this.enterpriseForm = this._fb.group({
      name: 'Go',
      phone: '',
      taxcode: '',
      address: '',
      city: '',
      district: '',
      createdAt: '',
      status: ''
    });
  }

  ngOnInit(): void {
  }

  onReset(): void {
    this.enterpriseForm.reset();
  }

}
