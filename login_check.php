<?php
   $con=mysqli_connect("localhost","root","","android_test");

   if (mysqli_connect_errno($con)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }

   $username = $_GET['username'];
   $password = $_GET['password'];
   $result = mysqli_query($con,"SELECT * FROM login_data where username='$username' and password='$password'");
   $row = mysqli_fetch_array($result);
   $data = $row[0];

   if($data){
      echo $data;
   }
   else
   {
   echo "Invalid User";
   }
   mysqli_close($con);
?>