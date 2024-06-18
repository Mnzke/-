
<script>

export default {
  name: "Home",
  data() {
    return {
      navList: [
        { name: "/index", title: "首页", icon: "el-icon-s-home" },
        { name: "/user", title: "用户管理",icon:"el-icon-s-custom" },
        { name: "/user-center", title: "用户中心",icon:"el-icon-user" },
        { name: "/operation", title: "操作业务",icon:"el-icon-s-operation" },
      ],
    };
  },
  created() {
  },
  methods:{
    getName(){
      if(window.localStorage.getItem("user")){
        let user_name=window.localStorage.getItem("user");
        return "在线用户："+user_name.toString();
      }
      else{
        return
      }
    },
  }
};
</script>

<style >
.nav-logo {
  position: absolute;
  padding-top: -1%;
  left: 5%;
  font-size: 40px;
}

.head-title {
  position: absolute;
  padding-top: 20px;
  left: 15%;
  font-size: 20px;
  font-weight: bold;
}

.online-status {
  position: absolute;
  padding-top: 20px;
  left: 85%;
}


</style>



