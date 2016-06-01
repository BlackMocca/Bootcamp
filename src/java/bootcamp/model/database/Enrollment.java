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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oFNo's PC
 */
public class Enrollment {
    
    private long enrollmentId;
    private long courseInstanceId;
    private long studentId;
    private static final String TABLE_NAME = "enrollments";
    
    public static Enrollment getEnrollment(Long enrollmentId, Connection connection) {
        Enrollment enrollment = null;
        try {
            PreparedStatement ppstm = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE enrollment_id = ?");
            ppstm.setLong(1, enrollmentId);
            ResultSet rs = ppstm.executeQuery();
            while(rs.next()){
                enrollment = new Enrollment();
                ORM(rs, enrollment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return enrollment;
    }
    
    public static List<Enrollment> getEnrollment(Connection connection){
        List<Enrollment> enrollments = new ArrayList<>();
        try {
            PreparedStatement ppstm = connection.prepareStatement("SELECT * FROM " + TABLE_NAME);
            ResultSet rs = ppstm.executeQuery();
            while(rs.next()){
                Enrollment enrollment = new Enrollment();
                ORM(rs, enrollment);
                enrollments.add(enrollment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Enrollment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enrollments;
    }
    
    public static List<Enrollment> getEnrollmentByStudent(Long studentId, Connection con){
        List<Enrollment> result = new ArrayList<>();
        List<Enrollment> enrollments = getEnrollment(con);
        for (Iterator<Enrollment> iterator = enrollments.iterator(); iterator.hasNext();) {
            Enrollment next = iterator.next();
            if(next.getStudentId() == studentId){
                result.add(next);
            }
        }
        return result;
    }
    
    private static void ORM(ResultSet rs, Enrollment enrollment) throws SQLException{
        if(enrollment == null){
            enrollment = new Enrollment();
        }
        
        enrollment.setEnrollmentId(rs.getLong("enrollment_id"));
        enrollment.setCourseInstanceId(rs.getLong("crsinstance_id"));
        enrollment.setStudentId(rs.getLong("student_id"));
        
    }
    
    public long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public long getCourseInstanceId() {
        return courseInstanceId;
    }

    public void setCourseInstanceId(long courseInstanceId) {
        this.courseInstanceId = courseInstanceId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Enrollment other = (Enrollment) obj;
        if (this.enrollmentId != other.enrollmentId) {
            return false;
        }
        return true;
    }
    
    
}
