<%--
  User: ChenRongkai
  Date: 2019-06-03
  Time: 10:50
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件demo</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script>
        window.f_call_back = function (resp) {
            console.log("f_call_back",resp);
            if(resp.flag !== 0){
                alert(resp.msg);
            }else{
                alert("成功，"+JSON.stringify(resp.data));
            }
        }
    </script>
</head>
<body>
<div style="text-align: left">
    <iframe name="hiddenFrame" style="display: none;"></iframe>
    <form method="post" target="hiddenFrame" enctype="multipart/form-data" action="./bin/upload.do">
        回调函数名（函数必须在window对象上）：<input class="form-control" type="text" name="callBackFunName" value="f_call_back" /> <br/>
        二进制表名：<input class="form-control" type="text" name="targetTable" value="t_zjsys_xcjd_fjxx" /> <br/>
        表主键信息（如果是新增，则填max，如果是修改则填对应的主键）：<input class="form-control" type="text" name="tablePkInfo" value="{&quot;N_WJJLBH&quot;:&quot;max&quot;}" /> <br/>
        固定字段映射（CB_BINARY文件存储的二进制字段名，C_WJMC文件名称，C_WJHZ文件后缀名，N_SIZE文件大小[字节]，N_CJUSER创建人id，C_CJUSERNAME创建人名称，D_CJSJ创建时间，...修改）：<textarea class="form-control" name="columnMappingInfo">{&quot;CB_BINARY&quot;:&quot;CB_NR&quot;,&quot;C_WJMC&quot;:&quot;C_WJMC&quot;,&quot;C_WJHZ&quot;:&quot;C_GS&quot;,&quot;N_WJXH&quot;:&quot;N_SCXH&quot;,&quot;N_CJUSER&quot;:&quot;N_CJUSER&quot;,&quot;C_CJUSERNAME&quot;:&quot;C_CJUSERNAME&quot;,&quot;D_CJSJ&quot;:&quot;D_CJSJ&quot;,&quot;N_XGUSER&quot;:&quot;C_XGUSERNAME&quot;,&quot;D_XGSJ&quot;:&quot;D_XGSJ&quot;}</textarea> <br/>
        动态业务信息（根据业务表不一样而不一样）：<input class="form-control" type="text" name="ywExtInfo" value="{&quot;N_JDJLBH&quot;:0,&quot;C_WJLX&quot;:&quot;飞行检查结果&quot;,&quot;C_YXBZ&quot;:&quot;1&quot;,&quot;N_SCXH&quot;:1}" /> <br/>
        userId：<input class="form-control" type="text" name="userId" value="1" /> <br/>
        userName：<input class="form-control" type="text" name="userName" value="测试" /> <br/>
        二进制文件：<input class="form-control" type="file" name="binContent" /> <br/><br/>
        <input class="btn btn-block btn-success" type="submit" value="upload" />
    </form>
</div>
</body>
</html>
