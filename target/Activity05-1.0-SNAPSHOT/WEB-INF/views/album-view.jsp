<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="images/favicon.png" type="image/png">
        <title>Album View</title>
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
        <div class="container my-5">
            <div class="card shadow p-4">
                <div class="row g-4 align-items-center">
                    <!-- Album Image -->
                    <div class="col-md-4 text-center">
                        <img src="images/${album.imagefile}" class="img-fluid rounded" alt="Album Image">
                    </div>
                    <!-- Album Details -->
                    <div class="col-md-8">
                        <h2 class="text-center mb-4">${album.name}</h2>                    
                        <div class="mb-3">
                            <h5>Artist:</h5>
                            <p>${album.artist.name}</p>
                        </div>
                        <div class="mb-3">
                            <h5>Tracks:</h5>
                            <ul class="list-group">
                                <!-- Example track list (to be dynamically generated) -->
                                <c:forEach var="track" items="${album.tracks}">
                                    <li class="list-group-item">${track.title}</li>
                                    </c:forEach>                            
                            </ul>
                        </div>
                        <a href="album-list.html" class="btn btn-secondary mt-3">Back to Album List</a>
                    </div>
                </div>
            </div>
        </div>    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
