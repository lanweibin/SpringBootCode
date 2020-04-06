package com.lwb.wxchat.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-04-05 11:41
 **/
@XStreamAlias("Voice")
public class Voice {
    @XStreamAlias("MediaId")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
