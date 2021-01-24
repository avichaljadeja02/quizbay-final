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
    <h2 class="nav-item">Quiz Type</h2>
  </nav>
  <br><br>
  <button id="show-modal" class="button1" @click="edit()">Static</button>
  <br><br>
    <!-- <router-link to="StaticQuestionBank"><button id="show-modal" class="button1">Static Crawling</button></router-link>
  <br><br> -->
<router-link to="/Dynamic"><button id="show-modal" class="button1" >Dynamic</button></router-link>
  <Modal v-if="showModal" @close="showModal = false">
  <h3 slot="header"> Static Quiz Details</h3>
  <div slot="body" class="name">
    <label for="category">Choose category: </label>
   <select name="category" id="category">
    <option value="Category 1">Category 1</option>
    <option value="Category 2">Category 2</option>
    <option value="Category 3">Category 3</option>
    <option value="Category 4">Category 4</option>
    <option value="Category 5">Category 5</option>
  </select><br><br>
    <div>
    <label for="time">Start Time: </label>
  <input type="datetime-local" id="time" name="time">
  <br><br>
  <label for="time">End Time: </label>
  <input type="datetime-local" id="time" name="time">
  <br><br>
    </div>
</div>
  </Modal>
  <!-- <ModalDynamic v-if="showModalDynamic" @close="showModalDynamic = false">
  <h3 slot="header"> Static Quiz Details</h3>
  <div slot="body" class="name">
    <label for="category">Choose category: </label>
   <select name="category" id="category">
    <option value="Category 1">Category 1</option>
    <option value="Category 2">Category 2</option>
    <option value="Category 3">Category 3</option>
    <option value="Category 4">Category 4</option>
    <option value="Category 5">Category 5</option>
  </select><br><br>
</div>
<router-link to="StaticManual"><button>DONE</button></router-link>
  </ModalDynamic> -->
</div>
</template>
<script>
import Modal from '../components/Modal'
export default {
  name: 'QuizInfo',
  components: {
    Modal
  },
  data () {
    return {
      showModal: false,
      showModalDynamic: false

    }
  },
  methods: {
    edit () {
      this.showModal = true
    },
    close () {
      this.showModal = false
    },
    editdynamic () {
      this.showModalDynamic = true
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

</style>
