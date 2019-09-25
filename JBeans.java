package com.company;

public class JBeans {

    private int num =99;
    private double d = 3.3;


    public void setD(double d) {
        this.d = d;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getD() {
        return d;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return num + "; " + d + "; ";
    }
}
