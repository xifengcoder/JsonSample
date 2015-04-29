package com.yxf.jsonsample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	
    public static void main(String[] args) {
    	System.out.println("testJsonString()");
    	testJsonString();
    	System.out.println("testJsonArray():");
    	testJsonArray();
    	System.out.println("testMapJson():");
    	testMapJson();
    }
    
    public static void testJsonString() {
    	Person person = new Person(1, "xiaoluo", "广州");
        //将Person对象转换成一个json类型的字符串对象
        String personString = JsonTools.getJsonString("person", person);
        System.out.println(personString.toString());
    }
    
    public static void testJsonArray(){
        List<Person> persons = new ArrayList<Person>();
        Person person = new Person(1, "xiaoluo", "广州");
        Person person2 = new Person(2, "android", "上海");
        persons.add(person);
        persons.add(person2);
        String personsString = JsonTools.getJsonString("persons", persons);
        //System.out.println(personsString);
        System.out.println("JSONObject : " + JSONArray.fromObject(persons));
        
        JSONObject jsonObject = JsonTools.getJsonObject("persons", persons);
        //    List<Person>相当于一个JSONArray对象
        JSONArray personsArray = (JSONArray)jsonObject.getJSONArray("persons");
        List<Person> persons2 = (List<Person>) personsArray.toCollection(personsArray, Person.class);
        System.out.println("ArrayList: " + persons2);
    }
    
    public static void testMapJson(){
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("id", "001");
        map1.put("name", "xiaoluo");
        map1.put("age", "20");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("id", "002");
        map2.put("name", "android");
        map2.put("age", "33");
        list.add(map1);
        list.add(map2);
        String listString = JsonTools.getJsonString("list", list);
        System.out.println(listString);
        System.out.println(JSONArray.fromObject(list));
        
        JSONObject jsonObject = JsonTools.getJsonObject("list", list);
        JSONArray listArray = jsonObject.getJSONArray("list");
        List<Map<String, String>> list2 = (List<Map<String, String>>) listArray.toCollection(listArray, Map.class);
        System.out.println("ArrayList: " + list2);
    }
}
