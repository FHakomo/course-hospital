
<#import "customer/home.ftl" as p>

<@p.pages>

<h1>Вхід у систему</h1>
<form action="/login" method="post">
<label for="username">Username</label>
<input type="text" id="username" name="username" placeholder="user"> <br>

<label for="password">Password</label>
<input type="text" id="password" name="password"
       placeholder="pass">

<input type="submit" value="Log in">

<a href="/registration">Register in our company</a>
</form>
</@p.pages>