package com.icheck.backend.exception;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorMessage {
    ID_EXISTED(1, "Không tìm thấy Id"),
    CODE_EXISTED(2, "Mã code đã tồn tại"),
    DATA_NOTFOUND(3, "Không tìm thấy dữ liệu."),
    SUCCESS(999, "Thành công!"),

    EMAIL_EXISTED(4, "Email đã tồn tại."),
    PHONE_EXISTED(5, "Số điện thoại đã tồn tại"),
    TAXCODE_EXISTED(6, "Mã số thuế đã tồn tại"),
    USERPACKAGE_EXISTED(7, "Gói đăng kí đã tồn tại."),

    INCORRECT_LOGIN(8, "Incorrect username or password"),
    TOKEN_EXPIRE(9, "Token hết hạn");
//    FIELD_REQUIRED("E1", "Field required"),
//
//    FIELD_INVALID("E2", "Field invalid"),
//
//
//
//    FIELD_EXISTED("E3", "Field already exists. Try again."),
//
//    FIELD_INCORRECT("E5", "Incorrect value"),
//
//    CHANGE_VERIFICATION("E9", "Change verification method"),
//
//    FIELD_PASSWORD_DO_NOT_MATCH("E4", "These passwords do not match. Please try again."),
//
//    PASSWORD_EXISTED("E401", "Password already exists. Try again."),
//
//    DEVICE_LIMIT("E23", "Device limit is reached"),
//
//    INCORREC_LOGIN("E11", "Incorrect"),
//
//    ACCOUNT_LOCK("E10", "Account has been disabled. Please contact the MedPing admin for more information"),
//
//    ACCOUNT_DISABLE("E112", "Account Disable"),
//
//    DATA_INVALID("E400", "Field invalid"),
//
//    DATA_NOTFOUND("E404", "Data Not Found"),
//
//    SUCCESS("S001", "SUCCESS"),
//
//    SYSTEM_ERROR("E001", "System Error"),
//
//    ME_BLOCK_USER("E100", "The user has been blocked by you"),
//
//    USER_BLOCK_ME("E101", "You have been blocked by a user"),
//    BLOCKED_EACH_ORTHER("E102", "You and that person blocked each other"),
//    REQUIRED_COMPANY_PROFILE("E103", "required company information"),
//    POLL_CLOSE("E104", "Poll is closed"),
//    ACCESS_DENIED("E503", "System Error"),
//    TOKEN_EXPIRED("E503", "token het han");
    private int code;

    private String message;

    public void setCode(int code){
        this.code = code;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
