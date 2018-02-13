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
        int startHour = 12;
        int startMinute = 30;
        int startDay = 5;
        int startMonth = 5;
        int startYear = 2017;
      Appt a = new Appt(startHour,startMinute,startDay,startMonth,startYear,"A","A1");
      Appt b = new Appt(startHour,startMinute,startDay,startMonth,startYear,"B","B1");
      Appt c = new Appt(startHour,startMinute,startDay,startMonth,startYear,"C","C1");

      Appt d = new Appt(1,startMinute,startDay,startMonth,startYear,"D","D1");
      Appt e = new Appt(1,1,startDay,startMonth,startYear,"E","E1");
        Appt f = new Appt(1,1,startDay,1,startYear,"F","F1");

        int[] arr = {};
        int[] arr2 = {1,2,3};
        int[] arr3 = {5};
        a.setRecurrence(arr,1,1,1);
        b.setRecurrence(arr2,1,1,1);
        c.setRecurrence(arr3,1,1,1);
        d.setRecurrence(arr,2,1,1);
        LinkedList<Appt> l = new LinkedList<Appt>();
      l.add(a);
      l.add(b);
      l.add(c);
      l.add(d);
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
