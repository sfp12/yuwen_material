
var path = window.location.origin+"/YuWen/resources/";

$(function () {
	$('#table-javascript').bootstrapTable({
        method: 'get',
        url: path+'material/materials',
        cache: false,
        height: 500,
        striped: true,
        pagination: true,        
        pageSize: 50,
        pageList: [10, 25, 50, 100, 200],        
        showColumns: true,
        showRefresh: true,
        minimumCountColumns: 2,        
        clickToSelect: true,
        queryParams: function(p){
        	return {
        		jiansuoxiang: encodeURI($('#jiansuoxiang').val()),
        		pipei: encodeURI($('#pipei').val()),
        		cong: encodeURI($('#cong').val()),
        		dao: encodeURI($('#dao').val()),
        		jiansuoci: encodeURI($('#jiansuoci').val())        		
        	};
        },
        columns: [{
            field: 'id',
            title: 'id',
            align: 'right',
            valign: 'bottom',
            sortable: true
        }, {
            field: 'xuanwentimu',
            title: '选文题目',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'zuozhe',
            title: '作者',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'yizhe',
            title: '译者',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'ticai',
            title: '体裁',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'ticai1',
            title: '体裁1',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'shidai',
            title: '时代',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'shidai1',
            title: '时代1',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'guobie',
            title: '国别',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'guobie1',
            title: '国别1',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'jiaokeshuming',
            title: '教科书名',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'cebie',
            title: '册别',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'cebie1',
            title: '册别1',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'jiaokeshubianzhuzhe',
            title: '教科书编著者',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'chubandi',
            title: '出版地',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'chubanshe',
            title: '出版社',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'nianfen',
            title: '年份',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'banben',
            title: '版本',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'xuanwenshouju',
            title: '选文首句',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'xuanwenmoju',
            title: '选文末句',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'timubieming',
            title: '题目别名',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'zuozhebieming',
            title: '作者别名',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }, {
            field: 'beizhu',
            title: '备注',
            align: 'center',
            valign: 'middle',
            sortable: true            
        }]
    });
	
	$('#tijiao').click(function(){
		
		if($('#cong').val() > $('#dao').val()){
			alert("起止年份有误。");
		}else{
			$('#table-javascript').bootstrapTable('refresh', {
				silent: true
			});
		}		

	})	
	
});