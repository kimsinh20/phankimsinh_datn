<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="jsoft.library.Utilities"%>
<%@page import="jsoft.library.ORDER"%>
<%@page import="jsoft.home.article.ARTICLE_SOFT"%>
<%@ page import="jsoft.home.article.ArticleControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jsoft.*, jsoft.objects.*"%>
<%@ page import="java.util.*, org.javatuples.*"%>
<%@ page import="jsoft.home.*"%>


<%
// xac dinh tap ki tu can lay
request.setCharacterEncoding("utf-8");
// lay uri xac dinh vi tri
String uri =request.getRequestURI().substring(6);
int at =uri.indexOf("/");
// tim bo quan ly ket noi
ConnectionPool cp = (ConnectionPool)application.getAttribute("CPool");

%>