package bean;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.AttVo;
import mybatis.Factory;
import mybatis.BoardVo;
import mybatis.FileUpload;

public class BoardMybatisDao {
	SqlSession sqlSession;//연결할때 가장 중요한 역할을한다
	
	public BoardMybatisDao() {
		sqlSession = Factory.getFactory().openSession();//생성자에서 세션을 오픈함
	}
	public List<BoardVo> select(Page p) {
		List<BoardVo> list = null;
		try {
			int totList = sqlSession.selectOne("board.count",p);
			p.setTotListSize(totList);
			p.pageCompute();
			list = sqlSession.selectList("board.select",p);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//sqlSession.close();//받드시 close해줘야함
			//앞전에는 셀렉트를 부를때로 이너트를 부를때로 dao가 만들어지고 해서 close를 안하면 셀렉트가안되지만
			//지금은 사용하는 유저가 한명이든 두명이든 싱글톤이기 때문에 한개밖에 생성되지않기에 close를 하면 안된다.
			return list;
		}
	}
	public String insert(BoardVo vo , List<AttVo> attList) {
		String msg = "게시글 입력 완료!!";
		try {
			int cnt = sqlSession.insert("board.insert",vo);
			if(cnt<1) {
				throw new Exception("게시문 입력중 오류 발생");
			}
			for(AttVo attVo : attList) {
				cnt = sqlSession.insert("board.insert_att",attVo);
				if(cnt<1) {
					throw new Exception("첨부데이터 저장시 오류 발생");
				}
			}
			
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
			msg =e.getMessage();
			sqlSession.rollback();
			delFile(attList);
		}finally {
			//sqlSession.close();
			return msg;
		}
		
	}
	
	public BoardVo view(int serial,char v) {
		BoardVo vo = null;
		
		try {
			vo = sqlSession.selectOne("board.view",serial);
			if(v=='v') {
				int cnt = sqlSession.update("board.hit",serial);
				if(cnt<1) {
					throw new Exception("조회수 업데이트중 오류발생");
				}else {
					sqlSession.commit();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//세션 클로즈 없이 / 또 sqlSession을 오픈해야하기때문에 
			return vo;
		}
	}
	public List<AttVo> getAttList(int pserial){
		List<AttVo> attList = null;
		
		try {
			attList = sqlSession.selectList("board.list_att",pserial);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//sqlSession.close();
			return attList;
		}
	}
	
	public String modify(BoardVo vo , List<AttVo> attList , List<AttVo> delList) {
		String msg="수정 완료!!";
		
		
		try {
			//본문글 수정 작업
			int cnt = sqlSession.update("board.update",vo);
			if(cnt<1) {
				throw new Exception("본문글 삭제중 오류발생");
			}
			//본문글 수정이 정상적으로 이루어지면 첨부데이터 를 추가 // boardAtt에 추가할수없다
			
			for(AttVo attVo : attList) {
				attVo.setSerial(vo.getSerial());
				
				cnt = sqlSession.insert("board.att_insert2",attVo);
				if(cnt<1) {
					
					throw new Exception("첨부 데이터 정보 수정중 오류 발생");
				}
			}
			//boardAtt에 삭제파일 정보를 제거
			for(AttVo attVo : delList) {
				cnt = sqlSession.delete("board.att_delete",attVo);
				if(cnt<1) {
					throw new Exception("첨부 데이터 정보 삭제중 오류 발생");
				}
					
			}
			//파일 삭제작업
			delFile(delList);
			
			sqlSession.commit();
		}catch(Exception e) {
			delFile(attList);//파일이 업로드가 되어있는데 본문업데이트추가하는작업중에 오류가 낫다면 삭제를 해야하기 때문에
			
			e.printStackTrace();
			msg = e.getMessage();
			sqlSession.rollback();
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	public String delete(BoardVo vo) {
		String msg = "삭제가 완료 되었습니다";
		try {
			//삭제하기전 댓글 존재 파악
			int cnt = sqlSession.selectOne("board.repl_cnt" , vo.getSerial());
			if(cnt > 0) {
				throw new Exception("댓글이 있는 자료는 삭제할수 없습니다");
			}
			//본문 삭제
			cnt = sqlSession.delete("board.delete",vo);
			if(cnt<1) {
				throw new Exception("삭제중 오류발생");
			}
			//첨부된 파일 목록
			List<AttVo> delList = sqlSession.selectList("board.att_list",vo.getSerial());
			//첨부 테이블 자료 삭제
			for(AttVo attVo : delList) {
				cnt = sqlSession.delete("board.att_delete",attVo);
				if(cnt <1) {
					throw new Exception("첨부 자료 삭제중 오류발생");
				}
			}
			//파일 삭제
			delFile(delList);
			
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
			msg = e.getMessage();
			sqlSession.rollback();
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	
	
	
	public String repl(BoardVo vo , List<AttVo> attList) {
		String msg = "댓글 등록이 완료 되었습니다";
		
		int cnt=0;
		try {
			//댓글저장
			cnt = sqlSession.insert("board.repl",vo);
			if(cnt<1) {
				throw new Exception("댓글 등록중 오류발생");
			}
			for(AttVo attVo : attList) {
				cnt = sqlSession.insert("board.insert_att",attVo);
				if(cnt<1) {
					throw new Exception("첨부 데이터 저장중 오류발생");
				}
			}
			
			sqlSession.commit();
		}catch(Exception e) {
			delFile(attList);
			e.printStackTrace();
			msg = e.getMessage();
			sqlSession.rollback();
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	
	
	
	
	
	
	//insert나 modify에서 sql 오류가 발생할때 , 삭제할 때 공통 사용
	public void delFile(List<AttVo> delList) {
		for(AttVo attVo : delList) {
			File f = new File(FileUpload.upload + attVo.getSysFile());
			if(f.exists()) {
				f.delete();
			}
			
		}
	}
}
