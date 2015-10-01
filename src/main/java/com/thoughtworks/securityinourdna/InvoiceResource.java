package com.thoughtworks.securityinourdna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.owasp.encoder.Encode;

@RestController
public class InvoiceResource {

    private final InvoiceRepo invoiceRepo;

    @Autowired
    public InvoiceResource(InvoiceRepo invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    public void createInvoice(@RequestParam("text") String invoice) throws Exception {
        invoiceRepo.add(invoice);
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<String> getAllInvoices() throws Exception {
        List<String> rawInvoices = invoiceRepo.all();

        List<String> safeInvoices = new ArrayList<>();
        for (String rawInvoice : rawInvoices) {
            safeInvoices.add(Encode.forHtml(rawInvoice));
        }

        return safeInvoices;
    }
}
