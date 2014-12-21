package me.aaa.qstns.service.cntr;

import me.aaa.qstns.basis.settings.QstnSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {

    private static final String NORMAL_IP = "8.8.8.8";
    private static final String BAD_IP = "9.9.9.9.9.9";
    private static final String COUNTRY = "lv";

    @Mock
    private QstnSettings qstnSettings;

    @InjectMocks
    private CountryServiceImpl countryService;

    @Test
    public void testGetCountryForClientNormal(){
        String country = "US";
        String actualCountry = countryService.getCountryForClient(NORMAL_IP);
        assertEquals(country, actualCountry);
    }

    @Test()
    public void testGetCountryForClientBad(){
        when(qstnSettings.getDefaultCountry()).thenReturn(COUNTRY);
        String actualCountry = countryService.getCountryForClient(BAD_IP);
        assertEquals(COUNTRY, actualCountry);
    }
}
