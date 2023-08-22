package com.luv2code.springboot.demosecurity.dao;

import com.luv2code.springboot.demosecurity.entity.Role;

public interface RoleDao {
	Role findRoleByName(String theRoleName);
}