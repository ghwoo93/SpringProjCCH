package com.kosmo.springapp.onememo.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.OneMemoService;

@Repository
public class OneMemoDAO implements OneMemoService {

	/*
	 * --------------------------------------------
	 * myBatis프레임워크 사용(mybatis-3.버전.jar)
	 * -SqlSessionFactory타입 객체 사용  
	   -형변환 불필요(iBatis는 형변환 해야 함)  
	 * --------------------------------------------
	 */
	/* [스프링에서 지원하는   마이바티스 관련 API(mybatis-spring-2.버전.jar) 미 사용]
	
		[프로그래밍 순서]
 	가. SqlSessionFactory타입의 openSession()메소드로 SqlSession타입 얻기 
 	나. SqlSession타입의 메소드 호출
    	.쿼리문이	SELECT 
	                  	다중레코드 일때:selectList()
	                  	단일 레코드일때:selectOne()
    	.쿼리문이 	INSERT - insert()
             		DELETE - delete()
             		UPDATE - update()메소드
         		      단,I/D/U일때는 반드시 commit()호출
         
		다.-close()호출   
	
	*/
	/* 스프링이 myBatis관련해서 지원하는 API 미사용시
	 * -로그인/목록/입력에 적용해 보자	
	 */ 
	
	/*
	private static SqlSessionFactory sqlMapper;
	static {
		
		try {
			Reader reader = Resources.getResourceAsReader("com/kosmo/springapp/onememo/mybatis/configuration.xml");
			sqlMapper=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}
		catch(IOException e) {e.printStackTrace();}		
	}*/
	/* SqlSessionFactory를 주입 받기(new하지 않고) */
//	@Resource(name="sqlSessionFactory")//static 필드 지원 안함
//	private SqlSessionFactory sqlMapper;
	/*[스프링에서 지원하는  마이바티스 관련 API(mybatis-spring-1.버전.jar) SqlSessionTemplate 사용]
		-위 프로그래밍 순서의 (가)  및 (나)에서는 commit()호출
  		그리고 (다)의 close()호출 불필요 
	 */
	
	@Resource(name ="template")
	private SqlSessionTemplate sqlMapper;
	
	@Override
	public boolean isLogin(Map map) {
		/* 스프링지원 마이바티스 API 미 사용시*/
		/*
		//1]SqlSession얻기
		SqlSession session=sqlMapper.openSession();
		//2]selectOne()호출
		int count = session.selectOne("memoIsLogin", map);
		//3]close()호출
		session.close();
		return count==1 ? true : false;*/
		/* 스프링지원 마이바티스 API 사용시:SqlSessionTemplate*/
		return (Integer)sqlMapper.selectOne("memoIsLogin", map)==1 ? true : false;
		
	}

	@Override
	public List<OneMemoDTO> selectList(Map map) {
		/* 스프링지원 마이바티스 API 미 사용시*/
		/*
		//1]SqlSession얻기
		SqlSession session=sqlMapper.openSession();
		//2]selectList()호출
		List<OneMemoDTO> list=session.selectList("memoSelectList",map);
		//3]close()호출
		session.close();
		return list;*/
		/* 스프링지원 마이바티스 API 사용시:SqlSessionTemplate*/
		return sqlMapper.selectList("memoSelectList",map);
	}

	@Override
	public int getTotalRecord(Map map) {		
		return sqlMapper.selectOne("memoGetTotalRecord",map);
	}

	@Override
	public OneMemoDTO selectOne(Map map) {		
		return sqlMapper.selectOne("memoSelectOne", map);
	}

	@Override
	public int insert(Map map) {
		/* 스프링지원 마이바티스 API 미 사용시*/
		/*
		//1]SqlSession얻기
		SqlSession session=sqlMapper.openSession();
		//2]insert()호출
		int affected=session.insert("memoInsert", map);
		//3]commit()호출
		session.commit();
		//4]close()호출
		session.close();
		return affected;*/
		/* 스프링지원 마이바티스 API 사용시:SqlSessionTemplate*/
		return sqlMapper.insert("memoInsert", map);
	}

	@Override
	public int delete(Map map) {
		/*메모 삭제-프로그래밍적으로 삭제하거나 혹은 
		   부모 삭제시 자동으로 해당 자식도 삭제되도록 FK설정
		  REFERENCES 부모테이블(PK컬럼) ON  DELETE CASCADE
		*/
		//자식삭제]
		sqlMapper.delete("commentDeleteByNo",map);
		//부모삭제]		
		return sqlMapper.delete("memoDelete", map);
	}

	@Override
	public int update(Map map) {		
		return sqlMapper.update("memoUpdate", map);
	}

}
