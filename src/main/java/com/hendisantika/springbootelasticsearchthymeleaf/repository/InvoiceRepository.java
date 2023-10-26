package com.hendisantika.springbootelasticsearchthymeleaf.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.hendisantika.springbootelasticsearchthymeleaf.entity.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;

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

    public String createOrUpdateInvoice(Invoice invoice) throws IOException {
        IndexResponse response = elasticsearchClient.index(
                i -> i.index(indexName)
                        .id(invoice.getId())
                        .document(invoice)
        );
        if (response.result().name().equals("Created")) {
            return "Invoice document has been created successfully.";
        } else if (response.result().name().equals("Updated")) {
            return "Invoice document has been updated successfully.";
        }
        return "Error while performing the operation.";
    }

}
