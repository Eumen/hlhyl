package com.suke.czx.common.task;

import java.util.Date;

import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.suke.czx.modules.hladmin.service.HlRewardService;

@Component
public class GenAward {

	@Autowired
	HlRewardService hlRewardService;

	@Scheduled(cron = "0 0 9 ? * MON-FRI")
	public void generateAward() {
		int count = hlRewardService.isGenerate(DateUtil.newIsoDateFormat().format(new Date()));
		if (count == 0) {
			this.hlRewardService.generate();
		}
	}
}
