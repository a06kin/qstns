package me.aaa.qstns.rest;

import me.aaa.qstns.basis.enums.QstnStatus;
import me.aaa.qstns.basis.exceptions.QstnExceptions;
import me.aaa.qstns.domain.Qstn;
import me.aaa.qstns.service.cntr.CountryService;
import me.aaa.qstns.service.qstn.QstnRepository;
import me.aaa.qstns.service.qstn.QstnService;
import me.aaa.qstns.service.qstn.filter.QstnFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/qstn")
public class QstnRestService {

    @Autowired
    private QstnService qstnService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private QstnFilterService qstnFilterService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private QstnRepository qstnRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> askQstn(@RequestParam("question") String qstn,
                                               HttpServletRequest request) throws QstnExceptions{
                                               //TODO: throw exception
        final String ip = request.getRemoteAddr();
        String country = countryService.getCountryForClient(ip);
        Qstn q = qstnService.askQstn(qstn, country);
        qstnFilterService.validateQst(q);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Qstn> getAllQstn(HttpServletRequest request) {
        return qstnRepository.findByStatus(QstnStatus.OK);
    }

    @RequestMapping(value = "/country/{country}",method = RequestMethod.GET)
    public List<Qstn> getAllQstnByCountry(@PathVariable("country") String country, HttpServletRequest request) {
        return qstnRepository.findByCountry(country);
    }

}
