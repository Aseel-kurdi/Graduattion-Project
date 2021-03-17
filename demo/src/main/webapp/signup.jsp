<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/png" href="https://i.ibb.co/xGXRwLF/130822812-836734607102721-7712471177251957862-n.png" />
    <meta charset="utf-8" />
    <title>Sign up Page</title>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Castoro&display=swap" rel="stylesheet">
    <script src="javaScript.js"></script>

</head>
<body>

<header>
    <nav >
        <a href="Home" class = "active">Home</a>
        <a href="AboutUs">About Us</a>
        <a href="log">LogIn</a>
        <a href="signup" >Sign Up</a>
    </nav>
</header>

<form action="signup" method="post"  >
    <div class="signup-form">
        <br>
        <br>
        <h1>Sign Up</h1>

        <div class="txtb">
            <i class="fas fa-user"></i>
            <input type="text" placeholder="Pharmacy name"name="pharmacyName" minlength="3" maxlength="15" value="" pattern="[a-zA-Z]+" required>
        </div>

        <div class="txtb">
            <i class="fas fa-id-badge"></i>
            <input type="text" placeholder="Pharmacy ID"name="pharmacyID" pattern="[0-9]{5}" maxlength="5" value="" required >
        </div>

<%--        <div class="txtb">--%>
<%--            <i class="fas fa-user"></i>--%>
<%--            <input type="text" placeholder="Pharmacist first name"name="pharmacistFirstName" value="" pattern="[a-zA-Z]+" required >--%>
<%--        </div>--%>

<%--        <div class="txtb">--%>
<%--            <i class="fas fa-user"></i>--%>
<%--            <input type="text" placeholder="Pharmacist last name"name="pharmacistLastName" value="" pattern="[a-zA-Z]+" required >--%>
<%--        </div>--%>

<%--        <div class="txtb">--%>
<%--            <i class="fas fa-id-badge"></i>--%>
<%--            <input type="text" placeholder="Pharmacist syndical number" name="pharmacistSyndicalNumber" value="" pattern="[0-9]{5}" required>--%>
<%--        </div>--%>




        <div class="txtb">
            <i class="fas fa-envelope-open"></i>
            <input type="email" placeholder="Email"name="Email" value="">
        </div>

        <div class="txtb">
            <i class="fas fa-phone-alt"></i>
            <input type="text" placeholder="Phone number"name="phoneNumber" value="" pattern="^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$" required >
        </div>

        <div class="txtb">
            <i class="fas fa-lock"></i>
<%--            pattern="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$"--%>
            <input type="Password" placeholder="Password"name="pass"value="" id ="pass1"  required>
            <span class="eye" onclick="return confirmPassword()">
            <i id="hide1" class="fas fa-eye"></i>
            <i id="hide2" class="fas fa-eye-slash"></i>
      </span>
        </div>

        <div class="txtb">
            <i class="fas fa-lock"></i>
            <input type="Password" placeholder="Confirm password"name=""value="" id ="pass2"  onchange="return check()" required>



            <p id="pass">Passwords are not the same</p>
        </div>


        <div class="txtb">
            <i class="fas fa-map-marker-alt"></i>
            <input type="text" placeholder="Address"name="Address" value=""  required >
        </div>

        <input class = "submit" type="submit" value="Submit" onclick="show_alert()"  >
        <br>
        <div class="link">
            <a href="log">Already Have One?</a>
        </div>
    </div>
</form>



<script>
    function confirmPassword(){
        var x =document.getElementById("pass1");
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


    function show_alert() {
        alert("Your request will be submitted and pending for approval ^^ ");
    }
</script>
</body>
</html>