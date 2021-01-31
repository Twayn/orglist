package com.tech.orglist.service.orglist;


import com.tech.orglist.storage.entity.org.Org;

public interface OrgListService {
	void save(String orgName, String orgType, String userName, String[] accNums);

	Iterable<Org> getAll(String userName);
}
