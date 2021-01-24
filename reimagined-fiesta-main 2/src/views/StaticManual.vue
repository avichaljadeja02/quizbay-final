<template>
<div class="panel">
  <div class="header">
    <a href="/"><img class="header_logo" src="" alt="logo"/></a>
    <div class="header_nav">
      <div class="header_option">
<router-link to="/Login"><span class="header_optionLineOne">Logout</span></router-link>      </div>
    </div>
  </div>
  <nav id="nav">
    <h2 class="nav-item">Contest Creation  - Static Manual</h2>
  </nav>

  <div class="product1">
    <div class="product-card">
      <div v-for="index in 10" :key="index">
      <div class="product-info">
  <label for="fname" class="question">Question: </label>
  <span class="spanquestion"><input type="text" id="fname" name="fname" class="inputquestion" ></span>
  <label for="lname" class="question">Choice A: </label>
  <span class="spanquestion"><input type="text" id="lname" name="lname" class="inputquestion"></span>
  <label for="lname" class="question">Choice B: </label>
  <span class="spanquestion"><input type="text" id="lname" name="lname" class="inputquestion"></span>
  <label for="lname" class="question">Choice C: </label>
  <span class="spanquestion"><input type="text" id="lname" name="lname" class="inputquestion"></span>
  <label for="lname" class="question">Choice D: </label>
  <span class="spanquestion"><input type="text" id="lname" name="lname" class="inputquestion"><br></span>
<div><span class="clear">Correct answer:</span>

  <input type="radio" id="a" name="correct" value="a"
         checked>
  <label for="huey" >A</label>
  <input type="radio" id="b" name="correct" value="b" class="spacing">
  <label for="dewey" >B</label>
  <input type="radio" id="c" name="correct" value="c" class="spacing">
  <label for="louie" >C</label>
  <input type="radio" id="d" name="correct" value="d" class="spacing">
  <label for="louie" >D</label><br><br>
</div>
<div>
<span>Difficulty:</span>

  <input type="radio" id="easy" name="difficulty" value="easy"
         checked>
  <label for="huey" >Easy</label>
  <input type="radio" id="medium" name="difficulty" value="medium" class="spacing">
  <label for="dewey" >Medium</label>
  <input type="radio" id="difficult" name="difficulty" value="difficult" class="spacing">
  <label for="louie" >Difficult</label><br>
</div>
</div>
    </div>
    </div>
<hr />
  </div>
  <br>
<button class="button2">Set Quiz</button>
</div>
</template>
<script>
export default {
  name: 'StaticManual'
}
</script>
<style scoped>
.inputstyle{
  width: 30px
}
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
  margin-left: 1200px
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
.button2{
  display: inline-block;
  width: 80px;
  height: 50px;
  justify-content: center;
  font-size: 15px;
}
.place{
  display: inline-block;
  background-color: #f95e49;
  border-radius: 15px;
  border: 5px #cccccc;
  color: black;
  text-align: center;
  font-size: 10px;
  width: 50px;
  height: 20px;
  transition: all 0.5s;
  cursor: pointer;
  justify-content: center;

}
.container{
  width: 500px;
  height: 400px;
  margin: auto;
  padding: 10px;
  background-color: #ffcccc;
}
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid black;
}
.spacing{
  margin-left: 10px;
}
.your-class input{
  float:left;
}
.inputstyle{
  display: inline-block;
  width: 20px;
}
.clear{
  clear: left
}
.product1{
  display: flex;
  flex-wrap: wrap;
  box-shadow: 0 0 15px 4px rgba(0,0,0,0.06);
  border-radius: 5px;
  justify-content: space-between;
  text-align: justify;
}
.product-card {
  padding: 2%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap ;
  width:100vw;
  margin-bottom: 30px;
}
.product-info {
  margin-top: auto;
  justify-content: space-between;
  border: 1px solid black;
  padding: 35px;
  margin:20px;
  flex-wrap: wrap;
  width: 300px;
  justify-self: center;
}
.question {
            float: left;
        }

        .spanquestion {
            display: block;
            overflow: hidden;
            padding: 0px 4px 0px 6px;
        }

        .inputquestion {
            width: 50%;
        }
.hline { width:100%; height:1px; background: #fff }
hr {
    display: block;
    height: 1px;
    border: 0;
    border-top: 1px solid black;
    margin: 1em 0;
    padding: 0;
    /* width: 500px;
    justify-content: center;
    justify-self: center; */
}
</style>
