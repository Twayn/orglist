package com.tech.orglist.storage.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.orglist.storage.entity.org.Org;

@Repository
public interface OrgRepository extends CrudRepository<Org, Long> {}