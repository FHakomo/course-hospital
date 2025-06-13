<#import "customer/home.ftl" as p>

<@p.pages>



<h2>Створенні призначення</h2>

    <ul>
        <li>${doctor.firstName}</li>
        <li>${doctor.lastName}</li>
        <li>${doctor.phone}</li>
        <li>${doctor.specialization}</li>
    </ul>
    <hr>
    <h3>Пацієнти та їхні призначення</h3>
    <hr>
    <table class="table table-hover">
        <thead>

        <tr>
            <th>Ім'я пацієнта</th>
            <th>Назва призначення</th>
            <th>Опис що відбулося</th>
            <th>Дата призначення</th>
        </tr>
        </thead>
        <tbody>
        <#if prescriptionList??>
            <#list prescriptionList as item>
                <tr>
                    <td>${item.patient.lastName} ${item.patient.firstName}</td>
                    <td>${item.prescriptions.name}</td>
                        <td>${item.description}</td>
                        <td>${item.dateOfPrescription}</td>

                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <h5> ${AllElements}</h5>

    <form method="post" action="/prescribe">

        <button>Підтвердження</button>

    </form>

</@p.pages>