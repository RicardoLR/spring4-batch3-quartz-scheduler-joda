package com.richi.springbatch;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.springframework.batch.item.ItemProcessor;

import com.richi.springbatch.model.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult>{

	
	//@Override
	public ExamResult process(ExamResult result) throws Exception {
		System.out.println("Processing result :"+result);
		
		
		return result;
	}

	
	
	
}
