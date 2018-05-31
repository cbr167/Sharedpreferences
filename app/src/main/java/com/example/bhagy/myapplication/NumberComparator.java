package com.example.bhagy.myapplication;

import java.util.Comparator;

/**
 * Created by bhagy on 5/30/2018.
 */

public class NumberComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer integer, Integer t1) {
        return integer-t1;
    }
}
