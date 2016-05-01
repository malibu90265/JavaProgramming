package first.common.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")
public class FileUtils {
	//파일이 저장될 위치
	private static final String filePath = "C:\\dev\\file\\";

	public List<Map<String, Object>> parseInsertFileInfo(Map<String, Object> map, HttpServletRequest request)
			throws Exception {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		//클라이언트에서 전송된 파일 정보를 담아서 반환해줄 List. 다중 파일을 전송할 수 있도록 함.
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = null;

		String boardIdx = map.get("IDX").toString(); //신규 생성되는 게시글의 번호 가져오기

	    //만약 파일을 저장할 경로에 해당 폴더가 없으면 생성하도록 함.
		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}

		// 파일의 정보를 받아서 새로운 이름으로 변경하는 부분
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename(); //파일의 확장자
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() + originalFileExtension;

				multipartFile.transferTo(new File(filePath + storedFileName));
	             
	            listMap = new HashMap<String,Object>();
	            listMap.put("IS_NEW", "Y");
	            listMap.put("BOARD_IDX", boardIdx);
	            listMap.put("ORIGINAL_FILE_NAME", originalFileName);
	            listMap.put("STORED_FILE_NAME", storedFileName);
	            listMap.put("FILE_SIZE", multipartFile.getSize());
	            list.add(listMap);
			}
		}
		return list;
	}

	public List<Map<String, Object>> parseUpdateFileInfo(Map<String, Object> map, HttpServletRequest request) throws IllegalStateException, IOException {
		 MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		     
		    MultipartFile multipartFile = null;
		    String originalFileName = null;
		    String originalFileExtension = null;
		    String storedFileName = null;
		     
		    List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		    Map<String, Object> listMap = null; 
		     
		    String boardIdx = (String)map.get("IDX");
		    String requestName = null;
		    String idx = null;
		     
		     
		    while(iterator.hasNext()){
		        multipartFile = multipartHttpServletRequest.getFile(iterator.next());
		        if(multipartFile.isEmpty() == false){
		            originalFileName = multipartFile.getOriginalFilename();
		            originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		            storedFileName = CommonUtils.getRandomString() + originalFileExtension;
		             
		            multipartFile.transferTo(new File(filePath + storedFileName));
		             
		            listMap = new HashMap<String,Object>();
		            listMap.put("IS_NEW", "Y");
		            listMap.put("BOARD_IDX", boardIdx);
		            listMap.put("ORIGINAL_FILE_NAME", originalFileName);
		            listMap.put("STORED_FILE_NAME", storedFileName);
		            listMap.put("FILE_SIZE", multipartFile.getSize());
		            list.add(listMap);
		        }
		        else{
		            requestName = multipartFile.getName();
		            idx = "IDX_"+requestName.substring(requestName.indexOf("_")+1);
		            if(map.containsKey(idx) == true && map.get(idx) != null){
		                listMap = new HashMap<String,Object>();
		                listMap.put("IS_NEW", "N");
		                listMap.put("FILE_IDX", map.get(idx));
		                list.add(listMap);
		            }
		        }
		    }
		    return list;
	}
}