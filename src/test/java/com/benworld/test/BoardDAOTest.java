package com.benworld.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.benworld.domain.BoardVO;
import com.benworld.domain.Criteria;
import com.benworld.domain.SearchCriteria;
import com.benworld.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("Title1");
		board.setContent("Content1");
		board.setWriter("Writer1");
		dao.create(board);
		
	}

	@Test
	public void testRead() throws Exception {
		logger.info("read TEST Start -------------------------");
		logger.info(dao.read(10).toString());
		logger.info("read TEST End -------------------------");
	}
	@Test
	public void testUpdate()throws Exception{
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("새로운타이틀");
		vo.setContent("새로운 내용");
		dao.update(vo);
		
		
	}
	@Test
	public void testDelete() throws Exception{
		dao.delete(1);
	}
	@Test
	public void testListPage()throws Exception{
		int page = 3;
		List<BoardVO>  list = dao.listPage(page);
		
		for(BoardVO vo : list) {
			logger.info(vo.getBno() + ":" + vo.getTitle());
		}
	}
	@Test
	public void testListCriteria()throws Exception{
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO vo : list) {
			logger.info(vo.getBno() + ":" + vo.getTitle());
		}
	}
	
	@Test
	public void testURI()throws Exception{
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
	
	@Test
	public void testDynamic1() throws Exception{
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("글");
		cri.setSearchType("t");
		
		logger.info("===============================");
		List<BoardVO> list= dao.listSearch(cri);
		for(BoardVO vo : list) {
			logger.info(vo.getBno()+":" + vo.getTitle());
		}
		logger.info("===============================");
		logger.info("Count : " + dao.listSearchCount(cri));
	}
}
