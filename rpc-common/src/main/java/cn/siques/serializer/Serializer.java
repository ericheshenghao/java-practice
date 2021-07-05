package cn.siques.serializer;

import java.io.*;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.serializer
 * @Description:
 * @date : 2021/7/5 8:46
 */
public interface Serializer {

    <T> T deserialize(Class<T> clazz, byte[] b);

    <T> byte[] serialize(T object);

    enum  Algorithm implements Serializer{
        Java{
            @Override
            public <T> T deserialize(Class<T> clazz, byte[] b) {
                try {
                    ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(b));
                    return (T) is.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException("反序列化失败");
                }
            }

            @Override
            public <T> byte[] serialize(T object) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(object);
                    return bos.toByteArray();
                }catch(Exception e){
                    throw new RuntimeException("序列化失败");
                }
            }
        }
    }
}
