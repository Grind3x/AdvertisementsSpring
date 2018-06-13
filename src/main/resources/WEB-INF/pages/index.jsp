<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Prog.kiev.ua</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        .thumbnail {
            position: relative;
            width: 100px;
            height: 100px;
            overflow: hidden;
        }

        .thumbnail img {
            position: absolute;
            left: 50%;
            top: 50%;
            height: 100%;
            width: auto;
            -webkit-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }

        .thumbnail img.portrait {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="/">Prog.kiev.ua</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Add adv</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/view_all">View All</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top:10px">

    <div align="center">

        <form action="/add_xml" enctype="multipart/form-data" method="POST">
            Photo: <input type="file" name="file">
            <input type="submit" />
        </form>
    </div>


</div>
</body>
</html>

