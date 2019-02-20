function codeEditor(elEditor) {
    this.codeMirror = CodeMirror.fromTextArea(elEditor, {
        mode: 'text/x-java',
        smartIndent: true,
        indentWithTabs: true,
        lineNumbers: true,
        tabSize: 4,
        theme: 'eclipse.css'
    });
};

codeEditor.prototype = {
    setLanguage: function (lang) {
        this.codeMirror.setOption('mode', lang);
    },

    getLanguage: function () {
        return this.codeMirror.getOption('mode');
    },

    getCode: function () {
        return this.codeMirror.getValue();
    },

    setCode: function (code) {
        this.codeMirror.setValue(code);
    }
}

