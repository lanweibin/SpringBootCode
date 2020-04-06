package com.lwb.wxchat.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-04-04 17:57
 **/
@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage {

    @XStreamAlias("Voice")
    private Voice voice;

    @XStreamAlias("MediaId")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public VoiceMessage(Map<String, String> requestMap, String mediaId) {
        super(requestMap);
        this.setMsgType("voice");

        this.mediaId = mediaId;
    }


    public VoiceMessage(Map<String, String> requestMap, Voice voice) {
        super(requestMap);
        this.setMsgType("voice");
//        this.setVoice("\n<MediaId><![CDATA["+mediaId+"]]></MediaId>");
        this.setVoice(voice);
//        this.mediaId = mediaId;
    }
}
