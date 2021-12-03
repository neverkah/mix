package com.mashibing.proxy.jdk;

public class Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Calculator proxy = CalculatorProxy.getProxy(new MyCalculator());
        System.out.println(proxy == null);
      proxy.add(2,3);
        System.out.println(proxy.getClass());
    }
}