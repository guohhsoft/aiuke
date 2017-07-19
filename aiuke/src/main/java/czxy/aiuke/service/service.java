package czxy.aiuke.service;

import java.util.List;

import czxy.aiuke.entity.aiuke;
import czxy.aiuke.util.NoteResult;

public interface service {
	NoteResult<String> save(String singername,String singer,String addr,String beizhu);
	NoteResult<List<aiuke>> search(String name);
}
