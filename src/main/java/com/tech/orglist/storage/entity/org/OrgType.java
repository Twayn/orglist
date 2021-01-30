package com.tech.orglist.storage.entity.org;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(fluent = true)
public class OrgType {
	@Id
	@GeneratedValue
	private Long id;

	public String type;
}
