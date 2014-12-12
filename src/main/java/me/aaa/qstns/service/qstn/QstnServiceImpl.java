package me.aaa.qstns.service.qstn;

import me.aaa.qstns.domain.Qstn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QstnServiceImpl implements QstnService {

    @Override
    public Qstn askQstn(String qstn, String country) {
        Qstn q = new Qstn();
        q.setQstn(qstn);
        q.setCountry(country);

        return q;
    }
}
