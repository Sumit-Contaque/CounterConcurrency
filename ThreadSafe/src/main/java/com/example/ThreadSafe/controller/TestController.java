package com.example.ThreadSafe.controller;

import com.example.ThreadSafe.Beans.CounterResponse;
import com.example.ThreadSafe.service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	 
	@Autowired
	IdGeneratorService idGeneratorService;

	/**
	 * Backend server check
	 *
	 * @return hello.
	 */
	@RequestMapping("/")
	public String welcome() {//Welcome page, non-rest
		return "Hello  Here ";
	}

	/**
	 * Query and get value of current counter in database.
	 *
	 * @return value of counter stored in database
	 */
	@RequestMapping("/getCurrentValue")
	public CounterResponse getCurrentValue() {
		return idGeneratorService.getCurrentValue();
	}

	/**
	 * Update counter value in database to 0.
	 *
	 * @return number of rows updated in database
	 */
	@RequestMapping("/reset")
	public CounterResponse reset() {
		return idGeneratorService.reset();
	}

	/**
	 * Increments current counter in database through MySQL variable,
	 * it sets current value of counter in a variable and increments in same query.
	 * @return value of current_counter variable i.e. value of counter before UPDATE was performed
	 */
	@RequestMapping("/doIncrement")
	public CounterResponse doIncrement() {
		return idGeneratorService.incrementValue();
	}







	
	
	 

	
}
