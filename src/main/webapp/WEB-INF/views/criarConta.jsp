<%--
  Created by IntelliJ IDEA.
  User: branco
  Date: 26/11/17
  Time: 01:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Controle Produção</title>    <!-- Favicon-->
    <link rel="icon" href="/public/images/Logo.png" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="/public/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="/public/plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="/public/plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="/public/stylesheets/style.css" rel="stylesheet">
</head>

<body class="signup-page">
<div class="signup-box">
    <div class="logo">
        <a href="javascript:void(0);">Controle<b>Produtos</b></a>
        <small>Sistema de controle e qualidade de produção</small>
    </div>
    <div class="card">
        <div class="body">
            <form id="sign_up" method="POST" action="/cadastrarusuario">
                <div class="msg">Registre-se para acessar!</div>
                <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                    <div class="form-line">
                        <input type="text" class="form-control" name="usuario_nome" placeholder="Seu Usuario" required autofocus>
                    </div>
                </div>
                
                <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                    <div class="form-line">
                        <input type="password" class="form-control" name="usuario_senha" id="usuario_senha" minlength="6" placeholder="digite uma senha" required>
                    </div>
                </div>

                <button class="btn btn-block btn-lg bg-green waves-effect" type="submit">Cadastrar</button>

                <div class="m-t-25 m-b--5 align-center">
                    <a href="/">Já tem uma conta?</a>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Jquery Core Js -->
<script src="/public/plugins/jquery/jquery.min.js"></script>

<!-- Bootstrap Core Js -->
<script src="/public/plugins/bootstrap/js/bootstrap.js"></script>

<!-- Waves Effect Plugin Js -->
<script src="/public/plugins/node-waves/waves.js"></script>

<!-- Validation Plugin Js -->
<script src="/public/plugins/jquery-validation/jquery.validate.js"></script>

<!-- Custom Js -->
<script src="/public/js/admin.js"></script>
<script src="/public/js/pages/examples/sign-up.js"></script>
</body>

</html>