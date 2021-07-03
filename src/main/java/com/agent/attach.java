package com.agent;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.agent
 * @Description:
 * @date : 2021/7/2 22:59
 */
public class attach {
    public static void main(String[] args) {
        try {
            //获取当前系统中所有 运行中的 虚拟机
            System.out.println("running JVM start ");
            List<VirtualMachineDescriptor> list = VirtualMachine.list();
            System.out.println(list);

        }catch (Exception e){

        }
    }
}
