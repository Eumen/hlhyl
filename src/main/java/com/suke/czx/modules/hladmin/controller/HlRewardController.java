package com.suke.czx.modules.hladmin.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @RequiresPermissions("hladmin:hlreward:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
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
    @RequiresPermissions("hladmin:hlreward:info")
    public R info(@PathVariable("id") Integer id){
			HlRewardEntity hlReward = hlRewardService.queryObject(id);

        return R.ok().put("hlReward", hlReward);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("hladmin:hlreward:save")
    public R save(@RequestBody HlRewardEntity hlReward){
			hlRewardService.save(hlReward);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("hladmin:hlreward:update")
    public R update(@RequestBody HlRewardEntity hlReward){
			hlRewardService.update(hlReward);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("hladmin:hlreward:delete")
    public R delete(@RequestBody Integer[] ids){
			hlRewardService.deleteBatch(ids);

        return R.ok();
    }
	
}
