<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Aluno</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="css/estudante-padrao.css" rel="stylesheet" type="text/css"/>
        <link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

        <link rel="shortcut icon" href="img/icon.png" type="image/ico">        

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- Plugin CSS -->
        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/freelancer.min.css" rel="stylesheet">

        <style>

            body{
                background-color: #2C3E50;
            }

            .carousel-inner img {
                width: 100%;
                height: 100%;
            }

            .bloco{
                border-style: solid;
                margin-top: 30px;
                margin-bottom: 0px;
            }
        </style>
    </head>

    <body>
        <%
            HttpSession sessao = request.getSession();
            Usuario us = (Usuario)sessao.getAttribute("usuario");
            
        %>


        <nav class="navbar navbar-expand-lg navbar-light bg-primary rounded">
            <a class="navbar-brand h1 mb-0 icon icon-group" href="estudante-inicial.jsp"> FlashStudy</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav ml-auto">
                    <a class="nav-item nav-link icon icon-calendar"      href="estudante-cronograma.jsp" style="color: #383838"> Cronograma</a>
                    <a class="nav-item nav-link icon icon-refresh link"  href="estudante-ciclo.jsp" style="color: #383838"> Ciclo de estudos</a>
                    <a class="nav-item nav-link icon icon-pushpin"       href="estudante-flashcards.jsp" style="color: #383838"> Flashcards</a>  
                    <a class="nav-item nav-link icon icon-user"          href="estudante-perfil.jsp" style="color: #383838"> Perfil</a>
                    <a class="nav-item nav-link icon icon-question-sign" href="estudante-ajuda.jsp" style="color: #383838"> Ajuda</a>
                    <a class="nav-item nav-link icon icon-signout"       href="executar_login" style="color: #383838"> Sair</a>
                </div>
            </div>
        </nav>

        <div class="title ">
            <h2 class="icon icon-home" style="color: #cccccc"> Bem-vindo!</h2>
        </div>


        <div class="container">
            <div id="carouselSite" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselSite" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselSite" data-slide-to="1"></li>
                </ol>

                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/carrousel1.jpg">
                        <div class="carousel-caption d-none d-md-block">
                            <h1>Uma infinidade de opções!</h1>
                            <p class="lead">Tenha acesso a diversos materiais</p>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <img src="img/carrousel2.jpg">
                        <div class="carousel-caption d-none d-md-block">
                            <h1>Diminua o espaço!</h1>
                            <p class="lead">Tenha tudo em um só lugar</p>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselSite" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                    <span class="sr-only"> anterior</span>
                </a>
                <a class="carousel-control-next" href="#carouselSite" role="button" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                    <span class="sr-only"> avançar</span>
                </a>

            </div>


            <!-- Bootstrap core JavaScript -->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Plugin JavaScript -->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
            <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

            <!-- Contact Form JavaScript -->
            <script src="js/jqBootstrapValidation.js"></script>
            <script src="js/contact_me.js"></script>

            <!-- Custom scripts for this template -->
            <script src="js/freelancer.min.js"></script>

    </body>
</html>