package com.ald.news.user.controller.api.anti;

import com.ald.news.utils.java.UserTokenUtils;

/**
 * Create by xuxm on 2018/7/19
 */
public class AntiControllerTest {

    public static void main(String[] args) {
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2OTE1OTA5NzA5MDE4NDM3OjY5MCIsImlzcyI6IkVEUyIsImlhdCI6MTUzMjQyNjc1Mn0.ZFoYXmou_y2SZiSxGukQNizjDABirH0DeWDpi9v7FTw";
        String token="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3MjcxMzk2NTU1ODExOTMxOjcwOTAzIiwiaXNzIjoiRURTIiwiaWF0IjoxNTMyNDMzMzM4fQ.UBe4j8LU13lt8KhZX6Gk1tUcWQgh59z7wAMB0yrhV10";
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1Mjg4OTkyMjAxNzM0NDc0OjQ4NjgiLCJpc3MiOiJFRFMiLCJpYXQiOjE1MzI0Mzc4NTN9.9yDub6ztyyScyJJ-1TP7XJr0NzfL53JgmDFT5zhblls";
        Long userId = UserTokenUtils.decodeTokenToUserId(token);
        System.out.println(userId);
    }
}