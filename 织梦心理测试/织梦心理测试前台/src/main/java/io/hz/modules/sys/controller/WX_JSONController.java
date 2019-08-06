package io.hz.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import io.hz.modules.mis.entity.MisUserEntity;
import io.hz.modules.mis.service.MisUserService;
import io.hz.modules.sys.util.WX_AuthUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class WX_JSONController {

    @Autowired
    MisUserService misUserService;
    @GetMapping("/ggg")
    public String callBack(@RequestParam("code") String code, HttpSession session) throws IOException {

        //第二步：通过code换取网页授权access_token

        //从request里面获取code参数(当微信服务器访问回调地址的时候，会把code参数传递过来)

        //获取code后，请求以下链接获取access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WX_AuthUtil.APPID
                + "&secret=" + WX_AuthUtil.APPSECRET
                + "&code=" + code
                + "&grant_type=authorization_code";

        //通过网络请求方法来请求上面这个接口
        JSONObject jsonObject = WX_AuthUtil.doGetJson(url);

        //从返回的JSON数据中取出access_token和openid，拉取用户信息时用
        String token =  jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");

        // 第三步：刷新access_token（如果需要）

        // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
        String infoUrl ="https://api.weixin.qq.com/sns/userinfo?access_token=" + token
                + "&openid=" + openid
                + "&lang=zh_CN";
        //通过网络请求方法来请求上面这个接口
        JSONObject userInfo = WX_AuthUtil.doGetJson(infoUrl);
        String user = JSON.toJSONString(userInfo);
        MisUserEntity misUserEntity = JSON.parseObject(user,MisUserEntity.class);
        if(misUserService.getMisUserByOpenId(misUserEntity.getOpenid())==null){
            misUserEntity.setName(JSON.parseObject(user,MisUserEntity.class).getNickname());
            misUserService.insert(misUserEntity);
    }
        session.setAttribute("misUserEntity",misUserService.getMisUserByOpenId(misUserEntity.getOpenid()));
        return userInfo.toString();
    }
}
