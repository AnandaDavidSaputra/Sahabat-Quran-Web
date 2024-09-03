let Select2 = function () {
    "use strict";
    return {
        //main function
        init: function () {
            handleSelectCustomer();
        }
    };
}();

$('select').on('select2:opening', function (e) {
    if( $(this).attr('readonly') === 'readonly') { // Check if select tag is readonly.
        e.preventDefault();
        $(this).select2('close');
        return false;
    }
});

$('select').on('select2:clearing', function (e) {
    if( $(this).attr('readonly') === 'readonly') { // Check if select tag is readonly.
        e.preventDefault();
        return false;
    }
})

function handleSelectCustomer(){
    $("select.select-customer").select2({
        placeholder: 'Pilih Customer',
        searchInputPlaceholder: 'Cari customer...',
        allowClear: true,
        theme:'bootstrap4',
        ajax: {
            url: baseUrl + "api/select/customer",
            dataType: 'json',
            delay: 250,
            data: function (params) {
                return {
                    sort: "name",
                    direction: "ASC",
                    q: params.term,
                    page: (params.page || 1) - 1
                };
            }
        }
    });
}
