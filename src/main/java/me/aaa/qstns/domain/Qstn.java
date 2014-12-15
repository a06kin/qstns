package me.aaa.qstns.domain;

import me.aaa.qstns.basis.enums.QstnStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Qstn implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String data;

    @NotNull
    private String country;

    private QstnStatus status = QstnStatus.NOT_PROCESSED;

    public QstnStatus getStatus() {
        return status;
    }

    public void setStatus(QstnStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQstn() {
        return data;
    }

    public void setQstn(String data) {
        this.data = data;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
