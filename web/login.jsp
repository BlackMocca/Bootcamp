<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta h<body>
ttp-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>BootCamp Programming</title>
    <%@include file="header.jsp" %>
</head>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Student Portal</h3>
                    </div>
                    <div class="panel-body loginbody">
                        <img src="img/sitlogo.jpg" class="logo">
                        <form role="form" action="LoginServlet" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Student Id" name="email" type="" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <c:if test="${message != null}">
                                <p class="errormessage">${message}</p>
                                </c:if>
                                <input type="submit" class="btn btn-lg btn-success btn-block" value="Login"> 
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
 <!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/metisMenu.min.js"></script>
    <script src="js/raphael-min.js"></script>
    <script src="js/morris.min.js"></script>
    <script src="js/morris-data.js"></script>
    <script src="js/sb-admin-2.js"></script>
</html>
