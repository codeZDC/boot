package com.tuzhi.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.boot.mapper.ILogMapper;
import com.tuzhi.boot.domain.Log;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:LogService
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-06-26 13:40:43
 */
@Service
public class LogService {
	
	@Autowired
	private ILogMapper logMapper;
 
	public PageInfo<Log> findLogList(Log log) {
		// TODO 分页查询
		PageHelper.startPage(log.getPageNum(), log.getPageSize());
		PageInfo<Log> pageInfo = new PageInfo<Log>(logMapper.findLogList(log));
		
		return pageInfo;
	}
	
	public Log getLogById(Integer id){
		// TODO 根据ID查询
		return logMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveLog(Log log){
		// TODO 新增
		return logMapper.insertSelective(log) > 0;
	}
	
	public boolean editLog(Log log){
		// TODO 修改
		return logMapper.updateByPrimaryKeySelective(log) > 0;
	}
	
	public boolean delLog(List<Integer> logArr){
		// TODO	删除
		Example example = new Example(Log.class);
		Criteria c = example.createCriteria();
		c.andIn("id", logArr);
		return logMapper.deleteByExample(example) > 0;
	}

}
