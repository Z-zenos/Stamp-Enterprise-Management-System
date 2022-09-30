import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'ic-headerbar',
  templateUrl: './headerbar.component.html',
  styleUrls: ['./headerbar.component.scss']
})
export class HeaderbarComponent implements OnInit {
  @Input() isCollapsed!: boolean;
  @Output() collapsedEvent: EventEmitter<boolean> = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

  toggleCollapsed(): void {
    this.isCollapsed = !this.isCollapsed;
    this.collapsedEvent.emit(this.isCollapsed);
  }

}
