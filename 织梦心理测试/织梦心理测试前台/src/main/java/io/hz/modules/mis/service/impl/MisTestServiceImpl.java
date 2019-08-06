package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.common.base.Query;
import io.hz.modules.mis.dao.MisTestDao;
import io.hz.modules.mis.entity.MisTestEntity;
import io.hz.modules.mis.service.MisTestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MisTestServiceImpl extends ServiceImpl<MisTestDao, MisTestEntity> implements MisTestService {

    @Autowired
    MisTestDao misTestDao;

    @Override
    public List<MisTestEntity> getTestBut(Integer uid){
        return misTestDao.getTestBut(uid);
    }
    @Override
    public List<MisTestEntity> getTests(){
        return  misTestDao.getTests();
    }
    @Override
    public List<MisTestEntity>selectCollectTest(Map<String ,Object> params){
        int uid = Integer.parseInt((String) params.get("uid"));
        params.put("uid", uid);
        return misTestDao.selectCollectTest(params);
    }
    @Override
    public  List<MisTestEntity> getTestLimit(Map<String, Object> params){
        int u = Integer.parseInt((String) params.get("u"));
        params.put("u", u);
        return misTestDao.getTestLimit(params);
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String title = (String) params.get("title");
        //where name like '%??% and age>19'
        Page<MisTestEntity> page = this.selectPage(
                new Query<MisTestEntity>(params).getPage(),
                new EntityWrapper<MisTestEntity>().like(StringUtils.isNotBlank(title), "title", title)
        );
        return new PageUtils(page);
    }
    //分页查询
    @Override
    public List<MisTestEntity> getTestByCid(Integer cid){
        if(cid==0){
            return misTestDao.getAllTest();
        }else {
            return misTestDao.getTestByCid(cid);
        }
    }
    @Override
    public PageUtils MyqueryPage(Map<String, Object> params) {
        String title = (String) params.get("title");
        String cname = (String) params.get("cname");

        if (title == null || cname == null) {
            title = "";
            cname = "";
        }
        Integer cur = Integer.valueOf(params.get("page").toString());
        Integer size = Integer.valueOf(params.get("limit").toString());
        Page<MisTestEntity> page = new Page<MisTestEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page, params)));
    }

    //按顺序查询
    @Override
    public List<MisTestEntity> Search(Map<String,Object> params){
        String title = (String) params.get("title");
        if (title == null ) {
            title = "";
        }
        return baseMapper.Search(params);
    }

    @Override
    public List<MisTestEntity> selectBycid(Integer cid){
        return baseMapper.selectBycid(cid);
    }

    @Override
    public List<MisTestEntity>getAll(){
        return baseMapper.getAllTest();
    }
}
