package io.github.xudaojie.boot.qiniu;

import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.Base64;

/**
 * @author xdj
 * @date 2019-03-01
 */
public class QiuniuTest {

    private String accessKey = "u_-3OP7hWn4xIVO5O1axw7ise8sYt-o-F7ijyO18";

    private String secretKey = "HDodT3h2epnb3yV0QU-33KDza5BwlbuNrymJa65u";

    @Test
    public void createSign() {
        String method = "POST";
        String path = "/v3/video/censor";
        String host = "ai.qiniuapi.com";
        String contentType = "application/json";
//        String bodyStr = "{\"data\":{\"uri\":\"https://mars-assets.qnssl.com/scene.mp4\"},\"params\":{\"scenes\":[\"pulp\",\"terror\",\"politician\"],\"cut_param\":{\"interval_msecs\":5000}}}";
        String bodyStr = "{\"data\":{\"uri\":\"http://pnm9ma7qz.bkt.clouddn.com/test..mp4\"},\"params\":{\"scenes\":[\"pulp\",\"terror\",\"politician\"],\"cut_param\":{\"interval_msecs\":5000}}}";

        String data = "{0} {1}\nHost: {2}\nContent-Type: {3}\n\n{4}";
        data = MessageFormat.format(data,
                method,
                path,
                host,
                contentType,
                bodyStr);
        System.err.println(data);
//        HmacUtils.hmacSha1(secretKey, data);
        String sign = Base64.getUrlEncoder().encodeToString(HmacUtils.hmacSha1(secretKey, data));
        System.err.println(sign);
    }

    @Test
    public void createSign1() {
        String jobId = "5c78ace9d240050008c6b6cc";
        String method = "GET";
        String path = "/v3/jobs/video/" + jobId;
        String host = "ai.qiniuapi.com";
        String contentType = "application/json";
        String data = "{0} {1}\nHost: {2}\nContent-Type: {3}\n\n";
        data = MessageFormat.format(data,
                method, path, host, contentType);
        System.err.println(data);
//        HmacUtils.hmacSha1(secretKey, data);
        String sign = Base64.getUrlEncoder().encodeToString(HmacUtils.hmacSha1(secretKey, data));
        System.err.println(sign);
    }
}
