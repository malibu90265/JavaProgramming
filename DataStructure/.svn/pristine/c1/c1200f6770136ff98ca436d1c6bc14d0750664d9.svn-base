package first.sample.dao;
 
import java.util.List;
import java.util.Map;
 
import org.springframework.stereotype.Repository;
 
import first.common.dao.AbstractDAO;
 
@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO{
 
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
    	// selectList 메소드는 MyBatis의 기본 기능으로, list를 조회할 때 사용한다.
    	// selectList 메소드의 첫번째 인자는 쿼리 이름, 두번째는 쿼리가 실행되는데 필요한 변수이다.
    	// 여기서 sample = SQL의 namespace이고, selectBoardList는 id 이다.
        return (List<Map<String, Object>>)selectList("sample.selectBoardList", map);
    }
 
    public void insertBoard(Map<String, Object> map) throws Exception{
        insert("sample.insertBoard", map);
    }
    
    public void updateHitCnt(Map<String, Object> map) throws Exception{
        update("sample.updateHitCnt", map);
    }
     
    @SuppressWarnings("unchecked")
    public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) selectOne("sample.selectBoardDetail", map);
    }

    public void updateBoard(Map<String, Object> map) throws Exception{
        update("sample.updateBoard", map);
    }
    
    public void deleteBoard(Map<String, Object> map) throws Exception{
        //DB에서 아예 삭제하는 것이 아니라 del_gb 컬럼을 Y로 바꾼다.
    	update("sample.deleteBoard", map);
    }
    
    public void insertFile(Map<String, Object> map) throws Exception{
        insert("sample.insertFile", map);
    }
    
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("sample.selectFileList", map);
    }
    
    public void deleteFileList(Map<String, Object> map) throws Exception{
        update("sample.deleteFileList", map);
    }
     
    public void updateFile(Map<String, Object> map) throws Exception{
        update("sample.updateFile", map);
    }
}