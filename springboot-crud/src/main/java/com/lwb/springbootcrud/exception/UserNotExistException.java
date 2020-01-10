package com.lwb.springbootcrud.exception;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-01-10 20:20
 **/
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
