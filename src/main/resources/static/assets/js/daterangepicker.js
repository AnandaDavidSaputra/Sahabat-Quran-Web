$(document).ready(function () {

    initDateRange()
    initDatetimeRange()
    initSingleDate()
    initSingleDateSlash()
    initSingleDatePast()
    initSingleDateFuture()
    initSingleDateAhead()
    initSingleDateTime()
    initSingleDateTimeNow()
    initSingleDateTimeAhead()
    initDaterangeYYYYMMDD()

    function initDateRange(){
        $('.daterange').daterangepicker({
            autoUpdateInput: false,
            showDropdowns: true,
            locale: {
                format: 'DD/MM/YYYY'
            },
            ranges: {
                'Today': [moment(), moment()],
                'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                'This Month': [moment().startOf('month'), moment().endOf('month')],
                'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
            },
            alwaysShowCalendars: true,
        });

        $('.daterange').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('DD/MM/YYYY') + ' - ' + picker.endDate.format('DD/MM/YYYY'));
        });
    }

    function initDatetimeRange(){
        $('.daterange-time').daterangepicker({
            autoUpdateInput: false,
            timePicker: true,
            timePickerSeconds: true,
            timePicker24Hour: true,
            showDropdowns: true,
            locale: {
                format: 'DD/MM/YYYY HH:mm:ss'
            },
            ranges: {
                'Today': [moment().set("hour",0).set("minute",0).set("seconds",0), moment().set("hour",23).set("minute",59).set("seconds",59)],
                'Yesterday': [moment().subtract(1, 'days').set("hour",0).set("minute",0).set("seconds",0), moment().subtract(1, 'days').set("hour",23).set("minute",59).set("seconds",59)],
                'Last 7 Days': [moment().subtract(6, 'days').set("hour",0).set("minute",0).set("seconds",0), moment().set("hour",23).set("minute",59).set("seconds",59)],
                'Last 30 Days': [moment().subtract(29, 'days').set("hour",0).set("minute",0).set("seconds",0), moment().set("hour",23).set("minute",59).set("seconds",59)],
                'This Month': [moment().startOf('month'), moment().endOf('month')],
                'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
            },
            alwaysShowCalendars: true,
        });

        $('.daterange-time').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('DD/MM/YYYY HH:mm:ss') + ' - ' + picker.endDate.format('DD/MM/YYYY HH:mm:ss'));
        });
    }


    function initSingleDate(){
        $('.single-date').daterangepicker({
            autoUpdateInput: false,
            singleDatePicker: true,
            showDropdowns: true,
            locale: {
                format: 'DD-MM-YYYY'
            }
        });

        $('.single-date').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('DD-MM-YYYY')).trigger("change");
        });
    }


    function initSingleDateSlash(){
        $('.single-date-slash').daterangepicker({
            autoUpdateInput: false,
            singleDatePicker: true,
            showDropdowns: true,
            locale: {
                format: 'DD/MM/YYYY'
            }
        });

        $('.single-date-slash').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('DD/MM/YYYY')).trigger("change");
        });
    }

    function initSingleDatePast(){
        $('.single-date-past').daterangepicker({
            autoUpdateInput: false,
            singleDatePicker: true,
            showDropdowns: true,
            maxDate:moment().subtract(1, 'days'),
            locale: {
                format: 'DD-MM-YYYY'
            }
        });

        $('.single-date-past').on('apply.daterangepicker', function (ev, picker) {
            if(picker.startDate.format('DD-MM-YYYY') === moment().format('DD-MM-YYYY')){
                $(this).val(moment().subtract(1, 'days').format('DD-MM-YYYY'));
            }else{
                $(this).val(picker.startDate.format('DD-MM-YYYY'));
            }
        });
    }

    function initSingleDateFuture(){
        $('.single-date-future').daterangepicker({
            autoUpdateInput: false,
            singleDatePicker: true,
            showDropdowns: true,
            minDate:moment().add(1, 'days'),
            locale: {
                format: 'DD-MM-YYYY'
            }
        });

        $('.single-date-future').on('apply.daterangepicker', function (ev, picker) {
            if(picker.startDate.format('DD-MM-YYYY') === moment().format('DD-MM-YYYY')){
                $(this).val(moment().add(1, 'days').format('DD-MM-YYYY'));
            }else{
                $(this).val(picker.startDate.format('DD-MM-YYYY'));
            }
        });
    }

    function initSingleDateAhead(){
        $('.single-date-ahead').daterangepicker({
            autoUpdateInput: false,
            singleDatePicker: true,
            showDropdowns: true,
            minDate:moment(),
            locale: {
                format: 'DD-MM-YYYY'
            }
        });

        $('.single-date-ahead').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('DD-MM-YYYY'));
        });

    }

    function initSingleDateTime(){
        $('.single-datetime').daterangepicker({
            autoUpdateInput: false,
            singleDatePicker: true,
            timePicker: true,
            timePickerSeconds: true,
            timePicker24Hour: true,
            showDropdowns: true,
            locale: {
                format: 'DD-MM-YYYY HH:mm:ss'
            }
        });

        $('.single-datetime').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('DD-MM-YYYY HH:mm:ss'));
        });
    }

    function initSingleDateTimeNow(){
        $('.single-datetime-now').daterangepicker({
            autoUpdateInput: false,
            singleDatePicker: true,
            timePicker: true,
            timePickerSeconds: true,
            timePicker24Hour: true,
            showDropdowns: true,
            maxDate:moment(),
            locale: {
                format: 'DD-MM-YYYY HH:mm:ss'
            }
        });

        $('.single-datetime-now').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('DD-MM-YYYY HH:mm:ss'));
        });

    }

    function initSingleDateTimeAhead(){
        $('.single-datetime-ahead').daterangepicker({
            autoUpdateInput: false,
            singleDatePicker: true,
            timePicker: true,
            timePickerSeconds: true,
            timePicker24Hour: true,
            showDropdowns: true,
            minDate:moment().startOf('day'),
            locale: {
                format: 'DD-MM-YYYY HH:mm:ss'
            }
        });

        $('.single-datetime-ahead').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('DD-MM-YYYY HH:mm:ss'));
        });

    }

    function initDaterangeYYYYMMDD(){
        $('.daterange-yyyy-mm-dd').daterangepicker({
            autoUpdateInput: false,
            showDropdowns: true,
            locale: {
                format: 'YYYY-MM-DD'
            },
            ranges: {
                'Today': [moment(), moment()],
                'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                'This Month': [moment().startOf('month'), moment().endOf('month')],
                'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
            },
            alwaysShowCalendars: true,
        });

        $('.daterange-yyyy-mm-dd').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('YYYY-MM-DD') + ' - ' + picker.endDate.format('YYYY-MM-DD'));
        });

    }
});
