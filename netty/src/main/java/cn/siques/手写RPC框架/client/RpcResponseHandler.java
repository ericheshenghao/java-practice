package cn.siques.手写RPC框架.client;

import cn.siques.手写RPC框架.server.RpcResponseMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.Promise;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : heshenghao
 * @date : 16:02 2021/4/24
 */
public class RpcResponseHandler extends SimpleChannelInboundHandler<RpcResponseMsg> {
    public static final  ConcurrentHashMap<String, Promise<Object>>  PROMISES =   new ConcurrentHashMap<>();


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcResponseMsg msg) throws Exception {
        Promise<Object> promise = PROMISES.remove(msg.getSequenceId());
        if(promise!=null){
            Exception exception = msg.getE();
            Object returnValue = msg.getReturnValue();
            if(exception!=null) {
                promise.setFailure(exception);
            } else {
                promise.setSuccess(returnValue);
            }
        }

    }
}
