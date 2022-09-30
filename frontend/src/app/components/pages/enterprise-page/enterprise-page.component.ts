import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ic-enterprise-page',
  templateUrl: './enterprise-page.component.html',
  styleUrls: ['./enterprise-page.component.scss']
})
export class EnterprisePageComponent implements OnInit {

  isVisible = false;
  constructor() { }

  ngOnInit(): void {
  }

  showEnterpriseForm(): void {
    this.isVisible = true;
  }

  hideEnterpriseForm(isVisible: boolean): void {
    this.isVisible = isVisible;
  }

}
