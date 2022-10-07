import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'ic-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss']
})
export class ButtonComponent implements OnInit {
  @Input() icon?: string;
  @Input() title?: string;
  @Input() bgColor?: string;
  @Input() type?: string;
  @Input() disabled = false;
  @Input() margin?: string;
  constructor() { }

  ngOnInit(): void {
  }

}
