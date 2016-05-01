package com.sqisoft.iqs.admin.menu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.admin.menu.dao.MenuDAO;
import com.sqisoft.iqs.admin.menu.service.MenuService;
import com.sqisoft.iqs.admin.menu.vo.CategoryVO;
import com.sqisoft.iqs.admin.menu.vo.MenuVO;
import com.sqisoft.iqs.admin.menu.vo.MyMenuVO;
import com.sqisoft.iqs.admin.menu.vo.PhotoVO;

public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	
	@Override
	public List<PhotoVO> getPhotoList() {
		return this.menuDAO.getPhotoList();
	}
	
	@Override
	public PhotoVO getPhotoInfo(String photoIndex) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("photoIndex", photoIndex);
		return this.menuDAO.getPhotoInfo(param);
	}
	
	@Override
	public void updatePhoto(PhotoVO photoVO) {
		this.menuDAO.updatePhoto(photoVO);
	}

	@Override
	public List<CategoryVO> getCategoryList() {
		List<CategoryVO> categoryList = this.menuDAO.getCategoryList();
		if(categoryList == null) categoryList = new ArrayList<CategoryVO>();
		return categoryList;
	}
	
	@Override
	public boolean existCategoryName(String categoryName) {
		return this.menuDAO.existCategoryName(categoryName);
	}
	
	@Override
	public void insertCategory(CategoryVO category) {
		this.menuDAO.insertCategory(category);
	}
	
	@Override
	public CategoryVO getCategoryById(int categoryId) {
		CategoryVO category =  this.menuDAO.getCategoryById(categoryId);
		if(category == null) category = new CategoryVO();
		return category;
	}
	
	@Override
	public void modifyCategory(CategoryVO category) {
		this.menuDAO.modifyCategory(category);
	}
	
	@Override
	public void deleteCategoryById(int categoryId) {
		this.menuDAO.deleteCategoryById(categoryId);
	}
	
	// 메인 메뉴 ------------------------------------------
	// 관리자 메인
	@Override
	public List<MenuVO> getMenuList(int categoryId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("categoryId", categoryId);
		
		List<MenuVO> menuList = this.menuDAO.getMenuList(params);
		if(menuList == null) menuList = new ArrayList<MenuVO>();
		return menuList;
	}

	// 일반 사용자
	@Override
	public List<MenuVO> getNonAdminMenuList(int categoryId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("categoryId", categoryId);
		
		List<MenuVO> menuList = this.menuDAO.getNonAdminMenuList(params);
		if(menuList == null) menuList = new ArrayList<MenuVO>();
		return menuList;
	}
	
	// 임원
	@Override
	public List<MenuVO> getBoardMemberMenuList(int categoryId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("categoryId", categoryId);
		
		List<MenuVO> menuList = this.menuDAO.getBoardMemberMenuList(params);
		if(menuList == null) menuList = new ArrayList<MenuVO>();
		return menuList;
	}

	// 영업
	@Override
	public List<MenuVO> getSalesWomanMenuList(int categoryId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("categoryId", categoryId);
		
		List<MenuVO> menuList = this.menuDAO.getSalesWomanMenuList(params);
		if(menuList == null) menuList = new ArrayList<MenuVO>();
		return menuList;
	}

	// 인사
	@Override
	public List<MenuVO> getEstimationViewAndSignupMenuList(int categoryId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("categoryId", categoryId);
		
		List<MenuVO> menuList = this.menuDAO.getEstimationViewAndSignupMenuList(params);
		if(menuList == null) menuList = new ArrayList<MenuVO>();
		return menuList;
	}

	// 회계
	@Override
	public List<MenuVO> getIncludeAdminMenuList(int categoryId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("categoryId", categoryId);
		
		List<MenuVO> menuList = this.menuDAO.getIncludeAdminMenuList(params);
		if(menuList == null) menuList = new ArrayList<MenuVO>();
		return menuList;
	}
	// -------------------------------------------------
	
	@Override
	public int getMaxCategoryMenuSq(int categoryId) {
		return this.menuDAO.getMaxCategoryMenuSq(categoryId);
	}
	
	@Override
	public boolean existMenuNameAjax(int categoryId, String menuName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		params.put("menuName", menuName);
		
		return this.menuDAO.existMenuNameAjax(params);
	}
	
	@Override
	public boolean existCategoryIdAndMenuSq(int categoryId, int menuSq) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("categoryId", categoryId);
		params.put("menuSq", menuSq);
		
		return this.menuDAO.existCategoryIdAndMenuSq(params);
	}
	
	@Override
	public void insertMenu(MenuVO menu) {
		this.menuDAO.insertMenu(menu);
	}
	
	@Override
	public void updateChangeMenuSq(int categoryId, int menuSq, int maxSq) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("categoryId", categoryId);
		params.put("menuSq", menuSq);
		params.put("maxSq", maxSq);
		
		this.menuDAO.updateChangeMenuSq(params);
	}
	
	@Override
	public void updateMenu(MenuVO menu) {
		this.menuDAO.updateMenu(menu);
	}
	
	@Override
	public void deleteMenu(int categoryId, int menuSq) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("categoryId", categoryId);
		params.put("menuSq", menuSq);
		
		this.menuDAO.deleteMenu(params);
	}
	
	@Override
	public MenuVO getMenuByMenuSqAndCategoryId(int menuSq, int categoryId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("menuSq", menuSq);
		params.put("categoryId", categoryId);
		
		return this.menuDAO.getMenuByMenuSqAndCategoryId(params);
	}
	
	@Override
	public boolean existMyMenu(String memberId, int categoryId, int menuSq) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", memberId);
		params.put("categoryId", categoryId);
		params.put("menuSq", menuSq);
		
		return this.menuDAO.existMyMenu(params);
	}
	
	@Override
	public void insertMyMenu(String memberId, int categoryId, int menuSq, int seq) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", memberId);
		params.put("categoryId", categoryId);
		params.put("menuSq", menuSq);
		params.put("seq", seq);
		
		this.menuDAO.insertMyMenu(params);
	}
	
	@Override
	public List<MyMenuVO> getMyMenuListByEmail(String email) {
		List<MyMenuVO> myMenuList = this.menuDAO.getMyMenuListByEmail(email);
		if(myMenuList == null) myMenuList = new ArrayList<MyMenuVO>();
		return myMenuList;
	}
	
	@Override
	public void deleteMyMenu(String email, int seq) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		params.put("seq", seq);
		
		this.menuDAO.deleteMyMenu(params);
	}
	
	@Override
	public void updateMyMenu(String email, int categoryId, int menuSq, int seq) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		params.put("categoryId", categoryId);
		params.put("menuSq", menuSq);
		params.put("seq", seq);
		
		this.menuDAO.deleteMyMenuByUpdateBegin(params);
		
		this.menuDAO.insertMyMenu(params);
	}

}
