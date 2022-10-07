import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ic-package-page',
  templateUrl: './package-page.component.html',
  styleUrls: ['./package-page.component.scss']
})
export class PackagePageComponent implements OnInit {

  isVisible = false;
  constructor() { }

  ngOnInit(): void {
  }


  showPackageForm(): void {
    this.isVisible = true;
  }

  hidePackageForm(isVisible: boolean): void {
    this.isVisible = isVisible;
  }
}
