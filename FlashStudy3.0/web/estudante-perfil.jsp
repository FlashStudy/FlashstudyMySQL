<%@page import="model.Usuario"%>
<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Perfil</title>

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

        <style>
            IMG.displayed {
                display: block;
                margin-left: auto;
                margin-right: auto;
                padding: 15px;
                width: 400px;
            }

            .jumbotron{
                width: 80%;
            }

            #contFt{
                text-align: center;
            }
        </style>
    </head>

    <body>
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

        <div class="container-fluid">
            <div class="title">
                <h2 class="icon icon-user"> Perfil</h2>
                <span class="byline">Verifique e edite os seus dados</span>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-md-12 col-sm-12 col-xsm-12">
                    <div class="container" id="contFt">
                        <IMG class="displayed" src="images/user-default.png" alt="Usuário"></IMG>
                        <button type="button"class="btn btn-primary">Mudar foto</button>
                    </div>
                </div>

                <div class="col-lg-6 col-md-12 col-sm-12 col-xsm-12">
                    <div class="container">                                
                        <div class="jumbotron">
                            <form action="/action_page.php">
                                <div class="form-group">
                                    <label for="email">Nome:</label>
                                    <input type="text" class="form-control" id="nome" value="<%=us.getNome()%>" name="nome" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Email:</label>
                                    <input type="email" class="form-control" id="email" value="<%=us.getEmail()%>" name="email" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Senha:</label>
                                    <input type="password" class="form-control" id="senha" value="<%=us.getSenha()%>" name="senha" disabled>
                                </div>
                                <div class="form-group">
                                    <p id="lblsenha"></p>
                                    <input type="hidden" class="form-control" id="senhaC" name="senhaC">
                                </div>
                                <button type="button" onclick="editaDados(this.value)" class="btn btn-primary">Editar dados</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>