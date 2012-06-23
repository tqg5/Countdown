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
		
		startYear = sy;
		startMonth = sm;
		startDay = sd;
		
		endYear = ey;
		endMonth = em;
		endDay = ed;
		
		startTime = new DateTime(startYear,startMonth,startDay,0,0,0,0);
		endTime = new DateTime(endYear,endMonth,endDay,0,0,0,0);
		
		startDateTextView = textViewArray[0];
		endDateTextView = textViewArray[1];
		yearsTextView = textViewArray[2];
		monthsTextView = textViewArray[3];
		weeksTextView = textViewArray[4];
		daysTextView = textViewArray[5];
		hoursTextView = textViewArray[6];
		minutesTextView = textViewArray[7];
		secondsTextView = textViewArray[8];
		
		years = Years.yearsBetween(startTime, endTime).getYears();
		months = Months.monthsBetween(startTime, endTime).getMonths();
		weeks = Weeks.weeksBetween(startTime, endTime).getWeeks();
		days = Days.daysBetween(startTime, endTime).getDays();
		hours = Hours.hoursBetween(startTime, endTime).getHours();
		minutes = Minutes.minutesBetween(startTime, endTime).getMinutes();
		seconds = Seconds.secondsBetween(startTime, endTime).getSeconds();
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
