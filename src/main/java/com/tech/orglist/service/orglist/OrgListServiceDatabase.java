package com.tech.orglist.service.orglist;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.orglist.service.audit.AuditService;
import com.tech.orglist.storage.entity.audit.Audit;
import com.tech.orglist.storage.entity.org.Org;
import com.tech.orglist.storage.entity.org.OrgType;
import com.tech.orglist.storage.repo.OrgRepository;

@Service
public class OrgListServiceDatabase implements OrgListService {
	private final AuditService auditService;
	private final OrgRepository orgRepository;


	@Autowired
	public OrgListServiceDatabase(AuditService auditService, OrgRepository orgRepository) {
		this.auditService = auditService;
		this.orgRepository = orgRepository;
	}

	@Override
	public void save(String orgName, String orgType, String userName) {
		auditService.save(Audit.of(LocalDateTime.now(), userName));
		orgRepository.save(new Org().orgName(orgName).orgType(new OrgType().type(orgType)));
	}

	@Override
	public Iterable<Org> getAll(String userName) {
		auditService.save(Audit.of(LocalDateTime.now(), userName));
		return orgRepository.findAll();
	}
}
