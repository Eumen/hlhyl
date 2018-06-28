package com.suke.czx.modules.hladmin.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.hladmin.entity.HlRewardEntity;
import com.suke.czx.modules.hladmin.service.HlRewardService;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-03 13:05:01
 */
@RestController
@RequestMapping("/hladmin/hlreward")
public class HlRewardController {
	@Autowired
	private HlRewardService hlRewardService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<HlRewardEntity> hlRewardList = hlRewardService.queryList(query);
		int total = hlRewardService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(hlRewardList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id) {
		HlRewardEntity hlReward = hlRewardService.queryObject(id);

		return R.ok().put("hlReward", hlReward);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody HlRewardEntity hlReward) {
		hlRewardService.save(hlReward);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody HlRewardEntity hlReward) {
		hlRewardService.update(hlReward);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids) {
		hlRewardService.deleteBatch(ids);

		return R.ok();
	}

	@RequestMapping("/generate")
	public R generate() {
		int count = hlRewardService.isGenerate(DateUtil.newIsoDateFormat().format(new Date()));
		if (count > 0) {
			return R.error("今天奖金已生成");
		}
		hlRewardService.generate();
		return R.ok();
	}

}