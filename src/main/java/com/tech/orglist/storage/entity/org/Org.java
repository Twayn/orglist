package com.tech.orglist.storage.entity.org;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;

import com.tech.orglist.storage.entity.account.Account;

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
	@JoinColumn(name = "org_type_id", referencedColumnName = "id")
	public OrgType orgType;

	@OneToMany(mappedBy = "org", cascade = {CascadeType.ALL})
	public List<Account> accounts;

	public static Org of(String orgName, String orgType, String[] accNums) {
		Org org = new Org().orgName(orgName).orgType(OrgType.of(orgType));

		List<Account> accounts = Stream.of(accNums)
				.map(acc -> Account.of(acc, org))
				.collect(Collectors.toList());

		return org.accounts(accounts);
	}
}
