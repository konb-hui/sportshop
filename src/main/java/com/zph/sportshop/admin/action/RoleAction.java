package com.zph.sportshop.admin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.admin.service.PrivilegeService;
import com.zph.sportshop.admin.service.RoleService;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.admin.Admin;
import com.zph.sportshop.domain.privilege.Privilege;
import com.zph.sportshop.domain.privilege.Role;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.privilege.RoleQuery;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	@Resource(name="roleService")
	private RoleService roleService;
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	private Map<String, Object> result = new HashMap<String, Object>();
	private RoleQuery baseQuery = new RoleQuery();
	private String pid;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	@PrivilegeInfo(name="管理员管理")
	public String listRole() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		PageResult<Role> roles = this.roleService.findPageResult(baseQuery);
		List<Privilege> privileges = this.privilegeService.findAll();
		ActionContext.getContext().put("privileges", privileges);
		ActionContext .getContext().put("roles", roles);
		return "listRole";
	}
	@PrivilegeInfo(name="管理员管理")
	public String updateRole() {
		Role role1 = this.roleService.findByName(this.getModel().getRname());
		if(role1 != null) this.result.put("msg", "该角色已经存在");
		else {
			Role role2 = this.roleService.getEntry(this.getModel().getRid());
			role2.setRname(this.getModel().getRname());
			this.roleService.updateEntry(role2);
			String content = "更新了角色：" + role2.getRid();
			this.addInfo(content);
			this.result.put("msg", "更新成功");
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="管理员管理")
	public String addRole() {
		Role role1 = this.roleService.findByName(this.getModel().getRname());
		if(role1 != null) this.result.put("msg", "该角色已经存在");
		else {
			Role role2 = new Role();
			role2.setRname(this.getModel().getRname());
			this.roleService.saveEntry(role2);
			String content = "添加了角色：" + role2.getRid();
			this.addInfo(content);
			this.result.put("msg", "添加成功");
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="管理员管理")
	public String deleteRole() {
		Long rid = this.getModel().getRid();
		String content = "更新了角色：" + rid;
		this.addInfo(content);
		try {
			this.roleService.deleteEntryById(rid);
		} catch (Exception e) {
			// TODO: handle exception
			this.result.put("deleteInfo", "删除失败");
		}
		return SUCCESS;
	}
	public String findPrivilegeByRole() {
		Role role = this.roleService.getEntry(this.getModel().getRid());
		this.result.put("list", role.getPrivileges());
		return SUCCESS;
	}
	@PrivilegeInfo(name="管理员管理")
	public String updatePrivilege() {
		Role role = this.roleService.getEntry(this.getModel().getRid());
		Set<Privilege> privileges = new HashSet<Privilege>();
		String[] strs = this.pid.split(",");
		System.out.println(strs.length);
		for(int i = 0; i < strs.length;i++) {
			Long n = Long.valueOf(strs[i]);
			privileges.add(this.privilegeService.findPrivilege(n));
		}
		role.setPrivileges(privileges);
		this.roleService.updateEntry(role);
		Map session1 = ActionContext.getContext().getSession();
		Admin admin1 = (Admin) session1.get("admin");
		session1.put("functions", admin1.getRole().getPrivileges());
		String content = "修改了角色的权限：" + role.getRid();
		this.addInfo(content);
		return SUCCESS;
	}
}
