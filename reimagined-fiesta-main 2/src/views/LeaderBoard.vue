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
    <h2 class="nav-item">LeaderBoard</h2>
  </nav>
  <div class="container">
  <ul>
    <li class="table-header">
      <div class="col col-1">Rank</div>
      <div class="col col-2">Username</div>
      <div class="col col-3">Score</div>
    </li>
  </ul>
  <ul v-for="leader in leaderBoard" v-bind:key = leader.quizId>
    <li class="table-row">
      <div class="col col-1" data-label="Job Id">{{leader.userName}}</div>
      <div class="col col-2" data-label="Customer Name">{{leader.score}}</div>
    </li>
  </ul>
</div>
</div>
</template>
<script>
import axios from 'axios'
export default {
  name: 'LeaderBoard',
  data () {
    return {
      leaderBoard: [{
        userId: '',
        quizId: '1',
        userName: '',
        score: null,
        quizName: '',
        rank: null
      }]
    }
  },
  async mounted () {
    // const quizId = 1
    // const url = `http://10.177.1.121:8082/quizbay/leaderboard/quiz/${this.leaderBoard.quizId}`
    const resp = await axios.get('http://10.177.1.183:8082/quizbay/leaderboard/quiz/2')
    // fetch(url)
    //   .then(e => e.json())
    //   .then(response => {
    //     console.log(response)
    //     this.leaderBoard = response
    //   })
    // console.log(this.leaderBoard)
    // setTimeout({}, 500)
    console.log(resp.data)
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
    flex-basis: 33%;
  }
  .col-2 {
    flex-basis: 33%;
  }
  .col-3 {
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
      /* &:before {
        color: #6C7A89;
        padding-right: 10px;
        content: attr(data-label);
        flex-basis: 50%;
        text-align: right;
      } */
    }
}

</style>
