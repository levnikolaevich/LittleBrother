package ru.levnikolaevich.littlebrother.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="student")
public class Student {
    @Id
    private Integer id;
    private String fio;
    private boolean sex;
    private int groupId;

    @Version
    private long version;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name="student_lecture",
//            joinColumns=@JoinColumn(name="student_id", referencedColumnName="id"),
//            inverseJoinColumns=@JoinColumn(name="lecture_id", referencedColumnName="id"))
//    private List<Lecture> lectures;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }


    public void setFio(String fio) {
        this.fio = fio;
    }


    public boolean isSex() {
        return sex;
    }


    public void setSex(boolean sex) {
        this.sex = sex;
    }


    public int getGroup() {
        return groupId;
    }


    public void setGroup(int group) {
        this.groupId = group;
    }


    public String getSex() {
        return sex ? "Муж" : "Жен";
    }

//    public List<Lecture> getLectures() {
//        return lectures;
//    }
//
//    public void setLectures(List<Lecture> lectures) {
//        this.lectures = lectures;
//    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
