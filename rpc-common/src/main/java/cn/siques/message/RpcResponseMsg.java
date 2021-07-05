package cn.siques.message;

import lombok.Data;

/**
 * @author : heshenghao
 * @date : 16:02 2021/4/24
 */
@Data
public class RpcResponseMsg extends Message {

    private Object returnValue;
    private Exception e;



    @Override
    public int getMsgType() {
        return RPC_MESSAGE_TYPE_RESPONSE;
    }
}
