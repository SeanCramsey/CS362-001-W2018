package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import org.junit.Test;
import java.util.Iterator;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;
public class CalDayTest{
    /**
     * Test that the gets methods work as expected.
     */
    @Test
    public void Constructor()  throws Throwable  {
      GregorianCalendar cal = new GregorianCalendar();
      CalDay night = new CalDay();
      assertTrue(night.isValid());
      assertNull(night.iterator());
      assertEquals("", night.toString());
      CalDay day = new CalDay(cal);
      assertTrue(day.isValid());
      assertEquals(cal.get(cal.DAY_OF_MONTH),day.getDay());
      assertEquals(cal.get(cal.MONTH),day.getMonth());
      assertEquals(cal.get(cal.YEAR),day.getYear());
    }
    @Test
    public void addAppt() throws Throwable{
      Appt a = new Appt(1,1,1,1,1,"A","B");
      GregorianCalendar cal = new GregorianCalendar();
      CalDay day = new CalDay(cal);
      assertEquals(0,day.getSizeAppts());
      day.addAppt(a);
      assertEquals(1,day.getSizeAppts());
      assertNotEquals("", day.toString());
    }
}
