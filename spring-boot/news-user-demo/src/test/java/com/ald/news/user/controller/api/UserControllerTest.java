package com.ald.news.user.controller.api;

import org.apache.commons.lang3.StringUtils;

/**
 * Create by xuxm on 2018/7/24
 */
public class UserControllerTest {

    public static void main(String[] args) {
        String deviceInfo = "ONEPLUS A5010:Android:8.0.0:868233035190857:06999acffe485d99";
        String deviceId = getDeviceId(deviceInfo);
        System.out.println(deviceId);

    }

    public static String getDeviceId(String deviceInfo) {
        if (StringUtils.isNotEmpty(deviceInfo)) {
            switch (deviceInfo) {
                case "H5":
                    return "H5";
                default:
                    String[] split = deviceInfo.split(":");
                    if (split.length == 5) {
                        return split[3];
                    } else {
                        return "";
                    }
            }
        }
        return "";
    }
}