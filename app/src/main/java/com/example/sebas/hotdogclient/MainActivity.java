package com.example.sebas.hotdogclient;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GRAY;

public class MainActivity extends AppCompatActivity {

    private TextView mHotdogPrice;
    private TextView mBbqSaucePrice;
    private TextView mKetchupPrice;
    private TextView mMayonnaisePrice;
    private TextView mCurryPrice;
    private TextView mOnionPrice;
    private TextView mCheesePrice;

    private ImageView mBbqSauce;
    private ImageView mKetchup;
    private ImageView mMayonnaise;
    private ImageView mCurry;
    private ImageView mOnion;
    private ImageView mCheese;

    private TextView mPrice;
    private ImageButton mOrder;

    private String mIsHotDog;
    private boolean mIsBbqSauce;
    private boolean mIsKetchup;
    private boolean mIsMayonnaise;
    private boolean mIsCurry;
    private boolean mIsOnion;
    private boolean mIsCheese;

    private double mTotalPrice;
    private double mAdditionalPrice;
    private int mCounter = 0;
    private double mDiscount;


    private double hotdogPrice = 2.00;            //vorläufige Double-Werte bis Verbindung zur Datenbank hergestellt
    private double bbqSaucePrice = 0.40;
    private double ketchupPrice = 0.60;
    private double mayonnaisePrice = 0.70;
    private double curryPrice = 0.50;
    private double onionPrice = 0.30;
    private double cheesePrice = 0.40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mHotdogPrice = (TextView) findViewById(R.id.hotdog_price);
        mHotdogPrice.setText(String.format("%.2f", hotdogPrice)+ " €");

        mBbqSaucePrice = (TextView) findViewById(R.id.bbq_sauce_price);
        mBbqSaucePrice.setText("+ "+ String.format("%.2f", bbqSaucePrice)+ " €");

        mKetchupPrice = (TextView) findViewById(R.id.ketchup_price);
        mKetchupPrice.setText("+ "+ String.format("%.2f", ketchupPrice)+ " €");

        mMayonnaisePrice = (TextView) findViewById(R.id.mayonnaise_price);
        mMayonnaisePrice.setText("+ "+ String.format("%.2f", mayonnaisePrice)+ " €");

        mCurryPrice = (TextView) findViewById(R.id.curry_price);
        mCurryPrice.setText("+ "+ String.format("%.2f", curryPrice)+ " €");

        mOnionPrice = (TextView) findViewById(R.id.onion_price);
        mOnionPrice.setText("+ "+ String.format("%.2f", onionPrice)+ " €");

        mCheesePrice = (TextView) findViewById(R.id.cheese_price);
        mCheesePrice.setText("+ "+ String.format("%.2f", cheesePrice)+ " €");

        mBbqSauce = (ImageView) findViewById(R.id.bbq_sauce);
        mKetchup = (ImageView) findViewById(R.id.ketchup);
        mMayonnaise = (ImageView) findViewById(R.id.mayonnaise);
        mCurry = (ImageView) findViewById(R.id.curry);
        mOnion = (ImageView) findViewById(R.id.onion);
        mCheese = (ImageView) findViewById(R.id.cheese);

        mPrice = (TextView) findViewById(R.id.price);
        mOrder = (ImageButton) findViewById(R.id.order);

        mTotalPrice = 0;
        mAdditionalPrice = 0;
        mDiscount = 0;
        mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");

        mBbqSauce.setClickable(true);
        mBbqSauce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBbqSauce.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.baseline_star_border_black_24).getConstantState()) {
                    mBbqSauce.setImageResource(R.drawable.ic_star_orange_24dp);
                    mIsBbqSauce = true;
                    mBbqSaucePrice.setTextColor(BLACK);
                    mAdditionalPrice = mAdditionalPrice + bbqSaucePrice;
                    mCounter = mCounter +1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }else {
                    mBbqSauce.setImageResource(R.drawable.baseline_star_border_black_24);
                    mIsBbqSauce = false;
                    mBbqSaucePrice.setTextColor(GRAY);
                    mAdditionalPrice = mAdditionalPrice - bbqSaucePrice;
                    mCounter = mCounter - 1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }
            }
        });
        mKetchup.setClickable(true);
        mKetchup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mKetchup.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.baseline_star_border_black_24).getConstantState()) {
                    mKetchup.setImageResource(R.drawable.ic_star_orange_24dp);
                    mIsKetchup = true;
                    mKetchupPrice.setTextColor(BLACK);
                    mAdditionalPrice = mAdditionalPrice + ketchupPrice;
                    mCounter = mCounter +1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }else {
                    mKetchup.setImageResource(R.drawable.baseline_star_border_black_24);
                    mIsKetchup = false;
                    mKetchupPrice.setTextColor(GRAY);
                    mAdditionalPrice = mAdditionalPrice - ketchupPrice;
                    mCounter = mCounter -1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }
            }
        });

        mCurry.setClickable(true);
        mCurry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurry.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.baseline_star_border_black_24).getConstantState()) {
                    mCurry.setImageResource(R.drawable.ic_star_orange_24dp);
                    mIsCurry = true;
                    mCurryPrice.setTextColor(BLACK);
                    mAdditionalPrice = mAdditionalPrice + curryPrice;
                    mCounter = mCounter +1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;

                }else {
                    mCurry.setImageResource(R.drawable.baseline_star_border_black_24);
                    mIsCurry = false;
                    mCurryPrice.setTextColor(GRAY);
                    mAdditionalPrice = mAdditionalPrice - curryPrice;
                    mCounter = mCounter -1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }
            }
        });
        mMayonnaise.setClickable(true);
        mMayonnaise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMayonnaise.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.baseline_star_border_black_24).getConstantState()) {
                    mMayonnaise.setImageResource(R.drawable.ic_star_orange_24dp);
                    mIsMayonnaise = true;
                    mMayonnaisePrice.setTextColor(BLACK);
                    mAdditionalPrice = mAdditionalPrice + mayonnaisePrice;
                    mCounter = mCounter +1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }else {
                    mMayonnaise.setImageResource(R.drawable.baseline_star_border_black_24);
                    mIsMayonnaise = false;
                    mMayonnaisePrice.setTextColor(GRAY);
                    mAdditionalPrice = mAdditionalPrice - mayonnaisePrice;
                    mCounter = mCounter -1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }
            }
        });
        mOnion.setClickable(true);
        mOnion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnion.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.baseline_star_border_black_24).getConstantState()) {
                    mOnion.setImageResource(R.drawable.ic_star_orange_24dp);
                    mIsOnion = true;
                    mOnionPrice.setTextColor(BLACK);
                    mAdditionalPrice = mAdditionalPrice + onionPrice;
                    mCounter = mCounter +1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }else {
                    mOnion.setImageResource(R.drawable.baseline_star_border_black_24);
                    mIsOnion = false;
                    mOnionPrice.setTextColor(GRAY);
                    mAdditionalPrice = mAdditionalPrice - onionPrice;
                    mCounter = mCounter -1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }
            }
        });
        mCheese.setClickable(true);
        mCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCheese.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.baseline_star_border_black_24).getConstantState()) {
                    mCheese.setImageResource(R.drawable.ic_star_orange_24dp);
                    mIsCheese = true;
                    mCheesePrice.setTextColor(BLACK);
                    mAdditionalPrice = mAdditionalPrice + cheesePrice;
                    mCounter = mCounter +1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }else {
                    mCheese.setImageResource(R.drawable.baseline_star_border_black_24);
                    mIsCheese = false;
                    mCheesePrice.setTextColor(GRAY);
                    mAdditionalPrice = mAdditionalPrice - cheesePrice;
                    mCounter = mCounter -1;
                    if  (mCounter== 1) {
                        mDiscount = 0.10;
                    }else if (mCounter== 2){
                        mDiscount = 0.20;
                    }else if (mCounter== 3){
                        mDiscount = 0.30;
                    }else if (mCounter== 4){
                        mDiscount = 0.40;
                    }else if (mCounter>= 5){
                        mDiscount = 0.50;
                    }
                    mPrice.setText(String.format(" " +"%.2f", hotdogPrice)+ " € + " +String.format("%.2f", mAdditionalPrice)+  " € \n-" +String.format("%.2f", mAdditionalPrice) + " € x " + mDiscount + " % (Rabatt) " +"=      " + String.format("%.2f",hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount) +" €");
                    mTotalPrice = hotdogPrice + mAdditionalPrice - mAdditionalPrice *mDiscount;
                }
            }
        });

        mOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                HotDogItem hotDogItem = new HotDogItem();
                hotDogItem.setHotdog(mIsHotDog);
                hotDogItem.setBbqSauce(mIsBbqSauce);
                hotDogItem.setKetchup(mIsKetchup);
                hotDogItem.setMayonnaise(mIsMayonnaise);
                hotDogItem.setCurry(mIsCurry);
                hotDogItem.setOnion(mIsOnion);
                hotDogItem.setCheese(mIsCheese);
                hotDogItem.setTotalPrice(mTotalPrice);

                showOrderConfirmationDialog();

            }
        });
    }


    private void showOrderConfirmationDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.order_dialog_msg);
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Toast.makeText(MainActivity.this, String.format("%.2f",mTotalPrice) + " €",
                        Toast.LENGTH_LONG).show();

            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
