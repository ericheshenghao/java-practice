package cn.siques.message;

import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : heshenghao
 * @date : 17:21 2021/4/24
 */
@Data
public  abstract  class Message implements Serializable {
   private static ConcurrentHashMap<Integer, Class> map = new ConcurrentHashMap<>();

    /**
     * 请求类型 byte 值
     */
    public static final int RPC_MESSAGE_TYPE_REQUEST = 101;
    /**
     * 响应类型 byte 值
     */
    public static final int  RPC_MESSAGE_TYPE_RESPONSE = 102;

    public static Class<? extends Message> getMessageClass(int messageType) {
        return map.get(messageType);
    }


    public abstract int getMsgType();

   static {
       map.put(RPC_MESSAGE_TYPE_REQUEST, RpcRequestMsg.class);
       map.put(RPC_MESSAGE_TYPE_RESPONSE, RpcResponseMsg.class);
   }

    private int msgType;
    private  String sequenceId;


}
