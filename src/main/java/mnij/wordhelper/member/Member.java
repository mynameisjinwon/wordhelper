package mnij.wordhelper.member;

import mnij.wordhelper.grade.Grade;

public class Member {
    private String memberId;
    private String name;
    private String password;
    private Grade grade;

    public Member(String memberId, String name, String password, Grade grade) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.grade = grade;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                '}';
    }
}
