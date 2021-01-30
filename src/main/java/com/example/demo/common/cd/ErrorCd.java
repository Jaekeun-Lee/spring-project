package com.example.demo.common.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCd {

    WRONG_PASSWORD("wrong.password"),


    ;

    private final String messageKey;

}
