package com.macquarie.niks.repo;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.macquarie.niks.model.AccountBalanceDailyDetails;
import com.macquarie.niks.model.AccountBalanceMonthlyDetails;
import com.macquarie.niks.model.Entity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
@Repository
public interface AccountBalanceDailyDetailsRepository extends ReactiveCouchbaseRepository<AccountBalanceDailyDetails, Integer> {

    Mono<AccountBalanceDailyDetails> findById(final long id);
	
	Flux<AccountBalanceDailyDetails> update(final long id);
	
	@Query()
	Flux<AccountBalanceDailyDetails> findAccountByMonth(String month);
	
	@Query()
	Flux<AccountBalanceDailyDetails> findAccountByMonthAndStatus(String month, String Status);

	Flux<AccountBalanceDailyDetails> saveAll(List<Entity> dailyAccountDetailsList);
    
}