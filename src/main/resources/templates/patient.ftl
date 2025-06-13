<#import "customer/home.ftl" as p>

<@p.pages>

    <h1>Усі пацієнти</h1>
    <div class="col-md-8">


    <#if patients??>
    <#list patients as patient>
    <div class="col">
        <form method="post" action="/addToList">
        <div class="card">

            <div class="card-body">
                <h5 class="card-title text-center">${patient.lastName} ${patient.firstName}</h5>
                <p class="card-text text-center">${patient.age} років(роки),Вага - ${patient.weight}. <br>${patient.medicalHistory}
                    <br> Статус - ${patient.status.name}
<#--                    <br>${doctor}-->
                </p>
                <#if prescriptions??>
                <p class="card-text text-center">Оберіть ліки</p>
                <select name="prescription_id" class="form-select">
                    <#list prescriptions as prescription>
                    <option value="${prescription.id}">${prescription.name}</option>
                    </#list>
                </select>
            </div>
            </#if>
            <div class="d-grid gap-2">
                <input type="hidden" name="patient_id" value="${patient.id}">
                <button class="btn btn-info"> Прописати</button>
            </div>
        </div>
        </form>
        </#list>
        </#if>
    </div>
</@p.pages>