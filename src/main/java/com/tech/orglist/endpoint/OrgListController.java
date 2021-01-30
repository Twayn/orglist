package com.tech.orglist.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.orglist.service.orglist.OrgListService;
import com.tech.orglist.storage.entity.org.Org;

@RestController
public class OrgListController {
	final OrgListService service;

	public OrgListController(OrgListService service) {
		this.service = service;
	}

	@GetMapping("/orglist")
	Iterable<Org> getOrgList(@RequestParam String userName){
		return service.getAll(userName);
	}

	@GetMapping("/saveorg")
	void saveOrg(@RequestParam String orgName, @RequestParam String orgType, @RequestParam String userName){
		service.save(orgName, orgType, userName);
	}
}
