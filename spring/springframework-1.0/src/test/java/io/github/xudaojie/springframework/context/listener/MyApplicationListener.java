package io.github.xudaojie.springframework.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent e) {
        System.out.println(e.getClass() + ":" + e.getSource() + ": " + e.getTimestamp());
    }
}
