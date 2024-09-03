$(document).ready(function () {
    $(".phone-mask").inputmask("(999) 999-999999",{removeMaskOnSubmit : true});
    $(".number-mask").inputmask("9999999999999999",{removeMaskOnSubmit : true, "placeholder": ""});
    $(".decimal-mask").inputmask('decimal',{rightAlign:false,removeMaskOnSubmit : true, "placeholder": ""});
    $(".currency-mask").inputmask({ alias : "currency", prefix: 'Rp. ',removeMaskOnSubmit : true,rightAlign:false});
    $(".ip-mask").inputmask({ alias : "ip"});
    $(".pin-mask").inputmask("999999",{removeMaskOnSubmit : true});
    $(".year-mask").inputmask("9999",{removeMaskOnSubmit : true});
    $(".code-mask").inputmask("999",{removeMaskOnSubmit : true});
});
