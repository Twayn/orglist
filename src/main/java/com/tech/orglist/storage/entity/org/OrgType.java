package com.tech.orglist.storage.entity.org;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String type;

	public static OrgType of(String orgType) {
		return new OrgType().type(orgType);
	}
}
