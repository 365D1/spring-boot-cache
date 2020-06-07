package com._365d1.cache.web;
// +----------------------------------------------------------------------
// | 官方网站: www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 
// +----------------------------------------------------------------------
// | 时　　间: 2020/6/7 12:56
// +----------------------------------------------------------------------
// | 代码创建: 朱荻 <292018748@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:（修改人 - 修改时间）
// +----------------------------------------------------------------------

import com._365d1.cache.model.User;
import com._365d1.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public Object detail(
            @RequestParam(value = "id") Integer id
    ) {
        User user = userService.detail(id);
        return user;
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public Object update(
            @RequestParam(value = "nickName") String nickName,
            @RequestParam(value = "id") Integer id
    ) {
        User user = new User();
        user.setNickName(nickName);
        user.setId(id);
        return userService.update(user);
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Object delete(
            @RequestParam(value = "id") Integer id
    ) {
        userService.delete(id);
        return "删除";
    }

}
