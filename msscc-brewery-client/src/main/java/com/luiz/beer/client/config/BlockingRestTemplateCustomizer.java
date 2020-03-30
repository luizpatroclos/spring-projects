package com.luiz.beer.client.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * created by luiz albuquerque on 2020-03-29.
 */

@Component
@ConfigurationProperties(value = "dem.conf.external.spring", ignoreUnknownFields = true)
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private Integer maxTotal;
    private Integer maxRoute;
    private Integer connectReqTimeOut;
    private Integer connectTimeOut;

    public void setMaxRoute(Integer maxRoute) { this.maxRoute = maxRoute; }

    public void setConnectReqTimeOut(Integer connectReqTimeOut) { this.connectReqTimeOut = connectReqTimeOut; }

    public void setConnectTimeOut(Integer connectTimeOut) { this.connectTimeOut = connectTimeOut; }

    public void setMaxTotal(Integer maxTotal) { this.maxTotal = maxTotal; }


    public ClientHttpRequestFactory clientHttpRequestFactory() {

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

        connectionManager.setMaxTotal(maxTotal);
        connectionManager.setDefaultMaxPerRoute(maxRoute);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(connectReqTimeOut)
                .setConnectTimeout(connectTimeOut)
                .build();

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}
