import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import GoogleAuth from 'vue-google-oauth'
Vue.use(GoogleAuth, { client_id: '956680480995-gfmb4jil2uf2ijki4o39pv0uhgevg71c.apps.googleusercontent.com' })
Vue.googleAuth().load()

// import '@assets/main.css'
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
