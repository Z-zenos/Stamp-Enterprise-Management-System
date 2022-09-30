import {Component, Input, OnInit} from '@angular/core';

@Component({
<<<<<<< HEAD
  selector: 'ic-button',
=======
<<<<<<< HEAD
  selector: 'ic-button',
=======
  selector: 'app-button',
>>>>>>> 8c4af7ad011904e96dbddc69e780f99e936a5ec9
>>>>>>> f80ebbfd8b2941475fa2d9cbf6ab92e4e5ba3c80
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss']
})
export class ButtonComponent implements OnInit {
  @Input() icon?: string;
  @Input() title?: string;
  @Input() bgColor?: string;
<<<<<<< HEAD
  @Input() type?: string;
  @Input() disabled = false;
  @Input() margin?: string;
=======
<<<<<<< HEAD
  @Input() type?: string;
  @Input() disabled = false;
  @Input() margin?: string;
=======
>>>>>>> 8c4af7ad011904e96dbddc69e780f99e936a5ec9
>>>>>>> f80ebbfd8b2941475fa2d9cbf6ab92e4e5ba3c80

  constructor() { }

  ngOnInit(): void {
  }

}
