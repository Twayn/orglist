package com.tech.orglist.service.audit;

import com.tech.orglist.storage.entity.audit.Audit;

public interface AuditService {
	void save(Audit entry);
	Iterable<Audit> getAll();
}
