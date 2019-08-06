package io.hz.modules.mis.controller;

import io.hz.common.utils.ExportExcelUtil;
import io.hz.modules.mis.entity.ExportEntity;
import io.hz.modules.mis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("mis/my")
public class MyController {
    @Autowired
    private MyService myService;

    @RequestMapping("/exportexcel")
    public void c1(HttpServletRequest request, HttpServletResponse response){
        List<ExportEntity> list=myService.select1(null);
        //定义列
        String[] columnNames = {"测试题名称","价格","测试人数","测试内容","创建时间","分类名"};
        //定义表
        String fileName="测试题清单";

        //导出
        ExportExcelUtil<ExportEntity>util = new ExportExcelUtil<ExportEntity>();
        util.exportExcel(fileName,fileName,columnNames,list,response,ExportExcelUtil.EXCEL_FILE_2003);

    }
}
