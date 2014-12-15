package me.aaa.qstns.service.cntr.filter;


import me.aaa.qstns.basis.exceptions.QstnExceptions;

import java.sql.Time;

public interface CountryFilterService {
    void checkTimeLimit(Time from, Integer count, String country) throws QstnExceptions;
}
