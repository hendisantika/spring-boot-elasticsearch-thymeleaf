package com.hendisantika.springbootelasticsearchthymeleaf.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.hendisantika.springbootelasticsearchthymeleaf.entity.Invoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Objects;

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
@Slf4j
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

    public Invoice getInvoiceById(String invoiceId) throws IOException {
        Invoice invoice = null;
        GetResponse<Invoice> response = elasticsearchClient.get(
                g -> g.index(indexName)
                        .id(invoiceId),
                Invoice.class
        );

        if (response.found()) {
            invoice = response.source();
            log.info("Invoice name is: " + invoice.getName());
        } else {
            log.info("Invoice not found");
        }
        return invoice;
    }

    public String deleteInvoiceById(String invoiceId) throws IOException {
        DeleteRequest request = DeleteRequest.of(d -> d.index(indexName).id(invoiceId));

        DeleteResponse deleteResponse = elasticsearchClient.delete(request);
        if (Objects.nonNull(deleteResponse.result()) && !deleteResponse.result().name().equals("NotFound")) {
            return "Invoice with id : " + deleteResponse.id() + " has been deleted successfully !.";
        }
        System.out.println("Invoice not found");
        return "Invoice with id : " + deleteResponse.id() + " does not exist.";
    }

}
