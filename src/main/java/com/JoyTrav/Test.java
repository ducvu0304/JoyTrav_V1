package com.JoyTrav;

import com.JoyTrav.utils.ConvertObject;

public class Test {
    public static void main(String[] args) {
        ConvertObject convertObject =  new ConvertObject();

        double sale  = convertObject.convertSaleValue("10");

        System.out.println(sale);
    }
}
