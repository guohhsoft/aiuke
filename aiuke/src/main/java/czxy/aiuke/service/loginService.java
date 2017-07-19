package czxy.aiuke.service;

import czxy.aiuke.entity.user;
import czxy.aiuke.util.NoteResult;

public interface loginService {
	NoteResult<user> findByname(String name,String password);
	NoteResult<String> save(String name,String password,String telephone,String email); 
	NoteResult<String> update(String name,String password); 
	NoteResult<user> findByname(String name);
}
