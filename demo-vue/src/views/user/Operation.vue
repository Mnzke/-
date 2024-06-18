<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>操作业务</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card class="center-card1">
      <el-card class="estimate-box">
        <span class="card-title">填写记录</span>
        <p><el-radio v-model="radio" :label="1">血糖值</el-radio></p>
        <p><el-radio v-model="radio" :label="2">胰岛素</el-radio></p>
        <p><el-radio v-model="radio" :label="3" @change="waringMsg">并发症</el-radio></p>
        <p style="margin-top: 20px">
          <span>病症描述(数值/症状)</span>
          <el-input
            placeholder="请输入内容"
            v-model="tempDescription" style="width: 200px;margin-bottom: 10px" clearable>
          </el-input>
        </p>
        <p style="margin-top: 20px">
          <el-button type="primary" @click="addEstimate">提交记录</el-button>
        </p>
      </el-card>
      <el-card class="estimate-box">
        <!--<el-button @click="getEstimateList"></el-button>-->
        <el-table :data="bloodSugarList" border max-height="350" style="width: 100%">
          <el-table-column
            prop="symptomDescription"
            label="血糖值"
            width="80px">
          </el-table-column>
          <el-table-column
            prop="updateTime"
            label="记录时间"
            width="150">
          </el-table-column>
        </el-table>
      </el-card>
      <el-card class="estimate-box">
        <el-table :data="insulinList" border max-height="350" style="width: 100%">
          <el-table-column
            prop="symptomDescription"
            label="胰岛素"
            width="80px">
          </el-table-column>
          <el-table-column
            prop="updateTime"
            label="记录时间"
            width="150">
          </el-table-column>
        </el-table>

      </el-card>
      <el-card class="estimate-box">
        <el-table :data="complicationList" border max-height="350" style="width: 100%">
          <el-table-column
            prop="symptomDescription"
            label="并发症"
            width="80px">
          </el-table-column>
          <el-table-column
            prop="updateTime"
            label="记录时间"
            width="150">
          </el-table-column>
        </el-table>
      </el-card>
      <div>
        <el-button @click="estimateDialogVisible=true">生成评估报告</el-button>
      </div>

      <div>
        <el-col :span="8">
          <el-card shadow="hover" class="image-box" :body-style="{ padding: '0px' }">
            <img src="../../assets/img/门诊随访.jpg" class="image">
            <div style="padding: 20px">
              <span>门诊随访</span>
              <p style="float: right">
                <el-button @click="modifyActivity(3)" type="text" size="medium">参加</el-button></p>
            </div>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card shadow="hover" class="image-box" :body-style="{ padding: '0px' }">
            <img src="../../assets/img/扩展活动.jpg" class="image">
            <div style="padding: 20px">
              <span>扩展活动</span>
              <p style="float: right">
                <el-button @click="modifyActivity(5)" type="text" size="medium">参加</el-button></p>
            </div>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card shadow="hover" class="image-box" :body-style="{ padding: '0px' }">
            <img src="../../assets/img/科研招募.jpg" class="image">
            <div style="padding: 20px">
              <span>科研招募</span>
              <p style="float: right">
                <el-button @click="modifyActivity(8)" type="text" size="medium">参加</el-button></p>
            </div>
          </el-card>
        </el-col>

      </div>


    </el-card>
    <el-dialog :visible.sync="estimateDialogVisible"
               width="30%"
               @close="estimateDialogClosed">
    </el-dialog>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Operation",
  data(){
    return{
      tempBSL:'',
      tempGrowth:'',//暂存成长积分
      tempRedeemable:'',//暂存可兑积分
      estimateDialogVisible:false,
      bloodSugarList:[],//血糖记录列表
      insulinList:[],//胰岛素记录列表
      complicationList:[],//并发症记录列表
      radio:'',// 选择哪个病症填写
      tempDescription:'',//暂存病症描述
      activityId:'',//活动id
      activityOutpatient:'',//门诊随访
      activityExtension:'',//扩展活动
      activityScience:'',//科研招募
      sptmDspt:[{symptomSituation:"1"},{symptomSituation:"2"},{symptomSituation:"3"}],
      addForm:{
        userId:'',
        symptomDescription:'',
        symptomSituation:'',
        updateTime:'',
      }
    }
  },
  created() {
    this.getEstimateList()
    this.getUserGp()
    this.getActivity()
  },
  methods:{
    //更新成长积分
    modifyRedeemablePoints(n){
      let a=window.localStorage.getItem("user_id")
      axios.post('/user/update',{id:a,redeemablePoints:Number(this.tempRedeemable+n)})
      this.getUserGp()
    },
    getActivity(){
      let  _this=this;
      axios.post('/activity/list',{user:Number(window.localStorage.getItem("user_id"))})
        .then((res)=>{
          _this.activityId=res.data.data[0].id
          _this.activityCreateTime=res.data.data[0].createTime
          _this.activityOutpatient=res.data.data[0].outpatient
          _this.activityExtension=res.data.data[0].extension
          _this.activityScience=res.data.data[0].science
          console.log("血糖",_this.activityExtension);
        })
    },
    modifyActivity(n){
      if(n === 3){
        axios.post('/activity/update',{id:Number(this.activityId),outpatient:Number(this.activityOutpatient+1)})
          .then((res)=>{
            this.$message({
              message: "完成门诊随访，可兑积分+"+n,
              type: "success",
            });
            this.modifyRedeemablePoints(n)
            this.getActivity()
          })
      }else if(n === 5){
        axios.post('/activity/update',{id:Number(this.activityId),extension:Number(this.activityExtension+1)})
          .then((res)=>{
            this.$message({
              message: "参加扩展活动，可兑积分+"+n,
              type: "success",
            });
            this.modifyRedeemablePoints(n)
            this.getActivity()
          })
      }else if(n === 8){
        axios.post('/activity/update',{id:Number(this.activityId),science:Number(this.activityScience+1)})
          .then((res)=>{
            this.$message({
              message: "参加科研招募，可兑积分+"+n,
              type: "success",
            });
            this.modifyRedeemablePoints(n)
            this.getActivity()
          })
      }
    },
    estimateDialogClosed(){
      this.estimateDialogVisible=false;
    },
    waringMsg(){
      this.$confirm('并发症记录一般每年填写1次,请谨慎填写', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
    },
    getUserGp(){
      axios.post('/user/info?id='+Number(window.localStorage.getItem("user_id")))
        .then(res=>{
          console.log("res:",res)
          if (res.data.code === 200) {
            this.tempGrowth=res.data.data.growthPoints
            this.tempRedeemable=res.data.data.redeemablePoints

          }
        })
    },
    modifyGrowthPoints(m){
      let user = this.$store.state.user;
      axios.post('/user/update',{id:user.id,growthPoints:Number(this.tempGrowth+m)})
        .then((res) => {
          if (res.data.code === 200) {
            this.$message({
              message: "成长积分+"+m,
              type: "success",
            });
            this.getEstimateList()
            this.getUserGp()
          }
        })
    },

    getEstimateList(){
      let _this=this;
      this.bloodSugarList=[];
      this.insulinList=[];
      this.complicationList=[];
      for (let i=0;i<3;i++){
        axios.post('/estimate/list',{userId:Number(window.localStorage.getItem("user_id")),situation:_this.sptmDspt[i].symptomSituation})
          .then((res)=>{
            for(let j=0;j<res.data.data.length;j++){
              if(res.data.data[j].symptomSituation === "1"){
                _this.bloodSugarList.push(res.data.data[j])
              }else if(res.data.data[j].symptomSituation === "2"){
                _this.insulinList.push(res.data.data[j])
              }else if(res.data.data[j].symptomSituation === "3"){
                _this.complicationList.push(res.data.data[j])
              }
            }
            _this.tempBSL=_this.bloodSugarList.length;
            console.log("血糖",_this.bloodSugarList)
          })
      }

    },
    addEstimate(){
      let _this=this;
      if(this.radio===1){
        if(parseInt(this.tempDescription)){
          this.addForm.userId=window.localStorage.getItem("user_id")
          this.addForm.symptomSituation=this.radio;
          this.addForm.symptomDescription=this.tempDescription;
          this.addForm.updateTime=new Date().toLocaleString()
          axios.post('/estimate/add',this.addForm)
            .then((res) => {
              if (res.data.code === 200) {
                this.radio='';
                this.tempDescription='';
                this.$message({
                  message: "添加记录成功",
                  type: "success",
                });

                this.getEstimateList();

                //血糖记录大于3，成长积分+1
                if(this.tempBSL === 2){
                  this.modifyGrowthPoints(1);
                }
              }
            })
        }else {
          this.$message.error('无法提交，血糖值必须是数字');
        }
      }
      else if(this.radio===2){
        if(parseInt(this.tempDescription)){
          //第一次添加胰岛素记录，直接成长积分+2
          if(this.insulinList.length === 0){
            this.modifyGrowthPoints(2)
          }else{
            //三个月周期内计算一次，成长积分+2
            let y1=Number(this.insulinList.length)-1//最近一条胰岛素记录的位置
            let y2=new Date(this.insulinList[y1].updateTime).getTime()//最近一条并发症记录的时间
            let y3=new Date().getTime()//当前时间
            console.log("y2,y3",y2,y3)
            if(y3-y2>=1000*60*60*24*90){
              this.modifyGrowthPoints(2)
            }else{

            }
          }
          this.addForm.userId=window.localStorage.getItem("user_id")
          this.addForm.symptomSituation=this.radio;
          this.addForm.symptomDescription=this.tempDescription;
          this.addForm.updateTime=new Date().toLocaleString()
          axios.post('/estimate/add',this.addForm)
            .then((res) => {
              if (res.data.code === 200) {
                this.radio='';
                this.tempDescription='';
                this.$message({
                  message: "添加记录成功",
                  type: "success",
                });
                /*
                this.getEstimateList();
                 */
              }
            })
        }else {
          this.$message.error('无法提交，胰岛素值必须是数字');
        }
      }
      else if(this.radio===3){
        //第一次添加并发症记录，直接成长积分+3
        if(this.complicationList.length === 0){
          this.modifyGrowthPoints(3)
        }else{
          //一年周期内第一次填写并发症，成长积分+3
          let a=Number(this.complicationList.length)-1//最近一条并发症记录的位置
          let x1=new Date(this.complicationList[a].updateTime).getTime()//最近一条并发症记录的时间
          let b=new Date().getFullYear()+ "-01"  + "-01"//获取每年的年初
          let x2=new Date(b).getTime()//今年是哪年
          console.log("x1,x2",x1,x2)
          if(x1-x2<=0){
            this.modifyGrowthPoints(3)
          }else{
            this.$message.error("近一年内已提交过并发症记录")
          }
        }
        this.addForm.userId=Number(window.localStorage.getItem("user_id"))
        this.addForm.symptomSituation=this.radio;
        this.addForm.symptomDescription=this.tempDescription;
        this.addForm.updateTime=new Date().toLocaleString()
        axios.post('/estimate/add',this.addForm)
          .then((res) => {
            if (res.data.code === 200) {
              this.radio='';
              this.tempDescription='';
              this.$message({
                message: "添加记录成功",
                type: "success",
              });

              /*
              this.getEstimateList();
               */
            }
          })

      }


    }
  },




}
</script>

<style scoped>
.center-card1{
  margin-top: 20px;
  width: 1100px;
  height: 1000px;
}
.estimate-box{
  padding: 0;
  display: inline-block;
  /*border: red 1px solid;*/
  margin-top: 20px;
  margin-right: 20px;
  width: 238px;
  height: 400px;
}
.card-title{
  font-size: 25px;
  font-weight: bold;
}

.image-box{
  display: inline-block;
  margin-top: 20px;
  margin-right: 20px;
  width: 330px;
  height: 400px;
}
.image{
  width: 328px;
  display: block;
  border: #cac6c6 1px solid;
}
</style>
