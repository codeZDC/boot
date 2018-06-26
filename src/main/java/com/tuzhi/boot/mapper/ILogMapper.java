package com.tuzhi.boot.mapper;

import com.tuzhi.boot.base.BaseMapper;
import com.tuzhi.boot.domain.Log;

import java.util.List;

 /**
 * @ClassName:LogMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-06-26 13:40:43
 */
public interface ILogMapper extends BaseMapper<Log> {
	
	/**
	 * @title:findLogList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param log
	 * @CreateDate  2018-06-26 13:40:43
	 */
	List<Log> findLogList(Log log);
	
}
