package com.难度归档.笔试;

  class Test
{

    public static Test t1 = new Test();

    static
    {
        System.out.println("blockB");
    }

    {
        System.out.println("blockA");
    }

    public static void main(String[] args)
    {
        Test t2 = new Test();
    }
}
