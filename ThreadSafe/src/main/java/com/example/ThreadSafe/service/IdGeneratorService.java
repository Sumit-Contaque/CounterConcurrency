package com.example.ThreadSafe.service;

import com.example.ThreadSafe.Beans.CounterResponse;
import com.example.ThreadSafe.dao.CounterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author anurag
 *
 */


@Service
public class IdGeneratorService {


	@Autowired
	private CounterDao counterDao;

	public CounterResponse getCurrentValue() {
		try {
			Integer currentVal=counterDao.getValue();
			return new CounterResponse("success", "Current value for counter is " + currentVal);
		}catch (Exception e) {
			throw e ;
		}
	}
	public CounterResponse reset() {
		try {
			Integer val=counterDao.setInitialValue();
			return new CounterResponse("success", "value setted to 0.");
		}catch (Exception e) {
			throw e;
		}
	}

	public CounterResponse incrementValue() {
		try {
			Integer val=counterDao.updateValue();
			return new CounterResponse("success", "After increment by 1,Current value for counter is " + val);
		}catch (Exception e) {
			throw e;
		}
	}
	
	
}
