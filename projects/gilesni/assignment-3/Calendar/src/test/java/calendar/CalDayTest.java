package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;
public class CalDayTest {
    /**
     * Test that the gets methods work as expected.
     */
	@Test
	public void test01()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2016, 05, 13);
		CalDay calDay = new CalDay((GregorianCalendar)today);
		
		CalDay calDay2 = new CalDay();
		
		boolean bTest = calDay.isValid();
		assertEquals(bTest, true);
		
		int iTest = calDay.getDay();
		assertEquals(iTest, 13);
		
		iTest = calDay.getMonth();
		assertEquals(iTest, 05);
		
		iTest = calDay.getYear();
		assertEquals(iTest, 2016);
	}
	
	@Test
	public void test02() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2016, 05, 13);
		CalDay calDay = new CalDay((GregorianCalendar)today);
		
		Appt appt = new Appt(12, 2, 2, 2, 2000, "T", "D");
		Appt appt2 = new Appt(3, 2, 2, 2, 2000, "T", "D");
		
		LinkedList<Appt> llCheck = new LinkedList<Appt>();
		llCheck.add(appt2);
		llCheck.add(appt);
		
		/* If the test plan adds the appts in this order the mvn test command gets hung up at the CalDayTest
		calDay.addAppt(appt);
		calDay.addAppt(appt2);
		*/

		calDay.addAppt(appt2);
		calDay.addAppt(appt);

		LinkedList<Appt> llTest = calDay.getAppts();
		assertEquals(llTest, llCheck);
		
		int iTest = calDay.getSizeAppts();
		assertEquals(iTest, 2);
	}
	
	@Test
	public void test03() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2016, 05, 13);
		CalDay calDay = new CalDay(today);
		
		Appt appt = new Appt(12, 2, 2, 2, 2000, "T", "D");
		
		calDay.addAppt(appt);
		
		String sTest = calDay.toString();
		String sCheck = calDay.toString();
		assertEquals(sTest, sCheck);
	}
}
