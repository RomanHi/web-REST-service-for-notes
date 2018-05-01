<!DOCTYPE html>

<html lang="en">
<title>Notes service</title>
<body>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<form class="form-style-9" method="post" action="/create">
    <h3>${message!}</h3>
    <ul>
        <li>
            <input type="text" name="header" class="field-style field-split align-left" placeholder="Header"
                   required="true"/>
            <select class="align-right field-split" size="1" name="priority" id="priority">
                <option disabled>Priority</option>
                <option value="CRITICAL">Critical</option>
                <option value="MAJOR">Major</option>
                <option selected value="MINOR">Minor</option>
                <option value="TRIVIAL">Trivial</option>
            </select>
        </li>
        <li>
            <textarea name="note" class="field-style" placeholder="Message"></textarea>
        </li>
        <li>
            <input type="submit" value="Save Note"/>
            <a class="button" href="/profile">All notes</a>
        </li>

    </ul>
</form>
</body>

</html>