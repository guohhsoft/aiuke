package czxy.aiuke.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.aiuke.entity.pinglun;
import czxy.aiuke.service.pinglunService;
import czxy.aiuke.util.NoteResult;

@Controller
public class pinglunController {
	@Resource(name="pinglunservice")
	private pinglunService service;
	@RequestMapping("/pinglun/search.do")
	@ResponseBody
	public NoteResult<List<pinglun>> search(String addr){
		NoteResult<List<pinglun>> res = service.search(addr);
		return res ;
	}
	@RequestMapping("/pinglun/save.do")
	@ResponseBody
	public NoteResult<String> save(String addr,String message,String username){
		NoteResult<String> res = service.save(message, addr, username);
		return res ;
	}
}
