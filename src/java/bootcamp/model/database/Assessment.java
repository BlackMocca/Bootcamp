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
public class Assessment {
    
    private static final String TABLE_NAME = "assessments";
    
    private Long assessmentId;
    private String name;
    private Double score;
    private Boolean visible;
    private Long courseInstanceId;
    
    public static List<Assessment> getAssessments(Long courseInstanceId, Connection connection){
            List<Assessment> assessmentsList = new ArrayList<Assessment>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("select * from "+TABLE_NAME +" where crsinstance_id=?" );
            pstmt.setLong(1, courseInstanceId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Assessment asm = new Assessment();
                ORM(rs,asm);
                assessmentsList.add(asm);
                System.out.println(asm);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(Assessment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assessmentsList;
    }
    
    private static void ORM(ResultSet rs, Assessment assessment) throws SQLException{
        assessment.setAssessmentId(rs.getLong(1));
        assessment.setName(rs.getString(2));
        assessment.setScore(rs.getDouble(3));
        assessment.setVisible(rs.getBoolean(4));
        assessment.setCourseInstanceId(rs.getLong(5));
       
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Assessment other = (Assessment) obj;
        if (this.assessmentId != other.assessmentId) {
            return false;
        }
        return true;
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Long getCourseInstanceId() {
        return courseInstanceId;
    }

    public void setCourseInstanceId(Long courseInstanceId) {
        this.courseInstanceId = courseInstanceId;
    }

    @Override
    public String toString() {
        return "Assessment{" + "assessmentId=" + assessmentId + ", name=" + name + ", score=" + score + ", visible=" + visible + ", courseInstanceId=" + courseInstanceId + '}';
    }
    
}
