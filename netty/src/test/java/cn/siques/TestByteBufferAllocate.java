package cn.siques;

import java.nio.ByteBuffer;

/**
 * @author : heshenghao
 * @date : 17:05 2021/4/16
 */
public class TestByteBufferAllocate {
    public static void main(String[] args) {
        // 固定值

        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
        /**
         *class java.nio.HeapByteBuffer - 使用java堆内存，读写效率低的原因是
         * 需要由用户态向内核态拷贝，受到 GC的影响
         * class java.nio.DirectByteBuffer - 使用直接内存，零拷贝，不会收到垃圾回收的影响
         * 分配效率不高，需要显示的去释放内存
         */
    }
}
