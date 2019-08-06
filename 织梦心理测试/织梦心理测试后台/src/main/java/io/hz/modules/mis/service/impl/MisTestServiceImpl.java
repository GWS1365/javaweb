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
    public PageUtils queryPage(Map<String, Object> params) {
        String title = (String) params.get("title");
        Page<MisTestEntity> page = this.selectPage(
                new Query<MisTestEntity>(params).getPage(),
                new EntityWrapper<MisTestEntity>().like(StringUtils.isNotBlank(title), "title", title)
        );
        return new PageUtils(page);
    }

    @Override
    public List<MisTestEntity>getAll(){
        return baseMapper.getAllTest();
    }

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
        String sidx = (String) params.get("sidx");
        String order = (String) params.get("order");
        if (sidx == "") {
            params.put("sidx", "id");
        }
        if(title==null || cname==null){
            title ="";
            cname ="";
        }
        Integer cur = Integer.valueOf(params.get("page").toString());
        Integer size = Integer.valueOf(params.get("limit").toString());
        Page<MisTestEntity> page = new Page<MisTestEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page, params)));
    }
}
