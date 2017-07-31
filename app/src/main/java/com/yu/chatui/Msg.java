package com.yu.chatui;

/**
 * Created by D22436 on 2017/7/31.
 */

public class Msg {
    public static final int MSG_TYPE_RECEIVE = 0;  // 接收
    public static final int MSG_TYPE_SEND = 1;  // 发送

    private int msgId;
    private int msgType;
    private String msg;

    public Msg(int msgId, int msgType, String msg) {
        this.msgId = msgId;
        this.msgType = msgType;
        this.msg = msg;
    }

    public int getMsgId() {
        return msgId;
    }

    public int getMsgType() {
        return msgType;
    }

    public String getMsg() {
        return msg;
    }
}
