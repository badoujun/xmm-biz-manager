var global = new Vue({
    data: {
        token: "",
        username: "",
        catalogList: "",
        menuName: "",
        power_add: 0,
        power_del: 0,
        power_up: 0,
        power_sel: 0
    },
    created: function() {
        this.setMenuOfNow();
        var flag = true;
        var cookieArr = document.cookie.split(";");
        for(var i = 0; i < cookieArr.length; i++){
            var cookie = cookieArr[i].trim().split("=");
            if(cookie[0]=="tokenData"){
                flag = false;
                break;
            }
        }
        if(flag){
            localStorage.removeItem("tokenData");
        }
        var item = localStorage.getItem("tokenData");
        if(item == undefined || item == "undefined"){
            this.locationHref("login");
        }else{
            var obj = JSON.parse(item);
            this.token = obj.token;
            this.username = obj.username;
            this.catalogList = obj.catalogList;
            this.locationHref("index");
        }
        this.setPowers();
    },
    methods: {
        login: function (username, password) {
            $.ajax({
                async : false,
                type : "post",
                url : "/admin/login",
                data: {
                    username: username,
                    pwd: password
                },
                dataType : "json",
                success: function (result) {
                    if(result.statusCode == 1){
                        localStorage.setItem("tokenData", JSON.stringify(result.data));
                        document.cookie = "tokenData=login";
                        location.href = "/index.html";
                    }else{
                        alert(result.message);
                    }
                },
                error:function (result) {
                    alert("功能异常，请联系管理员");
                }
            });
        },
        logout: function () {
            localStorage.removeItem("tokenData");
            location.href = "/login.html";
        },
        locationHref: function (toUrl) {
            if(this.menuName == "index" || this.menuName == "login"){//web
                if(this.menuName.indexOf(toUrl) == -1){
                    location.href = "/" + toUrl + ".html";
                }
            }else{//web-iframe
                if(toUrl == "login"){
                    location.href = "/" + toUrl + ".html";
                }
            }
        },
        setMenuOfNow: function () {
            var url = window.location.href;
            var arr = url.split("/");
            var menu = arr[arr.length - 1];
            this.menuName = menu.substring(0, menu.length - 5);
        },
        setPowers: function () {
            var catalogList = this.catalogList;
            if(catalogList != undefined && catalogList != null && catalogList != ""){
                var menuName = this.menuName;
                var add = 0;
                var del = 0;
                var up = 0;
                var sel = 0;
                $.each(catalogList, function(i1,val1){
                    $.each(val1.menus, function(i2,val2){
                        if(val2.url == menuName){
                            $.each(val2.powers, function(i3,val3){
                                var power = val3.powerEnum.split("_")[1];
                                switch(power){
                                    case "add":
                                        add = 1;
                                        break;
                                    case "del":
                                        del = 1;
                                        break;
                                    case "up":
                                        up = 1;
                                        break;
                                    case "sel":
                                        sel = 1;
                                        break;
                                }
                            });
                        }
                    });
                });
                this.power_add = add;
                this.power_del = del;
                this.power_up = up;
                this.power_sel = sel;
            }
        }
    }
});