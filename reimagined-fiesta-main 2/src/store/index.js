import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    isLogin: false,
    username: '',
    email: ''
  },
  mutations: {
    setUserName (state, data) {
      state.username = data
      state.isLogin = true
    },
    setEmail (state, data) {
      state.email = data
    }
  },
  actions: {
    setUserName ({ commit }, data) {
      commit('setUserName', data)
    }
  },
  getters: {
    isLogin: (state) => state.isLogin,
    username: (state) => state.username,
    email: (state) => state.email
  },
  modules: {
  }
})
