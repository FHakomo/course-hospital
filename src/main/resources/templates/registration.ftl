<#import "/spring.ftl" as s>
<#import "customer/home.ftl" as p>
<@p.pages>
    <h2>Реєстрація в систему</h2>
        <form class="row g-3" action="/registration" method="post">
            <@s.bind "users"/>


            <div class="col-md-6">
                <label for="username">Логін</label>
                <@s.formInput "users.username" 'id="username" placeholder="username"'/> <br>
                <@s.showErrors "<br>"/>
                <#if err??>${err}</#if>
                <br>
            </div>
            <div class="col-md-6">
                <label for="username">Пароль</label>
                <@s.formInput "users.password" 'id="password" placeholder="password"'/> <br>
                <@s.showErrors "<br>"/> <br>
            </div>
            <#if roles??>
            <div class="col-12">
                <div class="col-auto">
                    <label for="role_id">Роль в лікарні</label>
                    <select class="form-select" id="role_id">
                        <#list roles as role>
                        <option value=#{role.id}>${role.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            </#if>
            <@s.bind "doctors"/>
            <div class="col-12">
                <label for="username">Ім'я</label>
                <@s.formInput "doctors.firstName" 'id="firstName" placeholder="Ім\'я"'/> <br>
                <@s.showErrors "<br>"/> <br>
            </div>
            <div class="col-12">
                <label for="username">Прізвище</label>
                <@s.formInput "doctors.lastName" 'id="lastName" placeholder="Прізвище"'/> <br>
                <@s.showErrors "<br>"/> <br>
            </div>
            <div class="col-md-6">
                <label for="username">Пошта</label>
                <@s.formInput "doctors.email" 'id="email" placeholder="email@gmail.com"'/> <br>
                <@s.showErrors "<br>"/> <br>
            </div>
            <div class="col-md-4">
                <label for="username">Телефон</label>
                <@s.formInput "doctors.phone" 'id="phone" placeholder="+380000000000"'/> <br>
                <@s.showErrors "<br>"/> <br>
            </div>
                <label for="username">Спеціалізація</label>
                <@s.formInput "doctors.specialization" 'id="specialization" placeholder="Спеціалізація"'/> <br>
                <@s.showErrors "<br>"/> <br>
            <div class="col-12">
                <label for="username">Кількість років</label>
                <@s.formInput "doctors.age" 'id="age" placeholder="00" type="number"'/> <br>
                <@s.showErrors "<br>"/> <br>
            </div>
            <div class="col-12">
                <input type="submit" value="Зареєструватися">
            </div>
        </form>
</@p.pages>