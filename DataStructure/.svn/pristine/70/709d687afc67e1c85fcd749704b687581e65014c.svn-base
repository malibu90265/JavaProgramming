package com.sqisoft.iqs.admin.menu.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.admin.menu.vo.CategoryVO;
import com.sqisoft.iqs.admin.menu.vo.MenuVO;
import com.sqisoft.iqs.admin.menu.vo.MyMenuVO;
import com.sqisoft.iqs.admin.menu.vo.PhotoVO;

public interface MenuDAO {

	public List<CategoryVO> getCategoryList();

	public boolean existCategoryName(String categoryName);
	
	public void insertCategory(CategoryVO category);

	public CategoryVO getCategoryById(int categoryId);

	public void modifyCategory(CategoryVO category);

	public void deleteCategoryById(int categoryId);
	// 메인 메뉴 --------------------------------
	public List<MenuVO> getMenuList(Map<String, Integer> params);		// 관리자
	public List<MenuVO> getNonAdminMenuList(Map<String, Integer> params);	// 일반 사용자
	public List<MenuVO> getBoardMemberMenuList(Map<String, Integer> params);	// 임원
	public List<MenuVO> getSalesWomanMenuList(Map<String, Integer> params);		// 영업
	public List<MenuVO> getEstimationViewAndSignupMenuList(Map<String, Integer> params);	// 인사
	public List<MenuVO> getIncludeAdminMenuList(Map<String, Integer> params);	// 회계
	// ------------------------
	
	public int getMaxCategoryMenuSq(int categoryId);

	public boolean existMenuNameAjax(Map<String, Object> params);
	
	public void insertMenu(MenuVO menu);

	public void updateChangeMenuSq(Map<String, Integer> params);
	
	public void updateMenu(MenuVO menu);
	
	public MenuVO getMenuByMenuSqAndCategoryId(Map<String, Integer> params);
	
	public void deleteMenu(Map<String, Integer> params);

	public boolean existMyMenu(Map<String, Object> params);

	public void insertMyMenu(Map<String, Object> params);

	public List<MyMenuVO> getMyMenuListByEmail(String email);

	public void deleteMyMenu(Map<String, Object> params);

	public void deleteMyMenuByUpdateBegin(Map<String, Object> params);

	public boolean existCategoryIdAndMenuSq(Map<String, Integer> params);

	public List<PhotoVO> getPhotoList();

	public PhotoVO getPhotoInfo(Map<String, String> param);

	public void updatePhoto(PhotoVO photoVO);

}
