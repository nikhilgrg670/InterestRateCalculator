package com.macquarie.niks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.macquarie.niks.dto.CloseAccountRequestDTO;
import com.macquarie.niks.dto.InterestRateCalculatorRequestDTO;
import com.macquarie.niks.service.manager.InterestRateCalculatorServiceManager;
 
@RestController
@RequestMapping("/everyday-banking/v1")

/**
 * This class will have all end points which will be invoked by API Consumers. 
 * Details of these endpoint is explained below:
 * @author abc
 *
 */
public class InterestRateCalculatorController {
    @Autowired
    private InterestRateCalculatorServiceManager interestRateCalculatorService;
 

    /**
     * This end point will be used to save the daily feeds including calculation of daily interest for an account
     * based on other details like opening balance date etc.
     * Status code 
     * 200 ok
     * 500 for any error
     * 400 for bad requests  
     * @param interestRateCalculatorDTO
     */
    @RequestMapping(value = "/dailyFeed", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveDailyFeed(@RequestBody InterestRateCalculatorRequestDTO interestRateCalculatorDTO) {
    	interestRateCalculatorService.processDailyFeeds(interestRateCalculatorDTO);
    }

    /**
     * This endpoint will be used to close an account, before closing the account we 
     * will fetch the interest accrued till now and publish it to save it in users  account.
     * * Status code 
     * 200 ok
     * 500 for any error
     * 400 for bad requests
     * @param closeAccountRequestDTO
     */
    @RequestMapping(value = "/closeAccount", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void closeAccount(@RequestBody CloseAccountRequestDTO closeAccountRequestDTO) {
    	interestRateCalculatorService.closeAccount(closeAccountRequestDTO.getBsb(), closeAccountRequestDTO.getIdentification());
    	
    }
 
}
