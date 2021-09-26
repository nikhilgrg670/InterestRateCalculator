package com.macquarie.niks.repo;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.macquarie.niks.model.AccountBalanceMonthlyDetails;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
@Repository
public interface AccountBalanceMonthlyDetailsRepository extends ReactiveCouchbaseRepository<AccountBalanceMonthlyDetails, Integer> {

    Mono<AccountBalanceMonthlyDetails> findById(final Integer id);
    
    @Query()
	Flux<AccountBalanceMonthlyDetails> findAccountByMonth(String month);
	
	@Query()
	Flux<AccountBalanceMonthlyDetails> findAccountByMonthAndStatus(String month, String Status);
    
    
}