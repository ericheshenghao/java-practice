package cn.siques.手写RPC框架.server;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import sun.dc.pr.PRError;

/**
 * @author : heshenghao
 * @date : 16:40 2021/4/24
 */
public class ProtoFrameDecoder extends LengthFieldBasedFrameDecoder {

    /**
     * 拆包，粘包
     */
    public ProtoFrameDecoder(){
        super(1024, 44, 4, 0, 0);
    }
}
