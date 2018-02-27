package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

//Looking for 100% branch coverage in isValid() and setRecurDays(int[] recurDays)

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tested!
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence", "setHour", "setMinute", "setMonth", "setDay"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly, Monthly, or Yearly!
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur!
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {

	     long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");
		 try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour = ValuesGenerator.RandInt(random);
				 int startMinute = ValuesGenerator.RandInt(random);
				 int startDay = ValuesGenerator.RandInt(random);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear = ValuesGenerator.RandInt(random);
				 String title = "Birthday Party";
				 String description = "This is my birthday party.";
				 //Construct a new Appointment object with the initial data	 
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
			    String methodName = ApptRandomTest.RandomSelectMethod(random);
			        if (methodName.equals("setTitle")) {
			            String newTitle = (String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
			        }
			        else if (methodName.equals("setRecurrence")) {
			            int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
			            boolean allowRecurDays = ValuesGenerator.getBoolean(5, random);
                        int[] recurDays;
                        if (allowRecurDays == true){
                            recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
                        }
                        else {
                            recurDays = null;
                        }
			            int recur = ApptRandomTest.RandomSelectRecur(random);
			            int recurIncrement = ValuesGenerator.RandInt(random);
			            int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
			            appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
			        }
			        else if (methodName.equals("setHour")) {
			            int newHour = ValuesGenerator.getRandomIntBetween(random, 0, 48);
			            appt.setStartHour(newHour);
			        }
                    else if (methodName.equals("setMinute")) {
                        int newMinute = ValuesGenerator.getRandomIntBetween(random, 0, 100);
                        appt.setStartHour(newMinute);
                    }
                    else if (methodName.equals("setDay")) {
                        int newDay = ValuesGenerator.getRandomIntBetween(random, 0, 60);
                        appt.setStartHour(newDay);
                    }
                    else if (methodName.equals("setMonth")) {
                        int newMonth = ValuesGenerator.getRandomIntBetween(random, 0, 24);
                        appt.setStartHour(newMonth);
                    }
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000) == 0 && iteration != 0 )
			              System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }


	
}
