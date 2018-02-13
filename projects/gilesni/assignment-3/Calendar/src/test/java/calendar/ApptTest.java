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
	public void test01()  throws Throwable  {
		Appt appointment = new Appt(4, 2, 2, 2, 2000, "T", "D");
		 
		//Tests for getStartMonth and setStartMonth
		appointment.setStartMonth(7);
		int test = appointment.getStartMonth();
		assertEquals(7, test);
		 
		//Tests for getStartHour and setStartHour
		appointment.setStartHour(12);
		test = appointment.getStartHour();
		assertEquals(12, test);
		 
		//Tests for getStartMinute and setStartMinute 
		appointment.setStartMinute(32);
		test = appointment.getStartMinute();
		assertEquals(32, test);
		 
		//Tests for getStartDay and setStartDay
		appointment.setStartDay(2);
		test = appointment.getStartDay();
		assertEquals(2, test);
		 
		//Tests for getStartYear and setStartYear
		appointment.setStartYear(2018);
		test = appointment.getStartYear();
		assertEquals(2018, test);
		 
		//Tests for getTitle and setTitle
		appointment.setTitle("Title");
		String sTest = appointment.getTitle();
		assertEquals("Title", sTest);
		 
		//Tests for getDescription and setDescription
		appointment.setDescription("Description");
		sTest = appointment.getDescription();
		assertEquals("Description", sTest);
		 
		//Test for getValid
		boolean bTrue = appointment.getValid();
		assertEquals(true, bTrue);
	}
	 
	/***************BRANCH COVERAGE FOR IS VALID()***************/
	@Test
	public void test02()  throws Throwable  {
		Appt appointment = new Appt(4, 2, 2, 2, 2000, "T", "D");
		 
		//setHour test cases and isValid()
		appointment.setStartHour(0);
		boolean bTest = appointment.getValid();
		assertEquals(false, bTest); //test lower edge case

		appointment.setStartHour(2);
		bTest = appointment.getValid();
		assertEquals(true, bTest); //test inner bound
		
		appointment.setStartHour(23);
		bTest = appointment.getValid();
		assertEquals(false, bTest); //test upper edge case

		appointment.setStartHour(-1);
		bTest = appointment.getValid();
		assertEquals(false, bTest); //test lower bound

		appointment.setStartHour(25);
		bTest = appointment.getValid();
		assertEquals(false, bTest); //test upper bound
	}
	
	@Test
	public void test03() throws Throwable {
		Appt appointment = new Appt(4, 2, 2, 2, 2000, "T", "D");

		//setMinute test cases and isValid()
		appointment.setStartMinute(0);
		boolean bTest = appointment.getValid();
		assertEquals(true, bTest); //test lower edge case
		
		appointment.setStartMinute(59);
		bTest = appointment.getValid();
		assertEquals(true, bTest); //test upper edge case

		appointment.setStartMinute(2);
		bTest = appointment.getValid();
		assertEquals(true, bTest); //test inner bound

		appointment.setStartMinute(-1);
		bTest = appointment.getValid();
		assertEquals(false, bTest); //test lower bound

		appointment.setStartMinute(64);
		bTest = appointment.getValid();
		assertEquals(false, bTest); //test upper bound
	}

	@Test
	public void test04() throws Throwable {
		Appt appointment = new Appt(4, 2, 2, 1, 2000, "T", "D");

		//setDay test cases and isValid()
		appointment.setStartDay(1);
		boolean bTest = appointment.getValid();
		assertEquals(true, bTest); //test lower edge case
		
		appointment.setStartDay(31);
		bTest = appointment.getValid();
		assertEquals(true, bTest); //test upper edge case

		appointment.setStartDay(4);
		bTest = appointment.getValid();
		assertEquals(true, bTest); //test inner bound

		appointment.setStartDay(-1);
		bTest = appointment.getValid();
		assertEquals(false, bTest); //test lower bound

		appointment.setStartDay(40);
		bTest = appointment.getValid();
		assertEquals(false, bTest); //test upper bound
	}

	@Test
	public void test05() throws Throwable {
		Appt appointment = new Appt(4, 2, 2, 2, 2000, "T", "D");

		//setDay test cases and isValid()
		appointment.setStartMonth(1);
		boolean bTest = appointment.getValid();
		assertEquals(true, bTest); //test lower edge case
		
		appointment.setStartMonth(12);
		bTest = appointment.getValid();
		assertEquals(true, bTest); //test upper edge case

		appointment.setStartMonth(4);
		bTest = appointment.getValid();
		assertEquals(true, bTest); //test inner bound
		
		int err = 0;
		try {
			appointment.setStartMonth(0);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			err = 1;
		}
		if (err == 1) {
			bTest = false;
		}
		else {
			bTest = appointment.getValid();
		}
		assertEquals(false, bTest); //test lower bound
		
		err = 0;
		try {
			appointment.setStartMonth(40);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			err = 1;
		}
		if (err == 1) {
			bTest = false;
		}
		else {
			bTest = appointment.getValid();
		}
		assertEquals(false, bTest); //test upper bound
	}

	@Test
	public void test06()  throws Throwable  {
		//setRecurBy
		Appt appointment = new Appt(4, 2, 2, 2, 2000, "T", "D");
		
		appointment.setRecurrence(null, 5, 5, 5);
		
		int iTest = appointment.getRecurNumber();
		assertEquals(iTest, 5);
		 
		iTest = appointment.getRecurBy();
		assertEquals(iTest, 5);
		 
		int[] iArrTest = appointment.getRecurDays();
		
		//isRecurring
		boolean bTest = appointment.isRecurring();
		assertEquals(bTest, true);
		
		iTest = appointment.getRecurIncrement();
		assertEquals(iTest, 5);
	}
	
	@Test
	public void test07() throws Throwable {
		//toString, representationApp, and compareTo test
		Appt appt = new Appt(12, 2, 2, 2, 2000, "T", "D");
		Appt appt2 = new Appt(3, 1, 1, 1, 1999, "T", "D");
		Appt appt3 = new Appt(0, 0, 1, 2, 2000, "T", "D");

		String sTest = appt.toString();
		assertEquals("\t2/2/2000 at 12:2pm ,T, D\n", sTest);
		sTest = appt2.toString();
		assertEquals("\t1/1/1999 at 3:1am ,T, D\n", sTest);
		
		int iTest = appt.compareTo(appt2);
		assertEquals(13, iTest);
		
		sTest = appt3.toString();
		assertEquals(null, sTest);
	}
}
