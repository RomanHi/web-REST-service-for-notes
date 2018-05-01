<!DOCTYPE html>
<html lang="en">
<title>Notes service</title>
<body>
<link rel="stylesheet" type="text/css" href="/css/table.css">
<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100 ver1 m-b-110">
                <div class="table100-head">
                    <table>
                        <thead>
                        <tr class="row100 head">
                            <th class="cell100 column0">ID</th>
                            <th class="cell100 column1">Username</th>
                            <th class="cell100 column2">Status</th>
                            <th class="cell100 column3">Role</th>
                            <th class="cell100 column4">Change</th>
                        </tr>
                        </thead>
                    </table>
                </div>

                <div class="table100-body js-pscroll">
                    <table>
                        <tbody>
                        <#list users as user>
                        <tr class="row100 body">
                            <td class="cell100 column0">${user.id}</td>
                            <td class="cell100 column1">${user.username}</td>
                            <td class="cell100 column2">${user.status}</td>
                            <td class="cell100 column3">${user.role}</td>
                            <td class="cell100 column4"><a href="/admin/${user.id}">Change</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
</body>
</html>