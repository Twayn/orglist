package com.tech.orglist.storage.entity.audit;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public LocalDateTime date;

	public String userName;

	@Enumerated(EnumType.STRING)
	public AuditType type;

	public static Audit of(LocalDateTime time, AuditType auditType, String description) {
		return new Audit().date(time).type(auditType).userName(description);
	}
}
