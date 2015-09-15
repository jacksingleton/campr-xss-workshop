$(function() {
    function renderInvoices() {
        $.get('/invoices', function(invoices) {
            $('#invoices').html('');
            invoices.forEach(function(invoice) {
                $('#invoices').append($('<hr>'));
                $('#invoices').append($('<p>'));
                $('#invoices p').last().html(invoice);
            });
        });
    };

    $('form').submit(function(e) {
        e.preventDefault();

        var invoiceTextArea = $('[name=invoice]');

        console.log(invoiceTextArea.val());

        $.post('/invoice', { text : invoiceTextArea.val() }, function() {
            renderInvoices();
        });

        invoiceTextArea.val('');
    });

    renderInvoices();
});
