<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
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
        </style>

        <script type="text/javascript">
            function addMateriaTbl() {

                if (document.getElementById("materia").value != "") {

                    var table = document.getElementById("tblMaterias");
                    var row = table.insertRow(1);
                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    cell1.innerHTML = document.getElementById("selMes").value;
                    cell2.innerHTML = document.getElementById("materia").value;
                }
            }

            function resetTbl() {
                var x = document.getElementById("tblMaterias").rows.length;

                if (x > 1) {

                    var i = 1;
                    while (i <= x) {
                        document.getElementById("tblMaterias").deleteRow(i);
                    }
                }
            }
        </script>
    </head>

    <body>

        <%
            String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        %>
        <%
            HttpSession sessao = request.getSession();
            Usuario us = (Usuario)sessao.getAttribute("usuario");
            
            out.println(us.getNome());
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
                    <a class="nav-item nav-link icon icon-signout"      href="executar_login" style="color: #383838"> Sair</a>
                </div>
            </div>
        </nav>

        <div class="title">
            <h2 class="icon icon-calendar"> Cronograma</h2>
            <span class="byline">Calendário com todos os seus planejamentos</span>
        </div>

        <div class="container-fluid">
            <div class="jumbotron">

                <button type="button" class="btn btn-primary" id="btnCiclo" data-toggle="modal" data-target="#myModal" onclick="addHorarios()">
                    <spam class = "icon icon-edit"> Editar Cronograma</spam>
                </button>

                <!-- Modal Formulário -->
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal cabeçalhor -->
                            <div class="modal-header">
                                <h4 class="modal-title">Cronograma</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal corpo -->
                            <div class="modal-body" id="mBody">
                                <div>
                                    <div class="form-group">
                                        <label for="sel1"><strong>Selecione o mês:</strong></label>
                                        <select class="form-control" id="selMes">
                                            <% for (int i = 0; i < 12; i++) {%>
                                            <option value="<%= meses[i]%>"><%= meses[i]%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="sel1"><strong>Matéria:</strong></label>
                                        <input type="text" class="form-control" id="materia" 
                                               placeholder="Nome da matéria" name="materia"/>                         
                                    </div>
                                    <button type="button" class="btn btn-primary" onclick="addMateriaTbl()" style="width: 100%">
                                        <span class="icon icon-plus-sign"> Adicionar mês e matéria</span>
                                    </button>
                                </div>
                                <table id="tblMaterias">
                                    <tr>
                                        <th>Mês</th>
                                        <th>Matéria</th>
                                    </tr>
                                </table>
                                <table  >

                                </table>
                            </div>

                            <!-- Modal rodapé -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-success" data-dismiss="modal">Concluir</button>
                                <button type="button" class="btn btn-danger" onclick="resetTbl()" data-dismiss="modal">Cancelar</button>
                            </div>

                        </div>
                    </div>
                </div>

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