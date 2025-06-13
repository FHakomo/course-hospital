<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Головна сторінка</title>
</head>
<body>
    <h1>${message}</h1>
<#--    <ul>-->
<#--        <#if prescriptions??>-->
<#--            <li>-->
<#--                <#list prescriptions as prescription>-->
<#--                    ${prescription.id}-->
<#--                    ${prescription.name}-->
<#--                    ${prescription.description}-->
<#--            </#list>-->
<#--            </li>-->
<#--        </#if>-->
<#--    </ul>-->
    <#if prescriptions??>
    <table>
        <thead>
        <tr>
            <th>№</th>
            <th>Назва</th>
            <th>Опис</th>
        </tr>
        </thead>
        <tbody>
        <#list prescriptions as prescription>
        <tr>${prescription.id}</tr>
        <tr>${prescription.name}</tr>
        <tr>${prescription.description}</tr>
        </#list>
        </tbody>
        </table>
    </#if>
<hr>
<form>

    <label for="name">Name</label>
    <input type="text"id="name" name="name"><br>
    <br>
    <label for="username">Username</label>
    <input type="text" id="username" name="username" placeholder="user"> <br>
    <br>
    <label for="password">Password</label>
    <input type="text" id="password" name="password"
           placeholder="pass">
    <br>
    <label for="age">Age</label>
    <input type="number" id="age" min="1" max="120" step="1"> <br>

    <input type="radio" name="gender" value="m"> Чоловік
    <input type="radio" name="gender" value="а"> Жінка
    <br>

    <select name="job">
        <option value="student">Студент</option>
        <option value="teacher">Викладач</option>
        <option value="developer">Розробник</option>
    </select>

</form>
<hr>

<img src="" alt="User1">
</body>
</html>