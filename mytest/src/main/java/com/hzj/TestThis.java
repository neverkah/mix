package com.hzj;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.aspectj.annotation.AspectJAdvisorFactory;
import org.springframework.aop.aspectj.annotation.BeanFactoryAspectJAdvisorsBuilder;
import org.springframework.beans.factory.ListableBeanFactory;

public class TestThis {

    public static void main(String[] args) {
       //String.this.isEmpty()
    }





     public void haveFun(){

     }

    private class BeanFactoryAspectJAdvisorsBuilderAdapter {

        public BeanFactoryAspectJAdvisorsBuilderAdapter(
                ListableBeanFactory beanFactory, AspectJAdvisorFactory advisorFactory) {

        }


        protected boolean isEligibleBean(String beanName) {
             TestThis.this.haveFun();
             return true;
        }
    }
}
