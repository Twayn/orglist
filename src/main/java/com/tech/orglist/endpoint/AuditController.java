package com.tech.orglist.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.orglist.storage.entity.audit.Audit;
import com.tech.orglist.service.audit.AuditService;

@RestController
public class AuditController {
	final AuditService auditService;

	@Autowired
	public AuditController(AuditService auditService) {
		this.auditService = auditService;
	}

	@GetMapping("/audit")
	Iterable<Audit> auditList(){
		return auditService.getAll();
	}
}
