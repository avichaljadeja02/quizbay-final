
<template>
 <div class="LoginUser">

 <div class="wrapper">
 <section class="login-block">
 <div class="container-fluid">
 <div class="row">
 <div class="col-sm-12">
 <form class="md-float-material form-material">
 <!-- <form class="md-float-material form-material" action="#" method="POST"> -->
 <div class="auth-box card">
 <div class="card-block">
 <h3 class="text-center heading">Login</h3>
 <br />
 <div class="form-group form-primary">
 <input
 type="email"
 class="form-control"
 placeholder="Email"
 maxlength="50"
 required
 />
 </div>
 <div class="form-group form-primary">
 <input
 type="password"
 class="form-control"
 placeholder="Password"
 maxlength="100"
 required
 />
 </div>
 <div class="row">
 <div class="col-md-12">

 <router-link to="HomePage"><input
 type="submit"
 class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20"
 name="submit"
 value="Login"
 /></router-link>
 <!-- <button type="submit">SIGNUP</button> -->
 </div>
 </div>
 <div class="or-container">
 <div class="line-separator"></div>
 <div class="or-label">or</div>
 <div class="line-separator"></div>
 </div>
 <div class="row">
 <div class="col-md-12">
 <a
 class="btn btn-lg btn-google btn-block text-uppercase btn-outline"
 href="#"
 ><img
 src="https://img.icons8.com/color/16/000000/google-logo.png"
 />
 Signup Using Google</a
 >
 </div>
 </div>
 <br />
 <p class="text-inverse text-center">
 Don't have an account?
 <router-link class="nav-item" to="/Register"
 >Register</router-link
 >
 </p>
 </div>
 </div>
 </form>
 </div>
 </div>
 </div>
 </section>
 </div>
 </div>
</template>
<script>
export default {
  name: 'Login'
}
</script>
<style scoped>
.wrapper {
 background: #f95e49;
}
body {
 background-color: #f2f7fb;
}
.login-block {
 margin: 30px auto;
 min-height: 93.6vh;
}
.login-block .auth-box {
 margin: 20px auto 0;
 max-width: 500px !important;
}
.card {
 border-radius: 5px;
 -webkit-box-shadow: 0 0 5px 0 rgba(43, 43, 43, 0.1),
 0 11px 6px -7px rgba(43, 43, 43, 0.1);
 box-shadow: 0 0 5px 0 rgba(43, 43, 43, 0.1),
 0 11px 6px -7px rgba(43, 43, 43, 0.1);
 border: none;
 margin-bottom: 30px;
 -webkit-transition: all 0.3s ease-in-out;
 transition: all 0.3s ease-in-out;
 background-color: white;
}
.card .card-block {
 padding: 1.25rem;
}
.f-80 {
 font-size: 80px;
}
.form-group {
 margin-bottom: 1.25em;
}
.form-material .form-control {
 display: inline-block;
 height: 43px;
 width: 100%;
 border: none;
 border-radius: 0;
 font-size: 16px;
 font-weight: 400;
 padding: 9px;
 background-color: transparent;
 -webkit-box-shadow: none;
 box-shadow: none;
 border-bottom: 1px solid #ccc;
}
.btn-md {
 padding: 10px 16px;
 font-size: 15px;
 line-height: 23px;
}
.btn-primary {
 background-color: #4099ff;
 border-color: #4099ff;
 color: #fff;
 cursor: pointer;
 -webkit-transition: all ease-in 0.3s;
 transition: all ease-in 0.3s;
}
.btn {
 border-radius: 2px;
 text-transform: capitalize;
 font-size: 15px;
 padding: 10px 19px;
 cursor: pointer;
}
.m-b-20 {
 margin-bottom: 20px;
}
.btn-md {
 padding: 10px 16px;
 font-size: 15px;
 line-height: 23px;
}
.heading {
 font-size: 21px;
}
#infoMessage p {
 color: red !important;
}
.btn-google {
 color: #545454;
 background-color: #ffffff;
 box-shadow: 0 1px 2px 1px #ddd;
}
.or-container {
 align-items: center;
 color: #ccc;
 display: flex;
 margin: 25px 0;
}
.line-separator {
 background-color: #ccc;
 flex-grow: 5;
 height: 1px;
}
.or-label {
 flex-grow: 1;
 margin: 0 15px;
 text-align: center;
}
</style>
