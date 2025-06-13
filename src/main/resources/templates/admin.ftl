<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
    <ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/admin">Головна панель</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/admin/users">Зміна інформації входу про користувачів</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/admin/roles">Зміна ролей користувачів</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/admin/doctors">Зміна інформації про персональних даних користувачів</a>
    </li>
    </ul>
    </div>
<br>
    <div class="row">
        <div class="col-md-4">
            <a href="/" style="text-decoration: none">
                <div class="card text-bg-dark">
                    <img src="/static/images/home.png" class="card-img" style="max-height: 512px; max-width: 512px;" alt="...">
                    <div class="card-img-overlay">
                        <h5 class="card-title">Повернутися на користувацьку сторінку</h5>
                        <p class="card-text">Повернутися на користувацьку сторінку для діагностування, виписування та інші лікарські функції.</p>
                    </div>
                </div>
            </a>
        </div>
    <div class="col-md-4">
        <a href="/manager" style="text-decoration: none">
        <div class="card text-bg-dark">
            <img src="/static/images/manager.png" class="card-img" style="max-height: 512px; max-width: 512px;" alt="...">
            <div class="card-img-overlay">
                <h5 class="card-title">Повернутися на сторінку менеджера</h5>
                <p class="card-text">Перейти на сторінку менеджера: редагувати інформацію про пацієнтів, ліки та діагнози.</p>
            </div>
        </div>
        </a>
    </div>

        <div class="col-md-4">
            <a href="/admin" style="text-decoration: none">
                <div class="card text-bg-dark">
                    <img src="/static/images/admin.png" class="card-img" style="max-height: 512px; max-width: 512px;" alt="...">
                    <div class="card-img-overlay">
                        <h5 class="card-title">Повернутися на сторінку адміністрування</h5>
                        <p class="card-text">Повернутися до адміністративної сторінки</p>
                    </div>
                </div>
            </a>
        </div>




    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.min.js" integrity="sha384-RuyvpeZCxMJCqVUGFI0Do1mQrods/hhxYlcVfGPOfQtPJh0JCw12tUAZ/Mv10S7D" crossorigin="anonymous"></script>
</body>
</html>