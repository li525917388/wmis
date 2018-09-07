package com.ldh.hplus.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ldh.hplus.common.model.BaseDaoPara;


@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

	private SqlSessionFactory sqlSessionFactory;
	
	public BaseDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<Map<String, Object>> getBean(BaseDaoPara bdp) {
		
		System.out.println("basedao");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Map<String, Object>> a = sqlSession.selectList("getBean",bdp);
		
		return a;
	}

}
