package com.JoyTrav.utils;

import com.JoyTrav.model.Group;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConvertObject {

    public Group convertToGroup(String groupAge) {
        switch (groupAge) {
            case "Adult" :
                return Group.ADULTS;
            case "Child" :
                return Group.CHILDREN;
            case "Toddler" :
                return Group.TODDLERS;
        }

        return Group.INFANTS;
    }

    public SimpleDateFormat covertStringToDate() {

        return new SimpleDateFormat("dd/MM/yyyy");
    }

    public double convertSaleValue(String sale) {
        if(!sale.equals("none")) {
            return (double) (100 - Integer.parseInt(sale)) /100;
        }

        return 0;
    }
}
