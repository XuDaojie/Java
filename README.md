## 请求转发与请求重定向
1. 请求重定向 客户端行为
    
    ``` java
    // 本质上等同于两次请求，前一次请求对象不会保存，URL地址会改变
    response.sendRedirect();
    ```
2. 请求转发 服务器行为
   
    ``` java
    // 是一次请求，转发后请求对象会保存，URL地址不会改变
    request.getRequestDispatcher()
        .forward(req, resp);
    ```

## Session的生命周期
### 销毁
Session销毁的三种方式

1. 调用session.invalidate()
2. Session过期
    1. 默认为30分钟
    2. session.setMaxInactiveInterval(timeout); // 秒
    3. WEB-INF
    
        ``` xml
        <session-config>
            <!-- 单位是分钟 -->
            <session-timeout>10<session-timeout>
        </session-config>
        ```
3. 服务器重启

