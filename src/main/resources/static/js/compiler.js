function onlineCompiler(editor) {
    this.editor = editor;
}

onlineCompiler.prototype = {
    compile: function () {
        var param = {
            lang: this.editor.getLanguage(),
            code: this.editor.getCode()
        };
        $.ajax({
            url: '/compile',
            type: 'POST',
            async: true,
            data: param,
            dataType: 'json',
            success: function (response) {
                console.log(response);
                var elResult = document.getElementById('result');
                elResult.innerText = response.result;
            },
            error: function (response) {
                console.log(response);
            }
        });
    }
}