//submit do formulário para o controller
$("form-add-promo").submit(function() {
    //bloquear o comportamento padrão do submit
    evt.preventDefault();
    promo.linkPromocao = $("#linkPromocao").val();
    promo.descricao = $("#descricao").val();
    promo.preco = $("#preco").val();
    promo.titulo = $("#titulo").val();
    promo.categoria = $("#categoria").val();
    promo.linkImage = $("#linkImage").attr("src");
    promo.site = $("#site").text();

    console.log('promo > ', promo);

    $.ajax({
        method: "POST",
        url: "/promocao/save",
        data: promo,
        success: function() {
            $("alert").addClass("alert alert-success").text("Ok! Promoção cadastrada com sucesso.");
        },
        error: function(xhr) {
            console.log(">error: ",xhr.responseText);
            $("#alert").addClass("alert alert-danger").text("Não foi possível salvar esta promoção.");
        }
    })
});

//funcao para capturar metatags
$("#linkPromocao").on('change', function() {
    var url = $(this).val();

    if(url.length > 7) {
        $.ajax({
            method:"POST",
            url: "/meta/info?url=" + url,
            cache: false,
            beforeSend: function() {
                $("#alert").removeClass("alert alert-danger").text('');
                $("#titulo").val("");
                $("#site").text("");
                $("#linkImagem").attr("src", "");
                $("#loader-img").addClass("loader");
            },
            success: function( data ) {
                console.log(data);
                $("#titulo").val(data.title);
                $("#site").text(data.site.replace("@", ""));
                $("#LinkImagem").attr("src", data.image)
            },
            statusCode: {
                404: function(){
                    $("#alert").addClass("alert alert-danger").text("Nenhuma informação pode ser recuperada dessa URL!");
                    $("#linkImagem").attr("src", "/images/promo-dark.png");
                }
            },
            error: function() {
                    $("#alert").addClass("alert alert-danger").text("Opss...Algo deu errado. Tente mais tarde.");
                    $("#linkImagem").attr("src", "/images/promo-dark.png");

            },
            complete: function() {
                $("#loader-img").removeClass("loader");
            }
        })
    }
});