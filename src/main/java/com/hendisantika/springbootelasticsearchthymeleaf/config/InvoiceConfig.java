package com.hendisantika.springbootelasticsearchthymeleaf.config;

import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/26/23
 * Time: 11:33
 * To change this template use File | Settings | File Templates.
 */
//@Configuration
public class InvoiceConfig extends ElasticsearchConfiguration {

    //    @Bean
//    public RestClient getRestClient() {
//        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200))
//                .build();
//        return restClient;
//    }
//
//    @Bean
//    public ElasticsearchTransport getElasticsearchTransport() {
//        return new RestClientTransport(getRestClient(), new JacksonJsonpMapper());
//    }
//
//    @Bean
//    public ElasticsearchClient getElasticsearchClient() {
//        ElasticsearchClient client = new ElasticsearchClient(getElasticsearchTransport());
//        return client;
//    }
    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withBasicAuth("elastic", "mhsj6S4eCTzb7lvlnISbCrKn")
                .build();
    }
}
