import {AbstractControl, ValidatorFn, Validators} from "@angular/forms";
import {NzSafeAny} from "ng-zorro-antd/core/types";

export type errorOpts = {
  en: string
} & Record<string, NzSafeAny>;

export type validationErrors = Record<string, errorOpts>;

const errMsgs = {
  phone: {
    message: 'Số điện thoại chỉ chứa 10 hoặc 11 chữ số!',
    fn: isPhone
  },
  email: {
    message: 'Email không hợp lệ!',
    fn: isEmail
  },
  taxcode: {
    message: 'Taxcode không hợp lệ!',
    fn: isTaxcode
  },
  password: {
    message: 'Mật khẩu không hợp lệ',
    fn: isPassword
  },
}

function isEmptyInputValue(value: NzSafeAny): boolean {
  return value == null || value.length === 0;
}

// Validate fields: phone, email, taxcode
function validateFn(fieldName: string, value: string): validationErrors | null {
  return errMsgs[fieldName].fn(value) ?
    null :
    {
      [fieldName]: {
        en: errMsgs[fieldName].message
      }
    };
}

function isPhone(value: string): boolean {
  return /(03|05|07|08|09|01[2|6|8|9])+([0-9]{8,9})\b/.test(value);
}

function isEmail(value: string): boolean {
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value);
}

function isTaxcode(value: string): boolean {
  return /\d{10,12}/.test(value);
}

function isPassword(value: string): boolean {
  return /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/.test(value);
}

export class Validation extends Validators {
  static override minLength(minLength: number): ValidatorFn {
    return (control: AbstractControl): validationErrors | null => {
      if (Validators.minLength(minLength)(control) === null) {
        return null;
      }
      return {
          minlength: { en: `Độ dài tối thiểu là ${minLength} ký tự!`
        }
      };
    };
  }

  static override maxLength(maxLength: number): ValidatorFn {
    return (control: AbstractControl): validationErrors | null => {
      if (Validators.maxLength(maxLength)(control) === null) {
        return null;
      }
      return {
        maxlength: { en: `Độ dài tối đa là ${maxLength} ký tự!` }
      };
    };
  }

  static match(controlName: string, checkControlName: string): ValidatorFn {
    return (controls: AbstractControl): validationErrors | null => {
      const control = controls.get(controlName);
      const checkControl = controls.get(checkControlName);

      // Check two fields match or not.
      if(control?.value !== checkControl?.value) {
        // Set error on checking control if validation fails.
        controls.get(checkControlName)?.setErrors({ matching: true });
        return {
          match: { en: 'Mật khẩu không trùng khớp!' }
        };
      }
      else {
        return null;
      }
    }
  }

  static isOnlyNumber(control: AbstractControl): validationErrors | null {
    return !/^\d+$/.test(control.value) ? { number: {en: 'Trường chỉ chứa số!'} } : null;
  }

  static validate(controlName: string): ValidatorFn {
    return (control: AbstractControl): validationErrors | null => {
      return isEmptyInputValue(control.value) ? null : validateFn(controlName, control.value);
    }
  }
}
