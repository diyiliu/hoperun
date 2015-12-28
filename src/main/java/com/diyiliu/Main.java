package com.diyiliu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: Main
 * Author: DIYILIU
 * Update: 2015-12-28 10:04
 */
public class Main {

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
