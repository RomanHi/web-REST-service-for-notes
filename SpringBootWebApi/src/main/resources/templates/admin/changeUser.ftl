<!DOCTYPE html>

<html lang="en">
<title>Notes service</title>
<body>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<form class="form-style-9" method="post" action="/admin">
    <ul>
        <li>
            <input value="${user.username}" type="text" name="username" required="true"
                   class="field-style field-split align-left"
            />
            <select class="align-right field-split" size="1" name="status" id="status">
                <option disabled>--Status--</option>
                <option value="BANNED">Banned</option>
                <option value="DELETED">Deleted</option>
                <option selected value="ACTIVE">Active</option>
            </select>
        </li>
        <li>
            <input type="text" name="password" placeholder="password" class="field-style field-split align-left"
            />
            <select class="align-right field-split" size="1" name="role" id="role">
                <option disabled>--Role--</option>
                <option value="ADMIN">Admin</option>
                <option selected value="USER">User</option>
            </select>
        </li>
        <li>
            <input type="submit" value="Save change"/>
            <a class="button" href="/admin">All users</a>
        </li>
        <input type="hidden" name="id" value="${user.id}">
    </ul>
</form>
</body>

</html>