package com.难度归档.笔试;

public class Test04 {

           static int x = 10;

         static { x += 5; }

    public static void main(String args[])
     {
     System.out.println("x = " + Test04.x);
     }
    static
           {x /= 3; }
   }

