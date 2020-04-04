package com.lwb.entites;

import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-03-22 21:19
 **/
public class TextMessage extends BaseMessage {

    private String  content;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public TextMessage(Map<String, String> requestMap, String content) {
        super(requestMap);
        this.setMsgType("text");
        this.content = content;
    }

    @Override
    public String toString() {
        String fromUserName = getFromUserName();
        String toUserName = getToUserName();
        String createTime = getCreateTime();
        String msgType = getMsgType();
        return "fromUserName----"+fromUserName+
                "------toUserName----"+toUserName+
                "------createTime----"+createTime+
                "------msgType----"+msgType+
                "------content----"+content;
    }
}
