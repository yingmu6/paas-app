package com.orange.starter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author
 * @date
 */
public class PaasAppStarter {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("paas-app-starter.xml");
        context.start();
        System.in.read();
    }
}