package com.yxf.jsonsample;

import net.sf.json.JSONObject;


public class JsonTools
{
    /**
     * �õ�һ��json���͵��ַ�������
     * @param key
     * @param value
     * @return
     */
    public static String getJsonString(String key, Object value) {
        JSONObject jsonObject = new JSONObject();
        //put��element������JSONObject�����з��� key/value ��
        jsonObject.put(key, value);
        //jsonObject.element(key, value);
        return jsonObject.toString();
    }
    
    /**
     * �õ�һ��json����
     * @param key
     * @param value
     * @return
     */
    public static JSONObject getJsonObject(String key, Object value)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        return jsonObject;
    }
    
}
