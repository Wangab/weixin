<%@	page import="java.util.Date"%>
<%@	page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="/WEB-INF/css/page_mp_article_improve2a26bd.css">
    <link rel="stylesheet" type="text/css" href="/WEB-INF/css/page_mp_article_improve_combo29ab01.css">
    <link rel="stylesheet" type="text/css" href="/WEB-INF/css/appmsg/not_in_mm2637ae.css">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <title>【WeStar模特卡】<s:property value='nick'/>/身高:<fmt:formatNumber type="number" maxFractionDigits="3" value="175.012" />cm/体重:<fmt:formatNumber type="number" maxFractionDigits="3" value="45.09" />kg</title>

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
                <h2 class="rich_media_title" id="activity-name">【WeStar模特卡】${user.nick}</h2>
                <div class="rich_media_meta_list">
                    <em id="post-date" class="rich_media_meta rich_media_meta_text">
                        <%
                            Integer hitsCount = (Integer) application.getAttribute("hitCounter");
                            if (hitsCount == null || hitsCount == 0) {
									/* 第一次访问 */
                                hitsCount = 1;
                            } else {
									/* 返回访问值 */
                                hitsCount += 1;
                            }
                            application.setAttribute("hitCounter", hitsCount);
                            SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
                            out.println(stf.format(new Date())
                                    + "  "
                                    + "<a href='http://www.tpy10.net/create.php?id=WeStarBL'>WeStar公众账号</a>&nbsp;【北京】&nbsp;阅读 " + hitsCount);
                        %></em>
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
                                    style="width: 85px; height: 60px; box-shadow: rgb(120, 120, 120) -1px 3px 8px; padding: 30px 10px 5px; -webkit-transform: rotateZ(-15deg); margin-left: -10px; color: rgb(255, 255, 255); border-color: rgb(240, 200, 213); background-color: rgb(235, 103, 148); box-sizing: border-box;"
                                    data-width="85px">
                                <p style="color: inherit; white-space: normal;">
										<span style="font-size: 18px;">
                                            <strong style="color: inherit;">
                                                <span class="autonum" style="color: inherit;" data-original-title="" title="">WeStar</span>
                                            </strong>
                                        </span>
                                </p>
                            </section>
                            <section style="padding: 0px; border: 0px rgb(235, 103, 148); max-width: 100%; margin-top: -70px; box-sizing: border-box; color: rgb(62, 62, 62); line-height: 25px; word-wrap: break-word !important;">
                                <section style="width: 20px; height: 20px; box-shadow: rgb(120, 120, 120) -1px 3px 8px; -webkit-transform: rotateZ(-45deg); margin-left: 100px; margin-bottom: -5px; color: rgb(255, 255, 255); border-color: rgb(240, 200, 213); background-color: rgb(235, 103, 148); box-sizing: border-box; padding: 0px;"
                                        data-width="20px"></section>
                                <section style="max-width: 100%; box-sizing: border-box; padding: 80px 15px 18px; color: inherit; font-size: 14px; box-shadow: rgb(117, 117, 117) 0px 0px 5px; border: 1px solid rgba(117, 117, 117, 0.498039); margin: 0px;">
                                    <p style="line-height: 24px; box-sizing: border-box; padding: 0px; margin-top: 0px; margin-bottom: 0px; text-align: right; color: inherit; white-space: normal;">
                                        <strong style="color: inherit;">
                                            <span class="135brush" data-brushtype="text" style="color: rgb(235, 103, 148); font-size: 28px; text-align: justify; border-color: rgb(235, 103, 148);"><s:property value='user.nick'/></span>
                                        </strong>
                                    </p>
                                    <section class="135brush"
                                             data-style="line-height: 1.75em; box-sizing: border-box; padding: 0px; margin: 0px; text-align: left; color: inherit;font-size:14px;"
                                             style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">
                                        <br>
                                        <p style="text-align: right;"><b>登录名：<s:property value='user.name' /></b></p>
                                        <p style="text-align: right;"><b>所在城市：<s:property value='user.haunted' /></b></p>
                                        <p style="text-align: right;"><b>三围：<fmt:formatNumber type="number" maxFractionDigits="3" value="${user.bust}" /> - <fmt:formatNumber type="number" maxFractionDigits="3" value="${user.waist}" /> - <fmt:formatNumber type="number" maxFractionDigits="3" value="${user.hips}" /></b></p>
                                        <p style="text-align: right;"><b>身高：<fmt:formatNumber type="number" maxFractionDigits="3" value="${user.height}" /> cm</b></p>
                                        <p style="text-align: right;"><b>体重：<fmt:formatNumber type="number" maxFractionDigits="3" value="${user.weight}" /> kg</b></p>
                                        <!-- <p style="text-align: right;"><b>胸围：<s:property value='user.bust'/></b></p>
											<p style="text-align: right;"><b>臀围：<s:property value='user.hips'/></b></p>
											<p style="text-align: right;"><b>腰围：<s:property value='user.waist'/></b></p>
											<p style="text-align: right;"><b>脚码：<s:property value='user.shoesSize'/></b></p> -->
                                    </section>
                                </section>
                            </section>
                        </section>
                        <section style="width: 0px; height: 0px; clear: both; box-sizing: border-box; padding: 0px; margin: 0px;"></section>
                    </section>
                    <s:if test="psList!=null && !psList.isEmpty()">
                        <s:iterator value="psList" id="cd" status="st">
                            <img data-s="300,640" data-type="jpeg"
                                 style="max-height: 800px !important;margin-top: 8px;"
                                 data-ratio="1.5" data-w="" src=".<s:property value='url'/>">
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <img data-s="300,640" data-type="jpeg"
                             style="max-height: 800px !important;margin-top: 8px;"
                             data-ratio="1.5" data-w=""
                             src=".<s:property value='user.photo'/>">
                    </s:else>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>