package com.abigail.burgercaloriecounter;

public class Burger {
    static final int Beef = 100;
    static final int Lamb = 170;
    static final int Ostrich = 150;
    static final int Asiago = 90;
    static final int Creme_Fraiche = 120;
    static final int Prosciutto = 115;

    private int mPattyCal;
    private int mCheeseCal;
    private int mProsciuttoCal;
    private int mSauceCal;

    public Burger(){
        mPattyCal = Beef;
        mCheeseCal = Asiago;
        mProsciuttoCal = 0;
        mSauceCal = 0;
    }

    public void setPattyCalories(int calories){
        mPattyCal = calories;
    }

    public void setCheeseCalories(int calories){
        mCheeseCal = calories;
    }

    public void setProsciuttoCalories(int calories){
        mProsciuttoCal = calories;
    }

    public void clearProsciuttoCalories(){
        mProsciuttoCal = 0;
    }

    public void setSauceCalories(int calories){
        mSauceCal = calories;
    }

    public int getTotalCalories(){
        return mPattyCal + mCheeseCal + mProsciuttoCal + mSauceCal;
    }
}
