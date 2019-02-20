function onlineCompiler(editor) {
    this.editor = editor;
}

onlineCompiler.prototype = {
    compile: function () {
        var param = {
            lang: this.editor.getLanguage(),
            code: this.editor.getCode()
        };

        var params = document.getElementById('testParam').value;
        var expected = document.getElementById('testResult').value;

        if (params && expected) {
            param.testParam = params;
            param.expected = expected;
        }

        $.ajax({
            url: '/compile',
            type: 'POST',
            async: true,
            data: param,
            dataType: 'json',
            success: function (response) {
                console.log(response);
                var elResult = document.getElementById('result');
                var printMessage = '출력값: \n' + response.result + '\n';
                printMessage += response.success ? "정답입니다" : "다시 풀어보세요";
                elResult.innerText = printMessage;
                if (params && expected) {
                    document.getElementById('testSuccess').innerHTML = response.testSuccess;
                }
            },
            error: function (response) {
                console.log(response);
            }
        });
    }
}