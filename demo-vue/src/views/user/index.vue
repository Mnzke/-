<template>
  <el-row>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
    </el-breadcrumb>
    <el-col :span="8" :key="o" style="margin-top: 20px">
      <el-card class="box-card">
        <img
          src="../../assets/img/NanJing.jpg"
          class="image"
        />
      </el-card>
    </el-col>
  </el-row>
</template>

<style>

.image {
  width: 100%;
  display: block;
}
.box-card{
  width: 810px;
  height: 570px;
  padding: 0;
}
</style>

<script>
import axios from "axios";

export default {

  data() {
    return {
      currentDate: new Date(),
      teptGp:'',//暂存成长积分
      teptFirstLog:'',//暂存近日登陆时间
    };
  },
  created() {
    //window.location.reload();
    let user = this.$store.state.user;
    console.log("Date",new Date().toLocaleDateString())
    //每日首次登陆，积分加一
    /*

    new Date(new Date().toLocaleDateString()).getTime()-new Date(new Date(user.firstLog).toLocaleDateString()).getTime()>0
    这个作用是判断上一个首次登陆时间是不是昨天，是的话把首次登录更新为今天

     */
    if(user.firstLog === null || new Date(new Date().toLocaleDateString()).getTime()-new Date(new Date(this.teptFirstLog).toLocaleDateString()).getTime()>0){
      axios.post('/user/update',{id:user.id,firstLog:new Date().toLocaleString(),growthPoints:Number(this.teptGp+1)})
        .then((res) => {
          console.log("+1",user.growthPoints)
          if (res.data.code === 200) {
            this.$message({
              message: "今日首次登陆，成长积分加1",
              type: "success",
            });
            this.getUserInfo1();
          }
        })
    }
  },
  methods:{
    getUserInfo1(){
      axios.post('/user/info?id='+this.$store.state.user.id)
        .then(res=>{
          console.log("res:",res)
          if (res.data.code === 200) {
            this.teptGp=res.data.data.growthPoints
            this.teptFirstLog=res.data.data.firstLog
          }
        })
    },
  }
};
</script>
