package com.xdj.javaee.bean;

/**
 * Created by xdj on 2017/5/22.
 */
public class RabbitMessage {

    private Class<?>[] paramType;
    private String exchange;
    private Object[] params;
    private String routeKey;

    public RabbitMessage() {
    }

    public RabbitMessage(String exchange, String routeKey, Object... params) {
        this.params = params;
        this.exchange = exchange;
        this.routeKey = routeKey;
    }

    public RabbitMessage(Class<?>[] paramType, String exchange, String routeKey, Object... params) {
        this.paramType = paramType;
        this.exchange = exchange;
        this.params = params;
        this.routeKey = routeKey;
    }

    public Class<?>[] getParamType() {
        return paramType;
    }

    public String getExchange() {
        return exchange;
    }

    public Object[] getParams() {
        return params;
    }

    public String getRouteKey() {
        return routeKey;
    }
}
