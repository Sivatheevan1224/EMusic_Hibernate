<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="images/favicon.png" type="image/png">
    <title>Sign In</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">
    <header class="bg-dark text-white py-3">
        <div class="container d-flex justify-content-between align-items-center">
            <!-- eMusic Center Name -->
            <h4 class="mb-0">eMusic Center</h4>            
        </div>
    </header>
    <div class="container flex-grow-1 d-flex align-items-center justify-content-center">
        <div class="card p-4 shadow" style="width: 400px;">
            <h2 class="text-center mb-4">Sign In</h2>
             <c:if test="${not empty errMsg}">
                 <h4 class="text-danger"> ${errMsg} </h4>
             </c:if>
            <form method="POST" action="${pageContext.request.contextPath}/login.html">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" name="username" placeholder="Enter your username" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" placeholder="Enter your password" required>
                </div>
                <button type="submit" class="btn btn-primary w-100">Sign In</button>
            </form>
        </div>
    </div>    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
