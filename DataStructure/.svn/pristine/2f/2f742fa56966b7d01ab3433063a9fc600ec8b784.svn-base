package com.sqisoft.iqs.humanResource.empPjMap.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.hr.vo.MppListVO;
import com.sqisoft.iqs.hr.vo.ProjectCountVO;
import com.sqisoft.iqs.humanResource.empPjMap.dao.EmpPjMapDAO;
import com.sqisoft.iqs.humanResource.empPjMap.vo.EmpPjMapVO;

public class EmpPjMapDAOImpl extends SqlSessionDaoSupport implements EmpPjMapDAO{
	
	@Override
	public List<EmpPjMapVO> getCheckBoxValue(String team_id) {
		return getSqlSession().selectList("empPjMapDAO.getCheckBoxValue", team_id);
	}

	@Override
	public List<ProjectCountVO> getProject_GetCount(String team_id) {
		return getSqlSession().selectList("empPjMapDAO.getProject_GetCount", team_id);
	}
	
}


/*
<select id="getCheckBoxValue" parameterType="map" resultMap="mppVO">
		SELECT
			pj.pj_id AS cpid
			, pj.pj_start_date AS cpstartday
			, pj.pj_end_date AS cpendday
			, pjd.pd_name AS name
			, hr.hr_job_skill AS skill
			, IF( hr.hr_company LIKE "SQI%" , "직원" , "외주" ) AS division
			, IFNULL(SUBSTRING( hr.hr_grade , 2 , 3 ), "-") AS position
			, pj.tm_id AS team
		FROM
			project pj
			LEFT OUTER JOIN ( SELECT	pj_id
										, pd_name
										, pd_sq
										, pd_start_date
								FROM	pj_deploy
								WHERE	pd_start_date <![CDATA[<]]> SYSDATE()
								AND		pd_end_date <![CDATA[>]]> SYSDATE()
							) AS pjd
			ON pjd.pj_id = pj.pj_id
			LEFT OUTER JOIN human_resource hr
			ON pjd.pd_name = hr.hr_name
		WHERE
			pj.tm_id = #{team_id}
		AND
			pj.pj_start_date <![CDATA[<]]> SYSDATE()
		AND
			pj.pj_end_date <![CDATA[>]]> SYSDATE()
		ORDER BY
			pj.pj_id
			, hr.hr_company LIKE "SQI%" DESC
			, pjd.pd_sq
			, pjd.pd_start_date
	</select>	

<select id="getProject_GetCount" parameterType="String" resultMap="pjCountVO">
SELECT
			pj.tm_id AS team_id
			, tm.tm_name AS team_name
			, pj.pj_id AS pj_id
			, pj.pj_start_date AS pj_start_day
			, pj.pj_end_date AS pj_end_day
			, IFNULL(pjd.name_count , 0 ) AS name_count
		FROM
			project pj
			LEFT JOIN team tm
			ON pj.tm_id = tm.tm_id
			LEFT JOIN (SELECT	pj_id
								, COUNT(pd_name) AS name_count
						FROM	pj_deploy
						WHERE	pd_start_date <![CDATA[<]]> SYSDATE()
						AND		pd_end_date > SYSDATE()
						GROUP BY pj_id
			) AS pjd
			ON pj.pj_id = pjd.pj_id
		WHERE	pj.tm_id = #{team_id}
		AND		pj.pj_start_date <![CDATA[<]]> SYSDATE()
		AND		pj.pj_end_date > SYSDATE()
</select>
*/
