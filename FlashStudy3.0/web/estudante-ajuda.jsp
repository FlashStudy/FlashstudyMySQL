<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Ajuda</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="css/estudante-padrao.css" rel="stylesheet" type="text/css" media="all" />
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

        <style type="text/css">
            body{
                background-color: #2C3E50;
            }

            .container{
                width: 70%;
            }

            textarea{
                height: 300px;
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
                    <a class="nav-item nav-link icon icon-calendar"     href="estudante-cronograma.jsp" style="color: #383838"> Cronograma</a>
                    <a class="nav-item nav-link icon icon-refresh link"      href="estudante-ciclo.jsp" style="color: #383838"> Ciclo de estudos</a>
                    <a class="nav-item nav-link icon icon-pushpin"      href="estudante-flashcards.jsp" style="color: #383838"> Flashcards</a>  
                    <a class="nav-item nav-link icon icon-user"         href="estudante-perfil.jsp" style="color: #383838"> Perfil</a>
                    <a class="nav-item nav-link icon icon-question-sign" href="estudante-ajuda.jsp" style="color: #383838"> Ajuda</a>
                    <a class="nav-item nav-link icon icon-signout"      href="executar_login" style="color: #383838"> Sair</a>
                </div>
            </div>
        </nav>

        <div class="title">
            <h2 class="icon icon-question-sign" style="color: #cccccc"> Ajuda</h2>
            <span class="byline" style="color: #cccccc">Veja aqui algumas dicas de como usar o <strong>Flashstudy</strong></span>
        </div>

        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-sm-12">
                    <div class="jumbotron">
                        <h3><strong>Dúvidas frequentes</strong></h3>

                        <div id="accordion">

                            <div class="card">
                                <div class="card-header">
                                    <a class="card-link" data-toggle="collapse" href="#collapseOne">
                                        Solicitando um <strong>Ciclo de Estudos</strong>
                                    </a>
                                </div>
                                <div id="collapseOne" class="collapse show" data-parent="#accordion">
                                    <div class="card-body">
                                        <ol>
                                            <li>Clique no menu <strong>Cronograma</strong> e crie novo cronograma;</li>
                                            <li>Insira todas as os assuntos e metas que deseja;</li>
                                            <li>Clique no menu <strong>Ciclo</strong> e clique no botão <strong>solicitar ciclo</strong>;</li>
                                            <li>Selecione o <strong>dia</strong> e os <strong>horáraios de início e fim</strong> do seu estudo no determinado dia;</li>
                                            <li>Adicione quantos dias você desejar e clique no botão <stron>criar ciclo</stron>;</li>
                                            <li>O sistema irá gerar automaticamente o seu <stron>Ciclo de estudos!</stron></li>
                                        </ol>
                                    </div>
                                </div>
                            </div>

                            <div class="card">
                                <div class="card-header">
                                    <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
                                        Criando um <strong>Flashcard</strong>
                                    </a>
                                </div>
                                <div id="collapseTwo" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                                    </div>
                                </div>
                            </div>
                            <!--
                            <div class="card">
                                <div class="card-header">
                                    <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
                                    Adicionando anotações ao seu <strong>Caderno online</strong>
                                    </a>
                                </div>
                                <div id="collapseThree" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                                    </div>
                                </div>
                            </div>
                            -->
                        </div>

                    </div>
                </div>
                <div class="col-lg-6 col-sm-12">
                    <div class="jumbotron">
                        <div class="container">
                            <div id="info">
                                <h2>Para mais informações:</h2>
                                <form action="/action_page.php">
                                    <div class="form-group">
                                        <label for="assunto"><strong>Assunto:</strong></label>
                                        <input type="text" class="form-control" id="assunto" placeholder="Assunto principal" name="assunto">
                                    </div>
                                    <div class="form-group">
                                        <label for="pwd2"><strong>Descrição:</strong></label>
                                        <textarea class="form-control" rows="5" placeholder="Críticas, dúvidas, sugestões..."></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-success">Enviar mensagem</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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