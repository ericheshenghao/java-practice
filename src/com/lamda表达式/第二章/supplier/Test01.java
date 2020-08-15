package com.lamda表达式.第二章.supplier;

import com.sun.xml.internal.fastinfoset.util.PrefixArray;

import java.util.function.DoubleSupplier;
import java.util.logging.Logger;


public class Test01 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("com.lamda表达式.第二章.supplier.Test01");

        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };
        randomSupplier= ()->Math.random();
        randomSupplier =Math::random;
        logger.info(String.valueOf(randomSupplier.getAsDouble()));



   }
}
