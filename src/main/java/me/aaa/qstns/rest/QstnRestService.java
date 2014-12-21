package me.aaa.qstns.rest;

import me.aaa.qstns.basis.enums.QstnStatus;
import me.aaa.qstns.basis.exceptions.QstnExceptions;
import me.aaa.qstns.basis.settings.QstnSettings;
import me.aaa.qstns.domain.Qstn;
import me.aaa.qstns.service.cntr.CountryService;
import me.aaa.qstns.service.cntr.filter.CountryFilterService;
import me.aaa.qstns.service.qstn.QstnRepository;
import me.aaa.qstns.service.qstn.QstnService;
import me.aaa.qstns.service.qstn.filter.QstnFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/qstn")
public class QstnRestService {

    public static final int ONE_SECOND_IN_MILLISECONDS = 1000;

    @Autowired
    private QstnService qstnService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private QstnFilterService qstnFilterService;

    @Autowired
    private CountryFilterService countryFilterService;

    @Autowired
    private QstnSettings qstnSettings;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private QstnRepository qstnRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> askQstn(@RequestParam("question") String qstn,
                                          HttpServletRequest request) throws QstnExceptions, IOException {
        final String ip = request.getRemoteAddr();
        String country = countryService.getCountryForClient(ip);
        long from = new Date().getTime() - (qstnSettings.getInTimeLimit().longValue() * ONE_SECOND_IN_MILLISECONDS);
        countryFilterService.checkTimeLimit(new Time(from), qstnSettings.getReqLimit(), country);

        Qstn q = qstnService.askQstn(qstn, country);
        qstnFilterService.validateQst(q);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Qstn> getAllQstn() {
        return qstnRepository.findByStatus(QstnStatus.OK);
    }

    @RequestMapping(value = "/country/{country}", method = RequestMethod.GET)
    public List<Qstn> getAllQstnByCountry(@PathVariable("country") String country) {
        return qstnRepository.findByCountryAndStatus(country, QstnStatus.OK);
    }

}
