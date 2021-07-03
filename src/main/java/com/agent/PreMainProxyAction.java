package com.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @author: 何胜豪
 * @Title: 打包类 jar -cvf test.jar PreMainProxyAction.class
 * @Package: com.agent
 * @Description:
 * @date : 2021/7/3 15:20
 */
public class PreMainProxyAction implements ClassFileTransformer {

    public static void premain(String agentArgs, Instrumentation ist) {
        ist.addTransformer(new PreMainProxyAction());
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!"demo/CoreActionImpl".equals(className)) {
            return classfileBuffer;
        }
        ASMProxyAction asmProxyAction = new ASMProxyAction();
        byte[] aop = asmProxyAction.aop(classfileBuffer);
        return aop;
    }
}
