package util;

import model.Department;
import model.HTTPEnum;
import model.User;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/7/16
 * TIME:2:33 PM
 */
@Component
public class InvokeHttpUtil {
    private static Logger logger = Logger.getLogger(InvokeHttpUtil.class.getName());

    /**
     * 调用服务器提供的http接口
     *
     * @param url
     * @param data
     * @return
     */
    public static String Invoke(String url, NameValuePair[] data) {

        String result = null;
        StringBuffer param = new StringBuffer();
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        for (NameValuePair nameValuePair : data) {
            param.append(nameValuePair.getName() + " " + nameValuePair.getValue() + " ");
        }
        postMethod.setRequestBody(data);

        int statusCode = 0;
        try {
            statusCode = httpClient.executeMethod(postMethod);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
                || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
            Header locationHeader = postMethod.getResponseHeader("location");
            String location = null;
            if (locationHeader != null) {
                location = locationHeader.getValue();
            } else {
                logger.error("location field is null");
            }
            return "0";
        } else {
            try {
                result = postMethod.getResponseBodyAsString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        postMethod.releaseConnection();
        return result;
    }

    /**
     * 根据关键字查询用户
     *
     * @param keyword
     * @return
     */
    public static ArrayList<User> QryUser(String keyword) {
        ArrayList<User> arrayList = new ArrayList<User>();
        String result = "";

        String url = HTTPEnum.QRYUSER.toString();
        NameValuePair[] data = {
                new NameValuePair("USR_REQ", "1"),
                new NameValuePair("WILDCARDS", keyword),
        };

        result = Invoke(url, data);
        JSONObject jsonObject = new JSONObject(result);
        if (jsonObject.get("RET").toString().equals("SUC")) {

            JSONArray jsonArray = new JSONArray(jsonObject.get("LST").toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                User user = new User();
                JSONObject userJson = new JSONObject(jsonArray.getJSONObject(i).toString());
                if (userJson.has("USR_ACC")) {
                    user.setUseracc(userJson.get("USR_ACC").toString());
                }

                if (userJson.has("USR_NAME")) {
                    user.setUsername(userJson.get("USR_NAME").toString());
                }

                if (userJson.has("USR_ID")) {
                    user.setUserid(userJson.get("USR_ID").toString());
                }

                if (userJson.has("SIGN")) {
                    user.setSign(userJson.get("SIGN").toString());
                }

                if (userJson.has("AVATAR")) {
                    user.setAvatar(Integer.parseInt(userJson.get("AVATAR").toString()));
                }

                if (userJson.has("BIRTHDAY")) {
                    user.setBirthday(userJson.get("BIRTHDAY").toString());
                }

                if (userJson.has("DEPT_ID")) {
                    user.setDeptid(userJson.get("DEPT_ID").toString());
                }

                if (userJson.has("DEPT_NAME")) {
                    user.setDeptname(userJson.get("DEPT_NAME").toString());
                }

                if (userJson.has("TEL")) {
                    user.setTelephone(userJson.get("TEL").toString());
                }

                if (userJson.has("MPHONE")) {
                    user.setMobilephone(userJson.get("MPHONE").toString());
                }

                if (userJson.has("EMAIL")) {
                    user.setEmail(userJson.get("EMAIL").toString());
                }

                arrayList.add(user);
                logger.info(user.toString());
            }
        } else {
            return null;
        }
        return arrayList;
    }


    /**
     * 根据ID查询指定用户
     *
     * @param id
     * @return
     */
    public static User QryUserById(String id) {
        String result = "";
        User user = new User();

        String url = HTTPEnum.QRYUSER.toString();
        NameValuePair[] data = {
                new NameValuePair("USR_REQ", "1"),
                new NameValuePair("USR_ID", id),
        };

        result = InvokeHttpUtil.Invoke(url, data);
        JSONObject jsonObject = new JSONObject(result);
        if (jsonObject.get("RET").toString().equals("SUC")) {

            JSONArray jsonArray = new JSONArray(jsonObject.get("LST").toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject userJson = new JSONObject(jsonArray.getJSONObject(i).toString());
                if (userJson.has("USR_ACC")) {
                    user.setUseracc(userJson.get("USR_ACC").toString());
                }

                if (userJson.has("USR_NAME")) {
                    user.setUsername(userJson.get("USR_NAME").toString());
                }

                if (userJson.has("USR_ID")) {
                    user.setUserid(userJson.get("USR_ID").toString());
                }

                if (userJson.has("SIGN")) {
                    user.setSign(userJson.get("SIGN").toString());
                }

                if (userJson.has("AVATAR")) {
                    user.setAvatar(Integer.parseInt(userJson.get("AVATAR").toString()));
                }

                if (userJson.has("BIRTHDAY")) {
                    user.setBirthday(userJson.get("BIRTHDAY").toString());
                }

                if (userJson.has("DEPT_ID")) {
                    user.setDeptid(userJson.get("DEPT_ID").toString());
                }

                if (userJson.has("DEPT_NAME")) {
                    user.setDeptname(userJson.get("DEPT_NAME").toString());
                }

                if (userJson.has("TEL")) {
                    user.setTelephone(userJson.get("TEL").toString());
                }

                if (userJson.has("MPHONE")) {
                    user.setMobilephone(userJson.get("MPHONE").toString());
                }

                if (userJson.has("EMAIL")) {
                    user.setEmail(userJson.get("EMAIL").toString());
                }
            }
            return user;
        } else {
            return null;
        }
    }

    /**
     * 修改个人用户 TODO:确认是否需要所有个人资料字段
     *
     * @param user
     * @return
     */
    public static boolean ModUser(User user) {
        String result = null;
        String url = HTTPEnum.MODUSER.toString();
        NameValuePair[] data = {
                new NameValuePair("USR_REQ", user.getUserid()),
                new NameValuePair("ACC", user.getUseracc()),
                new NameValuePair("NAME", user.getUsername()),
                new NameValuePair("MPHONE", user.getMobilephone()),
                new NameValuePair("TEL", user.getTelephone()),
                new NameValuePair("EMAIL", user.getEmail()),
                new NameValuePair("SIGN", user.getSign()),
        };
        result = Invoke(url, data);
        JSONObject jsonObject = new JSONObject(result);
        result = jsonObject.get("RET").toString();
        return result.equals("SUC");
    }

    /**
     * 新增用户
     * @param reqid 管理员ID
     * @param user 用户信息
     * @return
     */
    public static boolean AddUser(String reqid, User user) {
        String result = "";
        String url = HTTPEnum.ADDUSER.toString();
        NameValuePair[] data = {
                new NameValuePair("USR_REQ", reqid),
                new NameValuePair("ACC", user.getUseracc()),
                new NameValuePair("NAME", user.getUsername()),
                //TODO 缺少SEX字段
                new NameValuePair("MPHONE", user.getMobilephone()),
                new NameValuePair("EMAIL", user.getEmail())
        };

        result = Invoke(url, data);

        if (!result.startsWith("{"))
            return false;
        JSONObject jsonObject = new JSONObject(result);
        result = jsonObject.get("RET").toString();
        return result.equals("SUC");
    }


    /**
     * 根据部门ID查询其子部门信息
     * @param id
     * @return
     */
    //TODO:如果查询根节点,则不带ID
    public static ArrayList<Department> QryChildDeptById(String id) {
        ArrayList<Department> departments = new ArrayList<Department>();
        String result = null;
        String url = HTTPEnum.QRYDEPT.toString();

        //查询非根目录
        NameValuePair[] data_nonroot = {
                new NameValuePair("USR_REQ", "1"),
                new NameValuePair("DEPT_ID", id),
        };

        //查询根目录
        NameValuePair[] data_root = {
                new NameValuePair("USR_REQ", "1"),
        };

        NameValuePair[] data;
        if (id.equals("0")){
           data = data_root;
        } else {
           data = data_nonroot;
        }

        result = Invoke(url, data);
        JSONObject jsonObject = new JSONObject(result);
        if (jsonObject.get("RET").toString().equals("SUC")) {
            JSONArray jsonArray = new JSONArray(jsonObject.get("LST_DEPT").toString());
            for (int i =0; i< jsonArray.length(); i++) {
                Department department = new Department();
                JSONObject departObject = new JSONObject(jsonArray.getJSONObject(i).toString());

                if (departObject.has("DEPT_ID")) {
                    department.setDeptid(departObject.getString("DEPT_ID"));
                }

                if (departObject.has("DEPT_NAME")) {
                    department.setDeptname(departObject.getString("DEPT_NAME"));
                }

                if (departObject.has("DEPT_LIQ")) {
                    department.setDeptliq(departObject.getString("DEPT_LIQ"));
                }

                if (departObject.has("PARENT_DEPT")) {
                    department.setParentid(departObject.getString("PARENT_DEPT"));
                }
                logger.info(department);
                departments.add(department);
            }
        } else {
            return null;
        }

        return departments;
    }

    /**
     * 为用户赋予权限
     * @param id 用户id
     * @param role 权限标示
     * @return 成功 true, 失败 false
     */
    public static boolean grantUser(String id, String role) {
        String result = "";
        String url = HTTPEnum.GRANTUSER.toString();

        NameValuePair[] data = {
                new NameValuePair("USR_REQ", id),
                new NameValuePair("ROLE", role),
        };

        result = Invoke(url, data);

        if (!result.startsWith("{"))
            return false;
        JSONObject jsonObject = new JSONObject(result);
        result = jsonObject.get("RET").toString();
        return result.equals("SUC");
    }

    /**
     * 重置用户密码
     * @param id 用户ID
     * @param password 用户密码
     * @return 成功 true, 失败 false
     */
    public static boolean resetPassword(String id, String password) {
        String result = "";
        String url = HTTPEnum.RESETPW.toString();

        NameValuePair[] data = {
                new NameValuePair("USR_REQ", id),
                new NameValuePair("USR_CODE", password)
        };

        result = Invoke(url, data);
        if (!result.startsWith("{"))
            return false;
        JSONObject jsonObject = new JSONObject(result);
        result = jsonObject.get("RET").toString();
        return result.equals("SUC");
    }

    public static void main(String[] args) {
//        System.out.println(InvokeHttpUtil.qryUser("lixing"));
//        System.out.println(InvokeHttpUtil.QryUserById("29297").toString());

//        //测试用户
//        User user = new User();
//        user.setUserid("80183");
//        user.setUseracc("test13");
//        user.setUsername("江苏陈江");
//        user.setMobilephone("15301586700");
////        user.setTelephone(" ");
//        user.setSign("ttstt");
//        user.setEmail("chenjiang3@189.cn");
//        boolean re = InvokeHttpUtil.ModUser(user);
//        System.out.println(re);

        // 查询部门
        /*String deptid = "310";
        ArrayList<Department> arrayList;
        arrayList = InvokeHttpUtil.QryChildDeptById(deptid);
        for (Department department : arrayList) {
            System.out.println(department);
        }*/

    }
}
