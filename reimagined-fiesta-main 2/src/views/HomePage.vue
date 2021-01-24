<template>
<div class="panel">
  <div class="header">
    <a href="/"><img class="header_logo" src="" alt="logo"/></a>
    <div class="header_nav">
      <div class="header_option">
        <router-link to="/Profile"><span class="header_optionLineOne">My Profile</span></router-link>
<router-link to="/Login"><span class="header_optionLineOne">Logout</span></router-link>      </div>
    </div>
  </div>
  <nav id="nav">
    <h2 class="nav-item"> Home Page</h2>
  </nav>
  <div class="product1">
    <div class="prouct_card">
      <br>
      <router-link to="QuizInfo"><button class="button1" >Create Contest</button></router-link>
      <br><br>
      <router-link to="Manual"><button class="button1" >Manual</button></router-link>
      <br><br>
      <router-link to="MyQuiz"><button class="button1" >My Quiz</button></router-link>
    </div>
  </div>

</div>
</template>
<script>
export default {
  name: 'HomePage'
}
</script>
<style scoped>
.header {
  height: 80px;
  display: flex;
  align-items: center;
  background-color: #f95e49;
  position: sticky;
  top: 0;
  z-index: 100;
}

.header_logo{
  width: 100px;
  object-fit: contain;
  margin: 0 20px;
  margin-top: 10px;
}

.header_nav{
  display: flex;
  justify-content: space-evenly;
}

.header_option {
  display: flex;
  flex-direction: column;
  margin-left: 10px;
  margin-right: 10px;
  color: black}

.header_optionLineOne{
  font-size: 15px;
  font-weight: 800;
  margin-left: 1200px;
}
.header_optionLineTwo{
  font-size: 15px;
  font-weight: 800
}
.nav{
  padding: 5px;
}
.nav-item {
  padding: 10px;
  font-weight: bold;
  color: black;
  text-decoration: none;
}
.vue-tempalte
  {
    margin-bottom: 150px;
    margin-top: 0%;
    margin-left: 430px;
    justify-content: center;
    width: 40%;
    height: 75vh;
    padding:5x;
    border: 1px solid black;
    box-shadow:0 0 15px 4px rgba(0,0,0,0.06);
    border-radius:10px;
    background-color:#F5F5F5;
  }
.button1{
  display: inline-block;
  background-color: #f95e49;
  border-radius: 15px;
  border: 5px #cccccc;
  color: black;
  text-align: center;
  font-size: 30px;
  width: 350px;
  height: 90px;
  transition: all 0.5s;
  cursor: pointer;
  justify-content: center;
  /* margin-left: 25px; */
}

</style>
