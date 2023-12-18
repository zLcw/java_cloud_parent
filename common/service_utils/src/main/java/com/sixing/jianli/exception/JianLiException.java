package com.sixing.jianli.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JianLiException extends RuntimeException {
    private Integer code;
    private String msg;
}
