<!DOCTYPE html>
<html lang="en">
<title>Notes service</title>
<body>
<link rel="stylesheet" type="text/css" href="/css/table.css">
<a href="/create">create note</a>
<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100 ver1 m-b-110">
                <div class="table100-head">
                    <table>
                        <thead>
                        <tr class="row100 head">
                            <th class="cell100 column0">Priority</th>
                            <th class="cell100 column1">Header</th>
                            <th class="cell100 column2">Date</th>
                            <th class="cell100 column3">Get text</th>
                            <th class="cell100 column4">Delete</th>
                        </tr>
                        </thead>
                    </table>
                </div>

                <div class="table100-body js-pscroll">
                    <table>
                        <tbody>
                        <#list notes as note>
                        <tr class="row100 body">
                            <td class="cell100 column0">${note.priority}</td>
                            <td class="cell100 column1">${note.header}</td>
                            <td class="cell100 column2">${note.createDate!}</td>
                            <td class="cell100 column3"><a href="/file/${note.noteId}">Text</a></td>
                            <td class="cell100 column4"><a href="/delete/${note.noteId}">Delete</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
</body>
</html>