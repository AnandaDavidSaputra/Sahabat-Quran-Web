let fileMaxSize = 50048576;

$(".input-file").on("change", function () {
    if(this.files[0].size > fileMaxSize){
        createAlert("File terlalu besar",'warning','file tidak boleh lebih dari '+formatBytes(fileMaxSize))
        $(this).val(null)
    }else{
        let imgTag = $(this).data("image-preview");
        let pdfTag = $(this).data("pdf-preview");
        let fileSrc = window.URL.createObjectURL(this.files[0])
        let filename = $('input[type=file]').val().replace(/.*(\/|\\)/, '');

        $(pdfTag).hide()
        $(imgTag).hide()

        if(filename.indexOf('.pdf') === -1){
            $(imgTag).prop("src",fileSrc)
            $(imgTag).show()
            $("#pdfPreviewGroup").hide()
        }else{
            $(pdfTag).prop("src",fileSrc)
            $(pdfTag).show()
            $("#pdfPreviewGroup").show()
        }
        $("#previewGroup").show()

    }
});

function formatBytes(bytes, decimals = 2) {
    if (bytes === 0) return '0 Bytes';

    const k = 1024;
    const dm = decimals < 0 ? 0 : decimals;
    const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];

    const i = Math.floor(Math.log(bytes) / Math.log(k));

    return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
}