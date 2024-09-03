let Timepicker = function () {
    "use strict";
    return {
        //main function
        init: function () {
            handleTimePicker();
        }
    };
}();

function handleTimePicker(){
    $(".datetimepicker-input").each(function () {
        let divId = $(this).parent().prop("id")
        $('#'+divId).datetimepicker({
            format: 'HH:mm'
        });
    })
}