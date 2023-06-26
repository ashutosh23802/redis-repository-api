package tiaa.in.redisrepository.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import tiaa.in.redisrepository.model.Fund;
import tiaa.in.redisrepository.repository.FundRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class RedisServiceTest {

    @InjectMocks
    private RedisService redisService;

    @Mock
    private FundRepository fundRepository;

    @Test
    public void shouldSaveFundObject() {
        when(fundRepository.save(any())).thenReturn(getFundObject());
        Fund fund = redisService.saveFund(getFundObject());
        assertEquals("101",fund.getCusip());
    }

    @Test
    public void shouldGetundObject() {
        when(fundRepository.findById(any())).thenReturn(Optional.of(getFundObject()));
        Fund fund = redisService.getFundById("101");
        assertEquals("101",fund.getCusip());
    }

    @Test
    public void shouldUpdateFundObject() {
        when(fundRepository.save(any())).thenReturn(getFundObject());
        Fund fund = redisService.saveFund(getFundObject());
        assertEquals("101",fund.getCusip());
    }

    @Test
    public void shouldDeleteFundObject() {
        redisService.deleteFund("101");
        verify(fundRepository).deleteById("101");
    }

    private Fund getFundObject(){
        return new  Fund.Builder()
                .withCusip("101")
                .withReportingSeq(1000)
                .withCategoryFundSeq(1000)
                .withExternalTickerSymbol("MMMMM")
                .withName("Global Equity Bond")
                .withTickerSymbol("MMMMM")
                .build();
    }
}