package me.aaa.qstns.service.cntr;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private static final String LOCALHOST = "127.0.0.1";

    @Override
    public String getCountryForClient(String ip) {
        if (LOCALHOST.equals(ip)) return "lv";
        String url = "http://www.telize.com/geoip/" + ip;

        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(url);
        request.addHeader("accept", "application/json");

        String result;
        HttpResponse response;
        JSONObject json = null;

        try {
            response = client.execute(request);
            result = EntityUtils.toString(response.getEntity());

            json = new JSONObject(result);

            return json.getString("country_code");

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return "lv";
        }
    }
}
