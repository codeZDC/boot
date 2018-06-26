package com.tuzhi.boot.controller;

import com.github.pagehelper.PageInfo;
import com.tuzhi.boot.base.BaseCtrl;
import com.tuzhi.boot.base.LayUiData;
import com.tuzhi.boot.domain.Log;
import com.tuzhi.boot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:LogCtrl
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-06-26 13:40:43
 */
@Controller
@RequestMapping("/log")
public class LogCtrl extends BaseCtrl {

	@Autowired
	private LogService logService;
	
	 /**
	 * @title:findLogList
	 * @description: 分页
	 * @author 郑德超
	 * @param log
	 * @CreateDate  2018-06-26 13:40:43
	 */
	@RequestMapping("/list")
	@ResponseBody
	public LayUiData findLogList(Log log){
		PageInfo<Log> page = logService.findLogList(log);
		return layUI(page);
	}
	
	/**
	 * @title:getLogById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-06-26 13:40:43
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Log getLogById(Integer id){
		Log log = logService.getLogById(id);
		return log;
	}
	
	
	 /**
	 * @title:editLog
	 * @description: 新增
	 * @author 郑德超
	 * @param log
	 * @CreateDate  2018-06-26 13:40:43
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveLog(Log log){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = logService.saveLog(log);
		map.put("success", flag);
		map.put("msg", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editLog
	 * @description: 修改
	 * @author 郑德超
	 * @param log
	 * @CreateDate  2018-06-26 13:40:43
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editLog(Log log){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = logService.editLog(log);
		map.put("success", flag);
		map.put("msg", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delLog
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-06-26 13:40:43
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delLog(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = logService.delLog(ids);
		map.put("success", flag);
		map.put("msg", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
