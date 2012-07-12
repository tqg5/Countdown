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
		this.startYear = -1;
		this.startMonth = -1;
		this.startDay = -1;
		
		this.endYear = -1;
		this.endMonth = -1;
		this.endDay = -1;
		
		this.startTime = null;
		this.endTime = null;
		
		this.startDateTextView = null;
		this.endDateTextView = null;
		this.yearsTextView = null;
		this.monthsTextView = null;
		this.weeksTextView = null;
		this.daysTextView = null;
		this.hoursTextView = null;
		this.minutesTextView = null;
		this.secondsTextView = null;
	
		this.years = -1;
		this.months = -1;
		this.weeks = -1;
		this.days = -1;
		this.hours = -1;
		this.minutes = -1;
		this.seconds = -1;
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
	
	public void setYearsTextView(TextView textView)
	{
		this.yearsTextView = textView;
	}
	
	//*****setter date variables methods ***************//
	public void setSeconds(DateTime strtTm,DateTime endTm)
	{
		this.seconds = Seconds.secondsBetween(startTime, endTime).getSeconds();
	}

	public void setMinutes(DateTime strtTm,DateTime endTm)
	{
		this.minutes = Minutes.minutesBetween(startTime, endTime).getMinutes();
	}
	
	public void setHours(DateTime strtTm,DateTime endTm)
	{
		this.hours = Hours.hoursBetween(startTime, endTime).getHours();
	}
	
	public void setDays(DateTime strtTm,DateTime endTm)
	{
		this.days = Days.daysBetween(startTime, endTime).getDays();
	}
	
	public void setWeeks(DateTime strtTm,DateTime endTm)
	{
		this.weeks = Weeks.weeksBetween(startTime, endTime).getWeeks();
	}
	
	public void setMonths(DateTime strtTm,DateTime endTm)
	{
		this.months = Months.monthsBetween(startTime, endTime).getMonths();
	}
	
	public void setYears(DateTime strtTm,DateTime endTm)
	{
		this.years = Years.yearsBetween(startTime, endTime).getYears();
	}
	
	//setter methods for start/end time
	public void setStartTime(int startYear,int startMonth,int startDay)
	{
		this.startTime = new DateTime(startYear,startMonth,startDay,0,0,0,0);
	}
	
	public void setEndTime(int endYear, int endMonth, int endDay)
	{
		this.endTime = new DateTime(endYear,endMonth,endDay,0,0,0,0);
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
