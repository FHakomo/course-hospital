<#import "admin/admin.ftl" as p>

<@p.pages>


<#if roles??>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
    </tr>
    </thead>

    <tbody>

    <#list roles as role>
    <form method="post" action="/updateRole">
        <tr>
            <th scope="row">${role.id}</th>
            <td><input type="text" name="name" id="name" value=${role.name}></td>
        <input type="hidden" name="id" id="id" value=${role.id}>
        <td><button type="submit">Оновити</button></td>
        </tr>
    </form>
    </#list>
    </tbody>

</table>

</#if>



</@p.pages>
