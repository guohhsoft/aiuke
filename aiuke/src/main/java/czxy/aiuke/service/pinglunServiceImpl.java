package czxy.aiuke.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import czxy.aiuke.dao.pinglundao;
import czxy.aiuke.entity.pinglun;
import czxy.aiuke.util.NoteResult;
import czxy.aiuke.util.NoteUtil;
@Service("pinglunservice")
public class pinglunServiceImpl implements pinglunService{
@Resource
private pinglundao dao;
	public NoteResult<List<pinglun>> search(String addr) {
		NoteResult<List<pinglun>> res = new NoteResult<List<pinglun>>();
		List<pinglun> list = dao.search(addr);
		res.setData(list);
		return res;
	}
	public NoteResult<String> save(String message, String addr, String username) {
		String id = NoteUtil.createId();
		pinglun pl = new pinglun();
		pl.setId(id);
		pl.setMessage(message);
		pl.setUsername(username);
		pl.setAddr(addr);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ss HH:mm:ss");
		String time = sdf.format(date);
		pl.setTime(time);
		int count = dao.save(pl);
		NoteResult<String> res = new NoteResult<String>();
		if(count!=1){
			res.setMsg("保存失败");
		}else{
			res.setMsg("保存成功");
		}
		return res;
	}

}
