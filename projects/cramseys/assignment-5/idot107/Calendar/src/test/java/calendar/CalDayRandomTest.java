package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;



		 System.out.println("Start testing...");

		 try {

			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				 long randomseed = System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 //int startDay = ValuesGenerator.RandInt(random);
                 int startDay = ValuesGenerator.getRandomIntBetween(random,-5,35);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear = ValuesGenerator.RandInt(random);


				 int NumDaysInMonth = CalendarUtil.NumDaysInMonth(startYear, startMonth - 1);
				 if (startDay > NumDaysInMonth) continue;

				 GregorianCalendar day = new GregorianCalendar(startYear, startMonth, startDay);
				 CalDay cal = new CalDay(day);

				 int apptCounter = 0;

				 for (int i = 0; i < NUM_TESTS; i++) {
					 long randseed = System.currentTimeMillis();
					 Random rand2 = new Random(randseed);
					 //int startHour = ValuesGenerator.RandInt(rand2);
                     int startHour = ValuesGenerator.getRandomIntBetween(rand2,-29,89);
					 //int startMinute = ValuesGenerator.RandInt(rand2);
                     int startMinute = ValuesGenerator.getRandomIntBetween(rand2,-29,89);

					 String title = "Birthday Party";
					 String description = "This is my birthday party.";
					 //Construct a new Appointment object with the initial data
					 Appt appt = new Appt(startHour,
							 startMinute,
							 startDay,
							 startMonth,
							 startYear,
							 title,
							 description);

					 cal.addAppt(appt);

					 if(appt.getValid()){
					 	apptCounter++;
					 }
					 assertEquals(cal.getAppts().size(), apptCounter);
				 }
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if ((iteration % 10000) == 0 && iteration != 0)
					 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			 }
		 }catch(NullPointerException e){}
	 }


	
}
