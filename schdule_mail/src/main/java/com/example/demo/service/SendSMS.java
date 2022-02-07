package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CardDAO;
import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import kr.co.youiwe.webservice.BitSms;
import lombok.Setter;

@Service
@Setter
public class SendSMS {
	 
	@Autowired
	private MemberDAO dao;	
	
	public void sendSMS() {		 
	 
		List<MemberVO>list =dao.findAll();
	
		BitSms sms = new BitSms();
		
		String from ="01025598279";
		String to ="";
		String msg = "";
		String ampm = "오전";
		
		Date today = new Date();
		int hours = today.getHours();
		if(hours >= 12) {
			ampm="오후";
		}
		
		for(MemberVO m : list) {
			to = m.getPhone();
			msg = m.getName()+"님,"+ampm+"에 코로나 자가진단을 해주세요";
			sms.sendMsg(from, to, msg);
			System.out.println(m.getName()+"에게 메시지를 전송하였습니다.");
		}
		System.out.println("메시지를 모두 전송하였습니다.");
	}
}

	 
 