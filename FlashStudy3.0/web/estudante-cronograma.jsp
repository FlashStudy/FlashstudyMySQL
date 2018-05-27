<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<%@page import="model.Cronograma"%>
<%@page import="dao.CronogramaDao"%>
<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Cronograma de Estudos</title>

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

            body{
                background-color: #2C3E50;
            }

        </style>

        <script type="text/javascript">
        </script>
    </head>

    <body>

        <%
            HttpSession sessao = request.getSession();
            Usuario us = (Usuario)sessao.getAttribute("usuario");
            //CronogramaDao dao = new CronogramaDao();
            //Cronograma = dao.getByEmail(us.getEmail());
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
            <h2 class="icon icon-calendar" style="color: #cccccc"> Cronograma</h2>
            <span class="byline" style="color: #cccccc">Calendário com todos os seus planejamentos</span>
        </div>

        <div class="container">
            <div class="jumbotron">
                <!-- Large modal -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg"><spam class = "icon icon-edit"> Editar Cronograma</spam></button>

                <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">

                            <!-- Cabeçalho -->
                            <div class="modal-header">
                                <h4 class="modal-title">Cronograma</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <div class="modal-body">
                                <form name="fmeses" id="fmeses" action="CronoServlet" method="GET">
                                    <div class="form-row">

                                        <div class="form-group col-md-6">
                                            <label for="mInicio">Selecione o mês inicial:</label>
                                            <input onchange="testa()" class="form-control rounded" type="date" id="minicio" name="minicio"/>
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label for="mFim">Selecione o mês final:</label>
                                            <input onchange="testa()" class="form-control rounded" type="date" id="mfim" name="mfim"/>
                                        </div>

                                        <div class="form-group">
                                            <label for="materia">Matéria:</label>
                                            <input type="text" class="form-control" id="materia" placeholder="Matemática, história ...">
                                        </div>

                                    </div>
                                </form>
                            </div>

                        </div>

                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-12">
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
                </div>
            </div>
            <!--
            <button type="button" class="btn btn-info" id="btnCiclo" data-toggle="modal" data-target="#myModal" onclick="addHorarios()">
                <spam class = "icon icon-edit"> Editar Cronograma</spam>
            </button>
            
            <!-- Modal Formulário -->
            <!--
            <div class="modal fade modal-lg" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
            
            
            <!-- Modal cabeçalhor -->

            <!--
            <div class="modal-header">
                <h4 class="modal-title">Cronograma</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal corpo -->
            <!--
            <div class="modal-body" id="mBody">
                <form name="fmeses" id="fmeses" action="CronoServlet" method="GET">
                    <div class="row">
                        <div class="form-group col">
                            <label for="mInicio"><strong>Selecione o mês inicial:</strong></label>
                            <input onchange="testa()" class="rounded" type="date" id="minicio" name="minicio"/>
                        </div>
            
                        <div class="form-group col">
                            <label for="mFim"><strong>Selecione o mês final:</strong></label>
                            <input onchange="testa()" class="rounded" type="date" id="mfim" name="mfim"/>
                        </div>
                    </div>
            
                </form>
                <div class="form-group">
                    <label for="materia"><strong>Matéria:</strong></label>
                    <input type="text" style="width: 100%" class="form-control" id="materia" 
                           placeholder="Nome da matéria" name="materia" 
                           data-toggle="tooltip" data-placement="top"
                           title="Selecione os meses para habilitar esse campo!"
                           disabled="disabled"/>                         
                </div>  
                <button type="button" class="btn btn-primary" onclick="addMateriaTbl()" style="width: 100%">
                    <span class="icon icon-plus-sign"> Adicionar mês e matéria</span>
                </button>
            
                <table id="tblMaterias">
                    <tr>
                        <th>Matérias</th>
                    </tr>
                </table>
            
                <table></table>
            
            
            <!-- Modal rodapé -->
            <!--
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Salvar</button>
                <button type="button" class="btn btn-danger" onclick="" data-dismiss="modal">Cancelar</button>
            </div>
            
            </div>
            </div>
            </div>
            </div>
            -->


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