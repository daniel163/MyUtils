package com.handbb.ssp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/***
 * 便民信息查询相关接口
 * @author zhangheng
 *
 */
@Controller
@RequestMapping("/convenient")
public class Ssp_ConvenientController {
	private static Logger logger = LoggerFactory.getLogger(Ssp_ConvenientController.class);
	
	/***
	 * 获取便民信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/convenientinfo")
	public List<String> getConvenientinfo(){
		logger.debug("request >>> /convenient/convenientinfo >>> method(getConvenient)");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("");
		list.add("c");
		list.add("d");
		list.add("e");
		return list;
	}
}
