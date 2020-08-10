package com.bjsxt.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenshuaixin
 * @date 2020/8/8 - 23:09
 */
@Component
public class DeptProviderFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return "microcloud-provider-dept";  //设置好处理的失败路由
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(
                        "{\"deptno\":777777,\"dname\":\"【ERROR】Zuul-Fallback\",\"loc\":\"Gateway客户端提供\"}"
                                .getBytes());   //当出现服务调用错误之后返回的数据内容
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type","text/html;charset=UTF-8");
                return headers;
            }
        };
    }
}
