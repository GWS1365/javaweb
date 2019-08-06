

package io.hz.testService;

import java.util.ArrayList;
import java.util.List;

import io.hz.modules.mis.dao.*;
import io.hz.modules.mis.service.*;
import io.hz.modules.sys.entity.SysUserEntity;
import io.hz.modules.sys.service.SysUserService;
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
public class s1 {


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MisUserService misUserService;

    @Autowired
    private MisCategoryService misCategoryService;

    @Autowired
    private MisNoteService misNoteService;

    @Autowired
    private MisQuestionService misQuestionService;

    @Autowired
    private MisReality_resultService misReality_resultService;

    @Autowired
    private MisCommentService misCommentService;

    @Autowired
    private MisPrestore_resultService misPrestore_resultService;

    @Autowired
    private MisTestService misTestService;

    @Autowired
    private MisOrderService misOrderService;


    @Test
    public void t2(){
        SysUserEntity user=new SysUserEntity();
        user.setUsername("user");
        user.setPassword("admin");
        sysUserService.save(user);
    }

    @Test
    public void t4(){
        System.out.println(misUserService.selectById(1).getNickname());
        System.out.println(misCategoryService.selectById(1).getName());
        System.out.println(misNoteService.selectById(1).getLike());
        System.out.println(misOrderService.selectById(1).getOrderid());
        System.out.println(misCommentService.selectById(1).getContent());
        System.out.println(misPrestore_resultService.selectById(1).getDetails());
        System.out.println(misQuestionService.selectById(1).getQuestion());
        System.out.println(misReality_resultService.selectById(1).getStatus());
        System.out.println(misTestService.selectById(1).getImgsrc());

    }
    
    

}
