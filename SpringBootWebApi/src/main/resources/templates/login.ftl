<!DOCTYPE html>

<html lang="en">
<title>Notes service</title>
<body>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<form class="form-style-9" method="post" action="/login">
    <h3>${message!}</h3>
    <ul>
        <li>
            <input type="text" name="username" class="field-style field-full align-left" placeholder="username"
                   required="true"/>
        </li>
        <li>
            <input type="password" name="password" class="field-style field-full align-left" placeholder="password"
                   required="true"/>
        </li>
        <li>
            <input type="submit" value="Login"/>
            <a class="button" href="/signUp">Sign up</a>
        </li>

    </ul>
</form>
</body>

</html>