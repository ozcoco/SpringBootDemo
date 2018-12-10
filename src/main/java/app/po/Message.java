package app.po;

import java.io.Serializable;

public class Message implements Serializable, Cloneable {

    public final static int OK = 0;

    public final static int FAIL_PARAM_NULL = 1;

    public final static int FAIL_SERVICE = 2;


    private int code;

    private String msg;

    private byte[] data;


    public Message() {
    }

    public Message(int code, String msg, byte[] data) {
        this.code = code;
        this.msg = msg;
        this.data = data;

    }

    public static Message INSTANCE() {

        return new Message();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        System.out.println(" --------> finalize!!!!!! ");

    }
}
