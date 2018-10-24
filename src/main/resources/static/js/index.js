function initTable(){
    var student= {"name":$("#search_name").val(),"major":$("#search_major").val()};
    $.ajax({
        url: '/demo/searchStudent',         //请求后台的URL（*）
        method: 'POST',                      //请求方式（*）
        dataType: "json",
        data: JSON.stringify(student),
        contentType:"application/json",
        success: function (data) {
            $("#cusTable").bootstrapTable({
                toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
                showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns: [{
                    checkbox: true
                }, {
                    field: 'name',
                    title: '姓名'
                }, {
                    field: 'studentNo',
                    title: '学号'
                }, {
                    field: 'major',
                    title: '专业'
                }, {
                    field: 'enrollmentDate',
                    title: '入学时间'
                } ],
                locale: 'zh-CN'//中文支持,
            });
            $('#cusTable').bootstrapTable('load', data);
        }
    });
}


$(document).ready(function () {
    //调用函数，初始化表格
    initTable();

    //当点击查询按钮的时候执行
    $("#btn_query").on("click",initTable);

    //删除
    $('#btn_delete').on("click", function () {
        var row=$.map($("#cusTable").bootstrapTable('getSelections'),function(row){
            return row ;
        });
        var ids=[];
        for (var i = 0; i < row.length; i++) {
            //获取自定义table 的中的checkbox值
            var id=row[i].studentNo;   //OTRECORDID这个是你要在列表中取的单个id
            ids.push(id); //然后把单个id循环放到ids的数组中
        }
        var str=JSON.stringify(ids);
        //批量删除：
        $.ajax({
            type:"POST",
            url:"/demo/deleteStudent",
            dataType: "json",
            contentType:"application/json",
            data:str,
            success:function(msg){
                // alert("返回的是："+msg);
                if(msg>0){
                    // alert("删除成功！");
                    initTable();
                    //$('#cusTable').bootstrapTable('refresh');
                }else{
                    alert("删除失败！");
                }
            }
        });
    });


    //添加：
    $('#btn_add').on("click", function () {
        $('#myModal').modal();
    });

    //修改
    $('#btn_edit').on("click", function () {

        var row=$.map($("#cusTable").bootstrapTable('getSelections'),function(row){
            return row ;
        });
        if(row.length==1){
            for (var i = 0; i < row.length; i++) {
                //打开弹出框：
                $('#updatemyModal').modal();
                $('#update_name').val(row[i].name);
                $('#update_major').val(row[i].major);
                $('#update_enrollmentDate').val(row[i].enrollmentDate);
                $('#update_studentNo').val(row[i].studentNo);
            }
        }
    });


});

//提交添加：
function mya(){
    var name=$('#add_name').val();
    var major=$('#add_major').val();
    var enrollmentDate=$('#add_enrollmentDate').val();
    var studentNo=$('#add_studentNo').val();
    //实例化一个对象：
    var student={"name":name,"major":major,"enrollmentDate":enrollmentDate,"studentNo":studentNo};
    //将对象转换成字符串
    var str=JSON.stringify(student);
    $.ajax({
        type:"POST" ,
        url:"/demo/addStudent",
        dataType: "json",
        contentType:"application/json",
        data:str,
        success:function(msg){
            if(msg==1){
                //$('#cusTable').bootstrapTable('refresh');
                initTable();
                $('#ff_p').form('clear');
            }else{
                alert('添加失败');
            }

        }
    });
}

//修改提交：
function myb(){
    var name=$('#update_name').val();
    var major=$('#update_major').val();
    var enrollmentDate=$('#update_enrollmentDate').val();
    var studentNo=$('#update_studentNo').val();
    //实例化一个对象：
    var student={"name":name,"major":major,"enrollmentDate":enrollmentDate,"studentNo":studentNo};
    //将对象转换成字符串
    var str=JSON.stringify(student);
    $.ajax({
        type:"POST" ,
        url:"/demo/updateStudent",
        dataType: "json",
        contentType:"application/json",
        data:str,
        success:function(msg){
            if(msg==1){
                //$('#cusTable').bootstrapTable('refresh');
                initTable();
            }else{
                alert('修改失败');
            }
        }
    });
}