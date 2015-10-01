package com.thoughtworks.securityinourdna;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class InvoiceResourceTest {

    @Test
    public void all_should_not_allow_obvious_xss_attacks() throws Exception {
        // Given
        InvoiceRepo repo = new TestInvoiceRepo("<script>alert('xss!')</script>");
        InvoiceResource resource = new InvoiceResource(repo);

        // When
        List<String> invoices = resource.getAllInvoices();

        // Then
        assertFalse(invoices.get(0).contains("<script>"));
    }
}