package com.hendisantika.springbootelasticsearchthymeleaf.controller;

import com.hendisantika.springbootelasticsearchthymeleaf.entity.Invoice;
import com.hendisantika.springbootelasticsearchthymeleaf.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/26/23
 * Time: 12:20
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class InvoiceRestController {

    private final InvoiceRepository invoiceRepository;

    @PostMapping("/createOrUpdateInvoice")
    public ResponseEntity<Object> createOrUpdateInvoice(@RequestBody Invoice invoice) throws IOException {
        String response = invoiceRepository.createOrUpdateInvoice(invoice);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getInvoice")
    public ResponseEntity<Object> getInvoiceById(@RequestParam String invoiceId) throws IOException {
        Invoice invoice = invoiceRepository.getInvoiceById(invoiceId);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @GetMapping("/getAllInvoices")
    public ResponseEntity<Object> getAllInvoices() throws IOException {
        List<Invoice> invoices = invoiceRepository.getAllInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @DeleteMapping("/deleteInvoice")
    public ResponseEntity<Object> deleteInvoiceById(@RequestParam String invoiceId) throws IOException {
        String response = invoiceRepository.deleteInvoiceById(invoiceId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("invoice/get")
    public String getInvoice() {
        log.info("Entering into method getInvoice()");
        try {
            log.info("finding Invoices");
            throw new RuntimeException("Invoice not available");
        } catch (Exception e) {
            log.error(" Unable to find invoice" + e.getMessage());
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            log.error("Exception is -: " + sw);
        }
        return "INVOICE";
    }
}
