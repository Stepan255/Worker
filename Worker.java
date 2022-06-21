import java.util.Calendar;

// import javax.xml.crypto.Data;

/**
 * Worker
 */
public class Worker {
	private int salary = 0;
	private String firstName = null;
	private String lastName = null;
	private Calendar birthday = null; // todo calendar

	public Worker(String firstNameWorker, String lastNameWorker,Calendar birthdayWorker) {
		birthday = birthdayWorker;
		firstName = firstNameWorker;
		lastName = lastNameWorker;
		salary = 0;
	}

}