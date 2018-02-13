package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import org.junit.Test;
import java.util.LinkedList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Iterator;

import static org.junit.Assert.*;
public class TimeTableTest {
    /**
     * Test that the gets methods work as expected.
     */
    @Test
    public void test01()  throws Throwable  {
      TimeTable t = new TimeTable();
      assertNotNull(t);
      Appt a = new Appt(20,20,20,12,1999,"A","B");
      Appt b = new Appt(20,20,20,12,2000,"A","B");
      LinkedList<Appt> l = new LinkedList<Appt>();
      l.add(a);
      l.add(b);
      Calendar now = Calendar.getInstance();
      int day = now.get(Calendar.DAY_OF_MONTH);
      int month = now.get(Calendar.MONTH);
      int year = now.get(Calendar.YEAR);
      GregorianCalendar g = new GregorianCalendar(year,month,day);
      GregorianCalendar g0 = (GregorianCalendar)g.clone();
      GregorianCalendar g01 = (GregorianCalendar)g.clone();
      g0.add(Calendar.DAY_OF_MONTH,1);
      g01.add(Calendar.DAY_OF_MONTH,600);
      assertNotNull(t.getApptRange(l, g, g0));
      assertNotNull(t.getApptRange(l,g,g01));
    }

    @Test
    public void test02()  throws Throwable  {
      LinkedList<Appt> l = new LinkedList<Appt>();
      Appt a = new Appt(1,1,1,1,1,"A","B");
      Appt b = new Appt(2,2,2,2,2,"A","B");
      l.add(a);
      l.add(b);
      TimeTable t = new TimeTable();
      int [] pv = {1,0};
      assertNotNull(t.permute(l,pv));
    }
    @Test
    public void test03() throws Throwable{
      TimeTable t = new TimeTable();
      LinkedList<Appt> l = new LinkedList<Appt>();
      Appt a = new Appt(5,5,5,5,5,"A","B");
      Appt b = new Appt(-1,-1,-1,1,-1,"A","B");
      Appt c = new Appt(6,6,6,6,6,"A","B");
      assertNull(t.deleteAppt(l,a));
      l.add(a);
      assertNull(t.deleteAppt(l,b));
      assertNull(t.deleteAppt(l,c));
      l.add(b);
      assertNull(t.deleteAppt(l,a));
    }
    @Test
    public void test04() throws Throwable  {
      TimeTable t = new TimeTable();
      GregorianCalendar g = new GregorianCalendar();
      GregorianCalendar g0 = new GregorianCalendar(2017,1,1);
      GregorianCalendar g01 = new GregorianCalendar(2017,12,24);
      CalDay c = new CalDay(g);
      Appt a = new Appt(5,5,5,5,2017,"A","C");
      Appt b = new Appt(5,5,5,5,2018,"A","C");
      LinkedList<Appt> l = new LinkedList<Appt>();
      l = null;
      assertNotNull(t.getApptRange(c.getAppts(), g0, g01));
    }

}
