package me.aaa.qstns.service.qstn.filter;

import me.aaa.qstns.basis.exceptions.QstnExceptions;
import me.aaa.qstns.domain.Qstn;

/**
 * Created by aaa on 14/12/14.
 */
public interface QstnFilterService {
    Qstn validateQst(Qstn qstn) throws QstnExceptions;
}
