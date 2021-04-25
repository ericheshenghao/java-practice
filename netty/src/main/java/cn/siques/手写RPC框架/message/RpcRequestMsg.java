package cn.siques.手写RPC框架.message;


import cn.siques.手写RPC框架.message.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : heshenghao
 * @date : 16:02 2021/4/24
 */
@Data
@NoArgsConstructor
public class RpcRequestMsg extends Message {

    private String interfaceName;
    private String methodName;
    private Class<?>[] argType;
    private Object[] args;

    /**
     * 方法返回类型
     */
    private Class<?> returnType;

    public RpcRequestMsg(String interfaceName,String methodName){
        this.interfaceName = interfaceName;
        this.methodName = methodName;
    }



    @Override
    public int getMsgType() {
        return RPC_MESSAGE_TYPE_REQUEST;
    }
}
