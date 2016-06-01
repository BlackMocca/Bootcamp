<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>BootCamp Programming</title>
    <%@include file="../header.jsp" %>
</head>

<body>

    <div id="wrapper">
        <%@include file="../navbar.jsp" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">User Profile</h1>
        </div>
    </div>
    <div class="row">
        <form role="form" action="${pageContext.request.contextPath}/UpdateProfileServlet" method="post">
            <div class="col-lg-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Student Insance 
                    </div>
                    <div class="panel-body">

                        <fieldset disabled="">
                            <div class="form-group">
                                <label for="disabledSelect">Student ID</label>
                                <input class="form-control" id="disabledInput" type="text" placeholder="56130500008" disabled="">
                            </div>
                            <div class="form-group">
                                <label for="disabledSelect">LDAP Student Name</label>
                                <input class="form-control" id="disabledInput" type="text" placeholder="Jirapat Hangjaraon" disabled="">
                            </div>
                        </fieldset>
                    </div>
                </div>
            </div>

            <div class="col-lg-9">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       Update Profile
                    </div>
                    <div class="panel-body">
                      <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" placeholder="Name" name="name" value="${student.name}">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" placeholder="Enter Email" name="email" value="${student.email}">
                    </div>
                    <div class="form-group">
                        <label>Telephone</label>
                        <input type="text" class="form-control" placeholder="Enter Telephone" name="tel" value="${student.tel}">
                    </div>
                    <button type="submit" class="btn btn-primary pull-right">Update</button>
                </div>
            </div>
        </div>



    </form>

</div>
</div>



</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/metisMenu.min.js"></script>
<script src="js/raphael-min.js"></script>
<script src="js/morris.min.js"></script>
<script src="js/morris-data.js"></script>
<script src="js/sb-admin-2.js"></script>
</html>
