package com.suke.czx.modules.sys.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HlModifyRecUserEntity implements Serializable {
	private int id;
	private String recNewUserName;
	private String recNewName;

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getRecNewUserName() {
		return this.recNewUserName;
	}

	public void setRecNewUserName(final String recNewUserName) {
		this.recNewUserName = recNewUserName;
	}

	public String getRecNewName() {
		return this.recNewName;
	}

	public void setRecNewName(final String recNewName) {
		this.recNewName = recNewName;
	}

}
