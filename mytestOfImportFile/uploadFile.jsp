<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta http-equiv="Expires" content="0"/>
        <meta http-equiv="Pragma" content="no-cache"/>
        <meta http-equiv="Cache-control" content="no-cache"/>
        <meta http-equiv="Cache" content="no-cache"/>
        <title></title>
        
        <link rel="stylesheet" type="text/css" href="../../controls/bootstrap-3.3.5/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="../../controls/easyui-1.4.5/themes/bootstrap/easyui.css"/>
        <link rel="stylesheet" type="text/css" href="../../controls/dhtmlx-4.5/skins/web/dhtmlx.css"/>
        <link rel="stylesheet" type="text/css" href="../../controls/dhtmlx-4.5/skins/dhtmlxgrid_cdmcs.css"/>
        <link rel="stylesheet" type="text/css" href="../../style/pub-custom.css"/>
        
        <script type="text/javascript" src="../../script/public/tools/StringBuffer.js"></script>
        <script type="text/javascript" src="../../script/public/tools/spin.js"></script>
		<script type="text/javascript" src="../../script/public/tools/Page.js"></script>
        <script type="text/javascript" src="../../script/ajax/ajaxProxy_debug.js"></script>
        
        <script type="text/javascript" src="../../controls/dhtmlx-4.5/dhtmlx.min.js"></script>
        <script type="text/javascript" src="../../controls/easyui-1.4.5/jquery.min.js"></script>
        <script type="text/javascript" src="../../controls/bootstrap-3.3.5/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../../controls/easyui-1.4.5/jquery.easyui.min.js"></script>
    	<script type="text/javascript" src="../../script/public/jquery/jquery.json.js"></script>

        <script type="text/javascript" src="../../script/public/workmain/init.js"></script>
        <script type="text/javascript" src="../../script/public/workmain/initVerifyField.js"></script>
        <script type="text/javascript" src="../../script/public/common.js"></script>
        <script type="text/javascript" src="../../script/public/ywpub.js"></script>
        
        <script type="text/javascript" src="script/uploadFile.js?version=<%=System.currentTimeMillis() %>"></script>

        <style type="text/css">
            html,body{
                width:100%;
                height:100%;
            }
            fieldset {
                width:85%;
                margin:30px auto 0 auto;
            }
            legend {
                font-weight: 800;
            }
            input[type="radio"]{
                margin-right:5px;
            }
            .table-view{
                width:97%;height:100%;margin-left:2.5%;
            }
        </style>
  </head>
    
  <body class="easyui-layout">
        <div data-options="region:'center',border:false" style="padding-top:20px;">
        	<form action="" method="post" enctype="multipart/form-data" id="fileForm"> 
	            <table class="table-form table-nobordered" align="center" border="0" cellpadding="0" cellspacing="0">
	                <col width="12%">
	                <col/>
	                <col width="14%">
	                <col width="5">
	                <tr>
	                    <td align="right">
	                        <span class="input-label data-view-label">文件：</span>
	                    </td>
	                    <td align="left">
	                    	<input type="text" class="form-control" id="C_FILE" placeholder="请选择上传文件" title="" style="width: 99%;" disabled="disabled" /> 
	                    </td>
	                    <td><!-- -->
	                        <input type="button" id="btnSelFile" value=" 选择文件" class="btn btn-info"/>   
	                        <input type="file" id="openFile" multiple="multiple" name="openFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" style="display: none;"/>
	                    </td>
	                    <td></td>
	                </tr>
	                
	            </table>
        	</form> 
        </div>
        
        <div data-options="region:'south',border:false" style="height:45px; padding-top:5px; overflow: hidden;border-top: 1px solid #C7C7C7;">
            <table width="100%" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td width="20%">&nbsp;</td>
                    <td align="center">
                        <input type="button" id="btnSave" value=" 保&nbsp;&nbsp;存 " class="btn btn-primary"/>
                    </td>
                    <td align="center">
                        <input type="button" id="btnRet" value=" 返&nbsp;&nbsp;回 " class="btn btn-info"/>
                    </td>
                    <td width="20%">&nbsp;</td>
                </tr>
            </table>
        </div>
		<iframe id="hid_ifrm" name="hid_ifrm" width="0" height="0"></iframe>
    </body>
</html>