<#import "customer/home.ftl" as p>

<@p.pages>

    <div class="col-8-md">

    <h2>Діагноз пацієнту</h2>

        <form method="post" action="/updateDiagnose">
            <div class="row">
                <#if diagnoses??>
                    <label for="diagnos">Діагноз пацієнта</label>
                    <select name="diagnos_id" id="diagnos" class="form-select">
                        <#list diagnoses as diagnosis>
                            <#if diagnosis.id=diagnostic.diagnose.diagnosis.id>
                                <option value=${diagnostic.diagnose.diagnosis.id} selected> ${diagnostic.diagnose.diagnosis.name}</option>
                            <#else>
                                <option value=${diagnosis.id}>${diagnosis.name}</option>
                            </#if>                        </#list>
                    </select>
                </#if>
            </div>
            <div class="row">
                <#if patients??>
                    <label for="patient">Пацієнт</label>
                    <select name="patient_id" id="patient" class="form-select">
                        <#list patients as patient>
                            <#if patient.id=diagnostic.diagnose.patient.id>
                                <option value=${diagnostic.diagnose.patient.id} selected>${diagnostic.diagnose.patient.lastName} ${diagnostic.diagnose.patient.firstName}</option>
                            <#else>
                                <option value=${patient.id}>${patient.lastName} ${patient.firstName}</option>
                            </#if>
                        </#list>
                    </select>
                </#if>
            </div>
            <div class="row">
                <label for="date">Оберіть дату діагнозу</label>
                <input type="date" name="date" id="date" value="${diagnostic.diagnose.date}"/>
            </div>

    <button type="submit" class="btn btn-primary">Оновити</button>
        </form>
        <form method="post" action="/diagnosePatient">
        <button type="submit" class="btn btn-secondary">Поставити діагноз</button>
        </form>
    </div>

</@p.pages>