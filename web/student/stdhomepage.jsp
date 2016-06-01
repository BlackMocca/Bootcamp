<%@page import="java.util.List"%>
<%@page import="bootcamp.model.database.CourseInstance"%>
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
    <br/>  
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Semester ${selectSemester == 3 ? "Summer" : selectSemester}/${selectYear} 
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Subject</th>
                                    <th>Lecturer</th>
                                    <th>View Score</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<CourseInstance> courseLists = (List<CourseInstance>) request.getAttribute("courseInstances");
                                    for(int i = 0; i<courseLists.size();i++){
                                %>
                                <tr>
                                    <td><%= i+1 %></td>
                                    <td><%= courseLists.get(i).getCourseCode() + " " + courseLists.get(i).getCourseName()%></td>
                                    <td></td>
                                    <td><a href="StudentScoreView?courseid=<%= courseLists.get(i).getCourseId() %>"><i class="fa fa-info-circle" aria-hidden="true"></i></a></td>
                                </tr>
                                <%}
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>




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
