package com.mashibing.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculatorProxy {
    public static Calculator getProxy(final Calculator calculator){
        ClassLoader loader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler h = new MyInvocationHandler(calculator);
        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);

        return (Calculator) proxy;
    }

    private static class MyInvocationHandler implements InvocationHandler {
        private final Calculator calculator;

        public MyInvocationHandler(Calculator calculator) {
            this.calculator = calculator;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = null;
            try {

                System.out.println(method);

                System.out.println("invoke begin");
                result = method.invoke(calculator, args);
                System.out.println("invoke end");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            return result;
        }
    }
}