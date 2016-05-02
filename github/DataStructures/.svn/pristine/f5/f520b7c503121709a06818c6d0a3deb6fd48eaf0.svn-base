package com.sqisoft.iqs.admin.menu.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.admin.menu.dao.MenuDAO;
import com.sqisoft.iqs.admin.menu.vo.CategoryVO;
import com.sqisoft.iqs.admin.menu.vo.MenuVO;
import com.sqisoft.iqs.admin.menu.vo.MyMenuVO;
import com.sqisoft.iqs.admin.menu.vo.PhotoVO;

public class MenuDAOImpl extends SqlSessionDaoSupport implements MenuDAO {
	
	
	@Override
	public List<PhotoVO> getPhotoList() {
		return getSqlSession().selectList("menuDAO.getPhotoList");
	}
	
	@Override
	public PhotoVO getPhotoInfo(Map<String, String> param) {
		return getSqlSession().selectOne("menuDAO.getPhotoInfo", param);
	}
	
	@Override
	public void updatePhoto(PhotoVO photoVO) {
		getSqlSession().update("menuDAO.updatePhoto", photoVO);
	}

	@Override
	public List<CategoryVO> getCategoryList() {
		return getSqlSession().selectList("menuDAO.getCategoryList");
	}
	
	@Override
	public boolean existCategoryName(String categoryName) {
		int count = getSqlSession().selectOne("menuDAO.existCategoryName", categoryName);
		return count > 0;
	}
	
	@Override
	public void insertCategory(CategoryVO category) {
		getSqlSession().insert("menuDAO.insertCategory", category);
	}
	
	@Override
	public CategoryVO getCategoryById(int categoryId) {
		return getSqlSession().selectOne("menuDAO.getCategoryById", categoryId);
	}
	
	@Override
	public void modifyCategory(CategoryVO category) {
		getSqlSession().update("menuDAO.modifyCategory", category);
	}
	
	@Override
	public void deleteCategoryById(int categoryId) {
		getSqlSession().delete("menuDAO.deleteCategoryById", categoryId);
	}
	
	// 메인 메뉴 ----------------------------------
	// 관리자 메인
	@Override
	public List<MenuVO> getMenuList(Map<String, Integer> params) {
		return getSqlSession().selectList("menuDAO.getMenuList", params);
	}
	
	// 일반 사용자
	@Override
	public List<MenuVO> getNonAdminMenuList(Map<String, Integer> params) {
		return getSqlSession().selectList("menuDAO.getNonAdminMenuList", params);
	}
	
	// 임원
	@Override
	public List<MenuVO> getBoardMemberMenuList(Map<String, Integer> params) {
		return getSqlSession().selectList("menuDAO.getBoardMemberMenuList", params);
	}

	// 영업
	@Override
	public List<MenuVO> getSalesWomanMenuList(Map<String, Integer> params) {
		return getSqlSession().selectList("menuDAO.getSalesWomanMenuList", params);
	}

	// 인사
	@Override
	public List<MenuVO> getEstimationViewAndSignupMenuList(
			Map<String, Integer> params) {
		return getSqlSession().selectList("menuDAO.getEstimationViewAndSignupMenuList", params);
	}

	// 회계
	@Override
	public List<MenuVO> getIncludeAdminMenuList(Map<String, Integer> params) {
		return getSqlSession().selectList("menuDAO.getIncludeAdminMenuList", params);
	}
	
	// ------------------------------------

	@Override
	public int getMaxCategoryMenuSq(int categoryId) {
		return getSqlSession().selectOne("menuDAO.getMaxCategoryMenuSq", categoryId);
	}
	
	@Override
	public boolean existMenuNameAjax(Map<String, Object> params) {
		int count = getSqlSession().selectOne("menuDAO.existMenuNameAjax", params);
		return count > 0;
	}
	
	@Override
	public boolean existCategoryIdAndMenuSq(Map<String, Integer> params) {
		int count = getSqlSession().selectOne("menuDAO.existCategoryIdAndMenuSq", params);
		return count > 0;
	}
	
	@Override
	public void insertMenu(MenuVO menu) {
		getSqlSession().insert("menuDAO.insertMenu", menu);
	}
	
	@Override
	public void updateChangeMenuSq(Map<String, Integer> params) {
		getSqlSession().update("menuDAO.updateChangeMenuSq", params);
	}

	@Override
	public void updateMenu(MenuVO menu) {
		getSqlSession().update("menuDAO.updateMenu", menu);
	}
	
	@Override
	public MenuVO getMenuByMenuSqAndCategoryId(Map<String, Integer> params) {
		return getSqlSession().selectOne("menuDAO.getMenuByMenuSqAndCategoryId", params);
	}
	
	@Override
	public void deleteMenu(Map<String, Integer> params) {
		getSqlSession().delete("menuDAO.deleteMenu", params);
	}
	
	@Override
	public boolean existMyMenu(Map<String, Object> params) {
		int count = getSqlSession().selectOne("menuDAO.existMyMenu", params);
		return count > 0;
	}
	
	@Override
	public void insertMyMenu(Map<String, Object> params) {
		getSqlSession().insert("menuDAO.insertMyMenu", params);
	}
	
	@Override
	public List<MyMenuVO> getMyMenuListByEmail(String email) {
		return getSqlSession().selectList("menuDAO.getMyMenuListByEmail", email);
	}
	
	@Override
	public void deleteMyMenu(Map<String, Object> params) {
		getSqlSession().delete("menuDAO.deleteMyMenu", params);
	}
	
	@Override
	public void deleteMyMenuByUpdateBegin(Map<String, Object> params) {
		getSqlSession().delete("menuDAO.deleteMyMenuByUpdateBegin", params);
	}

}
