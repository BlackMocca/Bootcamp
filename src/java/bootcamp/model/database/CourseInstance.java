/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oFNo's PC
 */
public class CourseInstance {
    
    private static final String TABLE_NAME = "course_instances";
    
    private Long courseId;
    private String courseCode;
    private String courseName;
    private Date year;
    private Integer semester;
    private String courseInstanceName;

    public static List<CourseInstance> getCourseInstanceBySemester(Integer semester, String year, Connection con){
        List<CourseInstance> courseInstances = new ArrayList<CourseInstance>();
        //Hint : This method call another method in this class.
        //Hint : This method connect with database.
        System.out.println("First tttttttttttttttttttttttttttttttttttttttttt " +year);
        courseInstances.addAll(getCourseInstanceBySemester(year,String.valueOf(semester),con));
        System.out.println(courseInstances);
        return courseInstances;
    }
    public static List<CourseInstance> getCourseInstanceBySemester(String year, String semester, Connection con){
        List<CourseInstance> courseInstances = new ArrayList<CourseInstance>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.valueOf(year));
        Date date = cal.getTime();
        //Hint : This method connect with database.
          try{
            PreparedStatement pstmt = con.prepareStatement("select * from "+TABLE_NAME + " where academic_year=? and semester=? ");
            pstmt.setString(1, year);
            pstmt.setString(2, semester);
              
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                CourseInstance cin = new CourseInstance();
                ORM(rs,cin);
                courseInstances.add(cin);
                
            }
        }
        catch(Exception x){
            x.printStackTrace();
        }
        return courseInstances;
    }
    
    public static CourseInstance getCourseInstance(Long courseId, Connection connection) {
        CourseInstance courseInstance = null;
         try{
             
            PreparedStatement pstmt = connection.prepareStatement("select * from "+TABLE_NAME + " where crsinstance_id=?");
            pstmt.setLong(1, courseId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                CourseInstance cin = new CourseInstance();
                ORM(rs,cin);
                courseInstance = cin;
            }
        }
        catch(Exception x){
            x.printStackTrace();
        }
        return courseInstance;
    }
    
    public static void ORM(ResultSet rs, CourseInstance courseInstance) throws SQLException{
        courseInstance.setCourseId(rs.getLong(1));
         courseInstance.setCourseCode(rs.getString(2));
          courseInstance.setCourseName(rs.getString(3));
           courseInstance.setYear(rs.getDate(4));
           courseInstance.setSemester(rs.getString(5));
             courseInstance.setCourseInstanceName(rs.getString(6));
        
    }
    
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
    
    public void setSemester(String semester){
        setSemester(ApplicationData.getSemesterNumber(semester));
    }

    public String getCourseInstanceName() {
        return courseInstanceName;
    }

    public void setCourseInstanceName(String courseInstanceName) {
        this.courseInstanceName = courseInstanceName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CourseInstance other = (CourseInstance) obj;
        if (this.courseId != other.courseId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseInstance{" + "courseId=" + courseId + ", courseCode=" + courseCode + ", courseName=" + courseName + ", year=" + year + ", semester=" + semester + ", courseInstanceName=" + courseInstanceName + '}';
    }
    
    
}
