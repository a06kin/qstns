package me.aaa.qstns.service.qstn.filter;

import me.aaa.qstns.basis.enums.QstnStatus;
import me.aaa.qstns.basis.exceptions.QstnExceptions;
import me.aaa.qstns.basis.settings.QstnSettings;
import me.aaa.qstns.domain.Qstn;
import me.aaa.qstns.service.qstn.QstnRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QstnFilterServiceImpl implements QstnFilterService {

    @Autowired
    private QstnSettings qstnSettings;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private QstnRepository qstnRepository;

    @Override
    public Qstn validateQst(Qstn qstn) throws QstnExceptions {
        for (String word: qstnSettings.getBadWords()){
            if (StringUtils.containsIgnoreCase(qstn.getData(), word)){
                qstn.setStatus(QstnStatus.CONTAINS_ILLEGAL_WORDS);
                qstnRepository.save(qstn);
                throw new QstnExceptions(QstnStatus.CONTAINS_ILLEGAL_WORDS, "Question contains blacklisted words");
            }else{
                qstn.setStatus(QstnStatus.OK);
                qstnRepository.save(qstn);
            }
        }
        return qstn;
    }
}
