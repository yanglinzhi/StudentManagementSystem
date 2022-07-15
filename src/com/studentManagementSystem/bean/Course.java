package com.studentManagementSystem.bean;

/**
 * @author ylz
 * @date 2022/7/15 20:57
 */
public class Course {
    private Integer courseId;
    private String courseName;
    private String courseTeacherName;
    private Integer courseScore;

    public Course(Integer courseId, String courseName, String courseTeacherName, Integer courseScore) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTeacherName = courseTeacherName;
        this.courseScore = courseScore;
    }

    @Override
    public String toString() {
        return "course{" +
                "couresId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseTeacherName='" + courseTeacherName + '\'' +
                ", courseScore=" + courseScore +
                '}';
    }

    public Course(){}

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacherName() {
        return courseTeacherName;
    }

    public void setCourseTeacherName(String courseTeacherName) {
        this.courseTeacherName = courseTeacherName;
    }

    public Integer getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(Integer courseScore) {
        this.courseScore = courseScore;
    }
}
