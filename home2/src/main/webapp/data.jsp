<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="jsoft.library.Utilities"%>
<%@page import="jsoft.library.ORDER"%>
<%@page import="jsoft.home.article.ARTICLE_SOFT"%>
<%@ page import="jsoft.home.article.ArticleControl"%>
<%@ page import="jsoft.home.homepage.HomepageControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jsoft.*,jsoft.objects.*"%>
<%@ page import="java.util.*,org.javatuples.*"%>
<%@ page import="jsoft.home.*"%>


<%
// xac dinh tap ki tu can lay
request.setCharacterEncoding("utf-8");
// lay uri xac dinh vi tri
String uri =request.getRequestURI().substring(6);
int at =uri.indexOf("/");
// tim bo quan ly ket noi
ConnectionPool cp = (ConnectionPool)application.getAttribute("CPool");
HomepageControl cc = new HomepageControl(cp);
if(cp==null) {
	application.setAttribute("CPool", cc.getCP());
}

CareerObject similar = new CareerObject();;

Triplet<CareerObject, Integer, Byte> incareer = new Triplet<>(similar, 0, (byte)5);
ArrayList<String> listView = cc.viewHomePage(incareer);
if(listView.size()>0) {
	//gui cau truc hien thi vao phien lam viec
	session.setAttribute("listview",listView );
}
%>