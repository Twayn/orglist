package com.tech.orglist.service.orglist;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.orglist.service.audit.AuditService;
import com.tech.orglist.storage.entity.audit.Audit;
import com.tech.orglist.storage.entity.audit.AuditType;
import com.tech.orglist.storage.entity.org.Org;
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
		auditService.save(Audit.of(LocalDateTime.now(), AuditType.SAVE, userName));
		orgRepository.save(Org.of(orgName, orgType));
	}

	@Override
	public Iterable<Org> getAll(String userName) {
		auditService.save(Audit.of(LocalDateTime.now(), AuditType.LIST, userName));
		return orgRepository.findAll();
	}
}
