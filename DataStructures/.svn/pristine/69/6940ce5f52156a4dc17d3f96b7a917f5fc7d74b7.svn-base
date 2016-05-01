package first.sample.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.common.common.CommandMap;
import first.sample.service.SampleService;

/*
	Controller : 웹 클라이언트에서 들어온 요청을 해당 비지니스 로직(Service에서 처리)을 호출하고, 수행 결과와 함께 응답을 해주는 Dispatcher 역할을 한다.
	클래스 선언부에 있는 @Controller 어노테이션(Anotation)을 이용하여 Controller 객체임을 선언한다.
 */

@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());

	//Service 영역의 접근을 위한 선언. Resouce 어노테이션을 통해서 필요한 빈(bean)을 수동으로 등록.
	@Resource(name = "sampleService")
	private SampleService sampleService;

	// @RequestMapping은 요청 URL을 의미한다. 우리가 /sample/openBoardList.do 라는 주소를
	// 호출하게되면,
	// 이 주소는 @RequestMapping 어노테이션과 매핑되어, 해당 메소드가 실행된다.
	@RequestMapping(value = "/sample/openBoardList.do")
	public ModelAndView openSampleBoardList(Map<String, Object> commandMap) throws Exception {
		// 화면에 보여줄 jsp 파일
		ModelAndView mv = new ModelAndView("/sample/boardList");

		// 게시판에 필요한 정보(글번호, 글제모 작성일 등)를 Map에 저장.
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
		
		//Service 로직의 결과를 ModelAndView 객체에 담아서 클라이언트, 즉 jsp에서 그 결과를 사용할 수 있도록 한다.
		mv.addObject("list", list);

		return mv;
	}
	
	@RequestMapping(value="/sample/testMapArgumentResolver.do")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("");
	     
	    if(commandMap.isEmpty() == false){
	        Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
	        Entry<String,Object> entry = null;
	        while(iterator.hasNext()){
	            entry = iterator.next();
	            log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
	        }
	    }
	    return mv;
	}
	
	@RequestMapping(value="/sample/openBoardWrite.do")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/sample/boardWrite");
	     
	    return mv;
	}
	
	@RequestMapping(value="/sample/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
		//화면에서 전송한 모든 데이터는 HttpServletRequest에 담겨서 전송된다. 여기서 첨부파일은 CommandMap 처리를 하지 않아 HttpServletRequest를 추가로 받도록 하였다.
	    ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
	     
	    sampleService.insertBoard(commandMap.getMap(), request);
	     
	    return mv;
	}
	
	@RequestMapping(value="/sample/openBoardDetail.do")
	public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardDetail");
	    Map<String,Object> map = sampleService.selectBoardDetail(commandMap.getMap());
	    //게시글과 첨부파일목록 2가지를 반환
	    mv.addObject("map", map.get("map"));
	    mv.addObject("list", map.get("list"));
	     
	    return mv;
	}
	
	@RequestMapping(value="/sample/openBoardUpdate.do")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/sample/boardUpdate");
	     
	    Map<String,Object> map = sampleService.selectBoardDetail(commandMap.getMap());
	    mv.addObject("map", map);
	    mv.addObject("list", map.get("list"));
	    
	    return mv;
	}
	 
	@RequestMapping(value="/sample/updateBoard.do")
	public ModelAndView updateBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail.do");
	     
	    sampleService.updateBoard(commandMap.getMap(), request);
	     
	    mv.addObject("IDX", commandMap.get("IDX"));
	    return mv;
	}
	
	@RequestMapping(value="/sample/deleteBoard.do")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
	     
	    sampleService.deleteBoard(commandMap.getMap());
	     
	    return mv;
	}
}