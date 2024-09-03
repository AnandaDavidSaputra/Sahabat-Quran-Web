$(".toggle-password").on("click" ,function (){
    let el = $($(this).data("target"))
    let type = el.prop("type")

    el.prop('type', type === 'password' ? 'text': 'password')
})