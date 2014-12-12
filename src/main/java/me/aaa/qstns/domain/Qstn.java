package me.aaa.qstns.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Qstn implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String qstn;

    @NotNull
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQstn() {
        return qstn;
    }

    public void setQstn(String qstn) {
        this.qstn = qstn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
