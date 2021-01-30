package com.tech.orglist.service.audit;

import org.springframework.stereotype.Service;

import com.tech.orglist.storage.entity.audit.Audit;
import com.tech.orglist.storage.repo.AuditRepository;

@Service
public class AuditServiceDatabase implements AuditService {
	private final AuditRepository auditRepository;

	public AuditServiceDatabase(AuditRepository auditRepository) {
		this.auditRepository = auditRepository;
	}

	@Override
	public void save(Audit entry) {
		auditRepository.save(entry);
	}

	@Override
	public Iterable<Audit> getAll() {
		return auditRepository.findAll();
	}
}
