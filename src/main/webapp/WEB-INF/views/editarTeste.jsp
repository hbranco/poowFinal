
<%--
  Created by IntelliJ IDEA.
  User: branco
  Date: 26/11/17
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Controle Produção</title>    <!-- Favicon-->
    <link rel="icon" href="/public/images/Logo.png" type="image/png">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="/public/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="/public/plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="/public/plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Sweet Alert Css -->
    <link href="/public/plugins/sweetalert/sweetalert.css" rel="stylesheet" />

    <!-- Wait Me Css -->
    <link href="/public/plugins/waitme/waitMe.css" rel="stylesheet" />

    <!-- Bootstrap Select Css -->
    <link href="/public/plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="/public/stylesheets/style.css" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="/public/stylesheets/themes/all-themes.css" rel="stylesheet" />
</head>





<body class="theme-purple">
<!-- Page Loader -->
<div class="page-loader-wrapper">
    <div class="loader">
        <div class="preloader">
            <div class="spinner-layer pl-red">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>
        </div>
        <p>Please wait...</p>
    </div>
</div>

<!-- Top Bar -->
<nav class="navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
            <a href="javascript:void(0);" class="bars"></a>
            <a class="navbar-brand" href="/dashboard">Produção Controle</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button">
                        <span> ${usuario.usuario_nome} <i class="material-icons"> perm_identity </i></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header"> ${usuario.usuario_nome}</li>
                        <li class="body"> <a href="/logout"> Sair </a> </li>


                    </ul>

                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- #Top Bar -->
<section>
    <!-- Left Sidebar -->
    <aside id="leftsidebar" class="sidebar">

        <div class="menu">
            <ul class="list">
                <li class="header">MAIN NAVIGATION</li>
                <li class="active">
                    <a href="/dashboard">
                        <i class="material-icons">home</i>
                        <span>Home</span>
                    </a>
                </li>

                <li>
                    <a href="javascript:void(0);" class="menu-toggle">
                        <i class="material-icons">swap_calls</i>
                        <span>Produção</span>
                    </a>
                    <ul class="ml-menu">
                        <li>
                            <a href="/novoproduto">Novo Produto</a>
                        </li>
                        <li>
                            <a href="/produto">Todos Produtos</a>
                        </li>
                        <li>
                            <a href="/produtoteste">Produtos em teste</a>
                        </li>
                        <li>
                            <a href="/defeito">Produtos Defeito</a>
                        </li>
                        <li>
                            <a href="/produtoestoque">Produtos Estoque</a>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
        <!-- #Menu -->
        <!-- Footer -->
        <div class="legal">
            <div class="copyright">
                &copy; 2016 - 2017 <a href="javascript:void(0);">Produção e Qualdiade</a>.
            </div>
            <div class="version">
                <b>Veersão: </b> 1.0.0
            </div>
        </div>
        <!-- #Footer -->
    </aside>
    <!-- #END# Left Sidebar -->
    <!-- Right Sidebar -->

    <!-- #END# Right Sidebar -->
</section>


<section class="content">

    <div class="container-fluid">

        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>
                            EDIÇÃO DE TESTE DE PRODUTO!
                        </h2>
                    </div>

                    <div class="body">

                            <form class="form-horizontal" action="/salvarEditaTeste" method="post">

                                <c:choose>
                                    <c:when test="${produtoTeste.produto_teste_id!= null}">
                                        <input type="hidden" name="produto_teste_id" value="${produtoTeste.produto_teste_id}">
                                    </c:when>
                                </c:choose>


                                <div class="row clearfix">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                        <label for="produto_codigo">Código do Produto</label>
                                    </div>
                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" id="produto_codigo"  name="produto_codigo"  readonly value="${produtoTeste.produto_codigo}" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="row clearfix">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                        <label for="produto_teste_data_inicio">Data Entrada</label>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="date" id="produto_teste_data_inicio"  name="produto_teste_data_inicio" value="${produtoTeste.produto_teste_data_inicio}" class="form-control" placeholder="0001">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row clearfix">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                        <label for="produto_teste_obs">Observação de Teste</label>
                                    </div>


                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <textarea type="text" id="produto_teste_obs"  name="produto_teste_obs" rows="3" class="form-control">${produtoTeste.produto_teste_obs}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="row clearfix">
                                    <div class="col-md-4 pull-right">
                                        <button type="submit" class="btn btn-primary btn-block btn-lg waves-effect">Salvar</button>
                                    </div>
                                </div>
                            </form>
                    </div>
                    <div>
                      <span>${erro}
                        ${salvo} </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>



<!-- Jquery Core Js -->
<script src="/public/plugins/jquery/jquery.min.js"></script>

<!-- Bootstrap Core Js -->
<script src="/public/plugins/bootstrap/js/bootstrap.js"></script>

<!-- Select Plugin Js -->
<!-- Select Plugin Js -->
<script src="/public/plugins/bootstrap-select/js/bootstrap-select.js"></script>

<!-- Slimscroll Plugin Js -->
<%--<script src="/public/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>--%>

<!-- Waves Effect Plugin Js -->
<script src="/public/plugins/node-waves/waves.js"></script>

<!-- Custom Js -->
<script src="/public/js/admin.js"></script>

<!-- Demo Js -->
<script src="/public/js/demo.js"></script>
</body>

</html>