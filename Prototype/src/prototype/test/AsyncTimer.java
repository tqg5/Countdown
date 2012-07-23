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
	private int daysCounter = 0;
	private int weeksCounter = 0;
	private int monthsCounter = 0;
	private int yearsCounter = 0;
	
	private TextView startDateTextView;
	private TextView endDateTextView;
	private TextView yearsTextView;
	private TextView monthsTextView;
	private TextView weeksTextView;
	private TextView daysTextView;
	private TextView hoursTextView;
	private TextView minutesTextView;
	private TextView secondsTextView;
		
	public AsyncTimer()
    {	
		//init time variables
		this.startYear = -1;
		this.startMonth = -1;
		this.startDay = -1;
		
		this.endYear = -1;
		this.endMonth = -1;
		this.endDay = -1;
		
		this.startTime = null;
		this.endTime = null;
		
		this.years = -1;
		this.months = -1;
		this.weeks = -1;
		this.days = -1;
		this.hours = -1;
		this.minutes = -1;
		this.seconds = -1;
		
		//init text views
		this.startDateTextView = null;
		this.endDateTextView = null;
		this.yearsTextView = null;
		this.monthsTextView = null;
		this.weeksTextView = null;
		this.daysTextView = null;
		this.hoursTextView = null;
		this.minutesTextView = null;
		this.secondsTextView = null;
	
		//init counters
		this.secondsCounter = 0;
		this.minutesCounter = 0;
		this.hoursCounter = 0;
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
		this.secondsTextView.setText(Integer.toString(this.seconds));
	}
	
	public void setMinutesTextView(TextView textView)
	{
		this.minutesTextView = textView;
		this.minutesTextView.setText(Integer.toString(this.minutes));
	}
	
	public void setHoursTextView(TextView textView)
	{
		this.hoursTextView = textView;
		this.hoursTextView.setText(Integer.toString(this.hours));
	}
	
	public void setDaysTextView(TextView textView)
	{
		this.daysTextView = textView;
		this.daysTextView.setText(Integer.toString(this.days));
	}
	
	public void setWeeksTextView(TextView textView)
	{
		this.weeksTextView = textView;
		this.weeksTextView.setText(Integer.toString(this.weeks));
	}
	
	public void setMonthsTextView(TextView textView)
	{
		this.monthsTextView = textView;
		this.monthsTextView.setText(Integer.toString(this.months));
	}
	
	public void setYearsTextView(TextView textView)
	{
		this.yearsTextView = textView;
		this.yearsTextView.setText(Integer.toString(this.years));
	}
	
	//*****setter date variables methods ***************//
	public void setSeconds(DateTime strtTm,DateTime endTm)
	{
		this.seconds = Seconds.secondsBetween(strtTm, endTm).getSeconds();
	}

	public void setMinutes(DateTime strtTm,DateTime endTm)
	{
		this.minutes = Minutes.minutesBetween(strtTm, endTm).getMinutes();
	}
	
	public void setHours(DateTime strtTm,DateTime endTm)
	{
		this.hours = Hours.hoursBetween(strtTm, endTm).getHours();
	}
	
	public void setDays(DateTime strtTm,DateTime endTm)
	{
		this.days = Days.daysBetween(strtTm, endTm).getDays();
	}
	
	public void setWeeks(DateTime strtTm,DateTime endTm)
	{
		this.weeks = Weeks.weeksBetween(strtTm, endTm).getWeeks();
	}
	
	public void setMonths(DateTime strtTm,DateTime endTm)
	{
		this.months = Months.monthsBetween(strtTm, endTm).getMonths();
	}
	
	public void setYears(DateTime strtTm,DateTime endTm)
	{
		this.years = Years.yearsBetween(strtTm, endTm).getYears();
	}
	
	//setter methods for start/end time
	public void setStartTime(DateTime strtTme)
	{
		this.startTime = strtTme;
	}
	
	public void setEndTime(DateTime endTme)
	{
		this.endTime = endTme;
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
	
	//recalculate time every second
	private void recalculateTime()
	{
		System.out.println("recalculating time");
		//initializes a DateTime variable with the current time
		DateTime currentTime = new DateTime();
		
		DateTime startTime = new DateTime(currentTime.getYear(),currentTime.getMonthOfYear() - 1,currentTime.getDayOfMonth(),
				currentTime.getHourOfDay(),currentTime.getMinuteOfHour(),currentTime.getSecondOfMinute(),0);
		System.out.println("start time: "+startTime);
		System.out.println("end time: "+this.endTime);
		setSeconds(startTime, this.endTime);
		System.out.println("recalculating seconds: "+this.seconds);
		
		setMinutes(startTime, this.endTime);
		setHours(startTime, this.endTime);
		setDays(startTime, this.endTime);
		setWeeks(startTime, this.endTime);
		setMonths(startTime, this.endTime);
		setYears(startTime, this.endTime);
	}

	@Override
	protected Boolean doInBackground(Void... arg0) 
	{
		// TODO Auto-generated method stub
			
		System.out.println("do in background");
		while(true)
		{			
			Duration dur = new Duration(this.startTime,this.endTime);
			
			
			//System.out.println("seconds: "+dur.getStandardSeconds());
			
			recalculateTime();
			this.publishProgress(""+--this.seconds);
			/*
			++this.secondsCounter;
			System.out.println("seconds counter "+this.secondsCounter);
			
			if(this.secondsCounter == 60)
			{
				this.publishProgress(""+--minutes);
				++minutesCounter;
				
				if(this.minutesCounter == 60)
				{
					this.publishProgress(""+--this.hours);
					this.minutesCounter = 0;
					
					++this.hoursCounter;
					if(this.hoursCounter == 24)
					{
						this.publishProgress(""+--this.days);
						this.hoursCounter = 0;
						
						++this.daysCounter;
						if(this.daysCounter == 7)
						{
							this.publishProgress(""+--this.weeks);
							this.daysCounter = 0;
						}
						
					}
				}
					
				secondsCounter = 0;
			}
			*/
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
		//super.onProgressUpdate(progress[0]);
		
		System.out.println("on progress update seconds: "+this.seconds);
		this.secondsTextView.setText(Integer.toString(this.seconds));
		this.minutesTextView.setText(Integer.toString(this.minutes));
	}
	
	@Override
	protected void onCancelled()
	{
		
	}


}
