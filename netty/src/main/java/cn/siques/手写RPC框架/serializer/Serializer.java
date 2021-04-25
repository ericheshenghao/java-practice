package cn.siques.手写RPC框架.serializer;

import java.io.*;

/**
 * @author : heshenghao
 * @date : 18:51 2021/4/24
 */
public interface Serializer {

    <T> T deserialize(Class<T> clazz, byte[] bytes);

    <T> byte[] serialize(T object);

    enum  Algorithm implements Serializer{
        Java{
            @Override
            public <T> T deserialize(Class<T> clazz, byte[] bytes) {
                try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
                  return (T) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                   throw new RuntimeException("反序列化失败");
                }
            }

            @Override
            public <T> byte[] serialize(T object)  {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                    oos.writeObject(object);
                    return bos.toByteArray();
                } catch (IOException e) {
                    throw  new RuntimeException(e);
                }
            }
        }
    }
}
