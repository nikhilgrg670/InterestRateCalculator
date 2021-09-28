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

	This service will be responsible to fetch monthly accrued data saved in 	AccountBalanceMonthlyDetails and then will publish the data using Kafka Producer services.
	Service name is MonthlyInterestRateCalculateService
	
	
4) Kafka Producer --
	
	This producer will be responsible for publishing the monthly data by Calculate Monthly Service.
	
5) End Points --
	There are two end points available
	
		a) One for placing a request to close an account -- This will fetch the details from 			AccountBalanceMonthlyDetails Table and will then publish the monthly interest amount 			before closing the account
		
		b) To consume daily feed through API request -- This is an additional implementation to consume 			the daily feed in form of API if required.

# DATA MODELS
	There are three couchbase documents in our application.
	a) AccountBalanceDailyDetails -- This document will save the daily feed to each employee.
		Intial stauts would be IN_PROGRESS. It will be changed to COMPLETED once daily interest is 		calculated.
	b) AccountBalanceMonthlyDetails -- This document will save the monthly daily interest accrued till 		now. Every time daily interest is calculated, this document is updated with current interest 		value + daily interest calculated.
	
	 eg. Assume :Today is Sep 25,2021.
	 	  Assume :Today interest calculated for a customer is 283.4
	 	  Assume :Total interest calculated till now(till Sep 24,2021) for a customer 1200
	     AccountBalanceMonthlyDetail will be updated as 1200+283.4.
	     
	    Intial status for this document would be IN_PROGRESS. Once updation for last day of month
	    is completed. This is changed to completed.
	    This table will be used to publish monthly interest of a customer.
	    Also, this table will be used to calculate interest for a closure request account.

# ASSUMPTIONS:

	1. In single message, List of employee will not be containing too much data. but there will be 		many messages containing such data.
	2. All Kafka producer and Consumer configurations will be added. For now only place holders are 		created.
	3. At few places, properties are used directly in classed but not defined in 		application.properties.
	4. Till now constant package is empty, but constants related to logging and other requirements will 		be added.
	5. It is assumption that all documents related to account daily records will be moved to some Big 		Data like HDFS or Hbase.
	6. Lambok jar is inclued in IDE to get getters setters.

# HIGHLIGHT
 	
 	1. To fetch monthly accrued interest, we are running a scheduled job which will run at 12:00 AM of every first day of month.
 	   But this will fetch the details for previous month. By this we can avoid nuances related to number of days of every month 		like July(31), June(30) and Feb(28) 

#NOTE:

	1) We have also created end-points to consume these messages. Intention is that our service should 		be able to consume the daily feed either through Kafka or by a REST API CALL.

	2) We are consuming another micro-service to get account details like opening date.

# EXCEPTION HANDLING

	1) If there is any exception while doing processing in our application after document is saved, all 		such exceptions will be logged and status of the document will be updated accordingly alongwith 		reason.

	2) For all exceptions while consuming the data, dead letter queue will be used.

	3) Retry mechanism with ExponentialBackOff algorithm will be used for all couchbase call with 		temporary failures.

	4) For all methods related to kakfa producer, retry will be there. After retry if the exception is 		still there, these failures will be saved in couchbase document alongwith failed reasons.

	5) For all such failures where couchbase is down and we are not able to save the document/ update 		the document. Following will happen
		 > We will retry to save such details.
		 > If there is no success for above step, we will save such failures in a File.


# FUTURE ENHANCEMENTS
	
	1. Spring sleuth logging will be adding.
	2. Splunk will be used.
	3. Dyna Tracing or some tracing tool will be used.
	4. Jenkins will be integrated.
	5. Circuit Breaking pattern can be implemented.
	6. For code quality, SonarCube can be added.
	7. Error Handling Framework will be developed to automatically retrigger the journey from its 		failure points.

# JUNIT TEST

	Because of shortage of time, few of Junits are added, for rest of them all the test scenarios are 	added in resources folder as Test_Cases_1 and Test_Cases_2.
	
	

# TODO:

	> Add Integration test cases.
	> Isolate Unit Test and Integration Testing.
	> Add Code Coverage, we can use a tool like EclEmma.
