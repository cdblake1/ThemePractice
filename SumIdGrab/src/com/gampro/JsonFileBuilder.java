package com.gampro;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonFileBuilder {
	
	public static JsonObject gsonToJsonBuilder(String title, ArrayList<Integer> items) {
	
		JsonObject builder = new JsonObject();
		builder.addProperty("title", title);
		builder.addProperty("type", "custom");
		builder.addProperty("map", "any");
		builder.addProperty("mode", "any");
		builder.addProperty("priority", "false");
		builder.addProperty("sortrank", 0);
		
		JsonArray blocks = new JsonArray();
		JsonObject itemList = itemsBlockBuilder("items", items);
		
		if(itemList != null){
			blocks.add(itemList);
		}
		builder.add("blocks", blocks);
		return builder;
	}
	
	private static JsonObject itemsBlockBuilder(String type, ArrayList<Integer> itemLists){
		
		JsonObject itemsObjectBuilder = new JsonObject();
		itemsObjectBuilder.addProperty("type", type);
		itemsObjectBuilder.addProperty("recMath", "false");
		itemsObjectBuilder.addProperty("minSummonerLevel", -1);
		itemsObjectBuilder.addProperty("maxSummonerLevel", -1);
		itemsObjectBuilder.addProperty("showIfSummonerSpell", "");
		itemsObjectBuilder.addProperty("hideIfSummonerSpell", "");
		
		System.out.println("type: " + type + " " + itemLists.size());
		JsonArray itemsArrayBuilder = new JsonArray();
		for(int i = 0; i < itemLists.size(); i++){
			JsonObject itemListObject = new JsonObject();
			itemListObject.addProperty("id", itemLists.get(i).toString());
			itemListObject.addProperty("count", 1);
			itemsArrayBuilder.add(itemListObject);
			itemsObjectBuilder.add("items", itemsArrayBuilder);
		}
		
		return itemsObjectBuilder;
		
	}
	
}
