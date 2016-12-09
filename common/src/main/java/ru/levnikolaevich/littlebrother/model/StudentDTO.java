package ru.levnikolaevich.littlebrother.model;

import java.io.Serializable;
import java.util.List;

public class StudentDTO implements Serializable {
    private Integer id;
    private String fio;
    private boolean sex;
    private int groupId;
    private List<LectureDTO> lectures;
    private long version;

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

    public List<LectureDTO> getLectures() {
        return lectures;
    }

    public void setLectures(List<LectureDTO> lectures) {
        this.lectures = lectures;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
