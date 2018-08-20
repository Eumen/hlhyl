package com.suke.czx.modules.hladmin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suke.czx.modules.hladmin.dao.HlAnnocementDao;
import com.suke.czx.modules.hladmin.entity.HlAnnocementEntity;
import com.suke.czx.modules.hladmin.service.HlAnnocementService;

@Service("hlAnnocementService")
public class HlAnnocementServiceImpl implements HlAnnocementService {
	@Autowired
	private HlAnnocementDao hlAnnocementDao;

	@Override
	public HlAnnocementEntity queryObject(final Integer id) {
		return this.hlAnnocementDao.queryObject(id);
	}

	@Override
	public List<HlAnnocementEntity> queryList(final Map<String, Object> map) {
		return this.hlAnnocementDao.queryList(map);
	}

	@Override
	public int queryTotal(final Map<String, Object> map) {
		return this.hlAnnocementDao.queryTotal(map);
	}

	@Override
	public void save(final HlAnnocementEntity hlAnnocement) {
		this.hlAnnocementDao.save(hlAnnocement);
	}

	@Override
	public void update(final HlAnnocementEntity hlAnnocement) {
		this.hlAnnocementDao.update(hlAnnocement);
	}

	@Override
	public void delete(final Integer id) {
		this.hlAnnocementDao.delete(id);
	}

	@Override
	public void deleteBatch(final Integer[] ids) {
		this.hlAnnocementDao.deleteBatch(ids);
	}

	@Override
	public String selectLastAnnocement() {
		return this.hlAnnocementDao.selectLastAnnocement();
	}

}
