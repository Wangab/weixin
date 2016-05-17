<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat,java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>【WeStar活动展示】</title>

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
					<h2 class="rich_media_title" id="activity-name">${resultACT.title }</h2>
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
										<span style="font-size: 19px;"><strong
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
										<%
				List<TActivity> acts =  (List<TActivity>)(request.getAttribute("acts"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日");
				if(acts != null && acts.size()>0){
					for(TActivity act:acts){
					String tile = act.getTitle().length()>10?(act.getTitle().substring(0, 10)+"..."):(act.getTitle());
					if(tile.trim().length()==0){
						tile = dateFormat.format(act.getStartTime()) + "活动";
					}
					out.println("<div style='background-color: #b6d4f1;height: 110px;margin-bottom: 3px;margin-top: 3px;margin-left: 3px;margin-right: 3px;padding: 5px;' >");
					out.println("<div style='background-color: #fdefe3;height: 100%;width: 30%;float: left;' align='center'><strong>"+tile+"<br></strong></div>");
					out.println("<div style='width: 68%;margin-bottom: 3px;margin-top: 3px;margin-left: 3px;float: left;' align='center'>活动时间:"+dateFormat.format(act.getStartTime())+"<br>"+(act.getContent().length()>10?(act.getContent().substring(0, 9)+"..."):act.getContent())+"<br>价格:"+(act.getCommission()>0?String.format("%.0f",act.getCommission()):"面议")+"<br><a href='showaction.action?actid="+act.getId()+"'>查看活动详情</a></div></div>");
					//out.println("<div style='height: 30%;width: 68%;margin-bottom: 3px;margin-top: 3px;margin-left: 3px; float: left;' align='center'><a href='showaction.action?actid="+act.getId()+"'>查看活动详情</a></div></div>");
					}
					
				}else{
					out.println("<p>对不起哦！当前没有新的活动！</p>");
				}
			 %>
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
		<!-- <a href="#" onclick="alert('Clicked!');">发布活动请下载app</a> -->
		<span>虚假活动举报和个人主页制作，请联系286934784@qq.com</span>
    </footer><!--/#footer-->
</body>
</html>