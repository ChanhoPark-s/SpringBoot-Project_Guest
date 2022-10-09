package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MemberBean;
import com.example.demo.model.MemberDao;



@Controller
public class HomeController {
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String goHome(HttpServletRequest request,Model model,HttpSession session) {

		List<MemberBean> list = new ArrayList<MemberBean>();
		list = mdao.getUserList();
		System.out.println("lists size :"+list.size());
		
		MemberBean mb = new MemberBean();
		System.out.println(mb);
		mb.setId("아이디다");
		mb.setName("박찬호다");
		mb.setPw("1234");
		System.out.println(mb);
		model.addAttribute("asd",mb.getId());
		session.setAttribute("id", "123456");
		model.addAttribute("mb",mb);

		return "content/index";
	}
}
