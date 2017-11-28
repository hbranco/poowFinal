<%--
  Created by IntelliJ IDEA.
  User: branco
  Date: 26/11/17
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Controle Produção</title>
    <!-- Favicon-->
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

    <!-- Morris Chart Css-->
    <link href="/public/plugins/morrisjs/morris.css" rel="stylesheet" />

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
                            <a href="/produtoteste">Produtos Em Teste</a>
                        </li>
                        <li>
                            <a href="/defeito">Produtos Dfeito</a>
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
        <div class="block-header">
            <h2>DASHBOARD</h2>
        </div>

        <!-- Widgets -->
        <div class="row clearfix">
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-pink hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">playlist_add_check</i>
                    </div>
                    <div class="content">
                        <div class="text">PRODUTOS EM TESTE</div>
                        <div class="number count-to" data-from="0" data-to="${teste}" data-speed="15" data-fresh-interval="20"></div>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-pink hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">playlist_add_check</i>
                    </div>
                    <div class="content">
                        <div class="text">PRODUTOS EM ESTOQUE</div>
                        <div class="number count-to" data-from="0" data-to="${estoque}" data-speed="15" data-fresh-interval="20"></div>
                    </div>
                </div>
            </div>





            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-pink hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">playlist_add_check</i>
                    </div>
                    <div class="content">
                        <div class="text">PRODUTOS AGUANDANDO CONSERTO</div>
                        <div class="number count-to" data-from="0" data-to="${defeito}" data-speed="15" data-fresh-interval="20"></div>
                    </div>
                </div>
            </div>


            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-pink hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">playlist_add_check</i>
                    </div>
                    <div class="content">
                        <div class="text">PRODUTOS VENDIDOS</div>
                        <div class="number count-to" data-from="0" data-to="${venvido}" data-speed="15" data-fresh-interval="20"></div>
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
<script src="/public/plugins/bootstrap-select/js/bootstrap-select.js"></script>

<!-- Slimscroll Plugin Js -->
<%--<script src="/public/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>--%>

<!-- Waves Effect Plugin Js -->
<script src="/public/plugins/node-waves/waves.js"></script>

<!-- Jquery CountTo Plugin Js -->
<script src="/public/plugins/jquery-countto/jquery.countTo.js"></script>

<!-- Morris Plugin Js -->
<script src="/public/plugins/raphael/raphael.min.js"></script>
<script src="/public/plugins/morrisjs/morris.js"></script>

<!-- ChartJs -->
<script src="/public/plugins/chartjs/Chart.bundle.js"></script>

<!-- Flot Charts Plugin Js -->
<script src="/public/plugins/flot-charts/jquery.flot.js"></script>
<script src="/public/plugins/flot-charts/jquery.flot.resize.js"></script>
<script src="/public/plugins/flot-charts/jquery.flot.pie.js"></script>
<script src="/public/plugins/flot-charts/jquery.flot.categories.js"></script>
<script src="/public/plugins/flot-charts/jquery.flot.time.js"></script>

<!-- Sparkline Chart Plugin Js -->
<script src="/public/plugins/jquery-sparkline/jquery.sparkline.js"></script>

<!-- Custom Js -->
<script src="/public/js/admin.js"></script>
<script src="/public/js/pages/index.js"></script>

<!-- Demo Js -->
<script src="/public/js/demo.js"></script>
</body>

</html>