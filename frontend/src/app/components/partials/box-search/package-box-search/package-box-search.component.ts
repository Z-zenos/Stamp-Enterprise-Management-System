import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {SearchService} from "../../../../services/search.service";

@Component({
  selector: 'ic-package-box-search',
  templateUrl: './package-box-search.component.html',
  styleUrls: ['./package-box-search.component.scss']
})
export class PackageBoxSearchComponent implements OnInit {

  packageForm!: FormGroup;

  constructor(
    private _fb: FormBuilder,
    public searchService: SearchService
  ) {
    this.packageForm = this._fb.group({
      name: 'Handmade',
      code: '27415',
      status: '1'
    });
  }

  ngOnInit(): void {
  }

  onReset(): void {
    this.packageForm.reset();
  }
}
