package io.hz.modules.mis.controller;

import io.hz.common.base.PageUtils;
import io.hz.common.base.R;
import io.hz.modules.mis.entity.MisPrivateChatEntity;
import io.hz.modules.mis.service.MisPrivateChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("mis/misprivatechat")
public class MisPrivateChatController {
    @Autowired
    private MisPrivateChatService misPrivateChatService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String,Object> params){
        PageUtils page = misPrivateChatService.MyqueryPage(params);
        return R.ok().put("page",page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        MisPrivateChatEntity misPrivateChat = misPrivateChatService.selectById(id);

        return R.ok().put("misPrivateChat", misPrivateChat);
        //{"msg":"success","misStudent":{"id":4,"name":"李三","age":18,"score":98.0},"code":0}
    }

    /**
     * RequestBody:参数
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MisPrivateChatEntity misPrivateChat){
        misPrivateChatService.insert(misPrivateChat);

        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestParam Map<String,Object> params){
        String content = (String)params.get("content");
        String contact = (String)params.get("contact");
        int uid = Integer.parseInt((String) params.get("uid"));
        MisPrivateChatEntity misPrivateChat = new MisPrivateChatEntity();
        misPrivateChat.setContact(contact);
        misPrivateChat.setContent(content);
        misPrivateChat.setUid(uid);
        misPrivateChatService.insert(misPrivateChat);
        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MisPrivateChatEntity misPrivateChat){
        misPrivateChatService.updateById(misPrivateChat);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        misPrivateChatService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
}
