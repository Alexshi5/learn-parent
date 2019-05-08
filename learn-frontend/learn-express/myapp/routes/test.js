var express = require('express');
var router = express.Router();

var axios = require('axios');

/* GET users listing. */
router.get('/', function(req, res, next) {

    var url = "http://localhost:8090/api/hello";
    axios.get(url)
        .then(function (response) {
            //console.log(response);
            console.log(req.app.get('env'));
            res.send(response.data);
        })
        .catch(function (error) {
            //console.log(error);
        });
});

/*router.get("/", function(req, res, next) {
    var data={
        code:0,
        data:{name:'aaa',pwd:'123'},
        isSuccess:true,
        msg:"请求成功"
    };
    res.json(data);

});*/

module.exports = router;