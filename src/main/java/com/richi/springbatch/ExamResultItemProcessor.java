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
		
		/*
		 * Only return results which are more than 75%
		 * 
		 */
		if(result.getPercentage() < 75){
			return null;
		}
		
		LocalTime time = LocalTime.now();

		
		// si el campo DOB en xml, esta en el intervalo, agregar a su nombre, Nacie apenas
		if( nacioApenas( result.getDob().toDateTime(time) )   ){
			result.setStudentName( result.getStudentName() + " was born recently");
		}
		
		return result;
	}

	public Boolean nacioApenas( DateTime dateTime){

		// Crear un intervalo entre el 1 de Enero y la fecha actual
		DateTime inicio = new DateTime(2014, 1, 1, 0, 0, 0, 0);
		//DateTime fin = new DateTime();
        LocalDateTime localDateTime = new LocalDateTime();

		Interval interval = new Interval(inicio, localDateTime.toDateTime()); // OJO comvertir los Local TIME o DATE

		// Recuperar el inicio y fin del intervalo
		//DateTime init = interval.getStart();
		//DateTime end = interval.getEnd();

		// Comprobar si una fecha determinada está dentro del intervalo
		//boolean apenasNacieron = interval.contains( fechaNacimiento  );

		// Conversión a duración o período
		//Duration duration = interval.toDuration();
		//Period period = interval.toPeriod();
		
		//System.out.println("entro" + inicio +" "+ localDateTime +" "+ interval);

		return interval.contains(dateTime);
	}
	
	
}
