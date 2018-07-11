package com.suke.czx.common.entity;

import java.util.ArrayList;
import java.util.List;

import com.suke.czx.modules.sys.entity.HlUserEntity;

public class Nodes {
	private HlUserEntity userNode;

	private List<Nodes> children;

	public HlUserEntity getUserNode() {
		return this.userNode;
	}

	public void setUserNode(final HlUserEntity userNode) {
		this.userNode = userNode;
	}

	public List<Nodes> getChildren() {
		if (null == this.children) {
			this.children = new ArrayList<>();
		}
		return this.children;
	}

}
