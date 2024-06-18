<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户中心</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card class="center-card">
      <el-card class="box1-card">
        <img
          src="../../assets/img/portrait.jpg"
          class="portrait-image"
        />
      </el-card>
      <div style="float: left;margin-top: 20px">
        <table border="1px">
          <tr>
            <th width="100px">姓名</th>
            <th width="200px">{{this.userList.userName}}</th>
            <th width="300px">等级</th>
          </tr>
          <tr>
            <th>姓别</th>
            <th>{{this.userList.sex}}</th>
            <th>
              <el-tag v-if="this.userList.growthPoints>=0 && this.userList.growthPoints<=10 " type="danger">C</el-tag>
              <el-tag v-if="this.userList.growthPoints>=11 && this.userList.growthPoints<=25 " type="success">B</el-tag>
              <el-tag v-if="this.userList.growthPoints>25">A</el-tag>
            </th>
          </tr>
          <tr>
            <th>修改时间</th>
            <th>{{this.userList.registrationTime}}</th>
          </tr>
          <tr>
            <th>成长积分</th><th>{{this.userList.growthPoints}}</th>
            <th>可兑积分清空(一年)</th>
          </tr>
          <tr>
            <th>可兑积分</th><th>{{this.userList.redeemablePoints}}</th>
            <th>{{this.activityCreateTime}}</th>
          </tr>
        </table>

        <div>
          <!--修改按钮-->
          <el-button
            type="primary"
            size="mini"
            icon="el-icon-edit"
            @click="showEditDialog()"
          ></el-button>
        </div>
        <el-button v-if="this.bloodSugarList1.length>=10&&infoDisable===false"
                   @click="estimateDialogVisible=true">生成评估报告</el-button>
      </div>
    </el-card>

    <!--评估报告对话框-->
    <el-dialog :visible.sync="estimateDialogVisible"
               width="30%">
    </el-dialog>


    <!--修改用户的对话框-->
    <el-dialog title="修改个人资料" :visible.sync="editDialogVisible" width="30%">
      <p>(首次完善个人资料，成长积分+2)</p>
      <!--内容主体区域-->
      <el-form :model="editForm" label-width="70px">
        <el-form-item label="账号" prop="loginName">
          <el-input v-model="editForm.loginName" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="userName">
          <el-input v-model="editForm.userName"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-input v-model="editForm.sex"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="editForm.password"></el-input>
        </el-form-item>
      </el-form>
      <!--底部按钮区域-->
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="editInfo">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>
<script>
import axios from "axios";

import {  userUpdate} from "@/api/user";
export default {
  name: "UserCenter",
  data () {
    return {
      activityCreateTime:'',//活动创建时间
      estimateDialogVisible:false,//评估表是否可见
      bloodSugarList1:[],//血糖记录表
      infoDisable:'',//个人资料是否有空白
      userList:[],
      userID:Number(window.localStorage.getItem("user_id")),
      editDialogVisible: false, // 控制修改用户信息对话框是否显示
      editForm: []
    }
  },
  created() {
    this.getUserInfo();
    this.getEstimateForm();
    this.getActivity();
  },
  methods:{

    estimateDialogClosed(){
      this.estimateDialogVisible=false;
    },
    getEstimateForm(){
      let _this=this;
      this.bloodSugarList1=[];
      axios.post('/estimatest',{userId:Number(window.localStorage.getItem("user_id")),situation:"1"})
        .then((res)=>{
          console.log("res12",res)
            for(let i=0;i<res.data.data.length;i++){
                _this.bloodSugarList1.push(res.data.data[i])
            }
            console.log("血糖",_this.bloodSugarList1);
        })
    },
    // 监听 修改用户状态
    showEditDialog() {
      this.editDialogVisible = true;
      this.editForm=this.userList;
      console.log("editForm:",this.editForm)
    },
    getUserInfo(){
      axios.post('/user/info?id='+this.userID)
        .then(res=>{
          console.log("res:",res)
          if (res.data.code === 200) {
            this.userList=res.data.data
            if (res.data.data.sex!==null){
              this.infoDisable=false;//个人资料没有空白，就是false
            }
          }
          console.log("userList:",this.userList)
        })
    },
    createActivyty(){
      axios.post('/activity/add',{userId:Number(window.localStorage.getItem("user_id")),createTime:new Date().toLocaleString()})
    },
    //可兑积分满一年，清零所有活动记录
    zeroActivity(){
        axios.post('/activity/update', {id: Number(this.activityId), outpatient:0,extension:0,science:0})
      },
        getActivity(){
      let  _this=this;
      axios.post('/activityst',{user:Number(window.localStorage.getItem("user_id"))})
        .then((res)=>{
          //console.log("res12",res)
          let a=new Date(res.data.data[0].createTime).getTime()+1000*60*60*24*366
          _this.activityCreateTime=new Date(a).toLocaleDateString()
          //当前时间超过清零时间，把所有活动记录清空
          if(new Date().getTime()-a>=0){
            this.zeroActivity()
          }
        })
    },
//修改用户
    editInfo() {
      if(this.editForm.registrationTime === null){
        //首次填写个人资料获得2个成长积分
        this.editForm.growthPoints+=2;
        this.createActivyty()
      }
      this.editForm.registrationTime=new Date().toLocaleString();
      axios.post('/user/update',this.editForm)
        .then((res) => {
          if (res.data.code === 200) {
            this.editDialogVisible = false;
            this.getUserInfo();
            this.$message({
              message: "修改信息成功",
              type: "success",
            });
          } else {
            this.$message.error("修改信息失败");
          }
        })
        .catch((err) => {
          this.$message.error("修改用户异常");
          console.log(err);
        });
    },
  },
}
</script>

<style scoped>
.center-card{
  margin-top: 20px;
  width: 1000px;
  height: 500px;
  padding: 0;
}
.box1-card{
  width: 240px;
  height: 240px;
}
.portrait-image {
  width: 200px;
  height: 200px;
  display: block;
}

</style>
