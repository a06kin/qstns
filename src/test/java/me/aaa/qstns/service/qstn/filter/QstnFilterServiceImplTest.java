package me.aaa.qstns.service.qstn.filter;

import me.aaa.qstns.basis.exceptions.QstnExceptions;
import me.aaa.qstns.basis.settings.QstnSettings;
import me.aaa.qstns.domain.Qstn;
import me.aaa.qstns.service.qstn.QstnRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QstnFilterServiceImplTest {

    private static final String BAD_QSTN = "Is dat bad test Q?";
    private static final String NORMAL_QSTN = "You shall not pass?";

    @Mock
    private QstnSettings qstnSettings;

    @Mock
    private QstnRepository qstnRepository;

    @InjectMocks
    private QstnFilterServiceImpl qstnFilterService;

    @Before
    public void setUp(){
        when(qstnSettings.getBadWords()).thenReturn(Arrays.asList("test", "test2"));
    }

    @Test(expected = QstnExceptions.class)
    public void testValidateBadQst() throws QstnExceptions {
        Qstn q = mock(Qstn.class);
        when(q.getData()).thenReturn(BAD_QSTN);
        qstnFilterService.validateQst(q);
    }

    @Test
    public void testValidateNormalQst() throws QstnExceptions {
        Qstn q = mock(Qstn.class);
        when(q.getData()).thenReturn(NORMAL_QSTN);
        qstnFilterService.validateQst(q);
    }


}
