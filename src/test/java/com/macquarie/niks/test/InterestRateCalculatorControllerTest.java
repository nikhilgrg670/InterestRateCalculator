package com.macquarie.niks.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.macquarie.niks.dto.CloseAccountRequestDTO;

public class InterestRateCalculatorControllerTest extends AbstractTest {

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void findValidAccountForClosure() throws Exception {

		String uri = "/everyday-banking/v1/closeAccount";

		CloseAccountRequestDTO closeAccountRequestDTO = new CloseAccountRequestDTO();
		closeAccountRequestDTO.setBsb("182182");
		closeAccountRequestDTO.setIdentification("111222333");

		String inputJson = super.mapToJson(closeAccountRequestDTO);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void findInvalidValidAccountForClosure() throws Exception {

		String uri = "/everyday-banking/v1/closeAccount";

		CloseAccountRequestDTO closeAccountRequestDTO = new CloseAccountRequestDTO();
		closeAccountRequestDTO.setBsb("182181");
		closeAccountRequestDTO.setIdentification("111222334");

		String inputJson = super.mapToJson(closeAccountRequestDTO);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status);

	}

}
