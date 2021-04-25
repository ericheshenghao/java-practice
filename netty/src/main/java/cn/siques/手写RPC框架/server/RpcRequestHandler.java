package cn.siques.手写RPC框架.server;

import cn.siques.手写RPC框架.client.RpcRequestMsg;
import cn.siques.手写RPC框架.server.service.impl.ServiceContainer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.Method;

/**
 * @author : heshenghao
 * @date : 19:55 2021/4/24
 */
public class RpcRequestHandler extends SimpleChannelInboundHandler<RpcRequestMsg> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequestMsg msg) throws Exception {
        RpcResponseMsg response = new RpcResponseMsg();
        response.setSequenceId(msg.getSequenceId());
        System.out.println(response.getMsgType());
        try {
            Class<?> aClass = Class.forName(msg.getInterfaceName());
            Object service = ServiceContainer.getService(aClass);
            Class<?>[] argType = msg.getArgType();
            Object res = null;

            if(argType.length==0){
               Method method =  service.getClass().getMethod(msg.getMethodName());
                res = method.invoke(service);
            }else {
                Method method = service.getClass().getMethod(msg.getMethodName(), msg.getArgType());
                res = method.invoke(service,msg.getArgs());
            }

            response.setReturnValue(res);
        }catch (Exception e){
            response.setE(e);
        }
        ctx.writeAndFlush(response);
    }
}
