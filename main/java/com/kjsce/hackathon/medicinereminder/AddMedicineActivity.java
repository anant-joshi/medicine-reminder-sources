package com.kjsce.hackathon.medicinereminder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.kjsce.hackathon.medicinereminder.medicine.Medicine;

public class AddMedicineActivity extends AppCompatActivity {

    CheckBox bfBox, lunchBox, dinnerBox;

    RadioButton bfBoxBefore, bfBoxAfter;
    RadioButton lunchBoxBefore, lunchBoxAfter;
    RadioButton dinnerBoxBefore, dinnerBoxAfter;

    Button sunBut, monBut, tueBut, wenBut, thuBut, friBut, satBut;

    EditText medicineName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showAsPopup(this);
        setContentView(R.layout.activity_add_medicine);

        if(getSupportActionBar() != null)
            getSupportActionBar().setTitle("Add Medicine");

        initializeFields();
        setTagsToFalse();
        setCheckBoxListeners();
        setRadioButtonListeners();
        setButtonClickListeners();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_medicine_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Medicine m = getMedicineFromFields();
                DatabaseHelper helper = new DatabaseHelper(this);
                if(m != null) helper.addEntry(m);
                clearFields();
                break;
            case R.id.menu_done:
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void clearFields() {
        setContentView(R.layout.activity_add_medicine);
        initializeFields();
        setTagsToFalse();
        setCheckBoxListeners();
        setRadioButtonListeners();
        setButtonClickListeners();
        //HACK
        clearButtons();
    }

    //HACK
    private void clearButtons() {
        GradientDrawable bgShape;
        bgShape = (GradientDrawable) sunBut.getBackground();
        bgShape.setColor(0xFFFAFAFA);
        sunBut.setTag(false);
        bgShape = (GradientDrawable) monBut.getBackground();
        bgShape.setColor(0xFFFAFAFA);
        monBut.setTag(false);
        bgShape = (GradientDrawable) tueBut.getBackground();
        bgShape.setColor(0xFFFAFAFA);
        thuBut.setTag(false);
        bgShape = (GradientDrawable) wenBut.getBackground();
        bgShape.setColor(0xFFFAFAFA);
        wenBut.setTag(false);
        bgShape = (GradientDrawable) thuBut.getBackground();
        bgShape.setColor(0xFFFAFAFA);
        thuBut.setTag(false);
        bgShape = (GradientDrawable) friBut.getBackground();
        bgShape.setColor(0xFFFAFAFA);
        friBut.setTag(false);
        bgShape = (GradientDrawable) satBut.getBackground();
        bgShape.setColor(0xFFFAFAFA);
        satBut.setTag(false);
    }

    private Medicine getMedicineFromFields() {
        Medicine m = new Medicine();

        m.setName(medicineName.getText().toString());

        if((boolean) bfBox.getTag())
            if((boolean) bfBoxAfter.getTag())
                m.setBreakfast(1);
            else m.setBreakfast(-1);
        else m.setBreakfast(0);

        if((boolean) lunchBox.getTag())
            if((boolean) lunchBoxAfter.getTag())
                m.setLunch(1);
            else m.setLunch(-1);
        else m.setLunch(0);

        if((boolean) dinnerBox.getTag())
            if((boolean) dinnerBoxAfter.getTag())
                m.setLunch(1);
            else m.setLunch(-1);
        else m.setLunch(0);

        boolean[] weekDays = new boolean[7];
        weekDays[0] = (boolean) sunBut.getTag();
        weekDays[1] = (boolean) monBut.getTag();
        weekDays[2] = (boolean) tueBut.getTag();
        weekDays[3] = (boolean) wenBut.getTag();
        weekDays[4] = (boolean) thuBut.getTag();
        weekDays[5] = (boolean) friBut.getTag();
        weekDays[6] = (boolean) satBut.getTag();

        m.setDaysOfWeek(weekDays);

        return m;
    }

    private void setTagsToFalse() {
        bfBox.setTag(false);
        lunchBox.setTag(false);
        dinnerBox.setTag(false);

        bfBoxBefore.setTag(false);
        bfBoxAfter.setTag(false);

        lunchBoxBefore.setTag(false);
        lunchBoxAfter.setTag(false);

        dinnerBoxBefore.setTag(false);
        dinnerBoxAfter.setTag(false);

        sunBut.setTag(false);
        monBut.setTag(false);
        tueBut.setTag(false);
        wenBut.setTag(false);
        thuBut.setTag(false);
        friBut.setTag(false);
        satBut.setTag(false);
    }

    private void setButtonClickListeners() {
        sunBut.setOnClickListener(getButtonListeners());
        monBut.setOnClickListener(getButtonListeners());
        tueBut.setOnClickListener(getButtonListeners());
        wenBut.setOnClickListener(getButtonListeners());
        thuBut.setOnClickListener(getButtonListeners());
        friBut.setOnClickListener(getButtonListeners());
        satBut.setOnClickListener(getButtonListeners());
    }

    private void setRadioButtonListeners() {
        bfBoxBefore.setOnCheckedChangeListener(getRadioButtonListener(bfBoxAfter));
        bfBoxAfter.setOnCheckedChangeListener(getRadioButtonListener(bfBoxBefore));
        lunchBoxBefore.setOnCheckedChangeListener(getRadioButtonListener(lunchBoxAfter));
        lunchBoxAfter.setOnCheckedChangeListener(getRadioButtonListener(lunchBoxBefore));
        dinnerBoxBefore.setOnCheckedChangeListener(getRadioButtonListener(dinnerBoxAfter));
        dinnerBoxAfter.setOnCheckedChangeListener(getRadioButtonListener(dinnerBoxBefore));
    }

    private void setCheckBoxListeners() {
        bfBox.setOnCheckedChangeListener(getCheckBoxListener(bfBoxBefore, bfBoxAfter));
        lunchBox.setOnCheckedChangeListener(getCheckBoxListener(lunchBoxBefore, lunchBoxAfter));
        dinnerBox.setOnCheckedChangeListener(getCheckBoxListener(dinnerBoxBefore, dinnerBoxAfter));
    }

    private RadioButton.OnCheckedChangeListener getRadioButtonListener(final RadioButton other){
        return new RadioButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    buttonView.setTag(true);
                    other.setChecked(false);
                    other.setTag(false);
                }
            }
        };
    }

    private Button.OnClickListener getButtonListeners(){
        return new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                GradientDrawable bgShape = (GradientDrawable) v.getBackground();
                if((boolean) v.getTag()){
                    bgShape.setColor(0xFFFAFAFA);
                    v.setTag(false);
                }
                else{
                    bgShape.setColor(0xFF4CAF50);
                    v.setTag(true);
                }
            }
        };
    }

    private CheckBox.OnCheckedChangeListener getCheckBoxListener
            (final RadioButton before, final RadioButton after){
        return new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    before.setEnabled(true);
                    after.setEnabled(true);
                    buttonView.setTag(true);
                }
                else {
                    before.setEnabled(false);
                    after.setEnabled(false);
                    buttonView.setTag(false);
                }
            }
        };

    }

    private void initializeFields() {

        medicineName = (EditText) findViewById(R.id.med_name);

        bfBox = (CheckBox) findViewById(R.id.bf_box);
        lunchBox = (CheckBox) findViewById(R.id.lunch_box);
        dinnerBox = (CheckBox) findViewById(R.id.dinner_box);

        bfBoxBefore = (RadioButton) findViewById(R.id.bf_box_before);
        bfBoxAfter = (RadioButton) findViewById(R.id.bf_box_after);

        lunchBoxBefore = (RadioButton) findViewById(R.id.lunch_box_before);
        lunchBoxAfter = (RadioButton) findViewById(R.id.lunch_box_after);

        dinnerBoxBefore = (RadioButton) findViewById(R.id.dinner_box_before);
        dinnerBoxAfter = (RadioButton) findViewById(R.id.dinner_box_after);

        sunBut = (Button) findViewById(R.id.sunday_button);
        monBut = (Button) findViewById(R.id.monday_button);
        tueBut = (Button) findViewById(R.id.tuesday_button);
        wenBut = (Button) findViewById(R.id.wednesday_button);
        thuBut = (Button) findViewById(R.id.thursday_button);
        friBut = (Button) findViewById(R.id.friday_button);
        satBut = (Button) findViewById(R.id.saturday_button);
    }

    private void showAsPopup(Activity activity) {

        activity.requestWindowFeature(Window.FEATURE_ACTION_BAR);

        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.alpha = 1.0f;
        params.dimAmount = 0.5f;

        activity.getWindow().setAttributes(params);

        Point size = new Point();

        Display display = activity.getWindowManager().getDefaultDisplay();
        display.getSize(size);

        int width = size.x;
        int height = size.y;

        if (height > width) {
            activity.getWindow().setLayout((int) (width * .9), LinearLayout.LayoutParams.WRAP_CONTENT);
        } else {
            activity.getWindow().setLayout((int) (width * .7), LinearLayout.LayoutParams.WRAP_CONTENT);
        }
    }
}
