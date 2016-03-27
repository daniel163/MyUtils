package com.handbb.ssp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;

import com.handbb.ssp.dao.UserMapper;
import com.handbb.ssp.model.ResCode;
import com.handbb.ssp.model.User;
import com.handbb.ssp.model.UserInfo;
import com.handbb.ssp.model.UserMap;
import com.handbb.ssp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = LoggerFactory
			.getLogger(UserController.class);

	private UserService userService;

	// @Autowired
	// private HttpServletRequest httpServletRequest;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private ResCode rescode;

	@ResponseBody
	@RequestMapping("/view")
	public UserInfo viewUserinfo(@RequestParam("userid") Integer userid,
			HttpServletRequest httpServletRequest) {
		// 返回json数据示例
		logger.debug("接收请求 :" + "http://" + httpServletRequest.getRemoteAddr()
				+ ":8080" + httpServletRequest.getRequestURI() + "?"
				+ "userid=" + userid);
		UserInfo userinfo = userService.getUserInfobyID(userid);
		return userinfo;
	}

	@ResponseBody
	@RequestMapping("/view2/{userid}")
	public UserInfo viewUserinfo2(@PathVariable("userid") Integer userid,
			HttpServletRequest httpServletRequest) {
		// rest风格的请求
		// 返回json数据示例
		logger.debug("接收请求 :" + "http://" + httpServletRequest.getRemoteAddr()
				+ ":8080" + httpServletRequest.getRequestURI());
		UserInfo userinfo = userService.getUserInfobyID(userid);
		return userinfo;
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public String createUserinfo() {
		// 跳转到 createuser.jsp 提交后执行 /user/save
		return "createuser";
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public String showfileUpload() {
		return "file";
	}

	@RequestMapping(value = "/fileuploadlist", method = RequestMethod.GET)
	public String showfileUploadlist() {
		return "filelist";
	}

	@ResponseBody
	@RequestMapping(value = "/startupload", method = RequestMethod.POST)
	public ResCode startUpload(@RequestParam("file") MultipartFile file) {
		// 开始上传文件
		if (!file.isEmpty()) {
			logger.debug("开始处理文件上传 ...  ", file.getOriginalFilename());
			try {
				FileUtils.copyInputStreamToFile(
						file.getInputStream(),
						new File("d:\\imooc", System.currentTimeMillis()
								+ file.getOriginalFilename()));
				if (rescode == null) {
					rescode = new ResCode();
				}
				rescode.setRestCode("0001");
				rescode.setDescription("文件上传成功!");
			} catch (IOException e) {
				rescode.setRestCode("-0001");
				rescode.setDescription("发生异常,文件上传失败!");
				e.printStackTrace();
			}
		}
		return rescode;
	}

	@ResponseBody
	@RequestMapping(value = "/startuploadlist", method = RequestMethod.POST)
	public ResCode startUploadlist(@RequestParam("files") MultipartFile[] files) {
		// 开始上传文件
		if (files != null && files.length > 0) {
			logger.debug("开始处理多个文件上传 ... MultipartFile >>>  " + files.length);
			try {
				// 循环获取file数组中得文件
				for (int i = 0; i < files.length; i++) {
					MultipartFile file = files[i];
					// 保存文件
					FileUtils.copyInputStreamToFile(file.getInputStream(),
							new File("d:\\imooc", System.currentTimeMillis()
									+ file.getOriginalFilename()));
				}
				if (rescode == null) {
					rescode = new ResCode();
				}
				rescode.setRestCode("0001");
				rescode.setDescription("文件上传成功!");
			} catch (IOException e) {
				rescode.setRestCode("-0001");
				rescode.setDescription("发生异常,文件上传失败!");
				e.printStackTrace();
			}
		} else {
			if (rescode == null) {
				rescode = new ResCode();
			}
			rescode.setRestCode("-0002");
			rescode.setDescription("文件长度异常!");
		}

		return rescode;
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public UserMap saveUserinfo(@ModelAttribute UserInfo userinfo) {
		logger.debug("/save  >>>>>>>>>>>>>>");
		logger.debug("userinfo >>> " + userinfo.toString());
		Map<String, Object> map = new HashMap<String, Object>();

		for (int i = 0; i < 1; i++) {
			map.put("test" + i, "http://bbs.csdn.net/topics/" + i);
		}

		List<String> list = new ArrayList<String>();
		list.add("http://www.baidu.com_01");
		list.add("http://www.baidu.com_02");
		list.add("http://www.baidu.com_03");
		list.add("http://www.baidu.com_04");
		list.add("http://www.baidu.com_05");
		list.add("http://www.baidu.com_06");

		UserMap umap = new UserMap();
		umap.setName("map/list显示");
		umap.setLink(map);
		umap.setLinklist(list);
		// umap.setRescode("0001");
		// umap.setDescription("查询成功!");
		return umap;
	}

	@ResponseBody
	@RequestMapping(value = "/testmybatis")
	public User testMybatisSelect(HttpServletRequest httpServletRequest) {
		try {
			// ApplicationContext ctx = null;
			// ctx = new
			// ClassPathXmlApplicationContext("classpath:myApplicationContext.xml");

			ApplicationContext ctx = WebApplicationContextUtils
					.getWebApplicationContext(httpServletRequest.getSession()
							.getServletContext());

			UserMapper userDao = (UserMapper) ctx.getBean("userDao");
			User user = userDao.findUserById(1);
			return user;
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
