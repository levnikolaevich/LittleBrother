package ru.levnikolaevich.littlebrother.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class LectureDTO implements Serializable {
    private long id;
    private Calendar dateStart;
    private String theme;
    private long version;

    private List<StudentDTO> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDateStart()
    {
        return this.dateStart;
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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
