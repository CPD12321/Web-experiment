<%@page import="com.wm.Model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
	<%
		Object o = session.getAttribute("user");
		User user = (User)o;
		out.println("<font color=\"blue\" size=\"4\" face=\"Arial\">当前登录对象:</font>"+user.getaccount());
	%>
		<meta charset="UTF-8">
		<title>欢迎收听</title>
		<meta name="viewport" content="width=device-width" />
		<style>
			* {
				margin: 0;
				padding: 0;
			}
			
			body {
				margin-bottom: 50px;
			}
			
			.fix {
				position: fixed;
				bottom: 0;
				left: 0;
				z-index: 99;
				background-color: rgba(0, 0, 0, .5);
				right: 0;
				text-align: center;
				font-size:0;
			}
			
			audio {
				display: block;
				width: 100%;
			}
			button{
				padding: 3px 2px;
				margin:4px 1px;
			}
			.mp3_list {
				padding: 0;
				list-style: none;
			}		
			.mp3_list .mp3_title {
				padding: 14px 5px;
				border-bottom: 1px solid #CCCCCC;				
				color: #FFFFFF;
				background: #1EACEA;
				text-align: center;
			}
			
			.mp3_list li {
				position: relative;
				padding: 15px 50px 12px 12px;
				background: #fff;
				color: #4C4C4C;
				overflow: hidden;
				font-size: 14px;
				text-overflow: ellipsis;
				border-bottom: 1px solid #F5F5F5;
				white-space: nowrap;
				cursor: pointer;
			}
			
			.mp3_list .over,
			.mp3_list .active {
				color: #00B7EE;
			}
			
			.mp3_list li span {
				position: absolute;
				font-size: 12px;
				right: 0;
			}
		</style>
	</head>

	<body>
		<div class="fix">
			<audio controls autoplay="autoplay">
				<source src=""></source>
				浏览器不支持播放器请更换谷歌或升级浏览器
			</audio>
			<button id="play">播放</button>
			<button id="paused">暂停</button>
			<button id="urls">音乐地址</button>
			<button id="preurl">上一曲</button>
			<button id="nexturl">下一曲</button>
			<button id="loop">循环</button>
		</div>
		<ul class="mp3_list">
		</ul>
		<script src="js/listrings.js"></script>
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script>
			$(function() {
				var listindex = 0,
					len = mp3s.length,
					audio = $("audio")[0],
					source=$("source")[0];
				var initlist = function() {
					var html = '<div class="mp3_title">音乐列表</div>'
					for(i = 0; i < len; i++) {
						html += '<li data-id="' + i + '">' + mp3s[i].title + '<span>' + mp3s[i].desp.split("|")[1] + '</span></li>'
					}
					$(".mp3_list").html(html)
				};
				var playaudio = function() {
					audio.play();
				};
				//改变音频地址
				var changeSrc = function(index) {
					$(".mp3_list li").removeClass("active")
					$(".mp3_list li").removeClass("over");
					audio.src=mp3s[index].songUrl;
					$("#paused").trigger("click")
					$(".mp3_list li").eq(index).addClass("active")
					playaudio()
				};
				//初始化音乐队列
				initlist();
				//默认播放第一首
				changeSrc(listindex);
				//监听结束事件
				$("audio").on("ended", function() {
					if(++listindex > len) {
						listindex = 0;
					}
					changeSrc(listindex);
				});
				$(".mp3_list").on("mouseover", "li", function() {
					$(this).addClass("over")
				});
				$(".mp3_list").on("mouseout", "li", function() {
					$(this).removeClass("over")
				});
				$(".mp3_list").on("click", "li", function() {
					listindex = $(this).attr("data-id");
					changeSrc(listindex)
				});
				//播放
				$("#play").click(playaudio);
				$("#paused").click(function() {
					audio.pause()
				});
				$("#loop").click(function() {
					var val=audio.loop==true?"循环":"关闭"
					$(this)[0].innerText=val
					audio.loop = !audio.loop;
				});
				//当前音乐地址
				$("#urls").click(function() {
					alert(audio.currentSrc)
				});
				//上一曲
				$("#preurl").click(function() {
					if(--listindex < 0) {
						listindex = 0;
						return
					} else {
						changeSrc(listindex)
					}
				});
				//下一曲
				$("#nexturl").click(function() {
					if(++listindex > len) {
						listindex = len;
						return
					} else {
						changeSrc(listindex)
					}
				});

			})
		</script>
	</body>

</html>
