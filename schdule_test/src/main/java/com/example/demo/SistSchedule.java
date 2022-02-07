package com.example.demo;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SistSchedule {
	
  @Scheduled(fixedRate=10000)
  public void por() {
	 System.out.println("콜! 콜!");
  }
  
  //매일 오전 9시 31분에 동작함
  //연도는 생략가능함
  @Scheduled(cron = "0 31 9 * * ? ")
  public void pro2() {
	  System.out.println("pro2");
  }
  
  //매월 7일 9시 37분에 hello출력
  @Scheduled(cron ="0 38 9 7 * ?" )
  public void pro3() {
	  System.out.println("hello");
  }
 
}