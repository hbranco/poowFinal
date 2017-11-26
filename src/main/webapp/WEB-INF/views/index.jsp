<%--<!DOCTYPE html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<meta charset="UTF-8"/>--%>
    <%--<meta charset="UTF-8">--%>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Produtos Login</title>
    <!-- Favicon-->
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
<body class="login-page">
<div class="login-box">
    <div class="logo">
        <a href="javascript:void(0);">Controle<b>Produtos</b></a>
        <small>Sistema de controle e qualidade de produção</small>
    </div>
    <div class="card">
        <div class="body">
            <form id="sign_in" action="/autenticar" method="POST">
                <div class="msg">Entre com seu Usuario e Senha</div>
                <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                    <div class="form-line">
                        <input type="text" class="form-control" name="usuario_nome" placeholder="usuario_nome" required autofocus>
                    </div>
                </div>
                <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                    <div class="form-line">
                        <input type="password" class="form-control" name="usuario_senha" placeholder="usuario_senha" required>
                    </div>
                    <span class="text text-capitalize text-danger"> ${erroSenha} </span>
                </div>
                <div class="row">
                    <div class="col-xs-4 pull-right">
                        <button class="btn btn-block bg-green waves-effect" type="submit">Entrar!</button>
                    </div>

                    <div class="col-xs-4 pull-left">
                        <a href="/novousuario" class="btn btn-block bg-pink waves-effect" type="submit">Nova Conta!</a>
                    </div>
                </div>

                <div class="row">
                    <div class="text-center">
                        <span class="text text-capitalize text-info">${usuarioInvalido}</span>
                    </div>
                </div>


                <%--<div class="row m-t-15 m-b--20">--%>
                    <%--<div class="col-xs-6">--%>
                        <%--<a href="/novousuario">Nova Conta!</a>--%>
                    <%--</div>--%>

                <%--</div>--%>
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
<script src="/public/js/pages/examples/sign-in.js"></script>
</body>
</html>