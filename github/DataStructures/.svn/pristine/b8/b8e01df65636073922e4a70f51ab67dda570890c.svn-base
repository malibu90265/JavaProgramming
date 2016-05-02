package com.sqisoft.iqs.admin.menu.service;

import java.util.List;

import com.sqisoft.iqs.admin.menu.vo.CategoryVO;
import com.sqisoft.iqs.admin.menu.vo.MenuVO;
import com.sqisoft.iqs.admin.menu.vo.MyMenuVO;
import com.sqisoft.iqs.admin.menu.vo.PhotoVO;

public interface MenuService {

	//
	public List<CategoryVO> getCategoryList();

	public boolean existCategoryName(String categoryName);
	
	public void insertCategory(CategoryVO category);

	public CategoryVO getCategoryById(int categoryId);

	public void modifyCategory(CategoryVO category);

	public void deleteCategoryById(int categoryId);

	// 메인메뉴 리스트 --------------
	public List<MenuVO> getMenuList(int categoryId);						// 시스템관리자
	public List<MenuVO> getNonAdminMenuList(int categoryId);				// 일반 사용자
	public List<MenuVO> getBoardMemberMenuList(int categoryId);			// 임원
	public List<MenuVO> getSalesWomanMenuList(int categoryId);				// 영업
	public List<MenuVO> getEstimationViewAndSignupMenuList(int categoryId); // 인사
	public List<MenuVO> getIncludeAdminMenuList(int categoryId);			// 회계
	// ----------------------------
	
	public int getMaxCategoryMenuSq(int categoryId);

	public boolean existMenuNameAjax(int categoryId, String menuName);
	
	public void insertMenu(MenuVO menu);
	
	public void updateChangeMenuSq(int categoryId, int menuSq, int maxSq);

	public void updateMenu(MenuVO menu);
	
	public MenuVO getMenuByMenuSqAndCategoryId(int menuSq, int categoryId);

	public boolean existMyMenu(String memberId, int categoryId, int menuSq);
	
	public void insertMyMenu(String memberId, int categoryId, int menuSq, int seq);

	public List<MyMenuVO> getMyMenuListByEmail(String email);

	public void deleteMyMenu(String email, int seq);

	public void updateMyMenu(String email, int categoryId, int menuSq, int seq);

	public void deleteMenu(int categoryId, int menuSq);

	public boolean existCategoryIdAndMenuSq(int categoryId, int menuSq);

	public List<PhotoVO> getPhotoList();

	public PhotoVO getPhotoInfo(String photoIndex);

	public void updatePhoto(PhotoVO photoVO);

}
