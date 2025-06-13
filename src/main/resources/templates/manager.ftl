    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Demo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    </head>
    <body>

    <div class="my-class"></div>

    <div class="container-fluid">

        <div class="row">
            <div class="col">
                <nav class="navbar navbar-expand-lg bg-body-tertiary">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Навбар</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="/manager">Головна сторінка</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Лікарі</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="true">
                                        Dropdown
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Action</a></li>
                                        <li><a class="dropdown-item" href="#">Another action</a></li>
                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                                </li>
                            </ul>
                            <form class="d-flex" role="search">
                                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                                <button class="btn btn-outline-success" type="submit">Пошук</button>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <div class="list-group">
                    <a href="/manager" class="list-group-item list-group-item-action active" aria-current="true">
                        Головна сторінка
                    </a>
                    <a href="/manager/patients" class="list-group-item list-group-item-action">Усі пацієнти</a>
                    <a href="/prescriptions" class="list-group-item list-group-item-action">Усі можливі призначення</a>
                    <a href="/admin" class="list-group-item list-group-item-action" >Перейти до адміністративної панелі</a>
                </div>
            </div>
            <div class="col-md-8">


                <#if prescriptionCategories??>
                <#list prescriptionCategories as category>


                <div class="col-12"><div class="card mb-3" style="max-width: 540px;">

                        <div class="row g-0">
                            <div class="col-md-4">
                                <a href="/category/${category.id}">
                                    <img src="${category.images}" class="img-fluid rounded-start" alt="${category.name}">
                                </a>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h4 class="card-title"> ${category.name} </h4>
                                    <p class="card-text"> ${category.description}</p>
                                </div>
                            </div>
                        </div>

                    </div>
                    </#list>
                    </#if>

                </div>
            </div>
            <hr>
            <h3>Створення нової категорії</h3>
            <form method="post" action="createNewCategory">
                <label for="name">Назва нової категорії</label>
                <input type="text" id="name" name="name">

                <label for="description">Опис даної катеорії</label>
                <input type="text" id="description" name="description">

                <label for="image">Шлях до нової картинки</label>
                <input type="text" id="image" name="image">
                <br>
                <button type="submit">Додати</button>

            </form>

        </div>



            </div>
        </div>

    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.min.js" integrity="sha384-RuyvpeZCxMJCqVUGFI0Do1mQrods/hhxYlcVfGPOfQtPJh0JCw12tUAZ/Mv10S7D" crossorigin="anonymous"></script>
    </body>
    </html>
