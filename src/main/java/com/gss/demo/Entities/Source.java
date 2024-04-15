package com.gss.demo.Entities;

public enum Source {

    MERKEZ_BANKASI(0),
    OTHER(1);

    public int value;
    private Source(int i){
        value = i;
    }

}
