package com.thoughtworks.securityinourdna;

import java.util.ArrayList;
import java.util.List;

class TestInvoiceRepo implements InvoiceRepo {
    private final String testInvoice;

    public TestInvoiceRepo(String testInvoice) {
        this.testInvoice = testInvoice;
    }

    @Override
    public void add(String invoiceText) throws Exception { }

    @Override
    public List<String> all() throws Exception {
        return new ArrayList<String>() {{
            add(testInvoice);
        }};
    }
}
