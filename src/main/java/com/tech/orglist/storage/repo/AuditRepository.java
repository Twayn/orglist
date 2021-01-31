package com.tech.orglist.storage.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.orglist.storage.entity.audit.Audit;

@Repository
public interface AuditRepository extends CrudRepository<Audit, Long> {
}