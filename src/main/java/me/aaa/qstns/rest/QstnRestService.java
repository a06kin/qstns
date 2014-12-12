package me.aaa.qstns.rest;

import me.aaa.qstns.service.cntr.CountryService;
import me.aaa.qstns.service.qstn.QstnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/qstn")
public class QstnRestService {

    @Autowired
    private QstnService qstnService;

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> askQstn(@RequestParam("question") String qstn,
                                               HttpServletRequest request) { //TODO: throw exception
        final String ip = request.getRemoteAddr();
        String country = countryService.getCountryForClient(ip);
        qstnService.askQstn(qstn, country);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
