package me.aaa.qstns.service.cntr;

import me.aaa.qstns.basis.settings.QstnSettings;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private static final Logger LOGGER = Logger.getLogger(CountryService.class);

    @Autowired
    private QstnSettings qstnSettings;

    @Override
    public String getCountryForClient(String ip){
        String url = "http://www.telize.com/geoip/" + ip;

        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(url);
        request.addHeader("accept", "application/json");

        String result;
        HttpResponse response;
        JSONObject json;

        try {
            response = client.execute(request);
            result = EntityUtils.toString(response.getEntity());

            json = new JSONObject(result);

            if (json.has("country_code")){
                return json.getString("country_code");
            }else{
                return qstnSettings.getDefaultCountry();
            }

        } catch (IOException e) {
            LOGGER.debug(e);
            return qstnSettings.getDefaultCountry();
        }
    }
}
