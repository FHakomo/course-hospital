<#import "manager/home.ftl" as p>

<@p.pages>

    <h1>Усі пацієнти</h1>
    <div class="col-md-8">


    <#if patients??>
    <#list patients as patient>
    <form method="post" action="/updatePatient">
    <div class="col">
        <form method="post" action="/addToList">
        <div class="card">

            <div class="card-body">
                <h2 style="text-align:center"><label for="lastName">Прізвище та ім'я</label></h2>
                <h5 class="card-title text-center"><input type="text" name="lastName" value="${patient.lastName}"> <input type="text" name="firstName" value="${patient.firstName}"></h5>
                <p class="card-text text-center">Кількість прожитих років - <input type="number" name="age" value="${patient.age}">,Вага - <input type="number" name="weight" value="${patient.weight}">. </p>
                <p><label for="hist">Медична історія пацієнта</label> </p><br> <textarea name="hist" id="hist" cols="105" rows="6">${patient.medicalHistory}</textarea>
                    <br> Статус <br> <#if statuses??>
                    <select name="status_id" id="status_id" class="form-select">
                        <#list statuses as status>
                            <#if status.id=patient.status.id>
                                <option value=${patient.status.id} selected> ${patient.status.name}</option>
                            <#else>
                                <option value=${status.id}> ${status.name}</option>
                            </#if>
                        </#list>
                    </select>
                    </#if>
            <div class="d-grid gap-2">
                <input type="hidden" name="id" value="${patient.id}">
                <button class="btn btn-info"> Оновити</button>
            </div>
        </div>
            </div>
        </form>
        </#list>
        </#if>
    </div>
</@p.pages>