package me.aaa.qstns.domain;

import me.aaa.qstns.basis.enums.QstnStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Qstn implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String data;

    @NotNull
    private String country;

    @NotNull
    private Timestamp time;

    @NotNull
    private QstnStatus status = QstnStatus.NOT_PROCESSED;

    @PrePersist
    @PreUpdate
    protected void lastTouch() {
        time = new Timestamp(new Date().getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public QstnStatus getStatus() {
        return status;
    }

    public void setStatus(QstnStatus status) {
        this.status = status;
    }
}
