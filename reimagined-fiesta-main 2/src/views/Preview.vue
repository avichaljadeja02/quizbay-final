<template>
<div class="panel">
  <div class="header">
    <a href="/"><img class="header_logo" src="" alt="logo"/></a>
    <div class="header_nav">
      <div class="header_option">
<router-link to="/Login"><span class="header_optionLineOne">Logout</span></router-link>      </div>
    </div>
  </div>
 <div id="nav">
 <h2 class="nav-item">Contest Creation - Preview Questions</h2>

 <div class="containerItems">
 <div class="product-card">
   <div v-for="index in 10" :key="index">
 <div
 v-for="ques in questionbank"
 v-bind:key="ques.questionId"
 class="wrap-products"
 >
 <div class="product-info">

 <label>Question :- </label
 ><span class="bname">{{ ques.question }}</span>

 <div class="ques">
 <label>optionA :- </label
 ><span class="bname">{{ ques.optionA }}</span>
 </div>
 <div class="ques">
 <label>optionB :- </label
 ><span class="bname1">{{ ques.optionB }}</span>
 </div>
 <div class="ques">
 <label>optionC :- </label
 ><span class="bname2">{{ ques.optionC }}</span>
 </div>
 <div class="ques">
 <label>optionD :- </label
 ><span class="bname3">{{ ques.optionD }}</span>
 </div>
 <div class="ques">
 <label>CorrectAns :- </label
 ><span class="bname4">{{ ques.CorrectAns }}</span>
 </div>
 <div class="ques">
 <label>DifficultyLevel :- </label
 ><span class="bname5">{{ ques.DifficultyLevel }}</span>
 </div>
 <br />
 </div>
 </div>
 </div>
 </div>
 </div>
 <button class="button1">Set Quiz</button>
 </div>
</div>
</template>
<script>
export default {
  name: 'Preview',
  data () {
    return {
      questionbank: [
        {
          questionId: 1,
          question: 'abc ansertyuiopsdfgwertyuiophjklzxcvbnmwertyuioasdfsdfghjklxcvbnmghjkzxcvbnmqwertyuio',
          optionA: 'a',
          optionB: 'b',
          optionC: 'c',
          optionD: 'd',
          CorrectAns: 'qwer',
          DifficultyLevel: 'h'
        }
      ]
    }
  }
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
.name {
 justify-content: left;
 padding: 0px;
 margin-left: 2px;
 width: 100%;
 font-family: "Trebuchet MS", "Courier New", monospace;
}
h3 {
 text-decoration: underline;
 font-family: "Trebuchet MS", "Courier New", monospace;
}
.name input {
 width: 100%;
}
.product12 {
 font-weight: bold;
 width: 500px;
 justify-content: space-evenly;
}
.product1 {
 display: flex;
 flex-wrap: wrap;
 box-shadow: 0 0 15px 4px rgba(0, 0, 0, 0.06);
 border-radius: 5px;
 justify-content: space-between;
 text-align: left;
}
.product-card {
 padding: 2%;
 display: flex;
 flex-direction: row;
 justify-content: space-between;
 flex-wrap: wrap;
 width: 100vw;
 margin-bottom: 30px;
 justify-content: left;
}
.product-img {
 max-width: 100%;
}
.product-info {
 margin-top: auto;
 justify-content: space-between;
 border: 1px solid black;
 padding: 10px;
 margin: 10px;
 flex-wrap: wrap;
 width: 600px;
 word-wrap: break-word;
}
.button1 {
 display: inline-block;
 background-color: #f95e49;
 border-radius: 10px;
 border: 2px #cccccc;
 color: black;
 text-align: center;
 font-size: 18px;
 width: 80px;
 transition: all 0.5s;
 cursor: pointer;
 justify-content: center;
 margin-left: 132px;
}
.products .product-card:first-child,
.products .product-card:nth-child(2) {
 flex: 2 46%;
}
@media (max-width: 600px) {
 .product-card {
 flex: 1 46%;
 }
}
</style>
