// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//import axios from 'axios'

//import apiConfig from '../config/api.config'

import Axios from 'axios'
//import VueAxios from 'vue-axios'


//require('./mock'); //引入mock数据，关闭则注释该行

//Vue.use(VueAxios, Axios)
//Axios.defaults.baseURL = apiConfig.baseUrl

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
});

var app2 = new Vue({
  el: '#app2',
  data:{
    username: '小红'
  }
});

//var url="http://localhost:3000";
var url="http://192.168.138.128:3000";
Axios.get(url + '/test')
  .then(function (response) {
    console.log(response);
    //将数据展示到html页面上
    app2.username = response.data.data;
  })
  .catch(function (error) {
    console.log(error);
  });

//访问mock模拟数据
/*Axios.get('http://mock/test001')
  .then(function (response) {
    console.log(response);
    //将数据展示到html页面上
    app2.username = response.data.data.username;
  })
  .catch(function (error) {
    console.log(error);
  });*/
