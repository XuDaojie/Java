package com.ald.news.user;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author xdj
 * <code>
 * Response.ok().build();
 * Response.ok(obj).build();
 * Response.ok().message("操作成功").build();
 * Response.bad().build();
 * Response.code(Status.NOT_EXTENDED).build();
 * </code>
 */
public class Response<T> {

    private int code;
    private String msg;
    private T data;
    private String token;

    public Response() {
    }

    protected Response(int code, String msg, T data, String token) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.token = token;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public String getToken() {
        return token;
    }

    public static class ResponseBuilder<T> {

        private StatusType status;
        private T data;
        private Type dataType;
        private String msg;
        private String token;

        public static ResponseBuilder newInstance() {
            return new ResponseBuilder();
        }

        public ResponseBuilder code(StatusType status) {
            this.status = status;
            if (!Objects.isNull(status)) {
                message(this.status.getReasonPhrase());
            }
            return this;
        }

//        public ResponseBuilder code(int code) {
//            Status status = Status.fromStatusCode(code);
//            return code(status);
//        }

        public ResponseBuilder<T> data(T data) {
            this.data = data;
            this.dataType = (data != null) ? data.getClass() : null;
            return this;
        }

        public ResponseBuilder<T> message(String msg) {
            this.msg = msg;
            return this;
        }

        public ResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public Response<T> build() {
            return new Response<T>(status.getStatusCode(), msg, data, token);
        }
    }

    /**
     * 接口调用成功
     *
     * @return
     */
    public static ResponseBuilder ok() {
        return code(Status.OK);
    }

    /**
     * 接口调用成功并返回数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseBuilder<T> ok(T data) {
        if (Objects.isNull(data)) {
            // 非法参数
            throw new IllegalArgumentException();
        }
        return ok().data(data);
    }

    /**
     * 接口调用失败
     *
     * @return
     */
    public static ResponseBuilder bad() {
        return code(Status.BAD_REQUEST);
    }

    /**
     * 服务器内部错误
     *
     * @return
     */
    public static ResponseBuilder serverError() {
        return code(Status.INTERNAL_SERVER_ERROR);
    }

    public static ResponseBuilder code(StatusType status) {
        return ResponseBuilder.newInstance()
                .code(status);
    }

    /**
     * Base interface for statuses used in responses.
     */
    public interface StatusType {
        /**
         * Get the associated status code
         *
         * @return the status code
         */
        public int getStatusCode();

        /**
         * Get the class of status code
         *
         * @return the class of status code
         */
        public Status.Family getFamily();

        /**
         * Get the reason phrase
         *
         * @return the reason phrase
         */
        public String getReasonPhrase();
    }

    /**
     * {@link <a href="https://baike.baidu.com/item/HTTP%E7%8A%B6%E6%80%81%E7%A0%81/5053660?fr=aladdin">HTTP状态码</a>}
     * {@link <a href="http://tool.oschina.net/commons?type=5">HTTP状态码详解</a>}
     * {@link <a href="https://www.cnblogs.com/cjwxf/p/6186287.html">HTTP状态码详解</a>}
     * Commonly used status codes defined by HTTP, see
     * {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10">HTTP/1.1 documentation</a>}
     * for the complete list. Additional status codes can be added by applications
     * by creating an implementation of {@link StatusType}.
     */
    public enum Status implements StatusType {
        /**
         * 200 OK, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.1">HTTP/1.1 documentation</a>}.
         */
        OK(200, "OK"),
        /**
         * 201 Created, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.2">HTTP/1.1 documentation</a>}.
         */
        CREATED(201, "Created"),
        /**
         * 202 Accepted, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.3">HTTP/1.1 documentation</a>}.
         */
        ACCEPTED(202, "Accepted"),
        /**
         * 204 No Content, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.5">HTTP/1.1 documentation</a>}.
         */
        NO_CONTENT(204, "No Content"),
        /**
         * 301 Moved Permanently, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.2">HTTP/1.1 documentation</a>}.
         */
        MOVED_PERMANENTLY(301, "Moved Permanently"),
        /**
         * 303 See Other, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.4">HTTP/1.1 documentation</a>}.
         */
        SEE_OTHER(303, "See Other"),
        /**
         * 304 Not Modified, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.5">HTTP/1.1 documentation</a>}.
         */
        NOT_MODIFIED(304, "Not Modified"),
        /**
         * 307 Temporary Redirect, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.8">HTTP/1.1 documentation</a>}.
         */
        TEMPORARY_REDIRECT(307, "Temporary Redirect"),
        /**
         * 400 Bad Request, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.1">HTTP/1.1 documentation</a>}.
         */
        BAD_REQUEST(400, "Bad Request"),
        /**
         * 401 Unauthorized, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.2">HTTP/1.1 documentation</a>}.
         */
        UNAUTHORIZED(401, "Unauthorized"),
        /**
         * 403 Forbidden, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.4">HTTP/1.1 documentation</a>}.
         */
        FORBIDDEN(403, "Forbidden"),
        /**
         * 404 Not Found, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.5">HTTP/1.1 documentation</a>}.
         */
        NOT_FOUND(404, "Not Found"),
        /**
         * 406 Not Acceptable, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.7">HTTP/1.1 documentation</a>}.
         */
        NOT_ACCEPTABLE(406, "Not Acceptable"),
        /**
         * 409 Conflict, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.10">HTTP/1.1 documentation</a>}.
         */
        CONFLICT(409, "Conflict"),
        /**
         * 410 Gone, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.11">HTTP/1.1 documentation</a>}.
         */
        GONE(410, "Gone"),
        /**
         * 412 Precondition Failed, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.13">HTTP/1.1 documentation</a>}.
         */
        PRECONDITION_FAILED(412, "Precondition Failed"),
        /**
         * 415 Unsupported Media Type, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.16">HTTP/1.1 documentation</a>}.
         */
        UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
        /**
         * 500 Internal Server Error, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.5.1">HTTP/1.1 documentation</a>}.
         */
        INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
        /**
         * 503 Service Unavailable, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.5.4">HTTP/1.1 documentation</a>}.
         */
        SERVICE_UNAVAILABLE(503, "Service Unavailable"),

        // tag::http 标准状态码
        /**
         * 510 Not Extended, see {@link <a href="https://tools.ietf.org/html/rfc2774#section-7">HTTP/1.1 documentation</a>}.
         * see {@link <a href="http://tool.oschina.net/commons?type=5">HTTP状态码详解</a>}
         */
        NOT_EXTENDED(510, "Not Extended");
        // end::http 标准状态码

        // tag::自定义状态码

        // end::自定义状态码

        private final int code;
        private final String reason;
        private Family family;

        /**
         * An enumeration representing the class of status code. Family is used
         * here since class is overloaded in Java.
         */
        public enum Family {
            INFORMATIONAL, SUCCESSFUL, REDIRECTION, CLIENT_ERROR, SERVER_ERROR, OTHER
        }

        ;

        Status(final int statusCode, final String reasonPhrase) {
            this.code = statusCode;
            this.reason = reasonPhrase;
            switch (code / 100) {
                case 1:
                    this.family = Family.INFORMATIONAL;
                    break;
                case 2:
                    this.family = Family.SUCCESSFUL;
                    break;
                case 3:
                    this.family = Family.REDIRECTION;
                    break;
                case 4:
                    this.family = Family.CLIENT_ERROR;
                    break;
                case 5:
                    this.family = Family.SERVER_ERROR;
                    break;
                default:
                    this.family = Family.OTHER;
                    break;
            }
        }

        /**
         * Get the class of status code
         *
         * @return the class of status code
         */
        @Override
        public Family getFamily() {
            return family;
        }

        /**
         * Get the associated status code
         *
         * @return the status code
         */
        @Override
        public int getStatusCode() {
            return code;
        }

        /**
         * Get the reason phrase
         *
         * @return the reason phrase
         */
        @Override
        public String getReasonPhrase() {
            return toString();
        }

        /**
         * Get the reason phrase
         *
         * @return the reason phrase
         */
        @Override
        public String toString() {
            return reason;
        }

        /**
         * Convert a numerical status code into the corresponding Status
         *
         * @param statusCode the numerical status code
         * @return the matching Status or null is no matching Status is defined
         */
        public static Status fromStatusCode(final int statusCode) {
            for (Status s : Status.values()) {
                if (s.code == statusCode) {
                    return s;
                }
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", token='" + token + '\'' +
                '}';
    }
}
