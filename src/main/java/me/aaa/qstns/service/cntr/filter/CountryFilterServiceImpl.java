package me.aaa.qstns.service.cntr.filter;

import me.aaa.qstns.basis.enums.QstnStatus;
import me.aaa.qstns.basis.exceptions.QstnExceptions;
import me.aaa.qstns.service.qstn.QstnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;

@Service
@Transactional
public class CountryFilterServiceImpl implements CountryFilterService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private QstnRepository qstnRepository;

    @Override
    public boolean checkTimeLimit(Time fromTime, Integer count, String country) throws QstnExceptions {
        if (qstnRepository.countByTimerameAndCountry(fromTime, country) >= count){
            throw new QstnExceptions(QstnStatus.REACHED_MAX_QSTN_LIMIT, "Too many requests from your country");
        }
        return true;
    }

}
