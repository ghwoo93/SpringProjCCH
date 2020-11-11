package com.kosmo.springapp.onememo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;


import org.springframework.stereotype.Repository;

import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.OneMemoService;

@Repository
public class OneMemoDAO implements OneMemoService {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Resource(name="dataSourceByJNDI")
	private DataSource source;
	
	
	
	@Override
	public boolean isLogin(Map map) {
		try {
			
			
			conn = source.getConnection();
			psmt=conn.prepareStatement("SELECT COUNT(*) FROM member WHERE id=? AND pwd=?");
			psmt.setString(1, map.get("id").toString());
			psmt.setString(2, map.get("pwd").toString());
			rs = psmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==0) return false;
			
		} 
		catch (SQLException e) {e.printStackTrace();return false;}
		return true;
	}

	@Override
	public List<OneMemoDTO> selectList(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalRecord(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OneMemoDTO selectOne(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

}
