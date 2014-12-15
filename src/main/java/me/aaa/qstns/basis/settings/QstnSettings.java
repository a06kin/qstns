package me.aaa.qstns.basis.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "qstns")
public class QstnSettings {

    @NotNull
    private String defaultCountry;

    @NotNull
    private List<String> badWords;

    @NotNull
    private Integer inTimeLimit;

    @NotNull
    private Integer reqLimit;

    public String getDefaultCountry() {
        return defaultCountry;
    }

    public void setDefaultCountry(String defaultCountry) {
        this.defaultCountry = defaultCountry;
    }

    public List<String> getBadWords() {
        return badWords;
    }

    public void setBadWords(List<String> badWords) {
        this.badWords = badWords;
    }

    public Integer getInTimeLimit() {
        return inTimeLimit;
    }

    public void setInTimeLimit(Integer inTimeLimit) {
        this.inTimeLimit = inTimeLimit;
    }

    public Integer getReqLimit() {
        return reqLimit;
    }

    public void setReqLimit(Integer reqLimit) {
        this.reqLimit = reqLimit;
    }
}
