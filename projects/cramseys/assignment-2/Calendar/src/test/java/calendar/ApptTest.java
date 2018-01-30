package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
		 @Test
		 public void Constructor()  throws Throwable  {
			 int startHour = 1;
			 int startMinute = 1;
			 int startDay = 1;
			 int startMonth = 1;
			 int startYear = 1;
				String title = "A";
				String description = "B";
			 Appt a = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
			 assertTrue(a.getValid());
			 assertEquals(1, a.getStartHour());
			 assertEquals(1, a.getStartMinute());
			 assertEquals(1, a.getStartDay());
			 assertEquals(1, a.getStartMonth());
			 assertEquals(1, a.getStartYear());
			 assertEquals("A", a.getTitle());
			 assertEquals("B", a.getDescription());
		 }
		@Test
		public void getValid() throws Throwable {
			Appt a = new Appt(1,1,1,1,1,"T","D");
			assertTrue(a.getValid());
			Appt b = new Appt(-1,1,1,1,1,"T","D");
			assertTrue(!b.getValid());
			Appt c = new Appt(1,-1,1,1,1,"T","D");
			assertTrue(!c.getValid());
			Appt d = new Appt(1,1,-1,1,1,"T","D");
			assertTrue(!d.getValid());
			Appt e = new Appt(1,1,1,-1,1,"T","D");
			assertTrue(!e.getValid());
			Appt f = new Appt(1,1,1,1,-1,"T","D");
			assertTrue(!f.getValid());
		}

	 	@Test
	  public void sets()  throws Throwable  {
			Appt a = new Appt(1,1,1,1,1,"A","B");
			a.setStartHour(2);
			assertEquals(2, a.getStartHour());
			a.setStartMinute(2);
			assertEquals(2, a.getStartMinute());
			a.setStartMonth(2);
			assertEquals(2, a.getStartMonth());
			a.setStartYear(2);
			assertEquals(2, a.getStartYear());
			a.setStartDay(2);
			assertEquals(2, a.getStartDay());
			a.setTitle("B");
			assertEquals("B", a.getTitle());
			a.setDescription("A");
			assertEquals("A", a.getDescription());
			int[] arr = new int[0];
			a.setRecurrence(arr, 1, 2, 3);
			assertEquals(3,a.getRecurNumber());
			assertEquals(1,a.getRecurBy());
			assertEquals(2,a.getRecurIncrement());
			assertTrue(a.isRecurring());
	 	}
		@Test
		public void TtoString() throws Throwable{
			Appt a = new Appt(1,1,1,1,1,"A","B");
			assertEquals("	1/1/1 at 1:1am ,A, B\n", a.toString());
		}
		@Test
		public void Compare() throws Throwable{
			Appt a = new Appt(1,1,1,1,1,"A","B");
			Appt b = new Appt(1,1,1,1,1,"A","B");
			assertEquals(0, a.compareTo(b));
		}
}
