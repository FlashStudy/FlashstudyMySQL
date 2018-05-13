<%@page import="model.Usuario"%>
<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Cronograma de Estudos</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="shortcut icon" href="images/icon.ico" type="image/ico">        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="css/estudante-padrao.css" rel="stylesheet" type="text/css" media="all" />
        <link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="javascript/acoes.js"></script>

        <style type="text/css">
            table {
                border-collapse: collapse;
                border-spacing: 0;
                width: 100%;
                border: 1px solid #ddd;
            }

            th, td {
                text-align: center;
                padding: 16px;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2
            }
            tr:nth-child(odd) {
                background-color: #ffffff
            }
        </style>
    </head>

    <body>

        <%
            Usuario us = (Usuario) session.getAttribute("Usuario");
        %>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
                    <a class="nav-item nav-link icon icon-signout"      href="index.html" style="color: #383838"> Sair</a>
                </div>
            </div>
        </nav>

        <div class="title">
            <h2 class="icon icon-calendar"> Cronograma</h2>
            <span class="byline">Calendário com todos os seus planejamentos</span>
        </div>

        <div class="container-fluid">
            <div class="jumbotron">
                <button type="button" class="btn btn-primary icon icon-edit" id="btnEdit"> Editar cronograma</button>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header">
                                <a class="card-link" data-toggle="collapse" href="#collapseOne">
                                    <strong>Janeiro</strong>
                                </a>
                            </div>
                            <div id="collapseOne" class="collapse show" data-parent="#accordion">
                                <div class="card-body">
                                    <ul>
                                        <li>LP II</li>
                                        <li>Redes</li>
                                        <li>PIHM</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header">
                                <a class="card-link" data-toggle="collapse" href="#collapseTwo">
                                    <strong>Fevereiro</strong>
                                </a>
                            </div>
                            <div id="collapseTwo" class="collapse show" data-parent="#accordion">
                                <div class="card-body">
                                    <ul>
                                        <li>Português</li>
                                        <li>Matemática</li>
                                        <li>Física</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header">
                                <a class="card-link" data-toggle="collapse" href="#collapseThree">
                                    <strong>Março</strong>
                                </a>
                            </div>
                            <div id="collapseThree" class="collapse show" data-parent="#accordion">
                                <div class="card-body">
                                    <ul>
                                        <li>Filosofia</li>
                                        <li>Sociologia</li>
                                        <li>Química</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>