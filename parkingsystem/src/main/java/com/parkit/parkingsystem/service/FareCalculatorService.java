package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {

    public void calculateFare(Ticket ticket){
        if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }

//        int inHour = ticket.getInTime().getHours();
//        int outHour = ticket.getOutTime().getHours();
//        int duration = outHour - inHour;
        
        
        //TODO: Corréctions efféctuées !!
       // On obtient le temps passé dans le parking en Millis
       double duration = ticket.getOutTime().getTime() - ticket.getInTime().getTime();
       
       //On divise le resultat par 3 600 000 qui equivaut à une heure en Millis afin de le convertir sur une base 1. 
       double difference = duration / 3600000; 

       
//       System.out.print(" Temps passé dans le parking en Millis " + duration + " Heure(s)! " );
//       System.out.print(" Conversion sur une base 1, temps passé sur le parking " + difference + "heure(s)! " );

       
        switch (ticket.getParkingSpot().getParkingType()){
            case CAR: {
                ticket.setPrice(difference * Fare.CAR_RATE_PER_HOUR);
                break;
            }
            case BIKE: {
                ticket.setPrice(difference * Fare.BIKE_RATE_PER_HOUR);
                break;
            }
            default: throw new IllegalArgumentException("Unkown Parking Type");
        }
    }
}