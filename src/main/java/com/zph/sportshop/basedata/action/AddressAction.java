package com.zph.sportshop.basedata.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.AddressService;
import com.zph.sportshop.domain.basedata.Address;
import com.zph.sportshop.domain.basedata.User;

@Controller("addressAction")
@Scope("prototype")
public class AddressAction extends BaseAction<Address>{
	
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Resource(name="addressService")
	private AddressService addressService;
	
	public String addAddress() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		Address address = this.getModel();
		address.setUser(user);
		this.addressService.saveEntry(address);
		this.setResult("添加成功");
		return SUCCESS;
	}
	public String updateAddress() {
		Address address = addressService.getEntry(this.getModel().getAid());
		address.setCity(this.getModel().getCity());
		address.setProvince(this.getModel().getProvince());
		address.setCounty(this.getModel().getCounty());
		address.setConname(this.getModel().getConname());
		address.setDetailaddr(this.getModel().getDetailaddr());
		address.setContel(this.getModel().getContel());
		this.addressService.updateEntry(address);
		this.setResult("更新成功");
		return SUCCESS;
	}
	public String deleteAddress() {
		this.addressService.deleteEntryById(this.getModel().getAid());
		this.setResult("删除成功");
		return SUCCESS;
	}
}
