/**
 * 公用业务调用JS
 */


/**
 * 1、初始化基础代码下拉列表：同步
 * @param $container 下拉列表
 * @param args 调用过程参数
 * @param defVal 默认选中值
 * @param allFlag 显示全部时的字符
 */
function initBaseCodeSelect($container, args, defVal, allFlag){
    if($container){
        $container.empty();
    }

    var option_data = [];
    var ajax = new AjaxProxy();
    ajax.setCacheData(false);

    ajax.addParm("PC_DMFL", args.C_DMFL);  //代码分类
    ajax.addParm("PC_DM", args.C_DM ? args.C_DM : "");  //代码值 （空值则全部该代码分类的全部数据）
    ajax.addParm("PC_DWDM", args.C_DWDM ? args.C_DWDM : "");  //单位代码（空值则查询全部）
    ajax.addParm("PC_CS1", args.C_CS1 ? args.C_CS1 : ""); //参数，eg 为1时：工序过滤掉“成品退库”和“对外加工”序
    ajax.invokeProc("APPUSER.CTRI_PUB.PW_CTRI_PUB_DM", false);

    var row=ajax.getRowCount("P_RESULT");

    if($container){
        try{
            $container.combobox("loadData",[[null,null]]);
        }catch(e){

        }
    }
    if(row>0){
        if($container){
            if(allFlag){
                $container.append("<option value=''>"+allFlag+"</option>");
            }else if("" == allFlag){
                $container.append("<option value=''>&nbsp;</option>");
            }
        }

        for(var i=1;i<=row;i++){

            var data={
                C_DM    : ajax.getString("P_RESULT",i,"C_DM"),
                C_MC    : ajax.getString("P_RESULT",i,"C_MC"),
                N_SORT	: ajax.getString("P_RESULT",i,"N_SORT")
            };
            //预留两个字段
            var sSm1 = ajax.getString("P_RESULT",i,"C_SM1");
            if(typeof sSm1 == "undefined" ){
                sSm1 = "";
            }
            data.C_SM1 = sSm1;

            var sSm2 = ajax.getString("P_RESULT",i,"C_SM2");
            if(typeof sSm2 == "undefined" ){
                sSm2 = "";
            }
            data.C_SM2 = sSm2;

            //2019-04-03 增加：约定,如果js没有设置默认选中值时，将N_SORT = 0设为默认选中值
            if(defVal == null && typeof data.N_SORT != "undefined" && data.N_SORT == "0"){
                defVal = data.C_DM;
            }

            if("SCGX" == args.C_DMFL){//工序下拉框，产品状态 、是否涂层检验
                var cpzt = ajax.getString("P_RESULT",i,"C_CPZT");
                var sftcjy = ajax.getString("P_RESULT",i,"C_SFTCJY"); //是否涂层检验【0：否，1：是】
                data.C_CPZT	  = cpzt;
                data.C_SFTCJY = sftcjy;
                if($container){
                    $container.append("<option sx1='"+cpzt+"' value='"+data.C_DM+"' text='"+data.C_MC+"'>"+data.C_MC+"</option>");
                }

            }else if("SL" == args.C_DMFL){
                if($container){
                    $container.append("<option value='"+data.C_DM+"'>"+data.C_MC+"&nbsp;"+data.C_DM+"</option>");
                }
            }else{
                if($container){
                    $container.append("<option value='"+data.C_DM+"' text='"+data.C_MC+"'>"+data.C_MC+"</option>");
                }
            }
            option_data.push(data);
        }

        if(defVal && $container){
            $("option[value='"+defVal+"']", $container).attr({selected: true});
        }
    }


    return option_data;
}