package cn.siques.手写RPC框架.server;

import cn.siques.手写RPC框架.server.Message;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.swing.event.MenuEvent;

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
