package com.ibegu.dalao.resp;

public class AdminParticipantDetailQueryResp {
    private Long pid;

    private String nickname;

    // private String password;

    private String avatar;

    private String name;

    private String gender;

    private String university;

    private String college;

    private String major;

    private String grade;

    private String studentId;

    private String telNum;

    private String email;

    private String idNumber;

    private String joinDate;

    private Integer accountStatus;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", nickname=").append(nickname);
        // sb.append(", password=").append(password);
        sb.append(", avatar=").append(avatar);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", university=").append(university);
        sb.append(", college=").append(college);
        sb.append(", major=").append(major);
        sb.append(", grade=").append(grade);
        sb.append(", studentId=").append(studentId);
        sb.append(", telNum=").append(telNum);
        sb.append(", email=").append(email);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", joinDate=").append(joinDate);
        sb.append(", accountStatus=").append(accountStatus);
        sb.append("]");
        return sb.toString();
    }
}