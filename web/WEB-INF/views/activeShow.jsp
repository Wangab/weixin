<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">

<link rel="dns-prefetch" href="//res.wx.qq.com">
<link rel="dns-prefetch" href="//mmbiz.qpic.cn">
<link rel="shortcut icon" type="image/x-icon" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/favicon22c41b.ico">
<link rel="stylesheet" type="text/css" href="css/page_mp_article_improve2a26bd.css">
<link rel="stylesheet" type="text/css" href="css/page_mp_article_improve_combo29ab01.css">
<link rel="stylesheet" type="text/css" href="css/appmsg/not_in_mm2637ae.css">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>【WeStar活动展示】<s:if test='resultACT.title != null && resultACT.title !=""'>${resultACT.title }</s:if><s:else><fmt:formatDate value="${resultACT.startTime }" pattern="MM月dd日"/>活动</s:else></title>

</head>
<body id="activity-detail" class="zh_CN mm_appmsg not_in_mm" >
<!--MOB SHARE BEGIN-->
<div class="-mob-share-ui-button -mob-share-open">分享</div>
<div class="-mob-share-ui" style="display: none">
    <ul class="-mob-share-list">
        <li class="-mob-share-weibo"><p>新浪微博</p></li>
        <li class="-mob-share-tencentweibo"><p>腾讯微博</p></li>
        <li class="-mob-share-qzone"><p>QQ空间</p></li>
        <li class="-mob-share-qq"><p>QQ好友</p></li>
        <li class="-mob-share-weixin"><p>微信</p></li>
        <li class="-mob-share-renren"><p>人人网</p></li>
        <li class="-mob-share-kaixin"><p>开心网</p></li>
    </ul>
    <div class="-mob-share-close">取消</div>
</div>
<div class="-mob-share-ui-bg"></div>	
<script id="-mob-share" src="http://f1.webshare.mob.com/code/mob-share.js?appkey=cf7d00e467c0"></script>
<!--MOB SHARE END-->
	<div id="js_article" class="rich_media">
		<div id="js_top_ad_area" class="top_banner"></div>

		<div class="rich_media_inner">
			<div id="page-content">
				<div id="img-content" class="rich_media_area_primary">
					<h2 class="rich_media_title" id="activity-name">
						<s:if test='resultACT.title != null && resultACT.title !=""'>${resultACT.title }</s:if>
						<s:else><fmt:formatDate value="${resultACT.startTime }" pattern="MM月dd日"/>活动</s:else>
					</h2>
					<div class="rich_media_meta_list">
						<em id="post-date" class="rich_media_meta rich_media_meta_text">
						<%
								Integer hitsCount = (Integer) application.getAttribute("hitCounter2");
								if (hitsCount == null || hitsCount == 0) {
									/* 第一次访问 */
									hitsCount = 1;
								} else {
									/* 返回访问值 */
									hitsCount += 1;
								}
								application.setAttribute("hitCounter2", hitsCount);
								SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
								out.println(stf.format(new Date())
										+ "  "
										+ "<a href='http://www.tpy10.net/create.php?id=WeStarBL'>WeStar公众账号</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
										+ "  阅读 " + hitsCount);
							%>
                        </em>
					</div>
					<div class="rich_media_content " id="js_content">
						<section data-id="85635" class="135editor"
							style="border: 0px none; padding: 0px; box-sizing: border-box; margin: 0px; font-family: 微软雅黑;"
							data-color="rgb(235, 103, 148)" data-custom="rgb(235, 103, 148)">
							<section
								style="margin: 20px 10px 40px 20px; box-sizing: border-box; padding: 0px;">
								<section
									style="width: 10px; height: 10px; box-shadow: rgb(120, 120, 120) -1px 3px 8px; -webkit-transform: rotateZ(-50deg); margin-left: 120px; color: rgb(255, 255, 255); border-color: rgb(240, 200, 213); background-color: rgb(235, 103, 148); box-sizing: border-box; padding: 0px;"
									data-width="10px"></section>
								<section
									style="width: 85px; height: 70px; box-shadow: rgb(120, 120, 120) -1px 3px 8px; padding: 30px 10px 5px; -webkit-transform: rotateZ(-15deg); margin-left: -10px; color: rgb(255, 255, 255); border-color: rgb(240, 200, 213); background-color: rgb(235, 103, 148); box-sizing: border-box;"
									data-width="85px">
									<p style="color: inherit; white-space: normal;">
										<span style="font-size: 18px;"><strong
											style="color: inherit;"><span class="autonum"
												style="color: inherit;" data-original-title="" title="">WeStar</span>
										</strong> </span>
									</p>
								</section>
								<section
									style="padding: 0px; border: 0px rgb(235, 103, 148); max-width: 100%; margin-top: -70px; box-sizing: border-box; color: rgb(62, 62, 62); line-height: 25px; word-wrap: break-word !important;">
									<section
										style="width: 20px; height: 20px; box-shadow: rgb(120, 120, 120) -1px 3px 8px; -webkit-transform: rotateZ(-45deg); margin-left: 100px; margin-bottom: -5px; color: rgb(255, 255, 255); border-color: rgb(240, 200, 213); background-color: rgb(235, 103, 148); box-sizing: border-box; padding: 0px;"
										data-width="20px"></section>
									<section
										style="max-width: 100%; box-sizing: border-box; padding: 80px 15px 18px; color: inherit; font-size: 14px; box-shadow: rgb(117, 117, 117) 0px 0px 5px; border: 1px solid rgba(117, 117, 117, 0.498039); margin: 0px;">
										<p
											style="line-height: 24px; box-sizing: border-box; padding: 0px; margin-top: 0px; margin-bottom: 0px; text-align: left; color: inherit; white-space: normal;">
											<strong style="color: inherit;"><span
												class="135brush" data-brushtype="text"
												style="color: rgb(235, 103, 148); font-size: 28px; text-align: justify; border-color: rgb(235, 103, 148);">
												<s:if test='resultACT.title != null && resultACT.title !=""'>${resultACT.title }</s:if>
												<s:else><fmt:formatDate value="${resultACT.startTime }" pattern="MM月dd日"/>活动</s:else>
												</span>
											</strong>
										</p>
										<section class="135brush"
											data-style="line-height: 1.75em; box-sizing: border-box; padding: 0px; margin: 0px; text-align: left; color: inherit;font-size:14px;"
											style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">
											<br>
											<p style="text-align: left; white-space: normal;"><b>时间:<fmt:formatDate value="${resultACT.startTime }" pattern="MM月dd日"/> -- <fmt:formatDate value="${resultACT.endTime }" pattern="MM月dd日"/></b></p>
											<p style="text-align: left;"><b>价格:<s:if test="resultACT.commission== 0">面议</s:if><s:else><fmt:formatNumber type="number" maxFractionDigits="5" value="${resultACT.commission}" />元/人</s:else></b></p>
											<p style="text-align: left;"><b>活动地点：${resultACT.partyLocaltion}</b></p>
											<s:if test="resultACT.content != null"><p style="text-align: left;"><b>活动说明：</b><p style="text-indent: 2em;">${resultACT.content}</p></p></s:if>
											<s:if test='resultACT.numberPeople != null && resultACT.numberPeople >0'><p style="text-align: left;"><b>需求人数：${resultACT.numberPeople}</b></p></s:if>
											<s:else><p style="text-align: left;"><b>需求人数：待定</b></p></s:else>
											<s:if test='resultACT.location != null && resultACT.location!=""'><p style="text-align: left;"><b>面试地点：${resultACT.location}</b></p></s:if>
											<s:if test='resultACT.contact != null && resultACT.contact ！= ""'><p style="text-align: left;"><b>联系人：${resultACT.contact}</b></p></s:if>
											<p style="text-align: left;"><b>联系方式：${resultACT.phone}</b></p>
										</section>
									</section>
								</section>
							</section>
							<section style="width: 0px; height: 0px; clear: both; box-sizing: border-box; padding: 0px; margin: 0px;"></section>
						</section>
							<!-- 
							<img data-s="300,640" data-type="jpeg"
								style="width: 700px !important; visibility: visible !important; height: 466.206px !important;margin-top: 8px;"
								data-ratio="0.66600790513834" data-w=""
								src="image/photos/4/1448873670092_4.JPG">
							<p align="center">
								<span style="font-size: 14px; color: rgb(89, 89, 89);">如果你想做下一期的"<span style="font-size: 14px; color: rgb(192, 0, 0);"><strong>WeStar女神</strong></span>"，把你的WeStar号发给小编吧，等你呦~</span><br>
							</p> -->
					</div>
				</div>

			</div>
			<div id="js_pc_qr_code" class="qr_code_pc_outer"
				style="display: block;">
				<div class="qr_code_pc_inner">
					<div class="qr_code_pc">
						<img id="js_pc_qr_code_img" class="qr_code_pc_img" src="images/gongzhonghao.jpg"></img>
						<p>
							微信扫一扫<br>关注该公众号
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>
	<footer id="footer" class="midnight-blue" style="text-align: center;background-color: SkyBlue;">
		<!-- <a href="#" onclick="alert('Clicked!');">更多活动信息请点击标题处链接关注微信公众号</a> -->
		<a href="http://www.tpy10.net/create.php?id=WeStarBL" >更多活动信息请点击此处关注微信公众号</a>
    </footer><!--/#footer-->
</body>
</html>