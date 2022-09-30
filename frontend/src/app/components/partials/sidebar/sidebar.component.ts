import {Component, Input, OnInit} from '@angular/core';
import {Location} from "@angular/common";

@Component({
  selector: 'ic-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  @Input() isCollapsed!: boolean;
  route!: string;

  constructor(
    private _location: Location
  ) {
    this.route = this._location.path();
  }

  ngOnInit(): void {
  }

}
