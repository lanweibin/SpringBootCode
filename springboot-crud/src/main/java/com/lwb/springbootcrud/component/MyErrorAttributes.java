package com.lwb.springbootcrud.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-01-10 20:56
 **/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("key","自定义错误");
        return map;
    }
}
