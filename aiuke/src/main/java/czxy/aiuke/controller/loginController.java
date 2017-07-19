package czxy.aiuke.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.aiuke.entity.user;
import czxy.aiuke.service.loginService;
import czxy.aiuke.util.NoteResult;

@Controller
public class loginController {
	@Resource(name="loginService")
	private loginService service;
	@RequestMapping("/user/login.do")
	@ResponseBody
	public NoteResult<user> findByname(String name,String password){
		NoteResult<user> res = service.findByname(name, password);
		return res ;
	}
	@RequestMapping("/user/save.do")
	@ResponseBody
	public NoteResult<String> save(String name,String password,String telephone,String email){
		NoteResult<String> res = service.save(name, password, telephone, email);
		return res ;
	}
	@RequestMapping("/user/update.do")
	@ResponseBody
	public NoteResult<String> update(String name,String password){
		NoteResult<String> res = service.update(name,password);
		return res ;
	}
	@RequestMapping("/user/findByname.do")
	@ResponseBody
	public NoteResult<user> findByname(String name){
		NoteResult<user> res = service.findByname(name);
		return res ;
	}
}
