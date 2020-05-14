package hibernate.simple.examples.dao.common;

import java.util.List;

import hibernate.simple.examples.entity.Role;

public interface RoleManager {
	
	public void saveRole(Role role);
	public Role getRole(Integer id);
	public List<Role> getRoles();
	
}
