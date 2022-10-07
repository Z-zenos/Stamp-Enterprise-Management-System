import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-badge',
  templateUrl: './badge.component.html',
  styleUrls: ['./badge.component.scss']
})
export class BadgeComponent implements OnInit {
  @Input() bgColor?: string;
  @Input() title!: string;
  constructor() { }

  ngOnInit(): void {
  }

}
