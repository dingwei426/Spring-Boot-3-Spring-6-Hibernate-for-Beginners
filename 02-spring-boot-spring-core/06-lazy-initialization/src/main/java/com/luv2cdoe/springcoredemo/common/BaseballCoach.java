package com.luv2cdoe.springcoredemo.common;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes in batting practice.";
    }
}
