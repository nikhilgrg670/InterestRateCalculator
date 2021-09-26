# INTEREST RATE CALCULATOR

This Repository is the starting point. In this repository, there are following components:
1) Kafka Consumer --  This kafka consumer running which will be responsible for consuming the incoming daily feed. Consumer will do the following:

	a) It will first save the feed in Couchbase. Once it is successfully consumed, then it will 		acknowledge and move to next offset.
	b) After that it will call service to do furthur processing of the feed data.
	
2) Processing of feed data -- Feed Data will be processed as follows:

	a) Validation will be done. In case of failed validation, Status will be updated as failed along 		with failed reason.
	b) Account details like opening balance will be fetched through micro-service.
	c) Based on account details like balance, opening date interest rates will be fetched.
	d) Daily Interest Rate will be calculated.
	e) This will be updated in AccountBalanceDailyDetails table along with the status Completed.
	f) Also table AccountBalanceMonthlyDetails will be updated with tillNow interest.
	
3) Calculate Monthly Service --
	This service will be responsible to fetch monthly accrued data saved in AccountBalanceMonthlyDetails and then will publish the 	data using Kafka Producer services.
	
	
4) Kafka Producer --	
	This producer will be responsible for publishing the monthly data by Calculate Monthly Service.
	
5) End Points --
	There are two end points available
		a) One for placing a request to close an account -- This will fetch the details from AccountBalanceMonthlyDetails Table and 			will then publish the monthly interest amount before closing the account
		
		b) To consume daily feed through API request -- This is an additional implementation to consume 			the daily feed in form of API if required.


# ASSUMPTIONS:
1. In single message, List of employee will not be containing too much data. but there will be many messages containing such data.
2. All Kafka producer and Consumer configurations will be added. For now only place holders are created.

#NOTE:
1) We have also created end-points to consume these messages. Intention is that our service should be able to consume the daily feed either through Kafka or by a REST API CALL.

2) We are consuming another micro-service to get account details like opening date.


# FUTURE ENHANCEMENTS
1. Spring sleuth logging will be adding.
2. Splunk will be used.
3. Dyna Tracing or some tracing tool will be used.
4. Jenkins will be integrated.
5. Circuit Breaking pattern can be implemented.

