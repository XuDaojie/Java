package io.github.xudaojie.spring.aop.aspectj.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XuDaojie
 * @since 2021/7/28
 */
@Slf4j
@Service
public class EchoServiceImpl implements EchoService {

    @Override
    public void echo(String a) {
        System.out.println(getClass().getName() + " param: a=" + a);
    }

}
