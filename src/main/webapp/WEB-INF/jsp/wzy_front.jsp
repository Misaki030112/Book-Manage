<%--
  Created by IntelliJ IDEA.
  User: wqd
  Date: 2023/6/8
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="../js/jquery.min.js"></script>
    <script>
        $(function () {
            // 查询所有
            $('#btn1').click(function () {
                $.get('/employees', function (data) {
                    console.log(data);
                });
            });

            // 查询一个
            $('#btn2').click(function () {
                $.get('/employees/10', function (data) {
                    console.log(data);
                });
            });

            // 添加
            $('#btn3').click(function () {
                $.post('/employees', "id=11", function (data) {
                    console.log(data);
                });
            });

            // 修改
            $('#btn4').click(function () {
                $.ajax({
                    url: "/employees",
                    type: "PUT",
                    data: {id: 1, name: "小肥羊", age: 10},
                    success: function (data) {
                        console.log(data);
                    }
                });
            });

            // 删除
            $('#btn5').click(function () {
                $.ajax({
                    url: "/employees/13",
                    type: "DELETE",
                    data: {id: 1},
                    success: function (data) {
                        console.log(data);
                    }
                });
            });

        });
    </script>
</head>
<body>
<button id="btn1">查询所有</button>
<button id="btn2">查询一个</button>
<button id="btn3">添加</button>
<button id="btn4">修改</button>
<button id="btn5">删除</button>
</body>
</html>
