window.onload = function() {
    var elEditor = document.getElementById('editor');


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
};