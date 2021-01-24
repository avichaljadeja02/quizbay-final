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
    <h2 class="nav-item">Upcoming Quiz</h2>
  </nav>
  <div class="container">
  <ul >
    <li class="table-header">
      <div class="col column-1">Quiz Name</div>
      <div class="col column-2">Quiz category</div>
      <div class="col column-3">Date & Time</div>
      <!-- <div class="col col-4">LeaderBoard</div> -->
    </li>
    <div v-for="upcoming in upcomingQuiz" v-bind:key="upcoming.quizId">
    <li class="table-row">
      <div class="col column-1" data-label="Job Id">{{upcoming.quizName}}</div>
      <div class="col column-2" data-label="Customer Name">{{upcoming.category}}</div>
      <div class="col column-3" data-label="Amount">{{upcoming.startTime}}</div>
      <!-- <div class="col col-4" data-label="Payment Status"><router-link to="LeaderBoard"><button>LeaderBoard</button></router-link></div> -->
    </li>
    </div>
    </ul>
</div>

</div>
</template>
<script>
import axios from 'axios'
export default {
  name: 'UpcomingQuiz.vue',
  data () {
    return {
      upcomingQuiz: [
        {
          quizId: null,
          masterId: '',
          noOfQuestions: null,
          quizName: '',
          startTime: '',
          endTime: '',
          quiztype: null,
          category: ''
        }
      ]
    }
  },
  mounted () {
    axios.get('http://10.177.1.113:8083/quizbay/contest/getMasterFutureQuizzes/1').then((response) => {
      this.upcomingQuiz = response.data
    })
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
body {
  font-family: 'lato', sans-serif;
}
.container {
  max-width: 1000px;
  margin-left: auto;
  margin-right: auto;
  padding-left: 10px;
  padding-right: 10px;
}

h2 {
  font-size: 26px;
  margin: 20px 0;
  text-align: center;
}
  li {
    border-radius: 3px;
    padding: 25px 30px;
    display: flex;
    justify-content: space-between;
    margin-bottom: 25px;
  }
  .table-header {
    background-color: #ffcccc;
    font-size: 14px;
    text-transform: uppercase;
    letter-spacing: 0.03em;
  }
  .table-row {
    background-color: #ffffff;
    box-shadow: 0px 0px 9px 0px rgba(0,0,0,0.1);
  }
  .col-1 {
    flex-basis: 10%;
  }
  .col-2 {
    flex-basis: 40%;
  }
  .col-3 {
    flex-basis: 25%;
  }
  .col-4 {
    flex-basis: 25%;
  }
  .column-1 {
    flex-basis: 33%;
  }
  .column-2 {
    flex-basis: 33%;
  }
  .column-3 {
    flex-basis: 34%;
  }
  @media all and (max-width: 767px) {
    .table-header {
      display: none;
    }
    li {
      display: block;
    }
    .col {
      flex-basis: 100%;
    }
    .col {
      display: flex;
      padding: 10px 0;
    }
}

</style>
