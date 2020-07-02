package com.zph.sportshop.admin.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.admin.service.AdminService;
import com.zph.sportshop.admin.service.RoleService;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.admin.Admin;
import com.zph.sportshop.domain.privilege.Privilege;
import com.zph.sportshop.domain.privilege.Role;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.admin.AdminQuery;
import com.zph.sportshop.system.service.InfoService;
import com.zph.sportshop.util.encryption.EncryptionPsw;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends BaseAction<Admin>{
	
	@Resource(name="adminService")
	private AdminService adminService;
	@Resource(name="roleService")
	private RoleService roleService;
	@Resource(name="infoService")
	private InfoService infoService;
	private Long rid;
	private AdminQuery baseQuery = new AdminQuery();
	private String result;
	private String newPsw;
	private String oldPsw;
	public String getNewPsw() {
		return newPsw;
	}
	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}
	public String getOldPsw() {
		return oldPsw;
	}
	public void setOldPsw(String oldPsw) {
		this.oldPsw = oldPsw;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String login() {
		Map session1 = ActionContext.getContext().getSession();
		Admin admin1 = (Admin) session1.get("admin");
		if(admin1 != null) return "admin";
		Admin admin = this.adminService.findByNameAndPsw(this.getModel().getAdminName(), EncryptionPsw.getPassword(this.getModel().getPassword()));
		if(admin == null) {
			ActionContext.getContext().put("errorMsg", "用户名或密码错误");
			return "login";
		}else {
			Map session = ActionContext.getContext().getSession();
			Collection<Privilege> functions = admin.getRole().getPrivileges();
			session.put("admin", admin);
			session.put("functions", functions);
			return "admin";
		}
	}
	@PrivilegeInfo(name="管理员管理")
	public String listAdmin() {
		if(this.getKey() != null) listAdminByKey();
		else {
			baseQuery.setCurrentPage(this.getCurrentPage());
			baseQuery.setPageSize(6);
			baseQuery.setRid(this.rid);
			baseQuery.setSex(this.getModel().getSex());
			ActionContext.getContext().put("rid", this.rid);
			PageResult<Admin> admins = this.adminService.findPageResult(baseQuery);
			List<Role> roles = this.roleService.findAll();
			ActionContext.getContext().put("admins", admins);
			ActionContext.getContext().put("roles", roles);
		}
		return "listAdmin";
	}
	@PrivilegeInfo(name="管理员管理")
	public void listAdminByKey() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		baseQuery.setKey(this.getKey());
		ActionContext.getContext().put("key", this.getKey());
		PageResult<Admin> admins = this.adminService.findPageResultByKey(baseQuery);
		List<Role> roles = this.roleService.findAll();
		ActionContext.getContext().put("admins", admins);
		ActionContext.getContext().put("roles", roles);	
	}
	@PrivilegeInfo(name="管理员管理")
	public String updateAdmin() {
		Admin admin2 = this.adminService.getEntry(this.getModel().getAdminId());
		String content = "更新了管理员：" + admin2.getAdminId();
		this.addInfo(content);
		Role role = this.roleService.getEntry(this.rid);
		admin2.setRole(role);
		this.adminService.updateEntry(admin2);
		this.result = "更新成功";
		return SUCCESS;
	}
	@PrivilegeInfo(name="管理员管理")
	public String addAdmin() {
		Admin admin1 = this.adminService.findByName(this.getModel().getAdminName());
		if(admin1 != null) this.result = "该用户名已经存在";
		else {
			Admin admin2 = new Admin();
			admin2.setAdminName(this.getModel().getAdminName());
			admin2.setEmail(this.getModel().getEmail());
			admin2.setPassword(EncryptionPsw.getPassword(this.getModel().getPassword()));
			admin2.setPhone(this.getModel().getPhone());
			admin2.setSex(this.getModel().getSex());
			admin2.setTrueName(this.getModel().getTrueName());
			Role role = this.roleService.getEntry(this.rid);
			admin2.setRole(role);
			this.adminService.saveEntry(admin2);
			String content = "添加了管理员：" + admin2.getAdminName();
			this.addInfo(content);
			this.result = "添加成功";
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="管理员管理")
	public String deleteAdmin() {
		Long adminId = this.getModel().getAdminId();
		String content = "删除了管理员：" + adminId;
		this.addInfo(content);
		this.infoService.deleteByForeignId(adminId, "adminId");
		this.adminService.deleteEntryById(adminId);
		return SUCCESS;
	}
	public String adminLogout() {
		ActionContext.getContext().getSession().put("admin", null); 
		ActionContext.getContext().getSession().put("functions", null); 
		return "login";
	}
	public String showSelf() {
		Map session1 = ActionContext.getContext().getSession();
		Admin admin1 = (Admin) session1.get("admin");
		if(admin1 == null) return "login";
		else ActionContext.getContext().put("admin", admin1);
		return "showSelf";
	}
	public String updateSelf() {
		Map session = ActionContext.getContext().getSession();
		Admin admin = (Admin) session.get("admin");
		if(admin == null) return "login";
		admin.setAdminName(this.getModel().getAdminName());
		admin.setTrueName(this.getModel().getTrueName());
		admin.setEmail(this.getModel().getEmail());
		admin.setPhone(this.getModel().getPhone());
		this.adminService.updateEntry(admin);
		return SUCCESS;
	}
	public String updatePsw() {
		Map session = ActionContext.getContext().getSession();
		Admin admin = (Admin) session.get("admin");
		if(admin == null) return "login";
		if(!admin.getPassword().equals(EncryptionPsw.getPassword(this.oldPsw))) {
			this.result = "旧密码错误";
		}else {
			admin.setPassword(EncryptionPsw.getPassword(this.newPsw));
			this.adminService.updateEntry(admin);
			this.result = "更新成功";
		}
		return SUCCESS;
	}
}
