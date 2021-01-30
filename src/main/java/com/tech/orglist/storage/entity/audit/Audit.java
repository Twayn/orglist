package com.tech.orglist.storage.entity.audit;

import java.time.LocalDateTime;

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
public class Audit {
	@Id
	@GeneratedValue
	private Long id;
	public LocalDateTime date;
	public String userName;

	public static Audit of(LocalDateTime time, String description){
		return new Audit().date(time).userName(description);
	}
}
