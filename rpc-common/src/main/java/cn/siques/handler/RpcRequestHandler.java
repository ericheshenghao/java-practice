package cn.siques.handler;

import cn.siques.message.RpcRequestMsg;
import cn.siques.message.RpcResponseMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

/**
 * @author: 何胜豪
 * @Title: 请求消息入栈
 * @Package: cn.siques.handler
 * @Description:
 * @date : 2021/7/5 12:26
 */
public class RpcRequestHandler extends SimpleChannelInboundHandler<RpcRequestMsg> {

   @Autowired
    ApplicationContext applicationContext;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequestMsg msg) throws Exception {
        RpcResponseMsg response = new RpcResponseMsg();
        Object[] args = msg.getArgs();
        Class<?>[] argType = msg.getArgType();
        String beanName = msg.getInterfaceName();
        Class<?> aClass = Class.forName(beanName);
        Object service = applicationContext.getBean(aClass);
        Method method =  service.getClass().getMethod(msg.getMethodName(),argType);
        Object res = method.invoke(service,args);
        response.setReturnValue(res);
        response.setSequenceId(msg.getSequenceId());
        ctx.writeAndFlush(response);
    }
}
