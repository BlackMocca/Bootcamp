/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.model.utility;

import bootcamp.model.database.CourseInstance;
import static bootcamp.model.database.CourseInstance.ORM;
import bootcamp.model.database.Enrollment;
import bootcamp.model.database.Student;
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
 * @author Huag
 */
public class S {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    

            Connection con = ConnectionBuilder.getConnection();
    List<CourseInstance> enrollments = new ArrayList<CourseInstance>();
       List<CourseInstance> courseInstances = new ArrayList<CourseInstance>();
        //Hint : This method connect with database.
          try{
            PreparedStatement pstmt = con.prepareStatement("select * from course_instances ");
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                CourseInstance cin = new CourseInstance();
                ORM(rs,cin);
                System.out.println(cin);
            }
        }
        catch(Exception x){
            x.printStackTrace();
        }
        
    }
    private static void ORM(ResultSet rs, CourseInstance enrollment) throws SQLException{
        enrollment.setSemester(rs.getString("semester"));
        enrollment.setYear(rs.getDate("academic_year"));
        enrollment.setCourseCode(rs.getString(2));
        enrollment.setCourseId(rs.getLong(1));
       
    }
    
}
