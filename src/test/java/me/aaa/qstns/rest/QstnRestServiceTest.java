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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QstnRestServiceTest {

    private static final String IP = "8.8.8.8";
    private static final String COUNTRY = "lv";
    private static final int REQ_LIM = 1;
    private static final int TIME_LIM = 1;

    @Mock
    private HttpServletRequest request;

    @Mock
    private CountryService countryService;

    @Mock
    private CountryFilterService countryFilterService;

    @Mock
    private QstnService qstnService;

    @Mock
    private QstnSettings qstnSettings;

    @Mock
    private QstnFilterService qstnFilterService;

    @Mock
    private QstnRepository qstnRepository;

    @InjectMocks
    private QstnRestService qstnRestService;

    @Before
    public void setUp() {
        when(request.getRemoteAddr()).thenReturn(IP);
        when(qstnSettings.getInTimeLimit()).thenReturn(TIME_LIM);
        when(qstnSettings.getReqLimit()).thenReturn(REQ_LIM);
    }

    @Test
    public void testAskQstn() throws QstnExceptions {
        String qstn = "Wazzaaaaap?";
        when(countryService.getCountryForClient(IP)).thenReturn(COUNTRY);
        ResponseEntity<String> result = qstnRestService.askQstn(qstn, request);
        verify(countryService, times(1)).getCountryForClient(IP);
        verify(countryFilterService, times(1)).checkTimeLimit(any(Time.class), eq(REQ_LIM), eq(COUNTRY));
        verify(qstnService, times(1)).askQstn(any(String.class), any(String.class));
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testGetAllQstn(){
        Qstn qs = mock(Qstn.class);
        List<Qstn> qstns = Arrays.asList(qs, qs, qs);
        when(qstnRepository.findByStatus(QstnStatus.OK)).thenReturn(qstns);
        List<Qstn> actualQstns = qstnRestService.getAllQstn();
        verify(qstnRepository, times(1)).findByStatus(QstnStatus.OK);
        assertEquals(qstns, actualQstns);
    }

    @Test
    public void tesGetAllQstnByCountry(){
        String country = "lv";
        Qstn qs = mock(Qstn.class);
        List<Qstn> qstns = Arrays.asList(qs, qs, qs);
        when(qstnRepository.findByCountryAndStatus(country, QstnStatus.OK)).thenReturn(qstns);
        List<Qstn> actualQstns = qstnRestService.getAllQstnByCountry(country);
        verify(qstnRepository, times(1)).findByCountryAndStatus(country, QstnStatus.OK);
        assertEquals(qstns, actualQstns);
    }

}
