/*
==========================================
* jQuery焦点图插件v0.1
==========================================
+ 参数说明
+ picWidth : 焦点图宽度
+ picHeight :  焦点图高度
+ picVisibleNum :  一屏内焦点图个数
+ direction : 焦点图切换方向，默认为left，可以为right, top, bottom
+ picScrollSelector : 图片滚动层选择器
+ picSetSelector : 图片选择器
+ toggerSelector : 触发器选择器
+ toggerSelected : 触发器触发状态样式class
+ toggerMode : 触发方式，默认为鼠标划过
+ scrollTime : 滚动时间，默认500毫秒
+ intervalTime : 滚动间隔时间，默认3000毫秒
==========================================
* Copyright (c) 2012 伯仁网络 All rights reserved.
* Author: YinHailin
* $Id: jquery.focuspic.js 2012-10-19 YinHailin $
==========================================
*/

;(function($) {
	$.fn.focusPic = function(options){
		var defaults = {
			picWidth : 600,  //焦点图宽度
			picHeight : 300,  //焦点图高度
			picVisibleNum : 1,  //一屏内焦点图个数
			direction : 'left',  //焦点图切换方向，默认为left，可以为right, top, bottom
			picScrollSelector : '.picSet ul',  //图片滚动层选择器
			picSetSelector : '.picSet li',  //图片选择器
			toggerSelector : '.togger span',  //触发器选择器
			toggerSelected : 'selected',  //触发器触发状态样式class
			toggerMode : 'click',  //触发方式，默认为鼠标划过
			scrollTime : '500',  //滚动时间，默认500毫秒
			intervalTime : '3000'  //滚动间隔时间，默认3000毫秒
		};
		options = $.extend(defaults, options);
		
		return this.each(function(){
			var $pic = $(options.toggerSelector);
			var $togger = $(options.toggerSelector);
			var $picScrollSelector = $(options.picScrollSelector);
			var timer;

			$togger.bind(options.toggerMode, function(){
				clearTimeout(timer);
				$toggerOn = $(this);
				var index = $toggerOn.index(options.toggerSelector);  //获取当前触发器index
				var left = index * options.picWidth;
				
				$togger.filter('.'+options.toggerSelected).removeClass(options.toggerSelected);
				$toggerOn.addClass(options.toggerSelected);
				$picScrollSelector.animate({'left' : '-'+left+'px'},options.scrollTime);
				timer = setInterval(autoAnimate,options.intervalTime);
			});

			function autoAnimate() {
				var maxLeft = ($pic.length - options.picVisibleNum -1) * options.picWidth;
				var nextLeft = parseInt($picScrollSelector.css('left').replace('px')) - options.picWidth;
				if (isNaN(nextLeft)) nextLeft = 0-options.picWidth;
				if ((nextLeft + maxLeft) < 0) nextLeft = 0;
				$picScrollSelector.stop(true,true).animate({'left' : nextLeft +'px'},options.scrollTime);
				if ($togger.filter('.'+options.toggerSelected).next().is(':last')) {
					$togger.filter('.'+options.toggerSelected).removeClass(options.toggerSelected)
					$togger.first().addClass(options.toggerSelected);
				} else {
					$togger.filter('.'+options.toggerSelected).removeClass(options.toggerSelected)
						.next().addClass(options.toggerSelected);
				}
			}
			timer = setInterval(autoAnimate,options.intervalTime);
		});
	};
})(jQuery);
