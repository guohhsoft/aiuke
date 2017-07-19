package czxy.aiuke.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.aiuke.entity.aiuke;
import czxy.aiuke.service.service;
import czxy.aiuke.util.NoteResult;

@Controller
public class messagecontroller { 

	@Resource(name="service")
	private service service;
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult<List<aiuke>> search(String name){
		NoteResult<List<aiuke>> res = service.search(name);
		return res;
	}
	//保存
	@RequestMapping("/save.do")
	@ResponseBody
	public NoteResult<String> save(String singname,String singer,String addr,String beizhu){
		NoteResult<String> res = service.save(singname, singer, addr, beizhu);
		return res;
		
	}
}
