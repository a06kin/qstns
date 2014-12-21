package me.aaa.qstns.service.cntr;

import java.io.IOException;

public interface CountryService {
    String getCountryForClient(String ip) throws IOException;
}
