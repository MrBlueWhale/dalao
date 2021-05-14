package com.ibegu.dalao.domain;

public class Team {
    private Integer tid;

    private Integer contestId;

    private String teamName;

    private String uniName;

    private String uniAddr;

    private String zone;

    private String instructorName;

    private String instructorTel;

    private String instructorEmail;

    private String instructorProf;

    private String leaderTel;

    private String member1Tel;

    private String member2Tel;

    private String member3Tel;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getUniAddr() {
        return uniAddr;
    }

    public void setUniAddr(String uniAddr) {
        this.uniAddr = uniAddr;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorTel() {
        return instructorTel;
    }

    public void setInstructorTel(String instructorTel) {
        this.instructorTel = instructorTel;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public String getInstructorProf() {
        return instructorProf;
    }

    public void setInstructorProf(String instructorProf) {
        this.instructorProf = instructorProf;
    }

    public String getLeaderTel() {
        return leaderTel;
    }

    public void setLeaderTel(String leaderTel) {
        this.leaderTel = leaderTel;
    }

    public String getMember1Tel() {
        return member1Tel;
    }

    public void setMember1Tel(String member1Tel) {
        this.member1Tel = member1Tel;
    }

    public String getMember2Tel() {
        return member2Tel;
    }

    public void setMember2Tel(String member2Tel) {
        this.member2Tel = member2Tel;
    }

    public String getMember3Tel() {
        return member3Tel;
    }

    public void setMember3Tel(String member3Tel) {
        this.member3Tel = member3Tel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", contestId=").append(contestId);
        sb.append(", teamName=").append(teamName);
        sb.append(", uniName=").append(uniName);
        sb.append(", uniAddr=").append(uniAddr);
        sb.append(", zone=").append(zone);
        sb.append(", instructorName=").append(instructorName);
        sb.append(", instructorTel=").append(instructorTel);
        sb.append(", instructorEmail=").append(instructorEmail);
        sb.append(", instructorProf=").append(instructorProf);
        sb.append(", leaderTel=").append(leaderTel);
        sb.append(", member1Tel=").append(member1Tel);
        sb.append(", member2Tel=").append(member2Tel);
        sb.append(", member3Tel=").append(member3Tel);
        sb.append("]");
        return sb.toString();
    }
}