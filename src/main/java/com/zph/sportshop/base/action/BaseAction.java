package com.zph.sportshop.base.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zph.sportshop.domain.admin.Admin;
import com.zph.sportshop.domain.system.Info;
import com.zph.sportshop.system.service.InfoService;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	
	private Class classt;
	private T t;
	@Resource(name="infoService")
	private InfoService infoService;
	//模糊查询关键词
	private String key;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.classt = (Class) type.getActualTypeArguments()[0];
		try {
			this.t = (T) this.classt.newInstance();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void addInfo(String content) {
		Map session = ActionContext.getContext().getSession();
		Admin admin = (Admin) session.get("admin");
		Info info = new Info();
		info.setContent(content);
		info.setAdmin(admin);
		infoService.saveEntry(info);
	}
	public T getModel() {
		// TODO Auto-generated method stub
		return this.t;
	}
	//button方式传递字符串
	private String checkedStr;
	
	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}
	//submit方式传递数组
	private Long[] ids;
	
	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	private int currentPage;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public static final String ADDUI = "addUI";//跳转到增加页面的字符串
	public String addUI = ADDUI;
	
	public static final String UPDATEUI = "updateUI";//跳转到的修改页面的字符串
	public String updateUI = UPDATEUI;
	
	public static final String LISTACTION = "listAction";//跳转到显示页面的字符串
	public String listAction = LISTACTION;
	
	public static final String ACTION2ACTION = "action2action";//action跳转到action
	public String action2action = ACTION2ACTION;
	
	public HttpSession getSession() {//获取session
		return ServletActionContext.getRequest().getSession();
	}
}
