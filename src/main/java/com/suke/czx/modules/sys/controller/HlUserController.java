package com.suke.czx.modules.sys.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.suke.czx.common.entity.Nodes;
import com.suke.czx.common.utils.ExcelUtil;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.hladmin.entity.HlPurchaseEntity;
import com.suke.czx.modules.hladmin.entity.HlRewardEntity;
import com.suke.czx.modules.hladmin.service.HlHylPriceService;
import com.suke.czx.modules.hladmin.service.HlRewardService;
import com.suke.czx.modules.sys.entity.HlUserEntity;
import com.suke.czx.modules.sys.service.HlUserService;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-03 14:05:20
 */
@RestController
@RequestMapping("/sys/hluser")
public class HlUserController extends AbstractController {
	@Autowired
	private HlUserService hlUserService;
	@Autowired
	private HlHylPriceService hlHylPriceService;
	@Autowired
	private HlRewardService hlRewardService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		String price = hlHylPriceService.queryMaxPrice();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("price", price);

		Map<String, Object> userQueryMap = new HashMap<String, Object>();
		userQueryMap.put("userName", this.getUser().getUsername());
		List<HlUserEntity> userList = hlUserService.queryList(userQueryMap);
		if (!CollectionUtils.isEmpty(userList)) {

			map.put("amount", userList.get(0).getAmount());
			map.put("lockAmount", userList.get(0).getLockAmount());
			map.put("recUser", userList.get(0).getRecUser());
			map.put("userName", this.getUser().getUsername());
			Map<String, Object> mapReward = new HashMap<String, Object>();
			mapReward.put("userName", userList.get(0).getUserName());
			double recreward = hlRewardService.queryList(mapReward).stream().filter(award -> award.getAwardType() == 2)
					.map(HlRewardEntity::getAmount).mapToDouble(Double::doubleValue).sum();
			map.put("recReward", recreward);
		}

		return R.ok().put("hlUser", map);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/listAll")
	public R listAll(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<HlUserEntity> hlUserList = hlUserService.queryList(query);
		int total = hlUserService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(hlUserList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id) {
		HlUserEntity hlUser = hlUserService.queryObject(id);

		return R.ok().put("hlUser", hlUser);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/currentinfo")
	public R currentinfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", this.getUser().getUsername());
		HlUserEntity hlUser = hlUserService.queryList(map).get(0);
		return R.ok().put("hlUser", hlUser);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody HlUserEntity hlUser) {
		hlUserService.save(hlUser);

		return R.ok();
	}

	/**
	 * 保存
	 */
	@RequestMapping("/lock/{willLockAmount}")
	public R lock(@PathVariable("willLockAmount") Double willLockAmount) {
		Map<String, Object> userQueryMap = new HashMap<String, Object>();
		userQueryMap.put("userName", this.getUser().getUsername());
		HlUserEntity hue = hlUserService.queryList(userQueryMap).get(0);
		if (hue.getAmount() < willLockAmount) {
			return R.error("锁仓金额不可大于流通金额");
		}

		hue.setAmount(hue.getAmount() - willLockAmount);
		hue.setLockAmount(hue.getLockAmount() + willLockAmount);
		hlUserService.update(hue);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody HlUserEntity hlUser) {
		hlUserService.update(hlUser);

		return R.ok();
	}

	@RequestMapping("/password/{userId}")
	public R password(@PathVariable("userId") int userId) {
		hlUserService.password(userId);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids) {
		hlUserService.deleteBatch(ids);

		return R.ok();
	}

	@RequestMapping("/getAllUserMap")
	public R getAllUserMap(@RequestParam("userName") String userName) {
		if (userName.equals("admin1")) {
			return R.error("不允许查询管理员信息");
		}
		if (StringUtils.isEmpty(userName)) {
			userName = this.getUser().getUsername();
		}

		Nodes nodes = hlUserService.getAllUserMap(userName);
		return R.ok().put("nodes", nodes);
	}

	@RequestMapping("/export")
	public void export(HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<HlUserEntity> dataset = hlUserService.queryList(map);

		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"user.xls\"");
		response.setContentType("application/msexcel");
		response.addHeader("Cache-Control", "no-cache");

		String[] headers = new String[] { "编号", "用户名", "姓名", "", "身份证", "电话", "开户银行", "银行卡号", "流通货币数量", "锁仓数量", "推荐人账号",
				"推荐人姓名", "注册日期", "注释" };
		try {
			OutputStream out = response.getOutputStream();
			ExcelUtil.exportExcel("用户购买货币信息", headers, dataset, out, "yyyy-MM-dd");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
