<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 甜啵虎
  Date: 2024/1/12
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>优选天地-全部商品</title>
    <!--js-->
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/ddsmoothmenu.js"></script>
    <script src="js/jquery.flexslider.js"></script>
    <script src="js/jquery.elastislide.js"></script>
    <script src="js/jquery.jcarousel.min.js"></script>
    <script src="js/jquery.accordion.js"></script>
    <script src="js/light_box.js"></script>
    <script type="text/javascript">$(document).ready(function(){$(".inline").colorbox({inline:true, width:"50%"});});</script>
    <!--end js-->

    <!-- Mobile Specific Metas ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS ================================================== -->

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/orange.css">
    <link rel="stylesheet" href="css/skeleton.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ddsmoothmenu.css"/>
    <link rel="stylesheet" href="css/elastislide.css"/>
    <link rel="stylesheet" href="css/home_flexslider.css"/>

    <link rel="stylesheet" href="css/light_box.css"/>
</head>
<body>
<div class="mainContainer sixteen container">
    <!--Header Block-->
    <div class="header-wrapper">
        <header class="container">
            <div class="head-right">
                <ul class="top-nav">
                    <li class=""><a href="#" title="我的账户">我的账户</a></li>
                    <li class="my-wishlist"><a href="#" title="收藏">收藏</a></li>

                    <li class="checkout"><a href="zhifu.jsp" title="结算">结算</a></li>
                    <li class="log-in"><a href="login.jsp" title="登录">登录</a></li>
                </ul>

                <section class="header-bottom">
                    <div class="cart-block">
                        <ul>
                            <li>(2)</li>
                            <li><a href="login.jsp" title="Cart"><img title="Item" alt="Item" src="images/item_icon.png" /></a></li>
                            <li>购物车</li>
                        </ul>
                        <div id="minicart" class="remain_cart" style="display: none;">
                            <p class="empty">您的购物车有2件商品</p>
                            <ol>
                                <li>
                                    <div class="img-block"><img src="images/small_img1.png" title="" alt="" /></div>
                                    <div class="detail-block">
                                        <h4><a href="#" title="衣服">衣服</a></h4>
                                        <p>
                                            <strong>1</strong> x ￥99.00
                                        </p>
                                        <a href="#" title="细节展示">细节展示</a>
                                    </div>
                                    <div class="edit-delete-block">
                                        <a href="#" title="Edit"><img src="images/edit_icon.png" alt="Edit" title="Edit" /></a>
                                        <a href="#" title="Remove"><img src="images/delete_item_btn.png" alt="Remove" title="Remove" /></a>
                                    </div>
                                </li>
                                <li>
                                    <div class="img-block"><img src="images/small_img.png" title="" alt="" /></div>
                                    <div class="detail-block">
                                        <h4><a href="#" title="衣服">衣服</a></h4>
                                        <p>
                                            <strong>1</strong> x ￥99.00
                                        </p>
                                        <a href="#" title="细节展示">细节展示</a>
                                    </div>
                                    <div class="edit-delete-block">
                                        <a href="#" title="Edit"><img src="images/edit_icon.png" alt="Edit" title="Edit" /></a>
                                        <a href="#" title="Remove"><img src="images/delete_item_btn.png" alt="Remove" title="Remove" /></a>
                                    </div>
                                </li>
                                <li>
                                    <div class="total-block">共计:<span>￥ 198.00</span></div>
                                    <a href="zhifu.jsp" title="结算" class="orange-btn">结算</a>
                                    <div class="clear"></div>
                                </li>
                            </ol>
                        </div>
                    </div>
                    <div class="search-block">
                        <input type="text" value="搜索" />
                        <input type="submit" value="提交" />
                    </div>
                </section>
            </div>
            <h1 class="logo"><a href="index.jsp">
                <img title="Logo" alt="Logo" src="images/logo.png" />
            </a></h1>
            <nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
                <ul id="nav">
                    <li class=""><a href="index.jsp" title="首页">首页</a></li>
                    <li class="active"><a href="category.jsp" title="全部商品">全部商品</a></li>

                    <li class=""><a href="show_message.jsp" title="Footwear">留言板</a></li>
                </ul>
            </nav>

            <div class="mobMenu">
                <h1>
                    <span>菜单</span>
                    <a class="menuBox highlight" href="javascript:void(0);"></a>
                    <span class="clearfix"></span>
                </h1>
                <div id="menuInnner" style="display:none;">
                    <ul class="accordion">
                        <li class="active"><a href="index.jsp" title="首页">首页</a></li>
                        <li class="parent"><a href="category.jsp" title="全部商品">全部商品</a></li>
                        <li class=""><a href="show_message.jsp" title="留言板">留言板</a></li>
                        <span class="clearfix"></span>
                    </ul>

                </div>
            </div>

        </header>
    </div>
    <!--Content Block-->
    <section class="content-wrapper">
        <div class="content-container container">
            <div class="breadcrum-container">
                <ul>
                    <li><a href="#"></a></li>
                    <li></li>
                </ul>
            </div>
            <div class="col-left">
                <div class="block man-block">
                    <div class="block-title">鲜衣服套装衣服套装束</div>
                    <ul>
                        <li><a href="#">红衣服</a></li>
                        <li><a href="#">粉衣服</a></li>
                        <li><a href="#">白衣服</a></li>
                        <li><a href="#">香槟衣服</a></li>
                        <li><a href="#">连衣裙</a></li>
                        <li><a href="#">牛仔裤</a></li>
                        <li><a href="#">外套</a></li>
                        <li><a href="#">毛衣</a></li>

                    </ul>
                </div>
                <div class="block shop-by-block">
                    <div class="block-title">其他商品</div>
                    <ul>

                        <li><a href="#">衣服套装</a></li>
                        <li><a href="#">开业新上套装</a></li>
                        <li><a href="#">衣服装饰</a></li>
                        <li><a href="#">手工艺制品</a></li>
                    </ul>
                </div>
                <div class="block compare-block">
                    <div class="block-title">产品比较</div>
                    <ul>
                        <li>您没有相似的衣服要对比</li>
                    </ul>
                </div>
                <div class="block community-block">
                    <div class="block-title">喜好调查</div>
                    <ul>
                        <li class="question-row">您喜欢什么颜色的衣服？</li>
                        <li><input type="radio"><a href="#">红色</a></li>
                        <li><input type="radio"><a href="#">粉色</a></li>
                        <li><input type="radio"><a href="#">蓝色</a></li>
                        <li><input type="radio"><a href="#">白色</a></li>
                        <li><input type="radio"><a href="#">黄色</a></li>
                        <li><input type="radio"><a href="#">紫色</a></li>
                        <li><input type="radio"><a href="#">橙色</a></li>
                        <li class="vote-row"><button title="投票">投票</button></li>
                    </ul>
                </div>

            </div>
            <div class="col-main">
                <div class="category-banner"><img src="images/52.png" title="Banner" alt="Banner" /></div>
                <div class="pager-container">
                    <div class="pager">

                        <div class="show-per-page">
                            <label>当前展示</label> <select><option>09</option>
                            <option>18</option>
                            <option>06</option>

                        </select></div>
                    </div>
                    <div class="view-by-block">
                        <ul class="view-by">

                            <li><a href="#" title="网格" class="grid">网格</a></li>
                            <li><a href="#" title="列表" class="list">列表</a></li>
                        </ul>
                        <div class="short-by">
                            <label>排序方式</label><select>
                            <option>综合</option>
                            <option>销量</option>
                            <option>价格</option>

                        </select>
                        </div>
                    </div>
                </div>
                <div class="new-product-block">
                    <ul class="product-grid" style="float: left;">
                        <c:forEach items="${clothesListPage}" var="clothes">
                            <li style="width: 30%">
                                <a href="clothesServlet?tp=clothesQueryOne&clothesId=${clothes.clothesId}">
                                    <div class="pro-img"><img title="衣服图" alt="衣服图" src="${clothes.clothesPct}" /></div>
                                    <div class="pro-content"><p>${clothes.clothesName}</p></div>
                                    <div class="pro-price">￥${clothes.price}</div>
                                    <div class="pro-btn-block">
                                        <a class="add-cart left" href="#">加入购物车</a>
                                        <a class="add-cart right quickCart inline" href="#quick-view-container" title="快速预览">快速预览</a>					</div>
                                    <div class="pro-link-block">
                                        <a class="add-wishlist left" href="#" title="收藏">收藏</a>
                                        <a class="add-compare right" href="#" title="找相似">找相似</a>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>

                </div>
                <div class="pager-container">
                    <div class="pager">
                        <a href="clothesServlet?tp=up">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="clothesServlet?tp=down">下一页</a>
                    </div>
                    <div class="view-by-block">
                        <ul class="view-by">

                            <li><a href="#" title="网格" class="grid">网格</a></li>
                            <li><a href="#" title="List" class="list">List</a></li>
                        </ul>
                        <div class="short-by">
                            <label>排序方式</label><select>
                            <option>综合</option>
                            <option>销量</option>
                            <option>价格</option>

                        </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="news-letter-container">
                <div class="free-shipping-block">
                    <h1>享受免费送货服务</h1>
                    <p>我们把所有的订单当做节日礼物送给你！</p>
                </div>
                <div class="news-letter-block">
                    <h2>免费送货电话</h2>
                    <input type="text" value="手机号" />
                    <input type="submit" value="提交"/>
                </div>
            </div>
        </div>
    </section>
</div>
<!--Quick view Block-->
<script type="text/javascript">
    jQuery (function(){
        var tabContainers=jQuery('div.tabs > div');
        tabContainers.hide().filter(':first').show();
        jQuery('div.tabs ul.tabNavigation a').click(function(){
            tabContainers.hide();
            tabContainers.filter(this.hash).show();
            jQuery('div.tabs ul.tabNavigation a').removeClass('selected');
            jQuery(this).addClass('selected');
            return false;
        }).filter(':first').click();
    });
</script>
<article style="display:none;">
    <section id="quick-view-container" class="quick-view-wrapper">
        <div class="quick-view-container">
            <div class="quick-view-left">
                <h2>百合花 </h2>
                <div class="product-img-box">
                    <p class="product-image">
                        <img src="images/sale_icon_img.png" title="Sale" alt="Sale" class="sale-img" />
                        <a href="view.html" title="Image"><img src="images/quick_view_img1.png" title="Image" alt="Image" /></a>				</p>
                    <ul class="thum-img">
                        <li><img  src="images/quick_thum_img1.png" title="" alt="" /></li>
                        <li><img  src="images/quick_thum_img1.png" title="" alt="" /></li>
                    </ul>
                </div>
            </div>
            <div class="quick-view-right tabs">
                <ul class="tab-block tabNavigation">
                    <li><a class="selected" title="Overview" href="#tabDetail">概览</a></li>
                    <li><a title="细节展示" href="#tabDes">细节展示</a></li>
                </ul>
                <div id="tabDetail" class="tabDetail">
                    <div class="first-review">此商品为鲜活易腐类，不支持7天无理由退货</div>
                    <div class="price-box">
                        <span class="price">￥69.00</span>			</div>
                    <div class="availability">有库存</div>
                    <div class="color-size-block">
                        <div class="label-row">
                            <label><em>*</em> 颜色</label>
                            <span class="required">* 必填项</span>				</div>
                        <div class="select-row">
                            <select><option>  红色  </option>
                                <option>  蓝色   </option>
                                <option>  粉色   </option>
                                <option>  紫色   </option>

                            </select>
                        </div>
                        <div class="label-row">
                            <label><em>*</em>支付方式</label>
                        </div>
                        <div class="select-row">
                            <select><option>快捷支付</option>
                                <option>余额宝支付</option>
                                <option>集分宝</option>


                            </select>
                        </div>
                    </div>
                    <div class="add-to-cart-box">
				<span class="qty-box">
					<label for="qty">数量:</label>
					<a class="prev" title="" href="#"><img alt="" title="" src="images/qty_prev.png"></a>
					<input type="text" name="qty" class="input-text qty" id="qty" maxlength="12" value="1">
					<a class="next" title="" href="#"><img alt="" title="" src="images/qty_next.png"></a>				</span>
                        <button title="加入购物车" class="form-button"><span>加入购物车</span></button>
                    </div>
                </div>
                <div id="tabDes" class="tabDes">
                    <div> 优选天地适用场景: 休闲场合，商务场合，运动场合，社交场合，特殊场合。</div>
                    <div>衣服主材材: 天然材料主要包括棉、麻、丝、毛等；人造材料主要包括涤纶、尼龙、氨纶、丙纶、腈纶等。衣服数量: 11朵</div>
                    <div>适用节日: 情人节 圣诞节 春节 3.8妇女节 母亲节 感恩节 教师节 中秋节 七夕 白色情人节</div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </section>
</article>
<!--Footer Block-->
<section class="footer-wrapper">
    <footer class="container">
        <div class="link-block">
            <ul>
                <li class="link-title"><a href="#">关于我们</a></li>
                <li><a href="#">售后政策</a></li>
                <li><a href="#">客户服务</a></li>
                <li><a href="#">隐私权政策</a></li>
            </ul>
            <ul>
                <li class="link-title"><a href="#">客户服务</a></li>
                <li><a href="#">退换货</a></li>
                <li><a href="#">购物保障</a></li>
                <li><a href="show_message.jsp">留言板</a></li>
            </ul>
            <ul>
                <li class="link-title"><a href="#">服务条款</a></li>
                <li><a href="#">新闻中心</a></li>
                <li><a href="#">帮助</a></li>
                <li><a href="#">服务条款</a></li>
            </ul>
            <ul>
                <li class="link-title"><a href="#">我们的实力</a></li>
                <li class="aboutus-block">本店商品已向全国2603个区县提供自营配送服务，支持货到付款、POS机刷卡和售后上门服务，让您购物无忧！ <a href="#">更多</a> </li>
            </ul>

        </div>
        <div class="footer-bottom-block">
            <ul class="bottom-links">
                <li><a href="index.jsp">首页</a></li>

                <li><a href="show_message.jsp">留言板</a></li>
            </ul>
            <p class="copyright-block">Copyright &copy; 2024.优选天地 All rights reserved.</p>
        </div>
    </footer>
</section>
</body>
</html>