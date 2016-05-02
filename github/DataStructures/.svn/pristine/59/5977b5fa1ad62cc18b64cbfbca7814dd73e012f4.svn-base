package first.sample.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import first.common.util.FileUtils;
import first.sample.dao.SampleDAO;

/*
 ServiceImpl : Service interface를 통해 정의된 메소드를 실제로 구현하는 클래스
 @Service 어노테이션을 이용하여 Service 객체임을 선언.
 */

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
    Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="fileUtils")
    private FileUtils fileUtils;
     
    @Resource(name="sampleDAO")
    private SampleDAO sampleDAO;
     
    @Override
    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
        return sampleDAO.selectBoardList(map);
         
    }
 
    @Override
    public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
        sampleDAO.insertBoard(map);
        //파일을 저장하고, 그 데이터를 가져온 후 DB에 저장
        List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
        for(int i=0, size=list.size(); i<size; i++){
            sampleDAO.insertFile(list.get(i));
        }
    }
 
/*
	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
	    sampleDAO.insertBoard(map);
	     
	    
		    첨부파일은 Multipart 형식의 데이터이며, HttpServletRequest에 담겨서 서버로 전송된다고 이야기하였다.
			HttpServletRequest 그 자체로는 Multipart형식의 데이터를 조작하는데 어려움이 있기 때문에, MultipartHttpServletRequset 형식으로 형변환을 하였다.
	     
	    MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
	    
	    
		    이터레이터(Iterator) 패턴을 이용하여 request에 전송된 모든 name을 이용하려고 하는 부분이다. 
		    Iterator는 어떤 데이터들의 집합체에서 컬렉션(Collection)으로부터 정보를 얻어올 수 있는 인터페이스다. 
		    Iterator를 사용하면 집합체와 개별원소들을 분리시켜서 생각할 수가 있는데, 그 집합체가 어떤 클래스의 인스턴스인지 신경쓰지 않아도 되는 장점이 있다. 
			예를 들어 List나 배열에서는 순차적으로 데이터의 접근이 가능하지만, Map,Set 등의 클래스들은 순차적인 접근을 할수가 없다. 
			Map에서 데이터를 가져오려면 그 Map에 있는 키(Key)를 알아야 접근이 가능하다거나, for문 등의 반복문을 사용할수가 없는것을 생각하면 된다.
	     
	    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
	    
	    MultipartFile multipartFile = null;
	    
	    JSP에서 <input type="file" name="file">이라는 태그를 추가했었다. 여기서 name="file"을 봐야한다. 
		JSP내에서 작성된 데이터가 서버로 전송될 때에는 태그의 name값을 키(key)로 해서 값(value)가 전송된다. 
		즉, request에 값이 전달될때에도 Map과 마찬가지로 key,value 쌍의 형식으로 데이터가 저장된다. 
		위의 태그에서 name은 "file" 이라는 값이었고, reqeust에서 "file"이라는 키를 통해서 데이터를 가져올수 있는데, 이 경우 우리는 "file"이라는 키를 알고있지만, 
		실제로 개발을 하면, name값은 여러가지 다른 이름으로 넘어올수 있다. 
		따라서 Iterator를 통해서 모든 name값을 알아서 가져오게 하면, 개발자는 name이 무엇인지를 몰라도, 쉽게 그 값을 사용할수 있다.
	     
	    while(iterator.hasNext()){
	    	//MultipartFile 객체에 request에서 파일 객체를 가져오는 부분이다. multipartHttpServletRequest의 getFile() 메서드는 request에 저장된 파일의 name을 인자로 받는다.
	        multipartFile = multipartHttpServletRequest.getFile(iterator.next());
	        if(multipartFile.isEmpty() == false){ //실제 파일 정보가 있는지 검사
	            log.debug("------------- file start -------------");
	            log.debug("name : "+multipartFile.getName());
	            log.debug("filename : "+multipartFile.getOriginalFilename());
	            log.debug("size : "+multipartFile.getSize());
	            log.debug("-------------- file end --------------\n");
	        }
	    }
	}*/

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
	    //1. 해당 게시글의 조회수를 1 증가시킨다.
		sampleDAO.updateHitCnt(map);
		//2. 게시글의 상세 내용을 조회한다. (DAO에서 2개 이상의 동작을 수행하면 안된다.)
	    Map<String, Object> resultMap = sampleDAO.selectBoardDetail(map);
	    Map<String, Object> tempMap = sampleDAO.selectBoardDetail(map);
	    resultMap.put("map", tempMap);
	     
	    List<Map<String,Object>> list = sampleDAO.selectFileList(map);
	    resultMap.put("list", list);
	    return resultMap;
	}

	@Override
	public void updateBoard(Map<String, Object> map, HttpServletRequest request) throws Exception{
	    sampleDAO.updateBoard(map);
	    
	    //해당 게시글에 해당하는 첨부파일을 전부 삭제 처리한다.(DEL_GB='Y')
	    sampleDAO.deleteFileList(map);
	    //request에 담겨있는 파일 정보를 list로 변환. 기존에 저장된 파일 중에서 삭제되지 않은 파일 정보도 함께 반환한다.
	    List<Map<String,Object>> list = fileUtils.parseUpdateFileInfo(map, request);
	    Map<String,Object> tempMap = null;
	    for(int i=0, size=list.size(); i<size; i++){
	        tempMap = list.get(i);
	        if(tempMap.get("IS_NEW").equals("Y")){ // 신규 저장될 파일인지 판별
	            sampleDAO.insertFile(tempMap);
	        }
	        else{
	            sampleDAO.updateFile(tempMap);
	        }
	    }
	}
	
	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
	    sampleDAO.deleteBoard(map);
	}
}