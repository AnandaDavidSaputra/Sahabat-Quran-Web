function createToastNotif(title,icon,cl,body){
    $(document).Toasts('create', {
        title: title,
        body: body,
        icon: icon,
        class: cl
    })
}

function createToastSwal(icon,title){
    const Toast = Swal.mixin({
        toast: true,
        position: 'top',
        showConfirmButton: false,
        showCloseButton:true,
        timer: 5000,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    })

    Toast.fire({
        icon: icon,
        title: title,
    })
}
