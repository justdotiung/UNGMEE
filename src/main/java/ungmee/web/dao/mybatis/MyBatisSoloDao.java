package ungmee.web.dao.mybatis;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.SoloDao;
import ungmee.web.entity.Solo;
@Repository
public class MyBatisSoloDao implements SoloDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Override
	public Solo get(int id) {
		SoloDao soloDao = sqlSession.getMapper(SoloDao.class);
		return soloDao.get(id);
	}

	@Override
	public int insert(Solo solo) {
		SoloDao soloDao = sqlSession.getMapper(SoloDao.class);
		return soloDao.insert(solo);
	}

}
