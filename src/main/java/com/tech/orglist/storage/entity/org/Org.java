package com.tech.orglist.storage.entity.org;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(fluent = true)
public class Org {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	public String orgName;

	@ManyToOne(cascade = {CascadeType.ALL})
	public OrgType orgType;

	public static Org of(String orgName, String orgType) {
		return new Org().orgName(orgName).orgType(OrgType.of(orgType));
	}
}
