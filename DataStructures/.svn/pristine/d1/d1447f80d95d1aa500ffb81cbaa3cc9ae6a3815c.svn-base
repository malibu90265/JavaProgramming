package com.sqisoft.iqs.humanResource.empPjMap.vo;

public class EmpPjMapVO {
	
	private String tm_id;
	private String tm_name;
	private String pj_id;
	private String pj_start_date;
	private String pj_end_date;
	private String pd_name;
	private String pd_start_date;
	private String pd_end_date;
	private String hr_position;
	private String hr_job_skill;
	private String hr_division; //hr_company=SQI소프트 이면 직원/아니면 외주 및 퇴사자
	
	public String getTm_id() {
		return tm_id;
	}
	public void setTm_id(String tm_id) {
		this.tm_id = tm_id;
	}
	public String getTm_name() {
		return tm_name;
	}
	public void setTm_name(String tm_name) {
		this.tm_name = tm_name;
	}
	public String getPj_id() {
		return pj_id;
	}
	public void setPj_id(String pj_id) {
		this.pj_id = pj_id;
	}
	public String getPj_start_date() {
		return pj_start_date;
	}
	public void setPj_start_date(String pj_start_date) {
		this.pj_start_date = pj_start_date;
	}
	public String getPj_end_date() {
		return pj_end_date;
	}
	public void setPj_end_date(String pj_end_date) {
		this.pj_end_date = pj_end_date;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public String getPd_start_date() {
		return pd_start_date;
	}
	public void setPd_start_date(String pd_start_date) {
		this.pd_start_date = pd_start_date;
	}
	public String getPd_end_date() {
		return pd_end_date;
	}
	public void setPd_end_date(String pd_end_date) {
		this.pd_end_date = pd_end_date;
	}
	public String getHr_position() {
		return hr_position;
	}
	public void setHr_position(String hr_position) {
		this.hr_position = hr_position;
	}
	public String getHr_job_skill() {
		return hr_job_skill;
	}
	public void setHr_job_skill(String hr_job_skill) {
		this.hr_job_skill = hr_job_skill;
	}
	public String getHr_division() {
		return hr_division;
	}
	public void setHr_division(String hr_division) {
		this.hr_division = hr_division;
	}
	
}

/*package com.sqisoft.iqs.humanResource.empPjMap.vo;

public class EmpPjMapVO {
	
	private String tm_id;
	private String tm_name;
	private String pj_name;
	private String pj_start_date;
	private String pj_end_date;
	private String hr_name;
	private String hr_position;
	private String hr_job_skill;
	private String hr_company;
	
	
	public String getTm_id() {
		return tm_id;
	}
	public void setTm_id(String tm_id) {
		this.tm_id = tm_id;
	}
	public String getTm_name() {
		return tm_name;
	}
	public void setTm_name(String tm_name) {
		this.tm_name = tm_name;
	}
	public String getPj_name() {
		return pj_name;
	}
	public void setPj_name(String pj_name) {
		this.pj_name = pj_name;
	}
	public String getPj_start_date() {
		return pj_start_date;
	}
	public void setPj_start_date(String pj_start_date) {
		this.pj_start_date = pj_start_date;
	}
	public String getPj_end_date() {
		return pj_end_date;
	}
	public void setPj_end_date(String pj_end_date) {
		this.pj_end_date = pj_end_date;
	}
	public String getHr_name() {
		return hr_name;
	}
	public void setHr_name(String hr_name) {
		this.hr_name = hr_name;
	}
	public String getHr_position() {
		return hr_position;
	}
	public void setHr_position(String hr_position) {
		this.hr_position = hr_position;
	}
	public String getHr_job_skill() {
		return hr_job_skill;
	}
	public void setHr_job_skill(String hr_job_skill) {
		this.hr_job_skill = hr_job_skill;
	}
	public String getHr_company() {
		return hr_company;
	}
	public void setHr_company(String hr_company) {
		this.hr_company = hr_company;
	}
}


/////////////////////////////////////empPjMap_mappe-sql.xml 원본

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="empPjMapDAO">
	
	<resultMap type="com.sqisoft.iqs.humanResource.empPjMap.vo.EmpPjMapVO" id="empPjMap">
		<result property="tm_id"			column="tm_id"/>
		<result property="tm_name"			column="tm_name"/>
		<result property="pj_name"			column="pj_name"/>
		<result property="pj_start_date"	column="pj_start_date"/>
		<result property="pj_end_date"		column="pj_end_date"/>
		<result property="hr_name"			column="hr_name"/>
		<result property="hr_position"		column="hr_position"/>
		<result property="hr_job_skill"		column="hr_job_skill"/>
		<result property="hr_company"		column="hr_company"/>
	</resultMap>
	
	<!-- 이거 VO만 가져다 쓰는 것 맞나요? 위치 옮겨도 되는지 확인 바랍니다. -->
	<resultMap type="com.sqisoft.iqs.hr.vo.MppListVO" id="mppVO">
		<result property="name"				column="name" />
		<result property="cpid"				column="cpid" />
		<result property="cpstartday"		column="cpstartday" />
		<result property="cpendday"			column="cpendday" />
		<result property="position"			column="position" />
		<result property="team"				column="team" />
		<result property="skill"			column="skill" />
		<result property="location"			column="location" />
		<result property="division"			column="division" />
	</resultMap>
	
	<resultMap type="com.sqisoft.iqs.hr.vo.ProjectCountVO" id="pjCountVO">
		<result property="team_id"			column="team_id"/>
		<result property="team_name"		column="team_name"/>
		<result property="pj_id"			column="pj_id"/>
		<result property="name_count"		column="name_count"/>
		<result property="cpstartday"		column="cpstartday"/>
		<result property="cpendday"			column="cpendday"/>
		<result property="pj_start_day"		column="pj_start_day"/>
		<result property="pj_end_day"		column="pj_end_day"/>
	</resultMap>
	
	<select id="getCheckBoxValue" parameterType="map" resultMap="mppVO">
		SELECT  p.pj_id AS cpid, 
		        p.pj_start_date AS cpstartday, 
		        p.pj_end_date AS cpendday, 
		        p.tm_id AS team, 
		        pd.pd_name AS name, 
		        IFNULL(SUBSTRING( h.hr_grade , 2 , 3 ), "-") AS position, 
		        h.hr_job_skill AS skill,
        		IF( h.hr_company LIKE "%SQI%" , "직원" , "외주" ) AS division
		FROM	project p, human_resource h, pj_deploy pd
		WHERE	p.tm_id = #{tm_id}
		AND 	p.pj_id = pd.pj_id
		AND 	h.hr_name = pd.pd_name
  	  	AND   	pd.pd_start_date <![CDATA[<=]]> SYSDATE()
		AND		pd.pd_end_date <![CDATA[>=]]>  SYSDATE()
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
						WHERE	pd_start_date <![CDATA[<=]]> SYSDATE()
						AND		pd_end_date <![CDATA[>=]]>  SYSDATE()
						GROUP BY pj_id
			) AS pjd
			ON pj.pj_id = pjd.pj_id
		WHERE	pj.tm_id = #{team_id}
		AND		pj.pj_start_date <![CDATA[<=]]>  SYSDATE()
		AND		pj.pj_end_date <![CDATA[>=]]>  SYSDATE()
		AND		name_count != 0
	</select>
	
</mapper>




*/
