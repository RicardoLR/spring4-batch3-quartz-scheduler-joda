package com.richi.springbatch;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class FileArchivingTasklet implements Tasklet{

	
	private File archiveDirectory;
	//private String archiveDirectoryPath = "C:/Users/Richi/Documents/workspace-sts-3.8.3.RELEASE/spring-batch-quartz-scheduler/csv/archivedFiles/";
	private String archiveDirectoryPath = "E:/archivedFiles/";
	
	
	public void init(){
		archiveDirectory = new File(archiveDirectoryPath);
	}
	
	//@Override
	public RepeatStatus execute(StepContribution contribution,	ChunkContext chunkContext) throws Exception {
		Map<String, Object> map = chunkContext.getStepContext().getJobParameters();
		String fileName = (String) map.get("examResultInputFile");
		archiveFile(fileName);
		return RepeatStatus.FINISHED;
	}

	/** una ves procesado el archivo de entrada, 
	 * el archivo será movido a una carpeta diferente E:/archivedFiles con la fecha y hora sufijo
	 * 
	 * Observe el uso de jobParameters para obtener el nombre de archivo del archivo que procesamos en STEP anterior.
	 * */
	public void archiveFile(String fileName) throws IOException{
		System.out.println("class FileArchivingTasklet: Archiving file: "+fileName);
		
		File file = new File(fileName);
		File targetFile = new File(archiveDirectory, file.getName() + getSuffix() + ".csv" );
		
		FileUtils.moveFile(file, targetFile);
	}

	
	public String getSuffix(){
		
		return "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new DateTime(DateTimeZone.UTC).toDate());
	} 
	
}
