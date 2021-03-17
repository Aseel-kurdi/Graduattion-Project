<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="icon" type="image/png" href="https://i.ibb.co/xGXRwLF/130822812-836734607102721-7712471177251957862-n.png" />
    <meta charset="utf-8" />
    <title>Login Page</title>
    <link rel="stylesheet" href="style.css">
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

<form action="log" method="post">
    <div class="login-box">
        <h1>Login</h1>
            <div class="textbox">
                <i class="fas fa-user"></i>
    <%--            pattern="[a-zA-Z][a-zA-Z]{4,}"--%>
                <input type="text" placeholder="Pharmacy name" name="pharmacyName"  value=""  required> <!-- accept names with spaces -->
            </div>
        <div class="txtb">
            <i class="fas fa-id-badge"></i>
            <input type="text" placeholder="Pharmacy ID"name="pharmacyID" pattern="[0-9]{5}" maxlength="5" value="" required >
        </div>

            <div class="textbox">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Password" id="myinput"name="pass" value="" required>
                <span class="eye" onclick="return confirmPassword()">
                    <i id="hide1" class="fas fa-eye"></i>
                    <i id="hide2" class="fas fa-eye-slash"></i>
              </span>
            </div>
            <input class = "button" type="submit" value="Sign In"  >

    <%--        <div class="but">--%>
    <%--            <a class="button" href="signup">Sign Up</a>--%>
    <%--        </div>--%>
            <div class="link">
    <%--            <i class="fas fa-sign-in-alt"></i>--%>
                <a href="signup">Sign Up</a>
            </div>

        </div>

</form>




<script>
    function confirmPassword(){
        var x =document.getElementById("myinput");
        var y =document.getElementById("hide1");
        var z =document.getElementById("hide2");
        if(x.type==='password'){
            x.type="text";
            y.style.display="block";
            z.style.display="none";
        }
        else{
            x.type="password";
            y.style.display="none";
            z.style.display="block";
        }
    }


    function showAlert(){
        alert("Syndical number or Password incorrect, please try again ^^ ")
    }
</script>
</body>




</html>