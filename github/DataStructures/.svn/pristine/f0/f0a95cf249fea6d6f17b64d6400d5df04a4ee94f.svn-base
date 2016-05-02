package first.common.controller;
 
import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import first.common.common.CommandMap;
import first.common.service.CommonService;
 
@Controller
public class CommonController {
    Logger log = Logger.getLogger(this.getClass());
     
    @Resource(name="commonService")
    private CommonService commonService;
    
    /* [첨부 파일 다운로드 과정]
    	화면에서 특정 첨부파일 다운로드 요청 -> 서버에서 해당 첨부파일 정보 요청 -> DB에서 파일정보 조회 -> 조회된 데이터를 바탕으로 클라이언트에 다운로드가 가능하도록 데이터 전송
    */
    
    @RequestMapping(value="/common/downloadFile.do")
    public void downloadFile(CommandMap commandMap, HttpServletResponse response) throws Exception{
    	//HttpServletResponse response : 서버에서 화면으로 응답할 때, response에 응답 내용이 담기게 된다.
    	//여기서 다운로드가 가능한 데이터 전송이라는 것은 파일 정보를 response에 담아주는 것을 의미한다.
        Map<String,Object> map = commonService.selectFileInfo(commandMap.getMap());
        String storedFileName = map.get("STORED_FILE_NAME").toString();
        String originalFileName = map.get("ORIGINAL_FILE_NAME").toString();
        
        //실제로 파일이 저장된 위치에서 해당 첨부파일을 읽어서 byte[] 형태로 변환
        byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\file\\"+storedFileName));
        
        response.setContentType("application/octet-stream");
        response.setContentLength(fileByte.length);
        //response.setHeader에 "Content-Disposition" 에서 "attachment"는 첨부파일을 의미한다.
        //Content-Disposition 속성을 이용하여 해당 패킷이 어떤 형식의 데이터인지 알 수 있다. 
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.getOutputStream().write(fileByte);
         
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}