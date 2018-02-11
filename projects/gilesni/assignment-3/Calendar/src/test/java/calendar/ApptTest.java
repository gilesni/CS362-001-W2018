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
		 assertEquals(test,7);
		 
		 //Tests for getStartHour and setStartHour
		 appointment.setStartHour(12);
		 test = appointment.getStartHour();
		 assertEquals(test, 12);
		 
		 //Tests for getStartMinute and setStartMinute 
		 appointment.setStartMinute(32);
		 test = appointment.getStartMinute();
		 assertEquals(test, 32);
		 
		 //Tests for getStartDay and setStartDay
		 appointment.setStartDay(2);
		 test = appointment.getStartDay();
		 assertEquals(test,2);
		 
		 //Tests for getStartYear and setStartYear
		 appointment.setStartYear(2018);
		 test = appointment.getStartYear();
		 assertEquals(test,2018);
		 
		 //Tests for getTitle and setTitle
		 appointment.setTitle("Title");
		 String sTest = appointment.getTitle();
		 assertEquals(sTest, "Title");
		 
		 //Tests for getDescription and setDescription
		 appointment.setDescription("Description");
		 sTest = appointment.getDescription();
		 assertEquals(sTest, "Description");
		 
		 //Test for getValid
		 boolean bTrue = appointment.getValid();
		 assertEquals(bTrue, true);
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 //Branch coverage in isValid()
		 Appt appointment = new Appt(4, 2, 2, 2, 2000, "T", "D");
		 
		 //setHour
		 appointment.setStartHour(-1);
		 boolean bTest = appointment.getValid();
		 assertEquals(bTest, false);
		 
		 appointment.setStartHour(4);
		 bTest = appointment.getValid();
		 assertEquals(bTest, true);
		 
		 //setMinute
		 appointment.setStartMinute(-1);
		 bTest = appointment.getValid();
		 assertEquals(bTest, false);
		 
		 appointment.setStartMinute(2);
		 bTest = appointment.getValid();
		 assertEquals(bTest, true);
		 
		 //setDay
		 appointment.setStartDay(-1);
		 bTest = appointment.getValid();
		 assertEquals(bTest, false);
		 
		 appointment.setStartDay(2);
		 bTest = appointment.getValid();
		 assertEquals(bTest, true);
		 
		//setMonth
		 appointment.setStartMonth(-1);
		 bTest = appointment.getValid();
		 assertEquals(bTest, false);
		 
		 appointment.setStartMonth(2);
		 bTest = appointment.getValid();
		 assertEquals(bTest, true);
	 }
	 
	 @Test
	  public void test03()  throws Throwable  {
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
	 public void test04() throws Throwable {
		 //toString, representationApp, and compareTo test
		 Appt appt = new Appt(12, 2, 2, 2, 2000, "T", "D");
		 Appt appt2 = new Appt(3, 2, 2, 2, 2000, "T", "D");
		 Appt appt3 = new Appt(0, 0, 1, 2, 2000, "T", "D");
		 
		 String sTest = appt.toString();
		 assertEquals(sTest, "\t 2/2/2000 at 12:02pm ,T, D\n");
		 sTest = appt2.toString();
		 assertEquals(sTest, "\t 2/2/2000 at 3:02am ,T, D\n");
		 
		 int iTest = appt.compareTo(appt2);
		 assertEquals(iTest, 9);
		 
		 sTest = appt3.toString();
		 assertEquals(sTest, null);
	 }
}
