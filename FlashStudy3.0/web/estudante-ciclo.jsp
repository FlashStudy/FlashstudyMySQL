<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Ciclo de Estudos</title>

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

        <script type="text/javascript">
            function testaTable() {
                tabela = document.getElementById("ciclo");
            }

            function criaTabela() {
                var x = document.createElement("TABLE");
                x.setAttribute("id", "myTable");
                document.getElementById("areaCiclo").appendChild(x);

                var y = document.createElement("TR");
                y.setAttribute("id", "myTr");
                document.getElementById("myTable").appendChild(y);

                var z = document.createElement("TD");
                var t = document.createTextNode("cell");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);
            }

            function addHorarios() {
                var x = document.getElementById("selInicio");
                var y = document.getElementById("selFim");
                var i;

                for (i = 0; i < 24; i++) {
                    var option1 = document.createElement("option");
                    var option2 = document.createElement("option");

                    option1.text = i + ":00";
                    option2.text = i + ":00";

                    x.add(option1);
                    y.add(option2);

                }

            }
        </script>

        <style type="text/css">
            table {
                border-collapse: collapse;
                border-spacing: 0;
                width: 100%;
                border: 1px solid #ddd;
                border-color: black;
            }

            body{
                background-color: #2C3E50;
            }

            th, td {
                text-align: center;
                padding: 16px;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2
            }

            button{
                margin-bottom: 10px;
            }

            #adHora{
                float: right;
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
            <h2 class="icon icon-refresh" style="color: #cccccc"> Ciclo de Estudos</h2>
            <span class="byline" style="color: #cccccc">Veja aqui o que há para hoje e para a semana</span>
        </div>

        <div class="container">
            <div class="jumbotron" id="areaCiclo">

                <button type="button" class="btn btn-primary" id="btnCiclo" data-toggle="modal" data-target="#myModal" onclick="addHorarios()">
                    <spam class = "icon icon-refresh"> Solicitar ciclo</spam>
                </button>
                <div style="overflow-x:auto;">
                    <table id="mTabela">
                        <tr>
                            <th>Horários</th>
                            <th>Domingo</th>
                            <th>Segunda</th>
                            <th>Terça</th>
                            <th>Quarta</th>
                            <th>Quinta</th>
                            <th>Sexta</th>
                            <th>Sábado</th>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr><tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr><tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr><tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr><tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr><tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>

            <!-- Modal Formulário -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal cabeçalhor -->
                        <div class="modal-header">
                            <h4 class="modal-title">Formulário para criar o ciclo</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal corpo -->
                        <div class="modal-body" id="mBody">
                            <div>
                                <div class="form-group">
                                    <label for="sel1"><strong>Selecione o dia:</strong></label>
                                    <select class="form-control" id="selDia">
                                        <option>Domingo</option>
                                        <option>Segunda</option>
                                        <option>Terça</option>
                                        <option>Quarta</option>
                                        <option>Quinta</option>
                                        <option>Sexta</option>
                                        <option>Sábado</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="sel1"><strong>Horário Início:</strong></label>
                                    <select class="form-control" id="selInicio">
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="sel1"><strong>Horário fim:</strong></label>
                                    <select class="form-control" id="selFim">
                                    </select>
                                </div>

                                <button type="button" class="btn btn-primary" style="width: 100%"><span class="icon icon-plus-sign"> Adicionar dia e horários</span></button>
                            </div>
                            <table id="mTabela">
                                <tr>
                                    <th>Dias</th>
                                    <th>Horários</th>
                                </tr>
                            </table>
                        </div>

                        <!-- Modal rodapé -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success" data-dismiss="modal">Criar ciclo</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
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