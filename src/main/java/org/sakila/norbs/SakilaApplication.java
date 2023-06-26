package org.sakila.norbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public abstract class SakilaApplication {
    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            MyThread runnable = new MyThread(i);
            Thread thread2 = new Thread(runnable);
            thread2.start();
        }




   /*     List<BigDecimal> bigDecimalList = Arrays.asList(
                BigDecimal.valueOf(-218.07),
                BigDecimal.valueOf(-214.73),
                BigDecimal.valueOf(-221.77),
                BigDecimal.valueOf(-467.14),
                BigDecimal.valueOf(-258.73),
                BigDecimal.valueOf(-384.32)
        );

        BigDecimal total = bigDecimalList.stream().reduce(BigDecimal.ZERO,BigDecimal::add);

        System.out.println(total);*/


    /*    BigDecimal[][] bigDecimals = {
                {BigDecimal.valueOf(15.00), BigDecimal.valueOf(93.45)},
                {BigDecimal.valueOf(-16.50), BigDecimal.valueOf(-102.80)},
                {BigDecimal.valueOf(35.00), BigDecimal.valueOf(218.05)}
        };


        BigDecimal totals = Arrays.stream(bigDecimals).map(x-> {
            BigDecimal ret;
            ret = x[1].setScale(2,BigDecimal.ROUND_DOWN);
            System.out.println(ret);
            return ret;
        }).reduce(BigDecimal.ZERO,BigDecimal::add);*/


        SpringApplication.run(SakilaApplication.class, args);

    }


  
}
