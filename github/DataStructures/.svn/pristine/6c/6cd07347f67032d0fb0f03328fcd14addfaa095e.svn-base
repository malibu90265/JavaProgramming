package first.common.dao;
 
import java.util.Map;

import org.springframework.stereotype.Repository;
 
@Repository("commonDAO")
public class CommonDAO extends AbstractDAO{
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception{
		System.out.println("*********** " + map.get("IDX"));
	    return (Map<String, Object>)selectOne("common.selectFileInfo", map);
	}
}