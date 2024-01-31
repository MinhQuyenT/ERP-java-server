package com.minhphuc.hprserverjava.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MessageItem {

    private Integer code;

    private String msg;

}
