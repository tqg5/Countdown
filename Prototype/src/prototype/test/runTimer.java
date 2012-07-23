package prototype.test;

import org.joda.time.DateTime;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

public class runTimer extends Activity {
	
	private AsyncTimer timer;
	
	int startYear = 0;
	int startMonth = 0;
	int startDay = 0;
	
	int endYear = 0;
	int endMonth = 0;
	int endDay = 0;
	
	//text views
	private TextView startDateTextView = null;
	private TextView endDateTextView = null;
	
	//text views that are passed into the timer
	private TextView secondsTextView;
	private TextView minutesTextView;
	private TextView hoursTextView;
	private TextView daysTextView;
	private TextView weeksTextView;
	private TextView monthsTextView;
	private TextView yearsTextView;
	
	private boolean startDateHasBeenSet = false;
	private boolean endDateHasBeenSet = false;
	
	//date buttons
	private Button setStartDate;
	private Button setEndDate;
	
	//init checkboxes
	private CheckBox secondsCheckbox;
	private CheckBox minutesCheckbox;
	private CheckBox hoursCheckbox;
	private CheckBox daysCheckbox;
	private CheckBox weeksCheckbox;
	private CheckBox monthsCheckbox;
	private CheckBox yearsCheckbox;
	
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
        setContentView(R.layout.run_timer);
        
        //initialize buttons
        this.setStartDate = (Button) findViewById(R.id.chooseStartDate);
        this.setEndDate = (Button) findViewById(R.id.chooseEndDate);
        
        //add a click listener to the buttons
        this.setStartDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(START_DATE_DIALOG_ID);
            }
        });
        
        this.setEndDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(END_DATE_DIALOG_ID);
            }
        });
        
        this.startDateTextView = (TextView) findViewById(R.id.startDateValue);
        this.endDateTextView = (TextView) findViewById(R.id.endDateValue);
        
        //init checkboxes
        this.secondsCheckbox = (CheckBox) findViewById(R.id.secondsCheckbox);
        this.minutesCheckbox = (CheckBox) findViewById(R.id.minutesCheckbox);
        this.hoursCheckbox = (CheckBox) findViewById(R.id.hoursCheckbox);
        this.daysCheckbox = (CheckBox) findViewById(R.id.daysCheckbox);
        this.weeksCheckbox = (CheckBox) findViewById(R.id.weeksCheckbox);
        this.monthsCheckbox = (CheckBox) findViewById(R.id.monthsCheckbox);
        this.yearsCheckbox = (CheckBox) findViewById(R.id.yearsCheckbox);
        
        //init Text Views that are passed to the Timer
        this.secondsTextView = (TextView) findViewById(R.id.secondsTextView);
        this.minutesTextView = (TextView) findViewById(R.id.minutesTextView);
        this.hoursTextView = (TextView) findViewById(R.id.hoursTextView);
        this.daysTextView = (TextView) findViewById(R.id.daysTextView);
        this.weeksTextView = (TextView) findViewById(R.id.weeksTextView);
        this.monthsTextView = (TextView) findViewById(R.id.monthsTextView);
        this.yearsTextView = (TextView) findViewById(R.id.yearsTextView);
        
        //hide Text Views that are passed to the Timer
        this.secondsTextView.setVisibility(View.GONE);
        this.minutesTextView.setVisibility(View.GONE);
        this.hoursTextView.setVisibility(View.GONE);
        this.daysTextView.setVisibility(View.GONE);
        this.weeksTextView.setVisibility(View.GONE);
        this.monthsTextView.setVisibility(View.GONE);
        this.yearsTextView.setVisibility(View.GONE);
        
        //init timer
        this.timer = new AsyncTimer();
	}
	
	private void setTimerProperties()
	{
		DateTime startTime = new DateTime(this.startYear,this.startMonth,this.startDay,0,0,0,0);
		DateTime endTime = new DateTime(this.endYear,this.endMonth,this.endDay,0,0,0,0);
		
		this.timer.setStartTime(startTime);
		this.timer.setEndTime(endTime);
		
		if(this.secondsCheckbox.isChecked())
		{
			this.timer.setSeconds(startTime, endTime);
			this.secondsTextView.setVisibility(View.VISIBLE);
			this.timer.setSecondsTextView(this.secondsTextView);
		}
		if(this.minutesCheckbox.isChecked())
		{
			this.timer.setMinutes(startTime, endTime);
			this.minutesTextView.setVisibility(View.VISIBLE);
			this.timer.setMinutesTextView(this.minutesTextView);
		}
		if(this.hoursCheckbox.isChecked())
		{
			this.timer.setHours(startTime, endTime);
			this.hoursTextView.setVisibility(View.VISIBLE);
			this.timer.setHoursTextView(this.hoursTextView);
		}
		if(this.daysCheckbox.isChecked())
		{
			this.timer.setDays(startTime, endTime);
			this.daysTextView.setVisibility(View.VISIBLE);
			this.timer.setDaysTextView(this.daysTextView);
		}
		if(this.weeksCheckbox.isChecked())
		{
			this.timer.setWeeks(startTime, endTime);
			this.weeksTextView.setVisibility(View.VISIBLE);
			this.timer.setWeeksTextView(this.weeksTextView);
		}
		if(this.monthsCheckbox.isChecked())
		{
			this.timer.setMonths(startTime, endTime);
			this.monthsTextView.setVisibility(View.VISIBLE);
			this.timer.setMonthsTextView(this.monthsTextView);
		}
		if(this.yearsCheckbox.isChecked())
		{
			this.timer.setYears(startTime, endTime);
			this.yearsTextView.setVisibility(View.VISIBLE);
			this.timer.setYearsTextView(this.yearsTextView);
		}
		
	}
	
	private void updateDisplay(int dialog_int)
	{
		switch(dialog_int)
		{
			case START_DATE_DIALOG_ID:
				this.startDateTextView.setText(new StringBuilder()
				.append(Integer.toString(this.startYear)).append("-")
				.append(Integer.toString(this.startMonth)).append("-")
				.append(Integer.toString(this.startDay)));
				this.startDateHasBeenSet = true;
				
				break;
				
			case END_DATE_DIALOG_ID:
				this.endDateTextView.setText(new StringBuilder()
				.append(Integer.toString(this.endYear)).append("-")
				.append(Integer.toString(this.endMonth)).append("-")
				.append(Integer.toString(this.endDay)));
				this.endDateHasBeenSet = true;
				
				if(this.startDateHasBeenSet && this.endDateHasBeenSet)
				{
					setTimerProperties();
					timer.execute(null);
				}
				break;
				
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
}