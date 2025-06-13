<#import "admin/admin.ftl" as p>

<@p.pages>


    <#if allusers??>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Username</th>
                <th scope="col">Password</th>
                <th scope="col">Role</th>
            </tr>
            </thead>

            <tbody>

            <#list allusers as user>
            <form method="post" action="/updateUser">
            <tr>
                <th scope="row">${user.id}</th>
                <td><input type="text" name="username" value=${user.username}></td>
                <td>${user.password}</td>
                <#if roles??><td>
                    <select name="role_id" id="role_id" class="form-select">
                        <#list roles as role>
                            <#if role.id=user.role.id>
                                <option value=${user.role.id} selected> ${user.role.name}</option>
                            <#else>
                                <option value=${role.id}> ${role.name}</option>
                            </#if>
                        </#list>
                    </select>
                </td></#if>
                <input type="hidden" name="id" id="id" value=${user.id}>
                <td><button type="submit">Оновити</button></td>
            </tr>
            </form>
            </#list>
            </tbody>

        </table>

    </#if>



</@p.pages>
