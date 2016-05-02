package com.sqisoft.iqs.admin.menu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.admin.menu.service.MenuService;
import com.sqisoft.iqs.admin.menu.vo.CategoryVO;
import com.sqisoft.iqs.admin.menu.vo.MenuVO;
import com.sqisoft.iqs.admin.menu.vo.MyMenuVO;
import com.sqisoft.iqs.admin.menu.vo.PhotoVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class MenuController {

	private MenuService menuService;

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@RequestMapping("/common/getLoginHeaderAjax")
	public String getLoginHeaderAjax() {
		return "common/login_header";
	}
	
	@RequestMapping("/common/getChangePasswordPageAjax")
	public String getChangePasswordPageAjax() {
		return "common/changePassword";
	}
	
	// main
	@RequestMapping("/admin/main")
	public String mainPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO =  SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null || loginVO.getAccount().equals("n")) {
			return "/common/loginErrorPage";
		}
		return "admin/main/main";
	}
	
	@RequestMapping("/admin/getMenuListPage")
	public ModelAndView getMenuListPage(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		// 세션에서 이메일 가져오기
		LoginVO loginVO = new LoginVO();
		HttpSession session = request.getSession();
		loginVO =  SessionUtil.get(session, Session.MEMBER);
		
		String account = loginVO.getAccount();	// 로그인 권한
		String hr_position = loginVO.getHr_position();	// 직급(임원) 구분
		String hr_job_skill = loginVO.getHr_job_skill();	// 사업관리, 인사담당 구분
		String hrRole = loginVO.getHr_role();	// PM 구분
		
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		if(account.equals("s")) {	// 관리자 메뉴
			menuList = this.menuService.getMenuList(categoryId);
			
			view.addObject("menuList", menuList);
			view.setViewName("admin/main/menuListPage");
		}
		else if(account.equals("y")){	// 로그인 가능 권한
			
			if(hrRole== null || hrRole== "") {
				menuList = this.menuService.getNonAdminMenuList(categoryId);
			}
			else {
				if(hr_position.contains("임원")) {
					if(hrRole.contains("PM")) {
						menuList = this.menuService.getSalesWomanMenuList(categoryId);
					}
					else {
						menuList = this.menuService.getBoardMemberMenuList(categoryId);
					}
				}
				else {
					menuList = this.menuService.getNonAdminMenuList(categoryId);
					if(hr_job_skill.contains("영업")) {
						menuList = this.menuService.getSalesWomanMenuList(categoryId);
					}
					else {
						if(hr_job_skill.contains("인사") || hrRole.contains("PM")) {
							menuList = this.menuService.getEstimationViewAndSignupMenuList(categoryId);
						}
						else {
							if(hr_job_skill.contains("회계")) {
								menuList = this.menuService.getIncludeAdminMenuList(categoryId);
							}
							else {
								menuList = this.menuService.getNonAdminMenuList(categoryId);
							}
						}
						
					}
					
				}
			}
			view.addObject("menuList", menuList);
			view.setViewName("admin/main/menuListPage");
		}
		else {	// 로그인 불가인데 들어왔을 경우
			view.setViewName("/common/loginErrorPage");
		}
		
		return view;
	}
	
	@RequestMapping("/admin/photo")
	public ModelAndView getPhotoList(HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			view.setViewName("common/loginErrorPage");
		}
		List<PhotoVO> photoList = this.menuService.getPhotoList();
		
		view.setViewName("/admin/menu/photo");
		view.addObject("photoList", photoList);
		return view;
	}
	
	@RequestMapping(value="/admin/doUpdate" ,method=RequestMethod.POST)
	public ModelAndView doUpdatePhoto(@Valid PhotoVO photoVO, Errors errors){
		
		ModelAndView view = new ModelAndView();

		if(errors.hasErrors()){
			view.setViewName("common/loginErrorPage");
		}
		//업로드된 파일을 가져온다. 
		MultipartFile uploadedFile = photoVO.getUploadFile();
		
		if(uploadedFile != null){
			//파일이 저장될 결로는 지정한다. 
			String uploadedFileName = uploadedFile.getOriginalFilename();
			
			photoVO.setRealFileName(uploadedFileName);
			
			File destFileDir = new File("//uploadedFiles//");
			
			if(!destFileDir.exists()){
				destFileDir.mkdirs();
			}
			
			//c:\\uploadedFiles에 저장한다. Linux Path. 
			File destFile = new File("//uploadedFiles//", uploadedFileName);
			try{
				uploadedFile.transferTo(destFile);
			}catch(IllegalStateException | IOException e){
				throw new RuntimeException(e.getMessage(), e);
			}	
		}
		this.menuService.updatePhoto(photoVO);
		view.setViewName("redirect:photo");
		return view;
		
	}
	
	@RequestMapping("/admin/download/{photoIndex}")
	public void fileDownload(@PathVariable String photoIndex, HttpServletRequest request, HttpServletResponse response){
		PhotoVO fileInfo = this.menuService.getPhotoInfo(photoIndex);
		String realFileName = fileInfo.getRealFileName().trim();
		File downloadFile = new File("//uploadedFiles//"+realFileName);
		
		
		try{
		if(downloadFile == null){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		response.setContentType("application/download; charset=UTF-8");
	    response.setContentLength((int)downloadFile.length());
		//사용자의 브라우저 종류를 가져온다.
		String userAgent = request.getHeader("User-Agent");
		boolean isMsie = userAgent.indexOf("MSIE") >-1;
		
		String fileName = null;
		if(isMsie){
			fileName = URLEncoder.encode(fileInfo.getRealFileName(), "UTF-8");
		}
		else{
			fileName = new String (fileInfo.getRealFileName().getBytes("UTF-8"), "ISO-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream(downloadFile);
			FileCopyUtils.copy(fis, out);
			out.flush();
		}
		finally{
			if(fis != null){
				fis.close();
			}
			if(out != null){
				out.close();
			}
		}
		}
		catch(Exception e){
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	
	
	// mymenu
	@RequestMapping("/admin/getMiniHeaderAjax")
	public ModelAndView getMiniHeaderAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		LoginVO logined = SessionUtil.get(request.getSession(), Session.MEMBER);
		String email = logined.getEmail();
		
		List<MyMenuVO> myMenuList = this.menuService.getMyMenuListByEmail(email);
		Map<Integer, MyMenuVO> myMenuListMap = new HashMap<Integer, MyMenuVO>();
		for(MyMenuVO myMenu : myMenuList) {
			myMenuListMap.put(myMenu.getSeq(), myMenu);
		}
		
		view.addObject("mymenu", myMenuListMap);
		view.setViewName("/common/login_header_mini");
		
		return view;
		
	}
	
	@RequestMapping("/admin/getMyMenuHeaderAjax")
	public ModelAndView getMyMenuHeaderAjax(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		LoginVO logined = SessionUtil.get(request.getSession(), Session.MEMBER);
		String email = logined.getEmail();
		
		List<MyMenuVO> myMenuList = this.menuService.getMyMenuListByEmail(email);
		Map<Integer, MyMenuVO> myMenuListMap = new HashMap<Integer, MyMenuVO>();
		for(MyMenuVO myMenu : myMenuList) {
			myMenuListMap.put(myMenu.getSeq(), myMenu);
		}
		
		view.addObject("myMenuListMap", myMenuListMap);
		view.setViewName("admin/main/mymenu");
		
		return view;
	}
	
	@RequestMapping("/admin/existMyMenuAjax")
	@ResponseBody
	public Map<String, Boolean> existMyMenuAjax(HttpServletRequest request) {
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		
		LoginVO logined = SessionUtil.get(request.getSession(), Session.MEMBER);
		String memberId = logined.getEmail();
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int menuSq = Integer.parseInt(request.getParameter("menuSq"));
		
		boolean existResult = this.menuService.existMyMenu(memberId, categoryId, menuSq);
		
		result.put("result", existResult);
		
		return result;
	}
	
	@RequestMapping("/admin/insertMyMenuAjax")
	@ResponseBody
	public void insertMyMenuAjax(HttpServletRequest request) {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int menuSq = Integer.parseInt(request.getParameter("menuSq"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		LoginVO logined = SessionUtil.get(request.getSession(), Session.MEMBER);
		String memberId = logined.getEmail();
		
		this.menuService.insertMyMenu(memberId, categoryId, menuSq, seq);
	}
	
	@RequestMapping("/admin/updateMyMenuAjax")
	@ResponseBody
	public void updateMyMenuAjax(HttpServletRequest request) {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int menuSq = Integer.parseInt(request.getParameter("menuSq"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		LoginVO logined = SessionUtil.get(request.getSession(), Session.MEMBER);
		String email = logined.getEmail();
		
		this.menuService.updateMyMenu(email, categoryId, menuSq, seq);
	}
	
	@RequestMapping("/admin/deleteMyMenuAjax")
	@ResponseBody
	public void deleteMyMenuAjax(HttpServletRequest request) {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		LoginVO logined = SessionUtil.get(request.getSession(), Session.MEMBER);
		String email = logined.getEmail();
		
		this.menuService.deleteMyMenu(email, seq);
		
	}
	
	// admin/menu
	
	@RequestMapping("/admin/menu")
	public String adminMainPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "admin/menu/menu";
	}
	
	@RequestMapping("/admin/getCategoryListAjax")
	public ModelAndView getCategoryListAjax() {
		
		List<CategoryVO> categoryList = this.menuService.getCategoryList();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("categoryList", categoryList);
		view.setViewName("admin/menu/categoryList");
		
		return view;
	}
	
	@RequestMapping("/admin/getCategoryInsertFormAjax")
	public String getCategoryInsertFormAjax() {
		return "admin/menu/categoryInsertForm";
	}
	
	@RequestMapping("/admin/existCategoryNameAjax")
	@ResponseBody
	public Map<String, Boolean> existCategoryNameAjax(HttpServletRequest request) {
		
		String categoryName = request.getParameter("categoryName");
		
		boolean result = this.menuService.existCategoryName(categoryName);
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		resultMap.put("result", result);
		
		return resultMap;
	}
	
	@RequestMapping("/admin/insertCategoryAjax")
	@ResponseBody
	public void insertCategoryAjax(CategoryVO category) {
		this.menuService.insertCategory(category);
	}
	
	@RequestMapping("/admin/getCategoryModifyFormAjax/{categoryId}")
	public ModelAndView getCategoryModifyFormAjax(@PathVariable int categoryId) {
		
		CategoryVO category = this.menuService.getCategoryById(categoryId);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("category", category);
		view.setViewName("admin/menu/categoryModifyForm");
		
		return view;
	}
	
	@RequestMapping("/admin/modifyCategoryAjax")
	@ResponseBody
	public Map<String, Integer> modifyCategoryAjax(CategoryVO category) {
		
		this.menuService.modifyCategory(category);
		
		int categoryId = category.getId();
		
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("id", categoryId);
		
		return result;
	}
	
	@RequestMapping("/admin/deleteCategoryAjax/{categoryId}")
	@ResponseBody
	public void deleteCategoryAjax(@PathVariable int categoryId) {
		this.menuService.deleteCategoryById(categoryId);
	}
	
	// Menu 
	@RequestMapping("/admin/getMenuSearchPageAjax")
	public ModelAndView getMenuSearchPageAjax(HttpServletRequest request) {
		List<CategoryVO> categoryList = this.menuService.getCategoryList();
		
		ModelAndView view =  new ModelAndView();
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		view.addObject("categoryId", categoryId);
		view.addObject("categoryList", categoryList);
		view.setViewName("admin/menu/menuSearchPage");
		
		return view;
	}
	
	@RequestMapping("/admin/getMenuListAjax")
	public ModelAndView getMenuListAjax(HttpServletRequest request) {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		List<MenuVO> menuList = this.menuService.getMenuList(categoryId);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("menuList", menuList);
		view.setViewName("admin/menu/menuList");
		
		return view;
	}
	
	@RequestMapping("/admin/getMenuInsertFormAjax")
	public ModelAndView getMenuInsertFormAjax() {
		
		List<CategoryVO> categoryList = this.menuService.getCategoryList();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("categoryList", categoryList);
		view.setViewName("admin/menu/menuInsertForm");
		
		return view;
	}
	
	@RequestMapping("/admin/existMenuNameAjax")
	@ResponseBody
	public Map<String, Object> existMenuNameAjax(HttpServletRequest request) {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String menuName = request.getParameter("menuName");
		
		boolean result = this.menuService.existMenuNameAjax(categoryId, menuName);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String categoryName = "";
		if(result) {
			CategoryVO category = this.menuService.getCategoryById(categoryId);
			categoryName = category.getName();
		}
		
		resultMap.put("result", result);
		resultMap.put("categoryName", categoryName);
		
		return resultMap;
	}
	
	@RequestMapping("/admin/insertMenuAjax")
	@ResponseBody
	public void insertMenuAjax(MenuVO menu) {
		
		int categoryId = menu.getCategoryId();
		int menuSq = menu.getSq();
		
		boolean existResult = this.menuService.existCategoryIdAndMenuSq(categoryId, menuSq);
		if(existResult) {
			int maxSq = this.menuService.getMaxCategoryMenuSq(categoryId)+1;
			this.menuService.updateChangeMenuSq(categoryId, menuSq, maxSq);
		}
		
		this.menuService.insertMenu(menu);
	}
	
	@RequestMapping("/admin/getMenuModifyFormAjax/{categoryId}/{menuSq}")
	public ModelAndView getCategoryModifyFormAjax(@PathVariable int categoryId, @PathVariable int menuSq) {
		
		MenuVO menu = this.menuService.getMenuByMenuSqAndCategoryId(menuSq, categoryId);
		
		List<CategoryVO> categoryList = this.menuService.getCategoryList();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("categoryList", categoryList);
		view.addObject("menu", menu);
		view.setViewName("admin/menu/menuModifyForm");
		
		return view;
	}
	
	@RequestMapping("/admin/modifyMenuAjax")
	@ResponseBody
	public Map<String, Integer> modifyMenuAjax(MenuVO menu) {
		
		int originalCategoryId = menu.getOriginalCategoryId();
		int modifyCategoryId = menu.getCategoryId();
		int originalSq = menu.getOriginalSq();
		int modifySq = menu.getSq();
		
		int maxSq = this.menuService.getMaxCategoryMenuSq(modifyCategoryId)+1;
		
		if(modifySq == originalSq && modifyCategoryId == originalCategoryId) {
			// name or url 만 바꾸는 경우
			this.menuService.updateMenu(menu);
		} else {
			boolean existResult = this.menuService.existCategoryIdAndMenuSq(modifyCategoryId, modifySq);
			// 대분류 or 메뉴순서 까지 포함해서 바꾸는 경우
			// 1. 이미 있는 메뉴의 순서를 맨 마지막으로 보낸다.
			if(existResult) {
				this.menuService.updateChangeMenuSq(modifyCategoryId, modifySq, maxSq);
			}
			
			// 2. 바꿀려는 메뉴를 그 자리에 update해준다.
			this.menuService.updateMenu(menu);
			
			// 3. 대분류는 동일하고 순서만 바꿨을 경우는 맨 마지막을 옮겨지는 메뉴를 그 자리에 들어가는 메뉴의 순서로 보내준다. 
			if(modifyCategoryId == originalCategoryId && existResult) {
				this.menuService.updateChangeMenuSq(modifyCategoryId, maxSq, originalSq);
			}
		}
		
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("categoryId", modifyCategoryId);
		result.put("sq", modifySq);
		
		return result;
	}
	
	@RequestMapping("/admin/deleteMenuAjax/{categoryId}/{menuSq}")
	@ResponseBody
	public void deleteMenuAjax(@PathVariable int categoryId, @PathVariable int menuSq) {
		this.menuService.deleteMenu(categoryId, menuSq);
	}
	
}
