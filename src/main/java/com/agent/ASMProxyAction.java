package com.agent;


import jdk.internal.org.objectweb.asm.*;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.agent
 * @Description:
 * @date : 2021/7/3 15:24
 */
public class ASMProxyAction {
    public byte[] aop(byte[] bytes) {
        ClassReader cr = new ClassReader(bytes);
        return aop(cr);
    }

    private byte[] aop(ClassReader cr) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                if (!"say".equals(name)) {
                    return mv;
                }
                MethodVisitor aopMV = new MethodVisitor(super.api, mv) {
                    @Override
                    public void visitCode() {
                        super.visitCode();
                        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                        mv.visitLdcInsn("before core action");
                        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
                    }

                    @Override
                    public void visitInsn(int opcode) {
                        if (Opcodes.RETURN == opcode) {
                            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                            mv.visitLdcInsn("after core action");
                            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
                        }
                        super.visitInsn(opcode);
                    }
                };
                return aopMV;
            }
        }, ClassReader.SKIP_DEBUG);
        return cw.toByteArray();
    }
}
