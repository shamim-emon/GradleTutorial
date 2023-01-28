package com.example;

import org.apache.commons.lang3.StringUtils;

public class PrintService {

    public void print(MessageModel messageModel){
        String message = StringUtils.trim(messageModel.getMessage());
        System.out.println(message);
    }
}
