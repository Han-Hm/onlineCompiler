window.onload = function() {
    var elEditor = document.getElementById('editor');

    document.getElementById('question').innerHTML = consts.question.Q1;

    console.log('window load!!');
    var editor = new codeEditor(elEditor, consts.java.defaultCode);
    editor.setCode(consts.java.defaultCode);

    var elLanguage = document.getElementById('language');
    elLanguage.addEventListener("change", function(e) {
        editor.setLanguage(elLanguage.selectedOptions[0].value);
    }.bind(this));

    var compiler = new onlineCompiler(editor);
    var elCompileBtn = document.getElementById('compileBtn');
    elCompileBtn.addEventListener("click", function () {

        compiler.compile();
    }.bind(this));
    
    document.getElementById("addTestCase").addEventListener('click', function () {
        var elList = document.getElementById('testCaseList');
        var templete = '<tr><td><input></td><td><input></td><td><button name="addCase">확인</button></td></tr>';
        elList.getElementsByTagName('tbody')[0].innerHTML += templete;
        var btns = document.getElementsByName("addCase");
        btns[btns.length - 1].addEventListener('click', function () {
            var sHTML = '<td></td><td><input></td><td><button name="addCase">확인</button></td>';
            // this.parentElement.parentElement.innerHTML =
            debugger;
        })

    })
};