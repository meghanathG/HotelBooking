<html>
<head>
    <meta charset="utf-8">
    <title>Sign-up</title>
    <link href="./assets/css/signup.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <style>
@keyframes blink {
  0% { opacity: 1; }
  50% { opacity: 0; }
  100% { opacity: 1; }
}

.blink h3 {
  animation: blink 1s infinite;
}
</style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<!--container---------------------->
<div class="container" >
    <!--sign-up-box-container--->
    <div class="sign-up">

        <div id="png"><a href="/" title="HOME"><img style="width:55px; height:55px ; " src="./assets/img/home-page.png"></a></div>
        <!--heading-->
        <span class="blink">
				<h3 align=center style="color: red">${message}</h3>
			</span>
        <form action="insertcustomer" method="post">
            <h1 class="heading">Hello,Friend</h1>
            <!--name-box-->
            <div class="text">
                <img height="20px" src="./assets/img/user.png" />
                <input placeholder="Name" type="text" name="username"/>
            </div>
            <!--Email-box-->
            <div class="text">
                <img height="12px" src="./assets/img/email.png" />
                <input placeholder=" Example@gmail.com" type="email" name="email" />
            </div>
            <!--Password-box-->
            <div class="text">
                <img height="20px" src="./assets/img/password.png" />
                <input placeholder=" Password" type="password" name="password"/>
            </div>
            <div class="or"><b>OR</b></div>
            <div class="s1"><p><b>Sign-up with</b></p></div>

            <div>
                <ul>
                    <li><a href="#"><i class="fab fa-facebook" aria-hidden="true"></i></a></li>
                    <li><a href="#"><i class="fab fa-twitter" aria-hidden="true"></i></a></li>
                    <li><a href="#"><i class="fab fa-google"  aria-hidden="true"></i></a></li>
                    <li><a href="#"><i class="fab fa-linkedin" aria-hidden="true"></i></a></li>
                    <li><a href="#"><i class="fab fa-instagram" aria-hidden="true"></i></a></li>
                </ul>

            </div>
            <!--trems-->

            <div class="trems">
                <input class="check" type="checkbox" required/>
                <p class="conditions">I read and agree to <a href="#">Trems &amp; Conditions</a></p>
            </div>
            <!--button-->
            <div class="toop">
                <button type="submit" class="btn btn-primary" >CREATE ACCOUNT</button> </div>

        </form>
        <!--sign-in-->
        <div class="t"><p class="conditions" id="p3">Already have an account <a href="custlogin">Sign in</a></p> </div></div>
</div>
<!--text-container-->
<div class="text-container">

    <h1 style="color: #2d2c2c;font-family:cursive;">Glad to see you</h1>

    <div class="diag"><img class="fig1" width="100%" height="105%" src="./assets/img/Inkeddia_LI.jpg"/></div>
    <div class="para"> <b>Welcome</b>,Please Fill in the blanks for sign up</div>

</div>
</div>
</body>
</html>