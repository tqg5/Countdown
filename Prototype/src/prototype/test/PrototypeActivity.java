package prototype.test;
//test commit from eclipse
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Button;

import org.joda.time.*;

import prototype.test.R;
import prototype.test.R.id;
import prototype.test.R.layout;

public class PrototypeActivity extends Activity {
    /** Called when the activity is first created. */
	private AsyncTimer timer;

	private TextView startDateTextView;
	private TextView endDateTextView;
	private TextView yearsTextView;
	private TextView monthsTextView;
	private TextView weeksTextView;
	private TextView daysTextView;
	private TextView hoursTextView;
	private TextView minutesTextView;
	private TextView secondsTextView;
	private Button setStartDate;
	private Button setEndDate;
	
	private int startYear;
	private int startMonth;
	private int startWeek;
	private int startDay;
	private int startHour;
	private int startMinute;
	private int startSecond;
	
	private int endYear;
	private int endMonth;
	private int endWeek;
	private int endDay;
	private int endHour;
	private int endMinute;
	private int endSecond;
	
	
	private boolean startDateHasBeenSet = false;
	private boolean endDateHasBeenSet = false;
	
	TextView[] textViewArray = new TextView[9];
	
	// the callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener startDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
                    startYear = year;
                    startMonth = monthOfYear;
                    startDay = dayOfMonth;
                    updateDisplay(START_DATE_DIALOG_ID);
                }
            };
            
    private DatePickerDialog.OnDateSetListener endDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
                    endYear = year;
                    endMonth = monthOfYear;
                    endDay = dayOfMonth;
                    updateDisplay(END_DATE_DIALOG_ID);
                }
            };
	
	static final int START_DATE_DIALOG_ID = 0;
	static final int END_DATE_DIALOG_ID = 1;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        System.out.println("Calculate difference between two dates");
        System.out.println("=================================================================");

        DateTime startDate = new DateTime(2012, 2, 24, 0, 0, 0, 0);
        DateTime endDate = new DateTime();

        Years y = Years.yearsBetween(startDate, endDate);
        Months m = Months.monthsBetween(startDate, endDate);
        Weeks w = Weeks.weeksBetween(startDate, endDate);
        Days d = Days.daysBetween(startDate, endDate);
        Hours h = Hours.hoursBetween(startDate, endDate);
        Minutes min = Minutes.minutesBetween(startDate, endDate);
        Seconds s = Seconds.secondsBetween(startDate, endDate);
        
//        years = y.getYears();
//        months = m.getMonths();
//        weeks = w.getWeeks();
//        days = d.getDays();
//        hours = h.getHours();
//        minutes = min.getMinutes();
//        seconds = s.getSeconds();
        
        //timer = new AsyncTimer();
        //timer.execute(null);
        
        System.out.println("  Difference between " + endDate);
        System.out.println("  and " + startDate + " is " + startDay + " days.");
        
        startDateTextView = (TextView) findViewById(R.id.startDateTextView);
        endDateTextView = (TextView) findViewById(R.id.endDateTextView);
        yearsTextView = (TextView) findViewById(R.id.yearTextView);
        monthsTextView = (TextView) findViewById(R.id.monthsTextView);
        weeksTextView = (TextView) findViewById(R.id.weeksTextView);
        daysTextView = (TextView) findViewById(R.id.daysTextView);
        hoursTextView = (TextView) findViewById(R.id.hoursTextView);
        minutesTextView = (TextView) findViewById(R.id.minutesTextView);
        secondsTextView = (TextView) findViewById(R.id.secondsTextView);
        
        textViewArray[0] = startDateTextView;
        textViewArray[1] = endDateTextView;
        textViewArray[2] = yearsTextView;
        textViewArray[3] = monthsTextView;
        textViewArray[4] = weeksTextView;
        textViewArray[5] = daysTextView;
        textViewArray[6] = hoursTextView;
        textViewArray[7] = minutesTextView;
        textViewArray[8] = secondsTextView;
        
        setStartDate = (Button) findViewById(R.id.setStartDateButton);
        setEndDate = (Button) findViewById(R.id.setEndDateButton);
        
     // add a click listener to the button
        setStartDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(START_DATE_DIALOG_ID);
            }
        });
        
        setEndDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(END_DATE_DIALOG_ID);
            }
        });
        
//        yearsTextView.setText(Integer.toString(years));
//        monthsTextView.setText(Integer.toString(months));
//        weeksTextView.setText(Integer.toString(weeks));
//        daysTextView.setText(Integer.toString(days));
//        hoursTextView.setText(Integer.toString(hours));
        
        
    }
    
private void updateDisplay(final int dialog_int)
{
	switch(dialog_int)
	{
		case START_DATE_DIALOG_ID:
			startDateTextView.setText(new StringBuilder()
			.append(Integer.toString(startYear)).append("-")
			.append(Integer.toString(startMonth)).append("-")
			.append(Integer.toString(startDay)));
			startDateHasBeenSet = true;
			
			break;
			
		case END_DATE_DIALOG_ID:
			endDateTextView.setText(new StringBuilder()
			.append(Integer.toString(endYear)).append("-")
			.append(Integer.toString(endMonth)).append("-")
			.append(Integer.toString(endDay)));
			endDateHasBeenSet = true;
			
			break;
			
	}
	
	if(startDateHasBeenSet && endDateHasBeenSet)
	{
		DateTime sdt = new DateTime(startYear,startMonth,startDay,0,0,0,0);
		DateTime edt = new DateTime(endYear,endMonth,endDay,0,0,0,0);
		
		int years = Years.yearsBetween(sdt, edt).getYears();
		int months = Months.monthsBetween(sdt, edt).getMonths();
		int weeks = Weeks.weeksBetween(sdt, edt).getWeeks();
		int days = Days.daysBetween(sdt, edt).getDays();
		int hours = Hours.hoursBetween(sdt, edt).getHours();
		int minutes = Minutes.minutesBetween(sdt, edt).getMinutes();
		int seconds = Seconds.secondsBetween(sdt, edt).getSeconds();
		
		yearsTextView.setText(Integer.toString(years));
		monthsTextView.setText(Integer.toString(months));
		weeksTextView.setText(Integer.toString(weeks));
		daysTextView.setText(Integer.toString(days));
		hoursTextView.setText(Integer.toString(hours));
		minutesTextView.setText(Integer.toString(minutes));
		secondsTextView.setText(Integer.toString(seconds));
		
		
		System.out.println("start timer");
		if(timer != null)
		{
			timer.cancel(true);
			timer = null;
		}
		timer = new AsyncTimer(textViewArray, startYear,startMonth,startDay,
				endYear,endMonth,endDay);
		timer.execute(null);
	}
}

@Override
protected Dialog onCreateDialog(int id) 
{
    switch (id) 
    {
    case START_DATE_DIALOG_ID:
        return new DatePickerDialog(this,
                    startDateSetListener,
                    startYear, startMonth, startDay);
    case END_DATE_DIALOG_ID:
    	return new DatePickerDialog(this,
    				endDateSetListener,
    				endYear, endMonth, endDay);
    }
    return null;
}

protected void progressUpdate(String... progress) {
	
	System.out.println("main thread on progress update");
}
//add a button that starts the code in the onResume method here.
//use the various minus methods in the DateTime class to get the
    //countdown affect.
   
    
//@Override
//public void onResume() {
//	super.onResume();
//    setContentView(R.layout.main);
//	
//    while(seconds != 0)
//    {
//    	try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    	--hours;
//    	hoursTextView.setText(Integer.toString(hours));
//    	
//    }
//}
}