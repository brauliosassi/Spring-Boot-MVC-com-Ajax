//funcao para capturar metatags
$("#linkPromocao").on('change', function() {
    var url = $(this).val();

    if(url.length > 7) {
        $.ajax({
            method:"POST",
            url: "/meta/info?url=" + url,
            cache: false,
            success: function( data ) {
                console.log(data);
                $("#titulo").val(data.title);
                $("#site").text(data.site.replace("@", ""));
                $("#LinkImagem").attr("src", data.image)
            },
            statusCode: {
                404: function(){
                    $("#alert").addClass("alert alert-danger").text("Nenhuma informação pode ser recuperada dessa URL!");
                }
            },
            error: function() {
                    $("#alert").addClass("alert alert-danger").text("Opss...Algo deu errado. Tente mais tarde.");

            }
        })
    }
});