package com.zph.sportshop.good.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.UserService;
import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.domain.good.Brand;
import com.zph.sportshop.domain.good.Category;
import com.zph.sportshop.domain.good.Color;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.good.service.BrandService;
import com.zph.sportshop.good.service.CategoryService;
import com.zph.sportshop.good.service.GoodService;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.good.GoodQuery;
import com.zph.sportshop.util.copy.FileCopy;


@Controller("goodAction")
@Scope("prototype")
public class GoodAction extends BaseAction<Good>{
	
	@Resource(name="goodService")
	private GoodService goodService;
	@Resource(name="categoryService")
	private CategoryService categoryService;
	@Resource(name="brandService")
	private BrandService brandService;
	@Resource(name="userService")
	private UserService userService;
	private GoodQuery baseQuery = new GoodQuery();
	private Long cid;
	private Long bid;
	private String result;
	private String path;//图片路径
	private File image;//上传的图片
	private String keyword;//搜索关键词
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Long getBid() {
		return bid;
	}
	public void setBid(Long bid) {
		this.bid = bid;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String findGoodByCid() {
		baseQuery.setCid(this.cid);
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(16);
		PageResult<Good> goods = goodService.findPageResult(baseQuery);
		ActionContext.getContext().put("cid", this.cid);
		ActionContext.getContext().put("cate", categoryService.getEntry(this.cid).getCname());
		ActionContext.getContext().put("goods", goods);
		return listAction;
	}
	public String showDetail() {
		boolean fav = false;
		Good good = goodService.getEntry(this.getModel().getGid());
		//获取项目路径
		String classpath = this.getClass().getResource("/").getPath().replaceAll("WEB-INF/classes/", "");
		//获得每个商品的图片的绝对路径
		classpath = classpath+good.getImages();
		File file = new File(classpath);
		//获取商品所有图片
		File[] files = file.listFiles();
		//获取所有图片的绝对路径
		String[] images = new String[files.length];
		for(int i = 0; i < files.length;i++) {
			images[i] = good.getImages()+"/"+files[i].getName();
		}
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user==null) fav = false;
		else {
			for (Iterator iterator = user.getFavoritegoods().iterator(); iterator.hasNext();) {
				Good good1 = (Good) iterator.next();
				if(good1.getGid() == good.getGid()) {
					fav = true;
					break;
				}
			}
		}
		int commentSize = good.getComments().size();
		ActionContext.getContext().put("commentSize", commentSize);
		ActionContext.getContext().put("fav", fav);
		ActionContext.getContext().put("good", good);
		ActionContext.getContext().put("images", images);
		return "detail";
	}
	public String addFavorite() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) { 
			this.setResult("未登陆");
			return SUCCESS;
		}
		user.getFavoritegoods().add(goodService.getEntry(this.getModel().getGid()));
		userService.updateEntry(user);
		return "SUCCESS";
	}
	public String deleteFavorite() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		for (Iterator iterator = user.getFavoritegoods().iterator(); iterator.hasNext();) {
			Good good = (Good) iterator.next();
			if(good.getGid()==this.getModel().getGid()) iterator.remove();
		}
		userService.updateEntry(user);
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String listGood() {
		if(this.getKey() != null) listGoodByKey();
		else {
			baseQuery.setCurrentPage(this.getCurrentPage());
			baseQuery.setPageSize(6);
			baseQuery.setCid(this.cid);
			baseQuery.setBid(this.bid);
			PageResult<Good> goods = goodService.findPageResult(baseQuery);
			List<Category> categories = this.categoryService.findAll();
			List<Brand> brands = this.brandService.findAll();
			ActionContext.getContext().put("categories", categories);
			ActionContext.getContext().put("brands", brands);
			ActionContext.getContext().put("good", goods);
		}
		return "listgood";
	}
	@PrivilegeInfo(name="商品管理")
	public void listGoodByKey() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		baseQuery.setKey(this.getKey());
		ActionContext.getContext().put("key", this.getKey());
		PageResult<Good> goods = this.goodService.findPageResultByKey(baseQuery);
		List<Category> categories = this.categoryService.findAll();
		List<Brand> brands = this.brandService.findAll();
		ActionContext.getContext().put("categories", categories);
		ActionContext.getContext().put("brands", brands);
		ActionContext.getContext().put("good", goods);
	}
	@PrivilegeInfo(name="商品管理")
	public String listImages() {
		Good good = goodService.getEntry(this.getModel().getGid());
		//获取项目路径
		String classpath = this.getClass().getResource("/").getPath().replaceAll("WEB-INF/classes/", "");
		//获得每个商品的图片的绝对路径
		classpath = classpath+good.getImages();
		File file = new File(classpath);
		//获取商品所有图片
		File[] files = file.listFiles();
		//获取所有图片的绝对路径
		if(files != null) {
			String[] images = new String[files.length];
			for(int i = 0; i < files.length;i++) {
				images[i] = good.getImages()+"/"+files[i].getName();
			}
			ActionContext.getContext().put("images", images);
		}
		ActionContext.getContext().put("good", good);
		return "listImages";
	}
	@PrivilegeInfo(name="商品管理")
	public String updateImage() {
		String filepath1 = "/" + this.path;
		File file1 = new File(filepath1);
		String filepath2 = filepath1.replace(file1.getName(), "1.jpg");
		File file2 = new File(filepath2);
		Good good = goodService.getEntry(this.getModel().getGid());
		//获取项目路径
		String classpath = this.getClass().getResource("/").getPath().replaceAll("WEB-INF/classes/", "");
		//获得每个商品的图片的绝对路径
		classpath = classpath+good.getImages();
		new File(classpath + "/" + file1.getName()).renameTo(new File(classpath + "/abc.jpg"));
		new File(classpath + "/" + file2.getName()).renameTo(new File(classpath + "/" + file1.getName()));
		new File(classpath + "/abc.jpg").renameTo(new File(classpath + "/" + file2.getName()));
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String deleteImage() {
		String filepath1 = "/" + this.path;
		File file1 = new File(filepath1);
		Good good = goodService.getEntry(this.getModel().getGid());
		//获取项目路径
		String classpath = this.getClass().getResource("/").getPath().replaceAll("WEB-INF/classes/", "");
		//获得每个商品的图片的绝对路径
		classpath = classpath+good.getImages() + "/";
		File file2 = new File(classpath + file1.getName());
		boolean a = file2.delete();
		System.out.println(a);
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String addImage() {
		Good good = goodService.getEntry(this.getModel().getGid());
		//获取项目路径
		String classpath = this.getClass().getResource("/").getPath().replaceAll("WEB-INF/classes/", "");
		//获得每个商品的图片的绝对路径
		classpath = classpath+good.getImages();
		File file1 = new File(classpath);
		File[] files = file1.listFiles();
		if(files == null) {
			if(!file1.exists()) file1.mkdirs();
			String filename = this.image.getName();
			String srcPathStr = this.image.getAbsolutePath();
			String desPathStr = classpath;
			FileCopy.copyFile(srcPathStr, desPathStr);
			new File(desPathStr + "/" + filename).renameTo(new File(desPathStr + "/1.jpg"));
		}else {
			String srcPathStr = this.image.getAbsolutePath();
			String desPathStr = classpath;
			FileCopy.copyFile(srcPathStr, desPathStr);
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String updateGood() {
			Good good2 = this.goodService.getEntry(this.getModel().getGid());
			String content = "更新了商品：" + good2.getGname();
			this.addInfo(content);
			Brand brand = this.brandService.getEntry(this.bid);
			Category category = this.categoryService.getEntry(this.cid);
			good2.setGname(this.getModel().getGname());
			good2.setPrice(this.getModel().getPrice());
			good2.setVipPrice(this.getModel().getVipPrice());
			good2.setBrand(brand);
			good2.setCategory(category);
			this.goodService.updateEntry(good2);
			this.result = "更新成功";
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String addGood() {
		Good good1 = this.goodService.findByName(this.getModel().getGname());
		if(good1 != null) this.result = "该商品名字已经存在";
		else {
			Good good2 = new Good();
			Brand brand = this.brandService.getEntry(this.bid);
			Category category = this.categoryService.getEntry(this.cid);
			good2.setGname(this.getModel().getGname());
			good2.setPrice(this.getModel().getPrice());
			good2.setVipPrice(this.getModel().getVipPrice());
			good2.setBrand(brand);
			good2.setCategory(category);
			goodService.saveEntry(good2);
			this.result = "添加成功";
			String content = "添加了商品：" + good2.getGid();
			this.addInfo(content);
			Good good3 = this.goodService.findByName(this.getModel().getGname());
			String imagespath = "images/" + good3.getGid();
			good3.setImages(imagespath);
			this.goodService.updateEntry(good3);
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String deleteGood() {
		String content = "删除了商品：" + this.getModel().getGid();
		this.addInfo(content);
		this.goodService.deleteEntryById(this.getModel().getGid());
		return SUCCESS;
	}
	public String searchGood() {
		List<Good> goods = this.goodService.findByKey(this.keyword);
		ActionContext.getContext().put("goods", goods);
		ActionContext.getContext().put("keyword", this.keyword);
		return "searchGood";
	}
	public String listNewGood() {
		List<Good> newGoods = this.goodService.findNewGoods();
		ActionContext.getContext().put("newGoods", newGoods);
		return "homepage";
	}
}
