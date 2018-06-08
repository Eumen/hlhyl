package com.suke.czx.modules.hladmin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.hladmin.entity.HlTransactionEntity;
import com.suke.czx.modules.hladmin.service.HlTransactionService;
import com.suke.czx.modules.sys.controller.AbstractController;
import com.suke.czx.modules.sys.entity.HlUserEntity;
import com.suke.czx.modules.sys.entity.SysUserEntity;
import com.suke.czx.modules.sys.service.HlUserService;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-04 11:15:16
 */
@RestController
@RequestMapping("/hladmin/hltransaction")
public class HlTransactionController extends AbstractController {
	@Autowired
	private HlTransactionService hlTransactionService;

	@Autowired
	private HlUserService hlUserService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<HlTransactionEntity> hlTransactionList = hlTransactionService.queryList(query);
		int total = hlTransactionService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(hlTransactionList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id) {
		HlTransactionEntity hlTransaction = hlTransactionService.queryObject(id);

		return R.ok().put("hlTransaction", hlTransaction);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody HlTransactionEntity hlTransaction) {
		String userName = hlTransaction.getTargetUserName();
		String name = hlTransaction.getTargetName();
		Map<String, Object> queryUser = new HashMap<String, Object>();
		queryUser.put("userName", userName);
		queryUser.put("name", name);
		List<HlUserEntity> listUser = hlUserService.queryList(queryUser);

		if (CollectionUtils.isEmpty(listUser)) {
			return R.error("目标转账人不存在");
		}

		if (hlTransaction.getAmount() <= 0){
			return R.error("转账金额必须大于0");
		}

		SysUserEntity user = this.getUser();
		hlTransaction.setUserName(user.getUsername());
		hlTransaction.setName(user.getName());
		Map<String, Object> ownQueryUser = new HashMap<String, Object>();
		ownQueryUser.put("userName", user.getUsername());
		ownQueryUser.put("name", user.getName());
		List<HlUserEntity> listOwnUser = hlUserService.queryList(ownQueryUser);
		if (listOwnUser.get(0).getAmount() < hlTransaction.getAmount()) {
			return R.error("转账金额不允许大于流通持仓金额");
		}

		hlTransactionService.save(hlTransaction);

		return R.ok();
	}

}
