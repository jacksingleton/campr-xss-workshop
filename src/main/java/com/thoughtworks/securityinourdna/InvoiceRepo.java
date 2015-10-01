package com.thoughtworks.securityinourdna;

import java.util.List;

/**
 * InvoiceRepo
 */
public interface InvoiceRepo {
    void add(String invoiceText) throws Exception;

    List<String> all() throws Exception;
}
