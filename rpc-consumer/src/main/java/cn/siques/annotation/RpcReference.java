package cn.siques.annotation;

import java.lang.annotation.*;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.annotation
 * @Description:
 * @date : 2021/7/5 13:35
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface RpcReference{


}
