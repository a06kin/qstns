package me.aaa.qstns.service.qstn;

import me.aaa.qstns.domain.Qstn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QstnServiceImplTest {

    private static final String COUNTRY = "lv";

    @Mock
    private QstnRepository qstnRepository;

    @InjectMocks
    private QstnServiceImpl qstnService;

    @Test
    public void testAskQstn(){
        Qstn q = mock(Qstn.class);
        when(qstnRepository.save(q)).thenReturn(q);
        qstnService.askQstn(any(String.class), COUNTRY);
        verify(qstnRepository, times(1)).save(any(Qstn.class));
    }

}
