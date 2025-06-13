<#import "customer/home.ftl" as p>

<@p.pages>

<h1>${prescriptionCategory}</h1>
    <div class="col-md-4">


    <#if prescriptions??>
    <#list prescriptions as prescription>
            <div class="card">
                <img src="${prescription.image}" class="card-img-top" alt="${prescription.name}">
                <div class="card-body">
                    <h5 class="card-title text-center">${prescription.name}</h5>
                    <p class="card-text text-center">${prescription.description}</p>
                </div>
            </div>
    </#list>
</#if>
    </div>
</@p.pages>