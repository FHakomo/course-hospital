<#import "admin/admin.ftl" as d>

<@d.pages>



        <#if doctors??>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Age</th>
                    <th scope="col">Email</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Specialization</th>
                </tr>
                </thead>

                <tbody>

                <#list doctors as doctor>
                    <form method="post" action="/updateDoctor">
                        <tr>
                            <th scope="row">${doctor.id}</th>
                            <td><input type="number" min="20" max="100" name="age" id="age" value=${doctor.age}></td>
                            <td><input type="text" name="email" id="email" value=${doctor.email}></td>
                            <td><input type="text" name="firstName" id="firstName" value=${doctor.firstName}></td>
                            <td><input type="text" name="lastName" id="lastName" value=${doctor.lastName}></td>
                            <td><input type="text" name="phone" id="phone" value=${doctor.phone}></td>
                            <td><input type="text" name="spec" id="spec" value=${doctor.specialization}></td>
                            <input type="hidden" name="id" value=${doctor.id}>
                            <td><button type="submit">Оновити</button></td>
                        </tr>
                    </form>
                </#list>
                </tbody>

            </table>

        </#if>




</@d.pages>