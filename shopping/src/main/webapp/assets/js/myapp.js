$(function() {
	console.log(menu);
	// Active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// jQuery DataTable
	// Dummy DataSet
	/*
	 * var products=[ ['1','ABC'], ['2','MNB'], ['3','PKO'], ['4','XYZ'],
	 * ['5','MJK'], ['6','LKJ'], ['7','HJK'], ['8','PQR'] ];
	 * console.log('DataSet created');
	 */
	var $table = $('#productListTable');
	// If table exists
	if ($table.length) {
		/*
		 * console.log('Table exists'); $table.DataTable({ lengthMenu:
		 * [[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
		 * pageLength: 5, data: products });
		 */
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		$table
				.DataTable({
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'All Records' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg" />'
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of stock!</span>';
									}
									return data
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
									console.log(str);
									return str
								}
							} ]
				});
	}
});

// dismiss alert after 3 sec
var alert = $('.alert');
if (alert.length) {
	setTimeout(function(){
		$alert.fadeOut('slow');
	},3000)
}