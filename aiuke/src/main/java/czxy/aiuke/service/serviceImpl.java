package czxy.aiuke.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import czxy.aiuke.dao.messageDao;
import czxy.aiuke.entity.aiuke;
import czxy.aiuke.util.NoteResult;
import czxy.aiuke.util.NoteUtil;
@Service("service")
public class serviceImpl implements service {

	@Resource
	private messageDao dao;
	public NoteResult<String> save(String singname, String singer,
			String addr, String beizhu) {
		aiuke a = new aiuke();
		NoteResult<String> res = new NoteResult<String>();
		String id = NoteUtil.createId();
		a.setId(id);
		a.setSingname(singname);
		a.setAddr(addr);
		a.setBeizhu(beizhu);
		int count =dao.save(a);
		if(count!=1){
			res.setStatus(1);
			res.setMsg("成功保存");
		}else{
			res.setStatus(0);
			res.setMsg("保存失败");
		}
		return res;
	}

	public NoteResult<List<aiuke>> search(String name) {
		NoteResult<List<aiuke>> res = new NoteResult<List<aiuke>>();
		List<aiuke> list = dao.search(name);
		if(list.size()!=0){
			res.setStatus(1);
			res.setData(list);
			
		}else{
			res.setStatus(0);
			res.setMsg("查询失败");
		}
		return res;
	}

}
