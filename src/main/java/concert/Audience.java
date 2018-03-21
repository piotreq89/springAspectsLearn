package concert;

import org.aspectj.lang.annotation.*;

/**
 * Created on 08.03.2018.
 */

//klasa Audience jest zwykłą klasą Javy która po zastosowaniu kilku adnotacji stała się aspektem

@Aspect
public class Audience {


    @Before("execution(** concert.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("Widzowie wyłączają telefony");
    }

    @Before("execution(** concert.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Widzowie siadaja");
    }

    @AfterReturning("execution(** concertPerformance.perform(..))")
    public void applause(){
        System.out.println("Brawoo oklaski jea");
    }

    @AfterThrowing("execution(** concert.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("Eeee! Oddawać kase shit");
    }

    // można też tak

    @Pointcut("execution(** concert.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void applauseBefore(){
        System.out.println("Applause przed występem pokazanie punktu przeciecia przez @Pointcut");
    }

}
