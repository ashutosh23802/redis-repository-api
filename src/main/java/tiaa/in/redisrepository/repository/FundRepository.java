package tiaa.in.redisrepository.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tiaa.in.redisrepository.model.Fund;

@Repository
public interface FundRepository extends CrudRepository<Fund,String> {

}
