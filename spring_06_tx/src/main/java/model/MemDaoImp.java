package model;


import org.mybatis.spring.SqlSessionTemplate;


public class MemDaoImp  implements MemDAO{
	
	
	private SqlSessionTemplate sqlSession;
	
	public MemDaoImp() {
		
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public void insertMethod(MemDTO dto) {
		sqlSession.insert("mem.ins", dto);
		
	}

	
}
