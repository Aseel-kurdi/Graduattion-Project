<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Login Page</title>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Castoro&display=swap" rel="stylesheet">    </head>
<body>

<header>
    <nav>
        <a href="Home" >Home</a>
        <a href="AboutUs" >About Us</a>
        <a href="log">LogIn</a>
        <a href="signup" class = "active">Sign Up</a>
    </nav>
</header>


<form>
    <div class="login-box">

        <h1>View new Prescription</h1>

        <div class="textbox">
            <i class="fas fa-id-badge"></i>
            <input type="text" placeholder="Prescription ID" name="" value="" pattern="[0-9]{8}" required>
        </div>

        <input class = "submit" type="submit" value="check Prescription"  >


    </div>
</form>

</body>




</html>