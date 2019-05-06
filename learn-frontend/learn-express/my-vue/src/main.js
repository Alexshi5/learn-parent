// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//import axios from 'axios'

import apiConfig from '../config/api.config'

import Axios from 'axios'
import VueAxios from 'vue-axios'


require('./mock'); //引入mock数据，关闭则注释该行

Vue.use(VueAxios, Axios)
Axios.defaults.baseURL = apiConfig.baseUrl

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
});

//var url="http://localhost:3000";
/*Axios.get('/test')
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });*/

//访问mock模拟数据
Axios.get('http://localhost:8080/test001')
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
