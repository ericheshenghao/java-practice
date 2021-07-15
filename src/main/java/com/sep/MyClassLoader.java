package com.sep;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.sep
 * @Description:
 * @date : 2021/7/15 20:46
 */
public class MyClassLoader extends URLClassLoader {

    public MyClassLoader(){
        super(new URL[0]);
    }

}
