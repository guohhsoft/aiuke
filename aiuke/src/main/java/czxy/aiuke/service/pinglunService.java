package czxy.aiuke.service;

import java.util.List;

import czxy.aiuke.entity.pinglun;
import czxy.aiuke.util.NoteResult;

public interface pinglunService {
	NoteResult<List<pinglun>> search(String addr);
	NoteResult<String> save(String message,String addr,String username);
}
