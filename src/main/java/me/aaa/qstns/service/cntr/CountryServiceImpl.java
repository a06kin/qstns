package me.aaa.qstns.service.cntr;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    @Override
    public String getCountryForClient(String ip) {
        return "lv"; //TODO: implement http://www.telize.com service
    }
}
