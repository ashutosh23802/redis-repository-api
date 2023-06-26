package tiaa.in.redisrepository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiaa.in.redisrepository.model.Fund;
import tiaa.in.redisrepository.repository.FundRepository;

@Service
public class RedisService {

    @Autowired
    private FundRepository fundRepository;
    public Fund saveFund(Fund fund) {
        return fundRepository.save(fund);
    }

    public Fund getFundById(String id) {
        return fundRepository.findById(id).get();
    }

    public void deleteFund(String id) {
         fundRepository.deleteById(id);
    }
}
