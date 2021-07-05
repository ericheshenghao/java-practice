package cn.siques.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.codec
 * @Description:
 * @date : 2021/7/5 9:04
 */
public class ProtoFrameDecoder extends LengthFieldBasedFrameDecoder {
    public ProtoFrameDecoder() {
        super(1024, 44, 4, 0, 0);
    }
}
