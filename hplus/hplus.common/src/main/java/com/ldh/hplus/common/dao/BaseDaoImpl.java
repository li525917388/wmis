package com.ldh.hplus.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ldh.hplus.common.util.BaseParameterType;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private SqlSessionFactory sqlSessionFactory;
	
	public BaseDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<Map<String, Object>> getBean(BaseParameterType bpt) {
		
		System.out.println("basedao");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Map<String, Object>> list = sqlSession.selectList("getBean",bpt);
		
		return list;
	}

	@Override
	public List<Map<String, Object>> getAllList(@Param("table")String table) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Map<String, Object>> list = sqlSession.selectList("getAllList",table);
		
		return list;
	}

}
