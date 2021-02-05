package com.example.demo.common.dto;

import com.example.demo.common.cd.ErrorCd;
import lombok.*;
import org.springframework.core.env.Environment;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO implements Serializable {

    private String errorCode;
    private String messageKey;

    public ErrorDTO(ErrorCd errorCd) {
        this.errorCode = errorCd.name();
        this.messageKey = errorCd.getMessageKey();
    }
}
