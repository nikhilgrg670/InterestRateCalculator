package com.macquarie.niks.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;
import org.springframework.data.mongodb.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class is an entity for saving monthly interest accrued for a specific
 * account. Primary ID will be combination of identification, bsb, year and
 * Month.
 * 
 * This document will be created to save daily accrued interest amount.
 * 
 * This document will be in IN_PROGRESS once document is created.
 * 
 * This document status will be marked COMPLETED once last day of month has been
 * passed.
 * 
 * This document will be used by our monthly calculator service to return the
 * monthly interest of a customer. Also this can be used as history for our
 * monthly interest rate certificates
 * 
 * @author abc
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class AccountBalanceMonthlyDetails extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7748856401126024819L;

	@IdPrefix(order = 0)
	private String prefix = "IRC";

	@Field
	@IdAttribute(order = 1)
	long identification;

	@Field
	@IdAttribute(order = 0)
	String bsb;

	@Field
	@IdAttribute(order = 2)
	private String year;

	@Field
	@IdAttribute(order = 3)
	private String month;

	@Field
	private String monthlyInterestRate;

	@Field
	@NotNull
	@Pattern(regexp = "IRC_ACCOUNT_MONTHLY")
	private String type;

	@Field
	private String status = "IN_PROGRESS";

	@Override
	public String toString() {
		return "AccountBalanceMonthlyDetails [prefix=" + prefix + ", identification=" + identification + ", bsb=" + bsb
				+ ", year=" + year + ", month=" + month + ", monthlyInterestRate=" + monthlyInterestRate + ", type="
				+ type + "]";
	}

}
