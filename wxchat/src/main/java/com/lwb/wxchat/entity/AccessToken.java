package com.lwb.wxchat.entity;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-04-05 12:01
 **/
public class AccessToken {


    private String accessToken;
    private long expireTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public AccessToken(String accessToken, String expireIn) {
        super();
        this.accessToken = accessToken;
        expireTime = System.currentTimeMillis()+Integer.parseInt(expireIn)*1000;
    }

    /**
     * 判断token是否过期
     * @return
     * by 罗召勇 Q群193557337
     */
    public boolean isExpired() {
        return System.currentTimeMillis()>expireTime;
    }
}
