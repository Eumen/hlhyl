package com.suke.czx.common.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.suke.czx.modules.sys.entity.HlUserEntity;

public class Nodes {
	private HlUserEntity userNode;

	private List<Nodes> children;

	private Map<String, Double> achievement;

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

	public Map<String, Double> getAchievement() {
		if (null == this.achievement) {
			this.achievement = new HashMap<String, Double>();
		}
		return this.achievement;
	}

}
