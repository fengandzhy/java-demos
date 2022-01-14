package org.zhouhy.java.domain;

public class Person {
    private int age;
    private String name;
    public long id;
    public long grade;
    protected float score;
    protected int rank;

    public Person(int age, String name, long id, long grade, float score, int rank) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.score = score;
        this.rank = rank;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("age=").append(age);
        sb.append(", name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", grade=").append(grade);
        sb.append(", score=").append(score);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }
}
