<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page import="model.Flashcard"%>
<%@page import="dao.FlashcardDao"%>

<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Flashcards</title>

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
            #area{
                height: 100%;
            }

            #flash1{
                background-color: cadetblue;
                width: 80%;
                height: 300px;
                margin: auto;
                margin-bottom: 20px;
                padding: 5px;
            }

            #flash2{
                background-color: lightgreen;
                width: 80%;
                height: 300px;
                margin: auto;
                margin-bottom: 20px;
                padding: 5px;;
            }

            #resposta{
                height: 240px;
            }

            #pergunta{
                height: 180px;
            }

            .jumbotron{
                height: 100%;
            }

            .btn-group-wrap {
                text-align: center;
            }

            div.btn-group {
                margin: 0 auto; 
                text-align: center;
                width: inherit;
            }

            a {
                float: left;   
            }

            form{
                padding-top: 15px;
            }

            h4{
                padding: auto;
                margin-left: 50px;
            }
        </style>

    </head>

    <body>
        <%
            HttpSession sessao = request.getSession();
            Usuario us = (Usuario)sessao.getAttribute("usuario");
            
            String email = us.getEmail();
            
            out.println(us.getNome());
            
            FlashcardDao dao = new FlashcardDao();
            
            ArrayList<Flashcard> cards =(ArrayList) dao.getByEmail(email);
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
            <h2 class="icon icon-pushpin"> Flashcards</h2>
            <span class="byline">Crie e edite todos os seus flashcards</span>
        </div>

        <div class="container" id="area">
            <div class="jumbotron">
                <div class="row">
                    <div class="col-lg-12">
                        <form action="FlashcardServlet" method="POST">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="btn-group-wrap">
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-primary" title="Favoritar" id="btnFav"><a class="icon icon-star"></a></button>
                                            <button type="button" class="btn btn-primary" title="Criar novo" id="btnNovo"><a class="icon icon-plus-sign"></a></button>
                                            <button type="button" class="btn btn-primary" title="Deletar" id="btnDel"><a class="icon icon-trash"></a></button>
                                            <button type="button" class="btn btn-primary" title="Editar um flashcard" id="btnEdit"><a class="icon icon-edit"></a></button>
                                            <button type="button" class="btn btn-primary" title="Outras pessoas terão acesso ao flashcard" id="btnPublic">
                                                <input type="checkbox" name="publico" value="Público"/>  Público?</button>
                                        </div>   
                                    </div>  
                                </div>
                                <div class="col-lg-6">
                                    <div class="display-4">
                                        <h4>Pergunta</h4>
                                    </div>
                                    <div class="jumbotron" id="flash1">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="titulo" placeholder="Título do flashcard" name="titulo">
                                        </div>
                                        <div class="form-group">
                                            <textarea class="form-control" placeholder="Insira a sua pergunta aqui" id="pergunta" name="pergunta"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="display-4">
                                        <h4>Resposta</h4>
                                    </div>
                                    <div class="jumbotron" id="flash2">
                                        <div class="form-group">
                                            <textarea class="form-control" placeholder="Insira a sua resposta aqui" id="resposta" name="resposta"></textarea>
                                            <input type="hidden" name="email" value="<%= email%>"/>
                                            <button type="submit" class="btn btn-primary">Salvar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="jumbotron">
            <div class="row">
                <%
                    int i;
                    for(i=0; i<cards.size();i++){     
                %>
                <div class="col-lg-3 col-sm-12">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title"><%= cards.get(i).getTitulo()%></h5>
                            <p class="card-text">
                            <ul>
                                <li>Nível:<%= cards.get(i).getNivel()%></li>
                                <li>Status:<%= cards.get(i).isPublico()%></li>
                            </ul>
                            </p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>
                <%
                    }
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