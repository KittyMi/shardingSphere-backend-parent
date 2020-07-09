package com.sphere.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    /**
     * 获取访问者的ip
     * @param request
     * @return
     */
    public static String ip(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    /**
     * 获取访问的设备
     * @param request
     * @return
     */
    public static String getDeviceType(HttpServletRequest request) {
        String agentString =request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(agentString);
        OperatingSystem operatingSystem = userAgent.getOperatingSystem(); // 操作系统信息
        DeviceType deviceType = operatingSystem.getDeviceType(); // 设备类型

        switch (deviceType) {
            case COMPUTER:
                return "PC";
            case TABLET: {
                if (agentString.contains("Android")) return "Android Pad";
                if (agentString.contains("iOS")) return "iPad";
                return "Unknown";
            }
            case MOBILE: {
                if (agentString.contains("Android")) return "Android";
                if (agentString.contains("iOS")) return "IOS";
                return "Unknown";
            }
            default:
                return "Unknown";
        }
    }

    /**
     *  获取IP地址
     * @param ip
     * @return
     * @throws Exception
     */
    public static String getIpAddress(String ip) throws Exception{
        OkHttpClient okHttpClient=new OkHttpClient();

        final Request request = new Request.Builder()
                .url("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip="+ip)
                .get()//默认就是GET请求，可以不写
                .build();
        Response response=okHttpClient.newCall(request).execute();

        JSONObject jsonObject=  JSON.parseObject(response.body().string());
        if (jsonObject.getInteger("status") == 0) {
            return jsonObject.getJSONObject("content").getString("address");
        }
        return null;
    }

}
