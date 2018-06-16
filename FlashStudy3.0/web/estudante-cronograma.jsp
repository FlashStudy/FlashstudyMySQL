<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<%@page import="model.Assunto"%>
<%@page import="model.Cronograma"%>
<%@page import="model.Disciplina" %>
<%@page import="dao.CronogramaDao"%>
<%@page import="java.util.ArrayList" %>
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
                margin: 10px 5px;
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

        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/" type="text/javascript"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#minicio").change(function () {
                    if ($("#mfim").val() !== "") {
                        $("#materia").prop("disabled", false);
                    }
                });

                $("#mfim").change(function () {
                    if ($("#minicio").val() !== "") {
                        $("#materia").prop("disabled", false);
                    }
                });

                $("#addMateria").click(function () {
                    if ($("#materia").val() !== "") {
                        $("#tblMaterias").append("<tr><td>" + $("#materia").val() + "</td></tr>");
                        if ($("#materias").val() === "")
                            $("#materias").val($("#materia").val());
                        else
                            $("#materias").val($("#materias").val() + ";" + $("#materia").val());
                        $("#materia").val("");
                    } else {
                        alert("O campo está vazio!");
                    }
                });

                $("#btnCancelar").click(function () {
                    $("#tblMaterias").empty();
                    $("#tblMaterias").append("<tr><th>Matérias</tr></th>");
                });

                $(".close").click(function () {
                    $("#tblMaterias").empty();
                    $("#tblMaterias").append("<tr><th>Matérias</tr></th>");
                });
            });
        </script>
    </head>

    <body>

        <%
            HttpSession sessao = request.getSession();
            Usuario us = (Usuario)sessao.getAttribute("usuario");
            //CronogramaDao dao = new CronogramaDao();
            //Cronograma cronograma = dao.getByEmail(us.getEmail());
        %>

        <nav class=" navbar navbar-expand-lg navbar-light bg-primary rounded">
            <a class="navbar-brand  h1 mb-0  icon icon-group" href="estudante-inicial.jsp"> FlashStudy</a>
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
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal"><spam class = "icon icon-edit"> Editar Cronograma</spam></button>
                <input class="form-control" type="date" value="<%=//cronograma.getInicio()%>" readonly>
                <input class="form-control" type="date" value="<%=//cronograma.getFim()%>"  readonly>
                <div class="modal fade bd-example-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
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
                                            <input class="form-control rounded" type="month" id="minicio" name="minicio" value="<%=//cronograma.getInicio()%>"/>
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label for="mFim">Selecione o mês final:</label>
                                            <input class="form-control rounded" type="month" id="mfim" name="mfim" value="<%=//cronograma.getFim()%>"/>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <label for="materia"><strong>Matéria:</strong></label>
                                        <input type="text" style="width: 100%" class="form-control" id="materia" 
                                               placeholder="Nome da matéria" name="materia" 
                                               disabled="disabled"/>        
                                        <input type="hidden" name="materias" id="materias"/>
                                    </div>  
                                    <button type="button" class="btn btn-primary" id="addMateria" style="width: 100%">
                                        <span class="icon icon-plus-sign"> Adicionar matéria</span>
                                    </button>

                                    <table id="tblMaterias">
                                        <tr>
                                            <th>Matérias</th>
                                        </tr>
                                        <%
                                            //ArrayList<Disciplina> disciplinas = (ArrayList) cronograma.getDisciplinas();
                                            //for(Disciplina d : disciplinas){
                                        %>
                                        <tr><td><%=//d.getNome()%></td></tr>
                                        <%
                                        //}
                                        %>
                                    </table>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <input type="submit" class="btn btn-success" value="Confirmar" style="margin-top: 5px; width: 100%" />

                                        </div>

                                        <div class="form-group col-md-6">

                                            <button type="button" class="btn btn-danger" id="btnCancelar"
                                                    data-toggle="modal" data-target=".bd-example-modal" style="margin-top: 5px; width: 100%">Cancelar</button>
                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>

                    </div>
                </div>

                <div class="row">
                    <%
                        //for(Disciplina d : disciplinas){
                    %>
                    <div class="col-lg-4 col-md-6 col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <a class="card-link" data-toggle="collapse" href="#collapseOne">
                                    <strong><%=//d.getNome()%></strong>
                                </a>
                            </div>
                            <div id="collapseOne" class="collapse show" data-parent="#accordion">
                                <div class="card-body">
                                    <ul>
                                        <%
                                            //ArrayList<Assunto> assuntos = (ArrayList) d.getAssunto();
                                            //for(Assunto a : assuntos){
                                        %>
                                        <li><%=//a.getTema()%></li>
                                            <%
                                            //}
                                            %>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                   // }
                    %>

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