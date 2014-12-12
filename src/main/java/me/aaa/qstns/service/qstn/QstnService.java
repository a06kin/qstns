package me.aaa.qstns.service.qstn;

import me.aaa.qstns.domain.Qstn;

public interface QstnService {
    public Qstn askQstn(String qstn, String country);
}
