<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <!-- jquery -->
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>

        <!-- Code Mirror -->
        <link rel="stylesheet" href="http://codemirror.net/lib/codemirror.css">
        <link rel="stylesheet" href="/resources/css/eclipse.css">
        <script src="http://codemirror.net/lib/codemirror.js"></script>
        <script src="http://codemirror.net/mode/javascript/javascript.js"></script>

        <script src="/resources/js/const.js"></script>
        <script src="/resources/js/codeEditor.js"></script>
        <script src="/resources/js/compiler.js"></script>
        <script src="/resources/js/init.js"></script>
    </head>
    <body>

        <select id='language'>
            <option value='java' selected>java</option>
            <option value='python'>python</option>
            <option value='javascript'>javascript</option>
        </select>

        <div id="question"></div>
        <textarea id="editor" rows="20" style="width: 100%"></textarea>

        <button id="compileBtn">compile</button>
        <div id="result" style="font-size: 12px; width: 100%; height: 300px; background-color: #dddddd"></div>
        <button id="addTestCase">테스트케이스 추가</button>
        <table id="testCaseList" border="1">
            <thead>
                <tr><th>parameter</th><th>return value</th><th>-</th></tr>
            </thead>
            <tbody>
                <tr>
                    <td><input id="testParam"></td>
                    <td><input id="testResult"></td>
                    <td><div id="testSuccess"></div></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>