package com.company.chapter20.注解.Annotation3;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class userclass = Class.forName("com.company.chapter20.注解.Annotation3.User");
        // 旁段是否有id注解
        if (userclass.isAnnotationPresent(Id.class)) {
            // 有id注解时候，必须有id属性
            //获取类的属性
            Field[] fields = userclass.getDeclaredFields();

            boolean isRight = false;

            for (Field field : fields
            ) {
                if ("id".equals(field.getName()) && "int".equals(field.getType().getSimpleName())) {
                    isRight = true;  // 表示合法
                    break;
                }
            }
            if (!isRight) {
                throw new NotHasIdException("错误");
            }

        }
    }
}

