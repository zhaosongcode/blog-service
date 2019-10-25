package org.personal.blog.util.Http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by zs on 2019/8/23
 * 请求工具类
 */
public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
    private static RequestConfig requestConfig = null;

    static{
        // 设置请求和传输超时时间
        requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
    }

    /**
     * @Param []
     * @Return java.lang.String
     * @Author zs
     * @Date 2019/8/23 16:01
     * 功能描述：发送get请求
     */
    public static JSONObject get(String url){
        // get请求返回结果
        JSONObject jsonResult = null;
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送get请求
        HttpGet get = new HttpGet(url);
        get.setConfig(requestConfig);
        try {
            CloseableHttpResponse response = client.execute(get);
            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 读取服务器返回过来的json字符串数据
                HttpEntity entity = response.getEntity();
                String strResult = EntityUtils.toString(entity, "utf-8");
                // 把json字符串转换成json对象
                jsonResult = JSONObject.parseObject(strResult);
            } else {
                log.error("get请求提交失败:" + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("get请求提交失败:" + url, e);
        }
        finally {
            get.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * @Param []
     * @Return com.alibaba.fastjson.JSONObject
     * @Author zs
     * @Date 2019/8/23 17:31
     * 功能描述：post请求传递json数据
     */
    public static JSONObject post(String url, Map<String, Object> parMap){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost post = new HttpPost(url);
        // 设置请求和传输超时时间
        post.setConfig(requestConfig);
        try {
            if (null != parMap) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(parMap.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                post.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(post);
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    log.error("post请求提交失败:" + url);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("post请求提交失败:" + url);
        } finally {
            post.releaseConnection();
        }
        return jsonResult;
    }
}
