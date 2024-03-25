package com.sathya.servlet;

public class product {
private String proId;
private String proName;
private double proPrice;
private String proBrand;
private String proMadeIn;
private String proMfgDate;
private String proExpDate;
private InputStream proImage;
public product(String proId, String proName, double proPrice, String proBrand, String proMadeIn, String proMfgDate,
		String proExpDate, InputStream proImage) {
	super();
	this.proId = proId;
	this.proName = proName;
	this.proPrice = proPrice;
	this.proBrand = proBrand;
	this.proMadeIn = proMadeIn;
	this.proMfgDate = proMfgDate;
	this.proExpDate = proExpDate;
	this.proImage = proImage;
}
@Override
public String toString() {
	return "product [proId=" + proId + ", proName=" + proName + ", proPrice=" + proPrice + ", proBrand=" + proBrand
			+ ", proMadeIn=" + proMadeIn + ", proMfgDate=" + proMfgDate + ", proExpDate=" + proExpDate + "]";
}
public String getProId() {
	return proId;
}
public void setProId(String proId) {
	this.proId = proId;
}
public String getProName() {
	return proName;
}
public void setProName(String proName) {
	this.proName = proName;
}
public double getProPrice() {
	return proPrice;
}
public void setProPrice(double proPrice) {
	this.proPrice = proPrice;
}
public String getProBrand() {
	return proBrand;
}
public void setProBrand(String proBrand) {
	this.proBrand = proBrand;
}
public String getProMadeIn() {
	return proMadeIn;
}
public void setProMadeIn(String proMadeIn) {
	this.proMadeIn = proMadeIn;
}
public String getProMfgDate() {
	return proMfgDate;
}
public void setProMfgDate(String proMfgDate) {
	this.proMfgDate = proMfgDate;
}
public String getProExpDate() {
	return proExpDate;
}
public void setProExpDate(String proExpDate) {
	this.proExpDate = proExpDate;
}
public InputStream getProImage() {
	return proImage;
}
public void setProImage(InputStream proImage) {
	this.proImage = proImage;
}
}
