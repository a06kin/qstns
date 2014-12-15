package me.aaa.qstns.basis.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
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
    private BigDecimal timeframeLimit;

    public String getDefaultCountry() {
        return this.defaultCountry;
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

    public BigDecimal getTimeframeLimit() {
        return timeframeLimit;
    }

    public void setTimeframeLimit(BigDecimal timeframeLimit) {
        this.timeframeLimit = timeframeLimit;
    }
}
