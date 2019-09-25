package com.company;

import java.util.Arrays;

class User{
       private long id = 11099L;
       private int i =54;
       private char h = 'd';
       private double d = 1.3;
       private byte[] key={1,2,3};

    public void setId(long id) {
        this.id = id;
    }

    public void setD(double d) {
        this.d = d;
    }

    public void setKey(byte[] key) {
        this.key = key;
    }

    public void setH(char h) {
        this.h = h;
    }

    public void setI(int i) {
        this.i = i;
    }

    public long getId() {
        return id;
    }

    public byte[] getKey() {
        return key;
    }

    public char getH() {
        return h;
    }

    public double getD() {
        return d;
    }

    public int getI() {
        return i;
    }

    public String toString() {
        return id + "; " + i + "; " + h + "; " + d+ "; " + Arrays.toString(key)+ "; " ;
    }
}
