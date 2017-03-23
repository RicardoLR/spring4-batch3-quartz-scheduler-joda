package com.richi.springbatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/** Integrar Spring Batch con Quartz Scheduler para ejecutar el trabajo por lotes peri�dicamente. 
 * 
 * peri�dicamente, los archivos se reciben din�micamente (pueden tener nombres diferentes en cada ejecuci�n) 
 * en alguna carpeta de entrada (no necesariamente el classpath de la aplicaci�n). 
 * 
 * Veremos el uso de JobParameter para manejar este escenario. 
 * 
 * 
 * Tambi�n veremos el uso de Tasklet para archivar archivo una vez que se procesan (Mover a otra parte). 
 * 
 * Leeremos (uno o m�s) archivos planos (en cada ejecuci�n) usando FlatFileItemReader 
 * y escribiremos a un archivo con FlatFileItemWriter.
 * 
 * */


/** Leera dinamicamente los archivos de E:/inputFiles

infile.txt

Shaun Pollack  |   10/03/1975  |   85
Lance Klusner  |   10/03/1972  |   98
Alan Donald    |   01/02/1973  |   76

anotherinfile.txt
Brian Lara       |   09/11/1971  |   92
Malcom Marshall  |   10/03/1964  |   96
Vivian Richards  |   03/08/1960  |   88
Kurtley Ambrose  |   03/08/1971  |   61

yetanother.bak
Adam Gilchrist |   09/11/1977  |   91
Steve Waugh    |   10/03/1971  |   76
Shane Warne    |   03/08/1972  |   56
Andrew Symonds |   03/08/1973  |   61


*/
public class Main {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		 
		ApplicationContext context = new ClassPathXmlApplicationContext("quartz-context.xml");
	 
	}
}
