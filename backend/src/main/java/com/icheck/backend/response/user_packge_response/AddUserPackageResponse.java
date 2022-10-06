package com.icheck.backend.response.user_packge_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserPackageResponse {

    private Long id;

    private Long userId;

    private Long packageId;

    private int status;

    private LocalDateTime created_at;

    private LocalDateTime update_at;
}
