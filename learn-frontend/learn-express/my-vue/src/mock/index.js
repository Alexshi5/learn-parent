const Mock = require('mockjs');
//格式： Mock.mock( url, post/get , 返回的数据)；
Mock.mock('http://localhost:8080/test001', 'get', require('./json/test'));
