new Vue({
    el:"#app",
    data:{
        user:{
            id:"",
            age:"",
            username:"",
            PASSWORD:"",
            email:"",
            sex:"",
        },
        userList:[]
    },
    methods:{
        findAll:function () {
            var _this=this;
            axios.get("/vue/user/findAll.do")
                .then(function (response) {
                    _this.userList=response.data;//响应数据给userlist赋值
                    // $("#tab-model").show();
                    console.log(response);
                })
                .catch();
        },
        update:function (user) {
            var _this=this;
            axios.post("/vue/user/updateUser.do",_this.user)
                .then(function (response) {
                    _this.findAll();//响应数据给userlist赋值
                    console.log(response);
                })
                .catch();
        },
        findById:function (userid) {
            var _this=this;
            axios.get("/vue/user/findById.do",{params:{id:userid}})
                .then(function (response) {
                    _this.user=response.data;//响应数据给user赋值
                    $("#myModal").modal("show");
                    console.log(response);
                })
                .catch();
        }

    },
    created:function () {
        //当页面加载的时候，发起请求，查询所有
        this.findAll();
    }
});