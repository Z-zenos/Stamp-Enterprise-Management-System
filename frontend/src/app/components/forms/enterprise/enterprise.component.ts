import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {
  AbstractControl, FormBuilder,
  FormGroup,
  Validators
} from "@angular/forms";
import {Validation} from "../../../services/validation.service";

@Component({
  selector: 'ic-enterprise-form',
  templateUrl: './enterprise.component.html',
  styleUrls: ['./enterprise.component.scss']
})
export class EnterpriseComponent implements OnInit {
  @Input() isVisible = false;
  @Output() visibleEvent: EventEmitter<boolean> = new EventEmitter<boolean>();

  errors: Record<string, Record<string, string>> = {
    en: {
      required: 'Hãy điền đầy đủ thông tin!'
    }
  };

  enterpriseForm: FormGroup;

  constructor(private _fb: FormBuilder) {
    this.enterpriseForm = this._fb.group(
      {
        name: [
          'Facebook',
          [
            Validators.required,
            Validation.maxLength(255)
          ],
        ],

        email: [
          'abc@gmail.com',
          [
            Validators.required,
            Validation.validate('email')
          ]
        ],

        phone: [
          '09891938735',
          [
            Validators.required,
            Validation.validate('phone')
          ]
        ],

        taxcode: [
          '33366699900',
          [
            Validators.required,
            Validation.validate('taxcode')
          ]
        ],

        address: [
          'a',
          [
            Validators.required,
            Validation.maxLength(255)
          ]
        ],

        city: [
          'a',
          [
            Validators.required,
            Validation.maxLength(255)
          ]
        ],

        district: [
          'a',
          [
            Validators.required,
            Validation.maxLength(255)
          ]
        ],

        status: [1, Validators.required],

        password: [
          'Abc1234@',
          [
            Validators.required,
            Validation.validate('password')
          ]
        ],
        confirmPassword: [
          'Abc1234@',
          [
            Validators.required,
            Validation.validate('password')
          ]
        ],
        createdAt: [Date.now()]
      },
      {
        validators: [
          Validation.match('password', 'confirmPassword')
        ]
      }
    );
  }

  ngOnInit(): void {
  }

  // getter f to access form controls (f.username, f.email...)
  get f(): { [key: string]: AbstractControl } {
    return this.enterpriseForm.controls;
  }

  onSubmit(): void {
    if(this.enterpriseForm.invalid) {
      return;
    }
    console.log(JSON.stringify(this.enterpriseForm.value, null, 2));
    this.isVisible = false;
    this.visibleEvent.emit(this.isVisible);
  }

  onReset(e: MouseEvent): void {
    e.preventDefault();
    this.enterpriseForm.reset();
    for (const key in this.enterpriseForm.controls) {
      if (this.enterpriseForm.controls.hasOwnProperty(key)) {
        this.enterpriseForm.controls[key].markAsPristine();
        this.enterpriseForm.controls[key].updateValueAndValidity();
      }
    }
  }

  hide(): void {
    this.isVisible = false;
    this.visibleEvent.emit(this.isVisible);
  }
}
