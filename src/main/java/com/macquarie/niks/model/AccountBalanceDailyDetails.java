package com.macquarie.niks.model;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

import com.couchbase.client.java.repository.annotation.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This document will be created per Employee per day. 
 * 
 * This will contain information like closing balance on that day.
 * This will also save interest accrued for that day for that account.
 * 
 * This will be IN_PROGRESS status initially once document will be created as a first step
 * after receiving the feed from Kafka.
 * 
 * This will be in COMPLETED status once daily interest has been updated in the document.
 * 
 * This will be marked as FAILED for any of the failed reasons like account is not there.
 * or because of any validation failures.
 * 
 * This will be marked as MOVED once data is moved to some Big Data Database like HDFS.
 * 
 * @author abc
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(expiryExpression = "expiry.ttl", expiryUnit = TimeUnit.DAYS)
public class AccountBalanceDailyDetails extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3938055339178305114L;

	@IdPrefix(order = 0)
	private String prefix = "IRC_Daily";

	// NOTE: We are saving balance in String but we will be using BigDecimal for all
	// our calculations in respective methods
	@Field
	private String balance;

	@Field
	@IdAttribute(order = 2)
	private String year;

	@Field
	@IdAttribute(order = 3)
	private String month;

	@Field
	@IdAttribute(order = 4)
	private String day;

	@Field
	@IdAttribute(order = 0)
	private String bsb;

	@Field
	@IdAttribute(order = 1)
	private String identification;

	@Field
	private String interestAccruedToday;

	@Field
	@NotNull
	@Pattern(regexp = "IRC_DAILY_BALANCE")
	private String type;

	@Field
	private String status = "IN_PROGRESS";


	@Override
	public String toString() {
		return "AccountBalanceDailyDetails [prefix=" + prefix + ", balance=" + balance + ", year=" + year + ", month="
				+ month + ", day=" + day + ", bsb=" + bsb + ", identification=" + identification
				+ ", interestAccruedToday=" + interestAccruedToday + ", type=" + type + "]";
	}

}
