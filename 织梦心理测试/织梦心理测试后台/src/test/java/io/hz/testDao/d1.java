

package io.hz.testDao;

import io.hz.modules.mis.dao.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.1.0 2018-01-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class d1 {
	
    
    @Autowired
    private MisUserDao misUserDao;

    @Autowired
    private MisCategoryDao misCategoryDao;

    @Autowired
    private MisNoteDao misNoteDao;

    @Autowired
    private MisQuestionDao misQuestionDao;

    @Autowired
    private MisReality_resultDao misReality_resultDao;

    @Autowired
    private MisCommentDao misCommentDao;

    @Autowired
    private MisPrestore_resultDao misPrestore_resultDao;

    @Autowired
    private MisTestDao misTestDao;

    @Autowired
    private MisOrderDao misOrderDao;



    @Test
    public void t1(){
//        System.out.println(misUserDao.selectById(1).getNickname());
//        System.out.println(misCategoryDao.selectById(1).getName());
//        System.out.println(misNoteDao.selectById(1).getLike());
//        System.out.println(misOrderDao.selectById(1).getOrderid());
//        System.out.println(misCommentDao.selectById(1).getContent());
//        System.out.println(misPrestore_resultDao.selectById(1).getDetails());
//        System.out.println(misQuestionDao.selectById(1).getQuestion());
//        System.out.println(misReality_resultDao.selectById(1).getStatus());
//        System.out.println(misTestDao.selectById(1).getImgsrc());
        System.out.println(misTestDao.getTestByCid(3));
        System.out.println(misTestDao.getTestByCid(3).get(1).getCname());


    }
    
    
     
}
