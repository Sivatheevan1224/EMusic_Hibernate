<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="images/favicon.png" type="image/png">
    <title>Albums</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<header class="bg-dark text-white py-3">
		<div class="container d-flex justify-content-between align-items-center">
			<!-- eMusic Center Name -->
			<h4 class="mb-0">eMusic Center</h4>
			<!-- Welcome Message and Sign Out Button -->
			<div class="d-flex align-items-center">
                            <span class="me-3">Welcome, <span id="userFullName">${sessionScope.user.firstname} ${sessionScope.user.lastname}</span>!</span>
				<a href="sign-in.html"><button class="btn btn-outline-light btn-sm">Sign Out</button></a>
			</div>
		</div>
	</header>
    <div class="container my-3">
        <h1 class="text-center mb-4">Album List</h1>
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <!-- Example Album Card (to be dynamically generated) -->
            <c:forEach var="album" items="${albumlist}">
                
                <div class="col">
                <div class="card h-100" onclick="window.location='album-view.html?id=${album.albumid}';" style="cursor: pointer;">
                    <img src="images/${album.imagefile}" class="card-img-top" alt="Album Image">
                    <div class="card-body">
                        <h5 class="card-title">${album.name}</h5>
                        <p class="card-text">By ${album.artist.name}</p>
                    </div>
                </div>
            </div> 
                
            </c:forEach>
            
                       
            <!-- Repeat for additional albums -->
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
