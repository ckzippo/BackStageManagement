package controller;

import model.ActionEnum;
import model.BackStageAdmin;
import model.SessionEnum;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.BackStageAdminService;
import util.InvokeHttpUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/20/16
 * TIME:9:19 AM
 */
@Controller
@RequestMapping("")
public class DispatchController {

    /**
     * 用来验证后台管理员用户名和密码
     */
    @Autowired
    private BackStageAdminService backStageAdminService;

    @Autowired
    private InvokeHttpUtil invokeHttpUtil;

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "login")
    public ModelAndView login(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();

        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");
        System.out.println("name: " + name + " pw: " + password);

        BackStageAdmin backStageAdmin = backStageAdminService.validateAdmin(name, password);

        // 用户名密码校验
        if (backStageAdmin != null) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute(SessionEnum.USERNAME.getSessionName(), name);
            session.setAttribute(SessionEnum.PASSWORD.getSessionName(), password);
            session.setAttribute(SessionEnum.AUTHENTICATION.getSessionName(), "true");
            session.setAttribute(SessionEnum.DEPTID.getSessionName(), backStageAdmin.getDeptid());
            modelAndView.setViewName("main");
        } else {
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

    /**
     * 查询用户
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "qryUser")
    public ModelAndView qryUser(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();

        String keyword = httpServletRequest.getParameter("keyword");
        if (keyword != null) {
            ArrayList<User> queryResult = invokeHttpUtil.QryUser(keyword);

            // 将查询结果保存到session中,jsp页面从session中查询结果来展示
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute(ActionEnum.QRYUSER.getActionName(), queryResult);
        }

        modelAndView.setViewName("qryUser");
        return modelAndView;
    }

    /**
     * 修改用户
     * @return
     */

    @RequestMapping(value = "modUser", params ="flag=show")
    public ModelAndView modUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("modUser");
        return  modelAndView;
    }

    /**
     * 调用修改用户接口
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "modUser", params = "flag=invoke")
    public ModelAndView modUserInvoke(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();

        String acc = httpServletRequest.getParameter("acc");
        String username = httpServletRequest.getParameter("username");
        String mobile = httpServletRequest.getParameter("mobile");
        String telephone = httpServletRequest.getParameter("telephone");
        String email = httpServletRequest.getParameter("email");
        String id = httpServletRequest.getParameter("id");

        User user = new User();
        user.setUseracc(acc);
        user.setUsername(username);
        user.setMobilephone(mobile);
        user.setTelephone(telephone);
        user.setEmail(email);
        user.setUserid(id);

        if (invokeHttpUtil.ModUser(user)) {
            modelAndView.setViewName("success");
        } else {
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }

    /**
     * 为用户增加建群权限
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "addCreateGroupAuthority")
    public ModelAndView addCreateGroupAuthority(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        String id = httpServletRequest.getParameter("id");
        if (InvokeHttpUtil.grantUser(id, "3")) {
            modelAndView.setViewName("success");
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    /**
     * 重置用户密码,目前默认为是重置成跟用户ACC一致
     * TODO:采用随机密码,以短信的形式发送给用户,同时提醒用户及时更改
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "resetPassword")
    public ModelAndView resetPassword(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        String id = httpServletRequest.getParameter("id");
        String acc = httpServletRequest.getParameter("acc");
        if (InvokeHttpUtil.resetPassword(id, acc)) {
            modelAndView.setViewName("success");
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
