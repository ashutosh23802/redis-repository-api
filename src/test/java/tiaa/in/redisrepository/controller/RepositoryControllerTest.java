package tiaa.in.redisrepository.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import tiaa.in.redisrepository.model.Fund;
import tiaa.in.redisrepository.service.RedisService;
import tiaa.in.redisrepository.util.JsonUtil;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class RepositoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private RedisService redisService;

    @Test
    public void shouldSaveFundObject() throws Exception {
        when(redisService.saveFund(any())).thenReturn(getFundObject());

        mockMvc.perform(post("/fund")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(getFundObject())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cusip").value("101"));
    }

    @Test
    public void shouldGetFundObject() throws Exception {
        when(redisService.getFundById(any())).thenReturn(getFundObject());

        mockMvc.perform(get("/fund/101"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cusip").value("101"));
    }

    @Test
    public void shouldUpdateFundObject() throws Exception {
        when(redisService.saveFund(any())).thenReturn(getFundObject());

        mockMvc.perform(put("/fund")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(getFundObject())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cusip").value("101"));
    }

    @Test
    public void shouldDeleteFundObject() throws Exception {
        mockMvc.perform(delete("/fund/101"))
                .andExpect(status().isOk());
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
