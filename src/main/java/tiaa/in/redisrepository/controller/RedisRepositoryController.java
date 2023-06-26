package tiaa.in.redisrepository.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiaa.in.redisrepository.model.Fund;
import tiaa.in.redisrepository.service.RedisService;

@RestController
public class RedisRepositoryController {

    @Autowired
    RedisService redisService;

    @PostMapping("/fund")
    public ResponseEntity<Fund> addFund(@RequestBody Fund fund){
        return new ResponseEntity<>(redisService.saveFund(fund), HttpStatus.CREATED);
    }

    @GetMapping("/fund/{id}")
    public ResponseEntity<Fund> addFund(@PathVariable String id){
        return new ResponseEntity<>(redisService.getFundById(id), HttpStatus.OK);
    }

    @PutMapping("/fund")
    public ResponseEntity<Fund> updateFund(@RequestBody Fund fund){
        return new ResponseEntity<>(redisService.saveFund(fund), HttpStatus.OK);
    }

    @DeleteMapping("/fund/{id}")
    public ResponseEntity<Object> deleteFund(@PathVariable String id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
