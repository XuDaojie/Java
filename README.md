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

## JSP指令与动作元素

### Include指令与Include动作的区别


|   | 指令 | 动作  |
| --- | --- | --- |
| 语法格式 | <small>`<%@ include file=“x.jsp” %>`</small> | <small>`<jsp:include page=“x.jsp” />`</small> |
| 发生作用的时间  | 页面转换器 | 请求期 |
| 包含的内容 | 转换后的代码 | 页面输出 |
| 转换成的Servlet | 转换为同一个Servlet | 主页面和包含页面为两个Servlet |
| 编译时间 | 较慢 | 较快 |
| 执行时间 | 稍快 | 较慢  |

