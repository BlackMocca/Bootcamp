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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oFNo's PC
 */
public class Score {

    private Long scoreId;
    private Long studentId;
    private Long assessmentId;
    private Double score;
    private String grade;
    private Date last_upadate;
    private static final String TABLE_NAME = "scores";
    
    public static List<Score> getScoreByStudentId(Long studentId, Connection connection){
        List<Score> scoreList = new ArrayList<Score>();
        try{
            PreparedStatement pstmt = connection.prepareStatement("select * from "+TABLE_NAME+ " where student_id=?");
            pstmt.setLong(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Score sc = new Score();
                ORM(rs,sc);
                scoreList.add(sc);
                        System.out.println("Score " + sc);
            }
        }
        catch(Exception x){
            x.printStackTrace();
        }
        return scoreList;
    }

    private static void ORM(ResultSet rs, Score score) throws SQLException {
        score.setScoreId(rs.getLong(1));
        score.setStudentId(rs.getLong(2));
        score.setAssessmentId(rs.getLong(3));
        score.setScore(rs.getDouble(4));
        score.setGrade(rs.getString(5));
        score.setLast_upadate(rs.getDate(6));
        
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
        final Score other = (Score) obj;
        if (!Objects.equals(this.scoreId, other.scoreId)) {
            return false;
        }
        return true;
    }

    public Date getLast_upadate() {
        return last_upadate;
    }

    public void setLast_upadate(Date last_upadate) {
        this.last_upadate = last_upadate;
    }

    @Override
    public String toString() {
        return "Score{" + "scoreId=" + scoreId + ", studentId=" + studentId + ", assessmentId=" + assessmentId + ", score=" + score + ", grade=" + grade + ", last_upadate=" + last_upadate + '}';
    }

}
