package com.example.firstapp;

public class RowItem {
	private int UnitImageId;
	private String UnitTitle;
	private String UnitDesc;

	public RowItem(int UnitImageId, String UnitTitle, String UnitDesc){
		this.setUnitImageId(UnitImageId);
		this.setUnitTitle(UnitTitle);
		this.setUnitDesc(UnitDesc);
	}

	public String getUnitDesc() {
		return UnitDesc;
	}

	public void setUnitDesc(String unitDesc) {
		UnitDesc = unitDesc;
	}

	public String getUnitTitle() {
		return UnitTitle;
	}

	public void setUnitTitle(String unitTitle) {
		UnitTitle = unitTitle;
	}

	public int getUnitImageId() {
		return UnitImageId;
	}

	public void setUnitImageId(int unitImageId) {
		UnitImageId = unitImageId;
	}
	
	public String toString() {
		return UnitTitle + "\n" + UnitDesc;
	}
	

}
