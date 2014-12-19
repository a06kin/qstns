package me.aaa.qstns.rest.service.cntr.filter;

import me.aaa.qstns.basis.exceptions.QstnExceptions;
import me.aaa.qstns.service.cntr.filter.CountryFilterServiceImpl;
import me.aaa.qstns.service.qstn.QstnRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Time;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CountryFilterServiceImplTest {

    private static final Integer LIMIT = 2;
    private static final Integer MORE_THAN_LIMIT = 3;
    private static final Integer NORMAL_QSTN_COUNT = 1;

    @Mock
    private QstnRepository qstnRepository;

    @InjectMocks
    private CountryFilterServiceImpl countryFilterService;

    @Test(expected = QstnExceptions.class)
    public void checkTimeLimitFault() throws QstnExceptions {
        String country = "lv";
        Time now = new Time(new Date().getTime());
        when(qstnRepository.countByTimerameAndCountry(any(Time.class), eq(country))).thenReturn(MORE_THAN_LIMIT);
        countryFilterService.checkTimeLimit(now, LIMIT, country);
        verify(qstnRepository, times(1)).countByTimerameAndCountry(any(Time.class), eq(country));
    }

    @Test
    public void checkTimeLimit() throws QstnExceptions {
        String country = "lv";
        Time now = new Time(new Date().getTime());
        when(qstnRepository.countByTimerameAndCountry(any(Time.class), eq(country))).thenReturn(NORMAL_QSTN_COUNT);
        boolean result = countryFilterService.checkTimeLimit(now, LIMIT, country);
        verify(qstnRepository, times(1)).countByTimerameAndCountry(any(Time.class), eq(country));
        assertEquals(true, result);
    }

}
