package czxy.aiuke.dao;

import czxy.aiuke.entity.user;

public interface login {
	user findByname(String name);
	int save(user use);
	int update(user use);
}
