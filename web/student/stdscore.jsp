<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="bootcamp.model.database.Assessment"%>
<%@page import="bootcamp.model.database.Score"%>
<%@page import="bootcamp.model.database.CourseInstance"%>
<%@page import="java.util.List"%>
<%DecimalFormat scoreFormat = new DecimalFormat("#,###.00");%>
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
    <br>
    <div class="row">
        <div class="col-lg-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Choose Subject 
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <ul class="nav navsemester">
                        <%
                            List<CourseInstance> courseInstances = (List<CourseInstance>)request.getAttribute("enrollCourses");
                            for(int i=0; i < courseInstances.size();i++) {
                        %>
                        <li><a href="StudentScoreView?courseid=<%= courseInstances.get(i).getCourseId() %>"><%= courseInstances.get(i).getCourseCode()+ " "+courseInstances.get(i).getCourseName() %></a></li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </div>





        <div class="col-lg-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    ${selectedCourse.courseCode}  ${selectedCourse.courseName} (Semester ${semester}/<%= ((Date)request.getAttribute("year")).getYear() + 1900 %>)
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Assessments</th>
                                    <th>Score</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    Map<Long, Score> scoreList = (Map<Long, Score>)request.getAttribute("scoreList");
                                    List<Assessment> showAssessment = (List<Assessment>) request.getAttribute("showAssessment");
                                    for(int i = 0; i< showAssessment.size() ; i++) {
                                        Score score = (Score)(scoreList.get(showAssessment.get(i).getAssessmentId()));
                                %>
                                    <tr>
                                    <td><%= i+1 %></td>
                                    <td><%= showAssessment.get(i).getName() %><%if(showAssessment.get(i).getScore()>-1){%>(<%= scoreFormat.format(showAssessment.get(i).getScore()) %>)<%}%></td>
                                    <td><%= score.getGrade()!= null ? score.getGrade(): scoreFormat.format(score.getScore())%></td>
                                    </tr>
                                <%}%>
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
