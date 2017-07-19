package czxy.aiuke.dao;

import java.util.List;

import czxy.aiuke.entity.aiuke;

public interface messageDao {
	List<aiuke> search(String name);
	int save(aiuke auk);
}
