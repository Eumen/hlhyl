package com.suke.czx.modules.hladmin.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.hladmin.entity.HlAnnocementEntity;
import com.suke.czx.modules.hladmin.service.HlAnnocementService;
import com.suke.czx.modules.sys.controller.AbstractController;

/**
 * 华力公告
 * 
 * @author czx
 * @email ${email}
 * @date 2018-08-18 15:46:56
 */
@RestController
@RequestMapping("/hladmin/hlannocement")
public class HlAnnocementController extends AbstractController {
	@Autowired
	private HlAnnocementService hlAnnocementService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam final Map<String, Object> params) {
		// 查询列表数据
		final Query query = new Query(params);

		final List<HlAnnocementEntity> hlAnnocementList = this.hlAnnocementService.queryList(query);
		final int total = this.hlAnnocementService.queryTotal(query);

		final PageUtils pageUtil = new PageUtils(hlAnnocementList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") final Integer id) {
		final HlAnnocementEntity hlAnnocement = this.hlAnnocementService.queryObject(id);

		return R.ok().put("hlAnnocement", hlAnnocement);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/getLastAnnocement")
	public R getLastAnnocement() {
		String hlAnnocement = this.hlAnnocementService.selectLastAnnocement();
		return R.ok().put("hlAnnocement", hlAnnocement);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody final HlAnnocementEntity hlAnnocement) {
		hlAnnocement.setOperatorName(this.getUser().getUsername());
		hlAnnocement.setOperatorDate(new Date());
		this.hlAnnocementService.save(hlAnnocement);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody final HlAnnocementEntity hlAnnocement) {
		this.hlAnnocementService.update(hlAnnocement);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody final Integer[] ids) {
		this.hlAnnocementService.deleteBatch(ids);

		return R.ok();
	}

}
