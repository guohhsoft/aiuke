package czxy.aiuke.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import czxy.aiuke.dao.login;
import czxy.aiuke.entity.user;
import czxy.aiuke.util.NoteResult;
import czxy.aiuke.util.NoteUtil;
@Service("loginService")
public class loginServiceImpl implements loginService{
	@Resource
	private login dao;
	public NoteResult<user> findByname(String name, String password) {
		NoteResult<user> res = new NoteResult<user>();
		user use = dao.findByname(name);
	
		if(use==null){
			res.setStatus(0);
			res.setMsg("账户不存在");
		}else if(use.getPassword().equals(password)){
			res.setStatus(2);
			res.setData(use);
		}else{
			res.setMsg("密码错误");
			res.setStatus(1);
		}
		return res;
	}
	public NoteResult<String> save(String name, String password,
			String telephone, String email) {
		NoteResult<String> res = new NoteResult<String>();
		user us = new user();
		String id = NoteUtil.createId();
		us.setId(id);
		us.setEmail(email);
		us.setName(name);
		us.setTelephone(telephone);
		us.setPassword(password);
		user uuu = dao.findByname(name);
		if(uuu!=null){
			res.setStatus(1);
			res.setMsg("账号存在");
		}else{
			dao.save(us);
			res.setStatus(0);
			res.setMsg("注册成功");
		}
		return res;
	}
	public NoteResult<String> update(String name, String password) {
		NoteResult<String> res = new NoteResult<String>();
		user use = dao.findByname(name);
		use.setPassword(password);
		//use.setTelephone(telephone);
		//use.setEmail(email);
		int count = dao.update(use);
		if(count!=1){
			res.setMsg("更新失败");
		}else{
			res.setMsg("更新成功");
		}
		return res;
	}
	public NoteResult<user> findByname(String name) {
		NoteResult<user> res = new NoteResult<user>();
		user use = dao.findByname(name);
		res.setData(use);
		return res;
	}


}
