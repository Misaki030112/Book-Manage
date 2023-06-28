<%@ page import="com.book.domain.Book" %><%--
<%--
  Created by IntelliJ IDEA.
  User: 君行天下
  Date: 2017/7/23
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理主页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <script src="http://cdn.staticfile.org/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    <style>
        body{
            margin: 0;
            padding: 0;
            overflow: visible;
            background-color: rgb(240,242,245);
        }
        #newsa{
            width:500px;
            height: 200px;
            position: fixed;
            left: 35%;
            top:30%;
        }
         #chart-container {
             position: fixed;
             top: 20%;
             width: 50%;
             left: 50%;
             transform: translateX(-50%);
         }
    </style>

</head>
<body background="img/281289-106.jpg">
<nav  style="position:fixed;z-index: 999;width: 100%;background-color: #fff" class="navbar navbar-default" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand" href="admin_main.html">图书管理系统</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        图书管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allbooks.html">全部图书</a></li>
                        <li class="divider"></li>
                        <li><a href="book_add.html">增加图书</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        读者管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allreaders.html">全部读者</a></li>
                        <li class="divider"></li>
                        <li><a href="reader_add.html">增加读者</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        借还管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="lendlist.html">借还日志</a></li>
                    </ul>
                </li>
                <li >
                    <a href="admin_repasswd.html" >
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.html"><span class="glyphicon glyphicon-user"></span>&nbsp;${admin.adminId}，已登录</a></li>
                <li><a href="logout.html"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>


<div id="chart-container"></div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    温馨提示
                </h4>
            </div>
            <div class="modal-body">
                使用结束后请安全退出。
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">知道了
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<c:if test="${!empty login}">
    <script>
        $(function () {
            $("#myModal").modal({
                show: true
            })
        })
    </script>
</c:if>

</body>
<script>
    var books = ${books};
    var category = ['马克思主义','哲学','社会科学总论','政治法律','军事','经济','文化','文学'
        ,'艺术','历史地理','自然科学总论','数理科学和化学','天文学、地球科学','生物科学'
        ,'医药、卫生','农业科学','工业技术','交通运输','航空、航天','环境科学','综合'];
    var quantity = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
    // 使用for循环遍历books数组
    for (var i = 0; i < books.length; i++) {
        var book = books[i];
        quantity[book.classID]+=1;
    }

    var bookData = {};
    for (var i = 0; i < category.length; i++) {
        var temp = {
            category: category[i],
            quantity: quantity[i]
        };
        bookData.push(temp);
    }
</script>

<script>
    bookData = [
        { category: '马克思主义', quantity: 0 },
        { category: '哲学', quantity: 0 },
        { category: '社会科学总论', quantity: 0 },
        { category: '政治法律', quantity: 0 },
        { category: '军事', quantity: 0 },
        { category: '经济', quantity: 1 },
        { category: '文化', quantity: 4 },
        { category: '文学', quantity: 0 },
        { category: '艺术', quantity: 8 },
        { category: '历史地理', quantity: 0 },
        { category: '自然科学总论', quantity: 2 },
        { category: '数理科学和化学', quantity: 0 },
        { category: '天文学、地球科学', quantity: 0 },
        { category: '生物科学', quantity: 0 },
        { category: '医药、卫生', quantity: 0 },
        { category: '农业科学', quantity: 0 },
        { category: '工业技术', quantity: 0 },
        { category: '交通运输', quantity: 0 },
        { category: '航空、航天', quantity: 0 },
        { category: '环境科学', quantity: 0 },
        { category: '综合', quantity: 0 },
    ];
</script>


<script>
    // 初始化柱状图
    Highcharts.chart('chart-container', {
        chart: {
            type: 'column' // 设置图表类型为柱状图
        },
        title: {
            text: 'Book Categories and Quantities' // 图表标题
        },
        xAxis: {
            categories: bookData.map(data => data.category), // x 轴标签为图书类别
            title: {
                text: 'Category' // x 轴标题
            }
        },
        yAxis: {
            title: {
                text: 'Quantity' // y 轴标题
            }
        },
        series: [{
            name: 'Quantity',
            data: bookData.map(data => data.quantity) // 使用图书数量数据
        }]
    });
</script>

</html>
