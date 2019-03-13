package com.exampe.demo.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Roles {

	
	/**
	 * @param id
	 * @param roleName
	 */
	public Roles(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	public Roles() {}

	int id;
	String roleName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", roleName=" + roleName + "]";
	}
	
	
}
