<!DOCTYPE html>

<html lang="en">
<title>Notes service</title>
<body>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<form class="form-style-9">
    <ul>
        <li>
            <label type="text" name="header" class="field-style field-split align-left">header:</label>
            <label type="text" name="header" class="field-style field-split align-right">${(note.header)!}</label>

        </li>
        <li>
            <label type="text" name="date" class="field-style field-split align-left">Date:</label>
            <label type="text" name="date" class="field-style field-split align-right"
            >${(note.createDate)!}</label>
        </li>
        <li>
            <label type="text" name="priority" class="field-style field-split align-left">Priority:</label>
            <label type="text" name="priority" class="field-style field-split align-right"
            >${(note.priority)!}</label>
        </li>
        <li>
            <textarea name="note" class="field-style">${(note.note)!}</textarea>
        </li>
        <li>
            <a class="button" href="/create">Create new</a>
            <a class="button" href="/profile">All notes</a>
        </li>

    </ul>
</form>
</body>

</html>