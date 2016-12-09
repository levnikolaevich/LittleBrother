package ru.levnikolaevich.littlebrother.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.Calendar;

@Entity
@Table(name="lecture")
public class Lecture {
    @Id
    private long id;
    private Calendar dateStart;
    private String theme;

    @Version
    private long version;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "lectures")
//    private List<Student> students;

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public Calendar getDateStart() {
        return dateStart;
    }

    public void setDateStart(Calendar dateStart) {
        this.dateStart = dateStart;
    }


    public String getTheme() {
        return theme;
    }


    public void setTheme(String theme) {
        this.theme = theme;
    }
}
