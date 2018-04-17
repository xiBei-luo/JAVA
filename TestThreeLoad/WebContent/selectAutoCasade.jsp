<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>三级联动</title>
<script type="text/javascript" src="res/jquery-1.9.1.js"></script>
</head>
<script type="text/javascript">
	<!--页面加载时首先获得省 -->
	$(function(){
		 $.ajax({
			 type:"POST",
			 url:"/TestThreeLoad/province",
			 //dataType:"json",
			 async:false,
			 success:function(data){
				 //eval()可以使字符参与运算
				  //var pro=eval("("+data+")");//解析Json 注意此方法不需要声明dataType
				var pro=eval(data);//都可以
				  //$.parseJSON(data);//解析Json 注意此方法需要声明dataType 
				 for(var i=0;i<pro.length;i++){
					 $(".province").append("<option value="+pro[i].id+">"+pro[i].province+"</option>");
				 }
			 }
		 });
	});
</script>
<body>
	<table align="center" style="margin-top: 200px">
		<tr>
			<td>省:</td>
			<td>
				<select name="province" class="province">
					<option value="0">==请选择==</option>
				</select>
			</td>
			<td>市:</td>
			<td>
				<select name="city" class="city">
					<option value="0">==请选择==</option>
				</select>
			</td>
			<td>县:</td>
			<td>
				<select name="town" class="town">
					<option value="0">==请选择==</option>
				</select>
			</td>
		</tr>
	</table>
</body>
	<script type="text/javascript">
			$(".province").change(function(){
				var province_id=$(".province").val();
				//如果选择的是‘==请选择==’，不会执行去查找市，并且把已有的数据清空
				if($(".province").val()==0){
					$(".city option").remove();
					$(".city").append("<option value=0>==请选择==</option>");
					$(".town option").remove();
					$(".town").append("<option value=0>==请选择==</option>");
					return;
				}
				$.ajax({
					type:"POST",
					//传一个省的id参数
					url:"/TestThreeLoad/city?province_id="+province_id,
					dataType:"json",
					async:false,
					success:function(city){
						//var city=eval("("+city+")");
						var city=eval(city);
						for(var i=0;i<city.length;i++){
							$(".city").append("<option value="+city[i].id+">"+city[i].city+"</option>");
						}
					}
				});
			});
			//市下拉列表框发生改变的时候的事件
			$(".city").change(function(){
				$(".town option").remove();
				$(".town").append("<option value=0>==请选择==</option>"); 
				var city_id=$(".city").val();
				if($(".city").val()==0){
					return;
				}
				$.ajax({
					type:"POST",
					url:"town?city_id="+city_id,
					dataType:"json",
					async:false,
					success:function(town){
						var town=eval(town);
						for(var i=0;i<town.length;i++){
							$(".town").append("<option value="+town[i].id+">"+town[i].town+"</option>");
						}
					}
				});
			});
	</script>
</html>