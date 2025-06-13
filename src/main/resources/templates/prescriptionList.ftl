<#import "customer/home.ftl" as p>

<@p.pages>


    <h2>Прописані призначення</h2>

    <table class="table table-hover">
        <thead>

        <tr>
            <th>Ім'я пацієнта</th>
            <th>Назва призначення</th>
            <th>Опис що відбулося</th>
            <th>Дата призначення</th>
            <th>Оновити</th>
            <th>Видалити</th>
        </tr>
        </thead>
        <tbody>
        <#if prescriptionList??>
            <#list prescriptionList as item>
            <tr>
                <td>${item.patient.lastName} ${item.patient.firstName}</td>
                <td>${item.prescriptions.name}</td>
                <form method="post" action="/updateItemInList">
                <td><input type="text" name="description" value="${item.description}"/></td>
                <td><input type="date" name="date" value="${item.dateOfPrescription}"/></td>
                <td class="table-primary">


                        <input type="hidden" name="prescription_id" value="${item.prescriptions.id}">
                        <input type="hidden" name="patient_id" value="${item.patient.id}">
                        <button>Update</button>
                    </form>
                </td>
                <td class="table-primary">

                    <form method="post" action="/deleteItemFromList">
                        <input type="hidden" name="prescription_id" value="${item.prescriptions.id}">
                        <input type="hidden" name="patient_id" value="${item.patient.id}">
                        <button>Delete</button>
                    </form>
                </td>
            </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <form action="/deleteAllItems" method="post">
        <button>Clear the list</button>
    </form>
    <form method="get" action="/prescribetopatients">
        <button>Перейти на форму підтвердження</button>
    </form>
</@p.pages>