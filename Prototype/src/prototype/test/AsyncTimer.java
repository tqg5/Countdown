package prototype.test;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.os.AsyncTask;
import android.widget.TextView;
import org.joda.time.*;

//pass in array of TextViews for first parameter.
//the order will be yearTextView, monthsTextView,weeksTextView,
//daysTextView,hoursTextView,minutesTextView, and secondsTextView
public class AsyncTimer extends AsyncTask<Void,String,Boolean>{
		
	private int startYear;
	private int startMonth;
	private int startDay;
	
	private int endYear;
	private int endMonth;
	private int endDay;
	
	private DateTime startTime;
	private DateTime endTime;
	
	private int years;
	private int months;
	private int weeks;
	private int days;
	private int hours;
	private int minutes;
	private int seconds;
	
	private int secondsCounter = 0;
	private int minutesCounter = 0;
	private int hoursCounter = 0;
	
	private TextView startDateTextView;
	private TextView endDateTextView;
	private TextView yearsTextView;
	private TextView monthsTextView;
	private TextView weeksTextView;
	private TextView daysTextView;
	private TextView hoursTextView;
	private TextView minutesTextView;
	private TextView secondsTextView;
		
	public AsyncTimer(TextView[] textViewArray,int sy,int sm,int sd,
						int ey, int em, int ed)
    {		
		
		this.startYear = sy;
		this.startMonth = sm;
		this.startDay = sd;
		
		this.endYear = ey;
		this.endMonth = em;
		this.endDay = ed;
		
		this.startTime = new DateTime(startYear,startMonth,startDay,0,0,0,0);
		this.endTime = new DateTime(endYear,endMonth,endDay,0,0,0,0);
		
		this.startDateTextView = textViewArray[0];
		this.endDateTextView = textViewArray[1];
		this.yearsTextView = textViewArray[2];
		this.monthsTextView = textViewArray[3];
		this.weeksTextView = textViewArray[4];
		this.daysTextView = textViewArray[5];
		this.hoursTextView = textViewArray[6];
		this.minutesTextView = textViewArray[7];
		this.secondsTextView = textViewArray[8];
	
		this.years = Years.yearsBetween(startTime, endTime).getYears();
		this.months = Months.monthsBetween(startTime, endTime).getMonths();
		this.weeks = Weeks.weeksBetween(startTime, endTime).getWeeks();
		this.days = Days.daysBetween(startTime, endTime).getDays();
		this.hours = Hours.hoursBetween(startTime, endTime).getHours();
		this.minutes = Minutes.minutesBetween(startTime, endTime).getMinutes();
		this.seconds = Seconds.secondsBetween(startTime, endTime).getSeconds();
    }
	
	/* TODO
	 * To figure out exactly which settings the timer should countdown for,
	 * just iterate through all of the date variables and check which ones have been set.
	 * Then, just set the corresponding text views.
	 */
	
	//*****setter textView methods ***************//
	public void setSecondsTextView(TextView textView)
	{
		this.secondsTextView = textView;
	}
	
	public void setMinutesTextView(TextView textView)
	{
		this.minutesTextView = textView;
	}
	
	public void setHoursTextView(TextView textView)
	{
		this.hoursTextView = textView;
	}
	
	public void setDaysTextView(TextView textView)
	{
		this.daysTextView = textView;
	}
	
	public void setMonthsTextView(TextView textView)
	{
		this.monthsTextView = textView;
	}
	
	public void setYearssTextView(TextView textView)
	{
		this.yearsTextView = textView;
	}
	
	//*****setter date variables methods ***************//
	public void setSeconds(int secs)
	{
		this.seconds = secs;
	}

	public void setMinutes(int mins)
	{
		this.minutes = mins;
	}
	
	public void setHours(int hrs)
	{
		this.hours = hrs;
	}
	
	public void setDays(int dys)
	{
		this.days = dys;
	}
	
	public void setWeeks(int wks)
	{
		this.weeks = wks;
	}
	
	public void setMonths(int mths)
	{
		this.months = mths;
	}
	
	public void setYears(int yrs)
	{
		this.years = yrs;
	}
	
	
	//getter methods
	public int getSeconds()
	{
		return this.seconds;
	}

	public int getMinutes()
	{
		return this.minutes;
	}
	
	public int getHours()
	{
		return this.hours;
	}
	
	public int getDays()
	{
		return this.days;
	}
	
	public int getWeeks()
	{
		return this.weeks;
	}
	
	public int getMonths()
	{
		return this.months;
	}
	
	public int getYears()
	{
		return this.years;
	}

	@Override
	protected Boolean doInBackground(Void... arg0) 
	{
		// TODO Auto-generated method stub
			
		System.out.println("do in background");
		while(true)
		{			
			Duration dur = new Duration(startTime,endTime);
			
			
			System.out.println("seconds: "+dur.getStandardSeconds());
			this.publishProgress(""+--seconds);
			++secondsCounter;
			System.out.println("seconds counter "+secondsCounter);
			
			if(secondsCounter == 60)
			{
				this.publishProgress(""+--minutes);
				++minutesCounter;
				
				secondsCounter = 0;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
	
	@Override
	protected void onProgressUpdate(String... progress) {
		super.onProgressUpdate(progress[0]);
		
		secondsTextView.setText(Integer.toString(seconds));
		
		if(secondsCounter == 60)
			minutesTextView.setText(Integer.toString(minutes));
	}
	
	@Override
	protected void onCancelled()
	{
		
	}


}
