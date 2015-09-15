package com.thoughtworks.securityinourdna;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class InvoiceResourceTest {

    @Test
    public void all_should_not_allow_obvious_xss_attacks() throws Exception {
        // Given
        InvoiceRepo repo = new InvoiceRepo(null) {
            @Override
            public void add(String invoiceText) throws Exception { }

            @Override
            public List<String> all() throws Exception {
                return new ArrayList<String>() {{
                    add("<script>alert('xss!')</script>");
                }};
            }
        };
        InvoiceResource resource = new InvoiceResource(repo);

        // When
        List<String> invoices = resource.getAllInvoices();

        // Then
        assertFalse(invoices.get(0).contains("<script>"));
    }
}