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
import com.suke.czx.modules.hladmin.entity.HlTransactionEntity;
import com.suke.czx.modules.hladmin.service.HlTransactionService;




/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-03 13:05:01
 */
@RestController
@RequestMapping("/hladmin/hltransaction")
public class HlTransactionController {
    @Autowired
    private HlTransactionService hlTransactionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("hladmin:hltransaction:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
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
    @RequiresPermissions("hladmin:hltransaction:info")
    public R info(@PathVariable("id") Integer id){
			HlTransactionEntity hlTransaction = hlTransactionService.queryObject(id);

        return R.ok().put("hlTransaction", hlTransaction);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("hladmin:hltransaction:save")
    public R save(@RequestBody HlTransactionEntity hlTransaction){
			hlTransactionService.save(hlTransaction);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("hladmin:hltransaction:update")
    public R update(@RequestBody HlTransactionEntity hlTransaction){
			hlTransactionService.update(hlTransaction);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("hladmin:hltransaction:delete")
    public R delete(@RequestBody Integer[] ids){
			hlTransactionService.deleteBatch(ids);

        return R.ok();
    }
	
}
