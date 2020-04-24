<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="web-name">WEB CONSOLE</div>
<div class="profile">
	<div class="row">
		<div class="col-md-4">
			<div class="avata">
				<img src="<c:url value="/asset/user.png" />" />
			</div>
		</div>
		<div class="col-md-8">
			<div class="name">Lam Dan</div>
			<div class="dropdown">
				<button class="btn btn-link dropdown-toggle" id="setting"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="glyphicon glyphicon-cog"></i>
				</button>
				<div class="dropdown-menu" aria-labelledby="setting">
					<a class="dropdown-item" href="#">Update</a>
					<a class="dropdown-item" href="#">Impersonate</a>
					<a class="dropdown-item" href="#">Change Password</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Logout</a>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="navigation">
	<div class="title">IN-BOX</div>
	<div id="inbox">
		<div class="card">
			<div class="nav-heading row">
				<div class="col-md-2">
					<img src="<c:url value="/asset/bell-icon.png" />" />
				</div>
				<div class="col-md-7">
					<button class="btn btn-link">Notification</button>
				</div>
				<div class="col-md-3">
					<div class="notification">20</div>
				</div>
			</div>
		</div>
		<div class="card">
			<div class="nav-heading row">
				<div class="col-md-2">
					<img src="<c:url value="/asset/message-icon.png" />" />
				</div>
				<div class="col-md-7">
					<button class="btn btn-link">Message</button>
				</div>
				<div class="col-md-3">
					<div class="message">5</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="navigation">
	<div class="title">MAIN NAVIGATION</div>
	<div id="accordion">
		<div class="card">
			<div id="headingOne" class="nav-heading row">
				<div class="col-md-2">
					<img src="<c:url value="/asset/product-icon.png" />" />
				</div>
				<div class="col-md-8">
					<button class="btn btn-link" data-toggle="collapse"
						data-target="#collapseOne" aria-expanded="true"
						aria-controls="collapseOne">Product Management</button>
				</div>
				<div class="col-md-2">
					<i class="glyphicon glyphicon-chevron-left"></i>
				</div>
			</div>
			<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
				data-parent="#accordion">
				<div class="card-body">
					<ul>
						<li><a href="#">Product List</a></li>
						<li><a href="#">Add New Product</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="card">
			<div id="headingTwo" class="nav-heading row">
				<div class="col-md-2">
					<img src="<c:url value="/asset/category-icon.png" />" />
				</div>
				<div class="col-md-8">
					<button class="btn btn-link collapsed" data-toggle="collapse"
						data-target="#collapseTwo" aria-expanded="false"
						aria-controls="collapseTwo">Category Management</button>
				</div>
				<div class="col-md-2">
					<i class="glyphicon glyphicon-chevron-left"></i>
				</div>
			</div>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordion">
				<div class="card-body">
					<ul>
						<li><a href="#">Category List</a></li>
						<li><a href="#">Add New Category</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="card">
			<div id="headingThree" class="nav-heading row">
				<div class="col-md-2">
					<img src="<c:url value="/asset/dollar-icon.png" />" />
				</div>
				<div class="col-md-8">
					<button class="btn btn-link collapsed" data-toggle="collapse"
						data-target="#collapseThree" aria-expanded="false"
						aria-controls="collapseThree">Customer Management</button>
				</div>
				<div class="col-md-2">
					<i class="glyphicon glyphicon-chevron-left"></i>
				</div>
			</div>
			<div id="collapseThree" class="collapse"
				aria-labelledby="headingThree" data-parent="#accordion">
				<div class="card-body">
					<ul>
						<li><a href="#">Customer List</a></li>
						<li><a href="#">Add New Customer</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="card">
			<div id="headingFour" class="nav-heading row">
				<div class="col-md-2">
					<img src="<c:url value="/asset/eployee-icon.png" />" />
				</div>
				<div class="col-md-8">
					<button class="btn btn-link collapsed" data-toggle="collapse"
						data-target="#collapseFour" aria-expanded="false"
						aria-controls="collapseFour">Employee Management</button>
				</div>
				<div class="col-md-2">
					<i class="glyphicon glyphicon-chevron-left"></i>
				</div>
			</div>
			<div id="collapseFour" class="collapse" aria-labelledby="headingFour"
				data-parent="#accordion">
				<div class="card-body">
					<ul>
						<li><a href="#">Employee List</a></li>
						<li><a href="#">Add New Employee</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="card">
			<div id="headingFive" class="nav-heading row">
				<div class="col-md-2">
					<img src="<c:url value="/asset/present-icon.png" />" />
				</div>
				<div class="col-md-8">
					<button class="btn btn-link collapsed" data-toggle="collapse"
						data-target="#collapseFive" aria-expanded="false"
						aria-controls="collapseFive">Discount Management</button>
				</div>
				<div class="col-md-2">
					<i class="glyphicon glyphicon-chevron-left"></i>
				</div>
			</div>
			<div id="collapseFive" class="collapse" aria-labelledby="headingFive"
				data-parent="#accordion">
				<div class="card-body">
					<ul>
						<li><a href="#">Discount List</a></li>
						<li><a href="#">Add New Discount</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="navigation">
	<div class="title">STATISTICS</div>
	<div id="statistics">
		<div class="card">
			<div id="productStatistics" class="nav-heading row">
				<div class="col-md-2">
					<img src="<c:url value="/asset/chart-icon.png" />" />
				</div>
				<div class="col-md-8">
					<button class="btn btn-link" data-toggle="collapse"
						data-target="#collapseProductStatistics" aria-expanded="true"
						aria-controls="collapseProductStatistics">Product
						Statistics</button>
				</div>
				<div class="col-md-2">
					<i class="glyphicon glyphicon-chevron-left"></i>
				</div>
			</div>
			<div id="collapseProductStatistics" class="collapse"
				aria-labelledby="productStatistics" data-parent="#statistics">
				<div class="card-body">
					<ul>
						<li><a href="#">Today</a></li>
						<li><a href="#">Monthly</a></li>
						<li><a href="#">Yearly</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="card">
			<div id="orderStatistics" class="nav-heading row">
				<div class="col-md-2">
					<img src="<c:url value="/asset/chart-icon.png" />" />
				</div>
				<div class="col-md-8">
					<button class="btn btn-link" data-toggle="collapse"
						data-target="#collapseOrderStatistics" aria-expanded="true"
						aria-controls="collapseOrderStatistics">Order Statistics</button>
				</div>
				<div class="col-md-2">
					<i class="glyphicon glyphicon-chevron-left"></i>
				</div>
			</div>
			<div id="collapseOrderStatistics" class="collapse"
				aria-labelledby="orderStatistics" data-parent="#statistics">
				<div class="card-body">
					<ul>
						<li><a href="#">Today</a></li>
						<li><a href="#">Monthly</a></li>
						<li><a href="#">Yearly</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>