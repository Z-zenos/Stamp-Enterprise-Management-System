import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Validation} from "../../../services/validation.service";

@Component({
  selector: 'ic-package-form',
  templateUrl: './package-form.component.html',
  styleUrls: ['./package-form.component.scss']
})
export class PackageFormComponent implements OnInit {
  @Input() isVisible = false;
  @Output() visibleEvent: EventEmitter<boolean> = new EventEmitter<boolean>();

  errors: Record<string, Record<string, string>> = {
    en: {
      required: 'Hãy điền đầy đủ thông tin!'
    }
  };

  packageForm: FormGroup;

  constructor(private _fb: FormBuilder) {
    this.packageForm = this._fb.group(
      {
        name: [
          'Premium',
          [
            Validators.required,
            Validation.maxLength(255)
          ],
        ],

        code: [
          '123456789',
          [
            Validators.required,
            Validation.isOnlyNumber
          ]
        ],

        quantity: [
          '8',
          [
            Validators.required,
            Validation.isOnlyNumber
          ]
        ],

        price: [
          '12',
          [
            Validators.required,
            Validation.isOnlyNumber
          ]
        ],

        status: 1,
        createdAt: Date.now()
      },
    );
  }

  ngOnInit(): void {
  }

  // getter f to access form controls (f.username, f.email...)
  get f(): { [key: string]: AbstractControl } {
    return this.packageForm.controls;
  }

  onSubmit(): void {
    if(this.packageForm.invalid) {
      return;
    }
    console.log(JSON.stringify(this.packageForm.value, null, 2));
    this.isVisible = false;
    this.visibleEvent.emit(this.isVisible);
  }

  onReset(e: MouseEvent): void {
    e.preventDefault();
    this.packageForm.reset();
    for (const key in this.packageForm.controls) {
      if (this.packageForm.controls.hasOwnProperty(key)) {
        this.packageForm.controls[key].markAsPristine();
        this.packageForm.controls[key].updateValueAndValidity();
      }
    }
  }

  hide(): void {
    this.isVisible = false;
    this.visibleEvent.emit(this.isVisible);
  }
}
