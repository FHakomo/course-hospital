<#import "customer/home.ftl" as p>

<@p.pages>

<h1>Усі діагнози</h1>
<div class="col-md-8">


  <#if diagnoses??>
  <#list diagnoses as diagnos>
  <div class="col">
    <form method="post" action="/createDiagnose">
      <div class="card">

        <div class="card-body">
          <h5 class="card-title text-center">${diagnos.name}</h5>
          <p class="card-text text-center">${diagnos.description}
          </p>
          <#if patients??>
          <h2 style="text-align:center">Кому продіагностувати</h2>
          <select name="patient_id" class="form-select">
            <#list patients as patient>
            <option value="${patient.id}">${patient.lastName} ${patient.firstName}</option>
          </#list>
          </select>
        </div>
      </#if>
      <div class="d-grid gap-2">
        <input type="hidden" name="diagnos_id" value="${diagnos.id}">
        <button class="btn btn-info"> Продіагностувати</button>
      </div>
  </div>
  </form>
</#list>
</#if>
</div>
</@p.pages>