package com.thoughtworks.securityinourdna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcInvoiceRepo implements InvoiceRepo {

    private final Connection connection;

    public JdbcInvoiceRepo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(String invoiceText) throws Exception {
        final String query = "insert into invoices values (?)";
        final PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, invoiceText);
        stmt.execute();
    }

    @Override
    public List<String> all() throws Exception {
        final String query = "select * from invoices";
        final PreparedStatement stmt = connection.prepareStatement(query);
        final ResultSet resultSet = stmt.executeQuery();

        final List<String> invoices = new ArrayList<>();

        while (resultSet.next()) {
            invoices.add(resultSet.getString("text"));
        }

        return invoices;
    }
}
