package com.suke.czx.modules.hladmin.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suke.czx.common.utils.ExcelUtil;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.hladmin.entity.HlPurchaseEntity;
import com.suke.czx.modules.hladmin.service.HlPurchaseService;
import com.suke.czx.modules.sys.controller.AbstractController;
import com.suke.czx.modules.sys.entity.SysUserEntity;
import com.suke.czx.modules.sys.service.SysUserService;

/**
 * 购买货币申请
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-02 16:15:34
 */
@RestController
@RequestMapping("/hladmin/hlpurchase")
public class HlPurchaseController extends AbstractController {
	@Autowired
	private HlPurchaseService hlPurchaseService;
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {

		String userName = this.getUser().getUsername();
		if (!userName.contains("admin")) {
			params.put("userName", userName);
		}
		// 查询列表数据
		Query query = new Query(params);

		List<HlPurchaseEntity> hlPurchaseList = hlPurchaseService.queryList(query);
		int total = hlPurchaseService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(hlPurchaseList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id) {
		HlPurchaseEntity hlPurchase = hlPurchaseService.queryObject(id);

		return R.ok().put("hlPurchase", hlPurchase);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody HlPurchaseEntity hlPurchase) {
		hlPurchase.setApplyDate(new Date());
		hlPurchase.setStatus(1);

		SysUserEntity sue = sysUserService.queryObject(getUserId());
		hlPurchase.setUserName(sue.getUsername());
		hlPurchase.setName(sue.getName());

		hlPurchaseService.save(hlPurchase);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody HlPurchaseEntity hlPurchase) {
		if (hlPurchase.getStatus() == 2) {
			return R.error("此笔申请已同意，不允许修改");
		} else {
			hlPurchaseService.update(hlPurchase);
			return R.ok();
		}
	}

	@RequestMapping("/audit/{id}")
	public R audit(@PathVariable String id) {
		HlPurchaseEntity hlPurchase = hlPurchaseService.queryObject(Integer.valueOf(id));
		if (hlPurchase.getStatus() == 2) {
			return R.error("此笔申请已同意，不允许再次审核");
		} else {
			hlPurchase.setStatus(2);
			hlPurchaseService.audit(hlPurchase);
			return R.ok();
		}
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids) {
		hlPurchaseService.deleteBatch(ids);
		return R.ok();
	}

	@RequestMapping("/export")
	public void export(HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<HlPurchaseEntity> dataset = hlPurchaseService.queryList(map);

		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"purchase.xls\"");
		response.setContentType("application/msexcel");
		response.addHeader("Cache-Control", "no-cache");

		String[] headers = new String[] { "编号", "用户名", "姓名", "数量", "状态（1、申请  2、审核通过）", "申请日期", "付款方式(1,现金 2,转账 3,回执单)", "实付金额", "审核日期",
		"注释" };
		try {
			OutputStream out = response.getOutputStream();
			ExcelUtil.exportExcel("用户购买货币信息", headers, dataset, out, "yyyy-MM-dd");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
