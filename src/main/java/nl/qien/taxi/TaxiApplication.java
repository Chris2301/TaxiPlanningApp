package nl.qien.taxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nl.qien.taxi.domain.MailMail;
import nl.qien.taxi.domain.Taxi;

@SpringBootApplication
public class TaxiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

	    	MailMail mm = (MailMail) context.getBean("mailMail");
	 
	    	mm.sendMail("TaxiApp1234@gmail.com",
	    		   "TaxiApp1234@gmail.com",
	    		   "Hello Guy",
	    		   "PoogelyWoopski \n\n Dit werkt al in ieder geval");
	    	
	}
}
