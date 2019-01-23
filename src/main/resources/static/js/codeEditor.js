function codeEditor(elEditor) {
    this.codeMirror = CodeMirror.fromTextArea(elEditor, {
        mode: 'java',
        theme: 'eclipse.css',
        lineNumbers: true
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

