package com.kosmo.springapp.onememo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kosmo.springapp.onememo.service.MemoCommentService;


@Repository("commentDao")
public class MemoCommentDAO  implements MemoCommentService{

	@Override
	public List<Map> selectList(Map map) {
		
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
