package com.example.sabarishnandha.intelligentcheck;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;


public class BusLayoutActivity extends AppCompatActivity {


    private final int NUMBER_OF_SEATS_LEFT_UPPER = 5;
    private final int NUMBER_OF_SEATS_RIGHT_UPPER = 5;
    private final int NUMBER_OF_ROWS_LEFT_UPPER = 1;
    private final int NUMBER_OF_ROWS_RIGHT_UPPER = 2;

    private final int NUMBER_OF_SEATS_LEFT_LOWER = 8;
    private final int NUMBER_OF_SEATS_RIGHT_LOWER = 7;
    private final int NUMBER_OF_ROWS_LEFT_LOWER = 1;
    private final int NUMBER_OF_ROWS_RIGHT_LOWER = 3;

    private Double totatCost = 0.0;
    private int totalSeats = 0;
    private TextView totalPrice;
    private TextView totalBookedSeats;

    private LayoutParams seatParams;
    String selectseats="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);



        RelativeLayout busLayoutUpper = (RelativeLayout) findViewById(R.id.upper_deck);
        RelativeLayout busLayoutBottom = (RelativeLayout) findViewById(R.id.lower_deck);
        totalPrice = (TextView) findViewById(R.id.total_cost);
        totalBookedSeats = (TextView) findViewById(R.id.total_seats);

        // Layout Param for Seats
        seatParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        seatParams.weight = 1;
        seatParams.leftMargin = 5;
        seatParams.rightMargin = 5;

        // Add Bottom Seats
        addLeftSeats(NUMBER_OF_ROWS_LEFT_UPPER, NUMBER_OF_SEATS_LEFT_UPPER, busLayoutBottom);
        addRightSeats(NUMBER_OF_ROWS_RIGHT_UPPER, NUMBER_OF_SEATS_RIGHT_UPPER, busLayoutBottom);

        // Add Upper Seats
        addLeftSeats(NUMBER_OF_ROWS_LEFT_LOWER, NUMBER_OF_SEATS_LEFT_LOWER, busLayoutUpper);
        addRightSeats(NUMBER_OF_ROWS_RIGHT_LOWER, NUMBER_OF_SEATS_RIGHT_LOWER, busLayoutUpper);


    }




    private void addLeftSeats(int numberOfRowsLeft, float nuumberOfSeatsInRow, ViewGroup busLayout) {
        // Adding Left side rows

        int previousRow = 0;

        for (int leftRowCount = 0; leftRowCount < numberOfRowsLeft; leftRowCount++) {

            // Adding Linear layout as row
            LinearLayout LeftRow = new LinearLayout(getApplicationContext());
            LeftRow.setGravity(Gravity.CENTER);
            LeftRow.setId(leftRowCount);

            // Equi distance seats
            LeftRow.setWeightSum(nuumberOfSeatsInRow);

            // if it is first row add row to window
            // else add row below window row (BELOW)
            if (previousRow != leftRowCount) {
                RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                newParams.addRule(RelativeLayout.BELOW, previousRow);
                newParams.setMargins(10, 10, 10, 10);
                LeftRow.setLayoutParams(newParams);

            } else {
                RelativeLayout.LayoutParams leftRowParam = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                leftRowParam.setMargins(10, 10, 10, 10);
                LeftRow.setLayoutParams(leftRowParam);
            }

            // Add Seats in row
            for (int rowCount = 0; rowCount <= nuumberOfSeatsInRow; rowCount++) {

                // Left Upper
                final Seat leftRowSeat = (Seat) LayoutInflater.from(this).inflate(R.layout.seat, null);
                leftRowSeat.setLayoutParams(seatParams);
                leftRowSeat.setSeatNumber("SL " + rowCount);
                leftRowSeat.setGravity(Gravity.CENTER);

                leftRowSeat.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        updateCost(leftRowSeat);

                        Toast.makeText(getApplicationContext(), "seat # " + leftRowSeat.getSeatNumber(), Toast.LENGTH_SHORT).show();
                        selectseats+=" "+leftRowSeat.getSeatNumber();
                    }
                });

                LeftRow.addView(leftRowSeat);

            }

            // add row to bus layout
            busLayout.addView(LeftRow);

            // update row counter
            previousRow = leftRowCount;

        }
    }

    public void bookclick(View v)
    {
        SharedPreferences sp2=getSharedPreferences("sp2",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp2.edit();
        editor.putString("totalseats", totalSeats+"");
        editor.putString("selectseats",selectseats+"");
        editor.commit();
        Intent i2=new Intent(BusLayoutActivity.this,PassengerDetails.class);
        startActivity(i2);

    }





    private void updateCost(final Seat ud_LeftWindowSeat) {

        if (ud_LeftWindowSeat.setSelected()) {

            totatCost += ud_LeftWindowSeat.getSeatPrice();
            ++totalSeats;

        } else {
            totatCost -= ud_LeftWindowSeat.getSeatPrice();
            --totalSeats;
        }

        totalPrice.setText("" + totatCost);
        totalBookedSeats.setText("" + totalSeats);
    }


    private void addRightSeats(int numberOfRowsRight, float numberOfSeatsInRow, ViewGroup busLayout) {
        int previousRow;

        // ADD RIGHT ROWS

        previousRow = 0;

        // Begin adding rows
        for (int rightRowCount = 0; rightRowCount < numberOfRowsRight; rightRowCount++) {

            // Adding Linear layout as row
            LinearLayout rightRow = new LinearLayout(getApplicationContext());
            rightRow.setGravity(Gravity.CENTER);
            rightRow.setId(100 + rightRowCount);

            // make seats equal distance
            rightRow.setWeightSum(numberOfSeatsInRow);

            // if it is first row add row to window (ALIGN_PARENT_BOTTOM)
            // else add row above window row (ABOVE)
            if (previousRow != rightRowCount) {
                RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                newParams.addRule(RelativeLayout.ABOVE, 100 + previousRow);
                newParams.setMargins(10, 10, 10, 10);
                rightRow.setLayoutParams(newParams);

            } else {

                // Layout params for first row (Window seat), adding margin and
                // bottom alignment
                RelativeLayout.LayoutParams rightRowParam = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                rightRowParam.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                rightRowParam.setMargins(10, 10, 10, 10);
                rightRow.setLayoutParams(rightRowParam);
            }

            // Add Seats in row we have added
            for (int rowCount = 0; rowCount <= numberOfSeatsInRow; rowCount++) {

                // Left Upper
                final Seat rightRowSeat = (Seat) LayoutInflater.from(this).inflate(R.layout.seat, null);
                rightRowSeat.setLayoutParams(seatParams);
                rightRowSeat.setSeatNumber("SL" + rowCount);
                rightRowSeat.setGravity(Gravity.CENTER);

                rightRowSeat.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        updateCost(rightRowSeat);

                        Toast.makeText(getApplicationContext(), "seat # " + rightRowSeat.getSeatNumber(), Toast.LENGTH_SHORT).show();
                        selectseats+=" "+rightRowSeat.getSeatNumber();
                    }
                });

                // add seat to row
                rightRow.addView(rightRowSeat);

            }

            // and then add row to bus layout
            busLayout.addView(rightRow);

            // update row counter
            previousRow = rightRowCount;

        }
    }

}




class Seat extends android.support.v7.widget.AppCompatTextView {

    public Seat(Context context) {
        super(context);

    }

    public Seat(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public Seat(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    private String seatNumber;
    private Boolean isSelected = false;
    private Boolean isWomen = false;
    private Double seatPrice = 670.00;

    public Boolean getIsWomen() {
        return isWomen;
    }

    public void setIsWomen(Boolean isWomen) {
        this.isWomen = isWomen;
    }

    public Double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(Double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public Boolean setSelected() {

        this.isSelected = !this.isSelected;

        if (getIsSelected()) {
            setBackgroundColor(0xff99cc00);

        } else {
            setBackgroundColor(0xff33b5e5);

        }

        return isSelected;

    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;

        setText(seatNumber);
    }

}


