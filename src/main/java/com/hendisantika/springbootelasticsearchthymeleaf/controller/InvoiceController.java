package com.hendisantika.springbootelasticsearchthymeleaf.controller;

import com.hendisantika.springbootelasticsearchthymeleaf.entity.Invoice;
import com.hendisantika.springbootelasticsearchthymeleaf.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/26/23
 * Time: 12:23
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceRepository invoiceRepository;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "home";
    }

    @GetMapping("/listInvoice")
    public String viewlistInvoicePage(Model model) throws IOException {
        model.addAttribute("listInvoiceDocuments", invoiceRepository.getAllInvoices());
        return "listInvoice";
    }

    @PostMapping("/saveInvoice")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) throws IOException {
        invoiceRepository.createOrUpdateInvoice(invoice);
        return "redirect:/listInvoice";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) throws IOException {
        Invoice invoice = invoiceRepository.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "updateInvoice";
    }

    @GetMapping("/showNewInvoiceForm")
    public String showNewInvoiceForm(Model model) {
        // creating model attribute to bind form data
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "addInvoice";
    }
}
