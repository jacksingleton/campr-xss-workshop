package com.thoughtworks.securityinourdna;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.*;

public class InvoiceRepoTest {

    private final ConnectionFactory connectionFactory = new ConnectionFactory();
    private Connection conn;

    @Before
    public void setup() throws Exception {
        conn = connectionFactory.createInMemoryDatabase();
    }

    @Test
    public void should_allow_saving_and_retrieving_new_invoices() throws Exception {
        // Given
        final InvoiceRepo repo = new InvoiceRepo(conn);
        final String invoiceText = "test invoice test";

        // When
        repo.add(invoiceText);
        final List<String> allInvoices = repo.all();

        // Then
        assertEquals(1, allInvoices.size());
        assertEquals(invoiceText, allInvoices.get(0));
    }
}
