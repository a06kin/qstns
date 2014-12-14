package me.aaa.qstns.service.qstn;

import me.aaa.qstns.domain.Qstn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QstnServiceImpl implements QstnService {

    @Autowired
    private QstnRepository qstnRepository;

    @Override
    public Qstn askQstn(String qstn, String country) {
        Qstn q = new Qstn();
        q.setQstn(qstn);
        q.setCountry(country);

        if (false){
            //check dictionary

        }
        qstnRepository.save(q);
        return q;
    }
}
