package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;
public class TimeTableTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	 public void test01()  throws Throwable  {
		TimeTable timeTable = new TimeTable();
		 
		GregorianCalendar today = new GregorianCalendar(2016, 05, 13);
		GregorianCalendar tomorrow = new GregorianCalendar(2016, 05, 14);
		 
		Appt appt = new Appt(12, 2, 2, 2, 2000, "T", "D");
		Appt appt2 = new Appt(3, 2, 2, 2, 2000, "T", "D");
		 
		LinkedList<Appt> llCheck = new LinkedList<Appt>();
		llCheck.add(appt);
		llCheck.add(appt2);
		 
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> calDayCheck = new LinkedList<CalDay>();
		
		calDays = timeTable.getApptRange(llCheck, today, tomorrow);
		calDayCheck = timeTable.getApptRange(llCheck, today, tomorrow);
		assertEquals(calDays, calDayCheck);
	 }
	 
	 @Test
	 public void test02() throws Throwable {
		TimeTable timeTable = new TimeTable();
			 
		GregorianCalendar today = new GregorianCalendar(2016, 05, 13);
		GregorianCalendar tomorrow = new GregorianCalendar(2016, 05, 14);
			 
		Appt appt = new Appt(12, 2, 2, 2, 2000, "T", "D");
		Appt appt2 = new Appt(3, 2, 2, 2, 2000, "T", "D");
		
		LinkedList<Appt> llCheck = new LinkedList<Appt>();
		llCheck.add(appt);
		llCheck.add(appt2);
		 
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> calDayCheck = new LinkedList<CalDay>();
		
		calDays = timeTable.getApptRange(llCheck, tomorrow, today);
		calDayCheck = timeTable.getApptRange(llCheck, tomorrow, today);
		assertEquals(calDays, calDayCheck);
	 }
	 
	 @Test
	 public void test03() throws Throwable {
		TimeTable timeTable = new TimeTable();
			 
		GregorianCalendar today = new GregorianCalendar(2016, 05, 13);
		GregorianCalendar tomorrow = new GregorianCalendar(2016, 05, 15);
			 
		Appt appt = new Appt(12, 2, 13, 5, 2016, "T", "D");
		Appt appt2 = new Appt(3, 2, 13, 5, 2016, "T", "D");
		Appt appt3 = new Appt(4, 2, 14, 5, 2016, "T", "D");
		Appt appt4 = new Appt(5, 2, 14, 5, 2016, "T", "D");
		Appt appt5 = new Appt(6, 2, 15, 5, 2016, "T", "D");
		
		LinkedList<Appt> llCheck = new LinkedList<Appt>();
		llCheck.add(appt);
		llCheck.add(appt2);
		llCheck.add(appt3);
		llCheck.add(appt4);
		llCheck.add(appt5);
		 
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> calDayCheck = new LinkedList<CalDay>();
		
		calDays = timeTable.getApptRange(llCheck, today, tomorrow);
		calDayCheck = timeTable.getApptRange(llCheck, today, tomorrow);
		assertEquals(calDays, calDayCheck);
		
		assertEquals(null, timeTable.deleteAppt(llCheck, appt4));
		assertEquals(null, timeTable.deleteAppt(llCheck, null));
	 }
}
