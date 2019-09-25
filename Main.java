package com.company;

public class Main {

    public static void main(String[] args)throws Exception {
        MyEncoder coder1 = new MyEncoder();
        User user = new User();
        byte[] stream1 = coder1.serialize(user);
        System.out.println(coder1.deserialize(stream1));

        MyEncoder coder2 = new MyEncoder();
        JBeans beans = new JBeans();
        byte[] stream2 = coder2.serialize(beans);
        System.out.println(coder2.deserialize(stream2));
    }
}
