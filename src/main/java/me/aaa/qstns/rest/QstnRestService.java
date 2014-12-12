package me.aaa.qstns.rest;

import me.aaa.qstns.domain.Qstn;
import me.aaa.qstns.service.cntr.CountryService;
import me.aaa.qstns.service.qstn.QstnRepository;
import me.aaa.qstns.service.qstn.QstnService;
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
    private QstnRepository qstnRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> askQstn(@RequestParam("question") String qstn,
                                               HttpServletRequest request) { //TODO: throw exception
        final String ip = request.getRemoteAddr();
        String country = countryService.getCountryForClient(ip);
        qstnService.askQstn(qstn, country);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Qstn> getAllQstnByCountry(HttpServletRequest request) {
        System.out.println("find all ");
        System.out.println(qstnRepository.findAll());
        return qstnRepository.findAll();
    }

    @RequestMapping(value = "/country/{country}",method = RequestMethod.GET)
    public List<Qstn> getAllQstn(@PathVariable("country") String country, HttpServletRequest request) {
        return qstnRepository.findByCountry(country);
    }

}
