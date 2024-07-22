package com.blogapp12;

public class TestClass
{
    public static void main(String[] args)
    {
        TestClass testClass = new TestClass();

        int val = testClass.test();
        System.out.println(val);
    }

    public int test ()
    {
        Mainclass mainclass = new Mainclass();

        return mainclass.test2();
    }
}
