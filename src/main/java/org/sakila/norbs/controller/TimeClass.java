package org.sakila.norbs.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeClass {
    public static void main(String[] args) {
       LocalDateTime generationTime = LocalDateTime.of(2023,2,23,14,39,00);
        LocalDateTime expirationTime = generationTime.plusMinutes(10);
        LocalDateTime now = LocalDateTime.now();


      /*  Long expiryDuration = Duration.between(generationTime,expirationTime).toMillis();
        Long currentTime = Duration.between(generationTime,now).toMillis();*/


       /* Long remainType = expiryDuration - currentTime;
        System.out.println(remainType + " remaining milliseconds");*/

       // long seconds = (remainType / 1000) % 60;
        // long minutes = (remainType / 1000) / 60;


  //    long expTime  = generationTime.until(expirationTime, ChronoUnit.MINUTES);
      Long currentTime  = now.until(expirationTime, ChronoUnit.SECONDS);

        if (Long.valueOf(0)> currentTime) {
            System.out.println("expired");
        }

        System.out.println(currentTime);







    }
}
