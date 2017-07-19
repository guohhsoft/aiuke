package czxy.aiuke.dao;

import java.util.List;

import czxy.aiuke.entity.pinglun;

public interface pinglundao {
	 List<pinglun> search(String addr);
	 int save(pinglun pl);
}
