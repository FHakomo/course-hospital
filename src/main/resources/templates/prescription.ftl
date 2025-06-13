<#import "manager/home.ftl" as p>

<@p.pages>

    <h1>Усі призначення, які є в лікарні</h1>
    <div class="col-md-8">


    <#if prescriptions??>
    <#list prescriptions as prescription>
        <div class="card-group">
            <div class="card">
                <img src="${prescription.image}" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${prescription.name}</h5>
                    <p class="card-text">${prescription.description}.</p>
                </div>
            </div>
        </div>
        </#list>
        </#if>
        <h2>Створення нового продукту</h2>
        <form action="/CreateNewPrescription" method="post">
            <div class="mb-3">
            <label for="name">Назва нового призначення</label>
            <input type="text" id="name" name="name" placeholder="name">
            </div>
            <div class="mb-3">
            <label for="description">Опис нового призначення</label>
            <input type="text" id="description" name="description" placeholder="description">
            </div>
            <div class="mb-3">
            <label for="image">Опис нового призначення</label>
            <input type="text" id="image" name="image" placeholder="image">
            </div>
            <div class="mb-3">
            <#if prescriptionCategories??>
                <label for="category_id">Виберіть категорію</label>
                <select name="category_id">
                    <#list prescriptionCategories as category>

                        <option value=${category.id}>${category.name}</option>

                    </#list>
                </select>
            </#if>
                </div>
            <button type="submit" class="btn btn-outline-primary">Створити</button>

        </form>
    </div>

    <hr>
    <h2>Видалення та оновлення</h2>
    <#if prescriptions??>
        <#list prescriptions as prescription>
            <div class="card-group">

                <div class="card">
                    <form method="post" action="/UpdatePrescription">
                    <h5 class="card-title">Шлях до зображення: <input type="text" id="image" name="image" class="form-control" value="${prescription.image}"></h5>
                    <div class="card-body">
                        <input type="hidden" value="${prescription.id}" name="id">
                        <h5 class="card-title">Ім'я: <input type="text" id="name" name="name" class="form-control" value="${prescription.name}"></h5>
                        <p class="card-text">Опис: <input type="text" id="description" name="description" class="form-control" value="${prescription.description}"></p>
                        <#if prescriptionCategories??>
                            <label for="categories">Категорія</label>
                            <select name="category_id" id="categories" class="form-select">
                                <#list prescriptionCategories as category>
                                    <#if category.id=prescription.category.id>
                                    <option value=${prescription.category.id} selected>${prescription.category.name}</option>
                                    <#else>
                                        <option value=${category.id}>${category.name}</option>
                                    </#if>
                                </#list>
                            </select>
                        </#if>
                        <button type="submit" class="btn btn-warning">Оновити</button>
                    </div>
                    </form>
                    <form method="post" action="/DeletePrescription">
                        <input type="hidden" name="id" value="${prescription.id}">
                        <button type="submit" class="btn btn-danger" style="float:right">Видалити</button>
                    </form>
                </div>
            </div>
        </#list>
    </#if>

</@p.pages>