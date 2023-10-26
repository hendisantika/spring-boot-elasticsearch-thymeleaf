package com.hendisantika.springbootelasticsearchthymeleaf.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/26/23
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
@Repository
@RequiredArgsConstructor
public class InvoiceRepository {

    private final ElasticsearchClient elasticsearchClient;

    private final String indexName = "invoices";

}
