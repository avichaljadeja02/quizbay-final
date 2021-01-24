<template>
    <transition name="modal">
        <div class="modal-mask">
          <div class="modal-wrapper">
            <div class="modal-container">
              <div class="modal-header">
                <slot name="header">
                  default header
                </slot>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" @click="$emit('close')">
                    <span aria-hidden="true">&times;</span>
                </button>
              </div>

              <div class="modal-body">
                <slot name="body">
                  default body
                </slot>
              </div>

              <div class="modal-footer">
                <slot name="footer">
                  <button class="modal-default-button" @click="$emit('close')">
                    OK
                  </button>
                  <router-link to="StaticQuestionBank"><button class="modal-default-button" >
                    Go to Question Bank
                  </button></router-link>
                </slot>
              </div>
            </div>
          </div>
        </div>
      </transition>
</template>

<script>
export default {
  name: 'Modal'
}
</script>

<style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
  padding: 10px;
  margin-top: 5px;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
width:100%;

}
.modal-container {
  width: 450px;
  margin: 0px auto;
  padding: 30px 60px;
  border-radius: 14px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
  font-family: Helvetica, Arial, sans-serif;
  margin-bottom: 15px;
  background-color: white;

}

.modal-header {
    padding: 1rem 0;
}

.modal-header h3 {
  margin-top: 0;
  color: #42b983;
  text-align: left;
}

.modal-body {
  margin: 20px 0;
  padding: 0px;
  text-align: left;
  margin-bottom: 15px;

}

.modal-default-button {
  float: right;
  border-radius: 12px;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
  width:100%;
}
</style>
