package com.galvanize.playground.math;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
public class MathService {
    private String operation;
    private String x;
    private String y;
    private MultiValueMap<String, String> sumMap;
    public MathService(){

    }
    public MathService(String op, String xVal, String yVal){
        operation = op;
        x = xVal;
        y = yVal;
    }

    public MathService(MultiValueMap<String, String> queryMap){
        sumMap = queryMap;
    }

    public String doOperation(){
        int xValue = Integer.parseInt(x);
        int yValue = Integer.parseInt(y);
        int toReturn;
        switch(operation){
            case "add":
                toReturn=xValue+yValue;
                return String.format("%s + %s = %s",xValue, yValue, toReturn);
            case "subtract":
                toReturn = xValue-yValue;
                return String.format("%s - %s = %s",xValue, yValue, toReturn);
            case "multiply":
                toReturn = xValue*yValue;
                return String.format("%s * %s = %s",xValue, yValue, toReturn);
            case "divide":
                if(yValue==0){
                    return "ERROR - DIVIDE BY 0";
                }
                toReturn = xValue/yValue;
                return String.format("%s / %s = %s", xValue, yValue, toReturn);

        }
        return "invalid operator";

    }
    public String doSum(){
        int sum=0;
        List<String> list1 = sumMap.get("n");
        for(String str : list1){

            String current = ""+str;
            sum = sum+Integer.parseInt(current);
        }
        return "" + sum;
    }
}
