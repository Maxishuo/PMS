<template>
    <el-container style="height: 700px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1', '3']">
                <el-menu-item index="1" @click = home>首页</el-menu-item>
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-message"></i>个人中心</template>
                    <el-menu-item-group>
                        <el-menu-item index="1-1" @click = userProfile>个人资料</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-menu"></i>添加记录</template>
                    <el-menu-item-group>
                        <el-menu-item index="2-1">填写健康信息</el-menu-item>
                        <el-menu-item index="2-2" @click = activityadd>参加活动</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>查看</el-dropdown-item>
                        <el-dropdown-item>新增</el-dropdown-item>
                        <el-dropdown-item>删除</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>王小虎</span>
            </el-header>

            <el-main>
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item >
                        <el-radio-group v-model="form.health" @change = "handleRadioChange">
                            <el-radio label="并发症" ></el-radio>
                            <el-radio label="血糖" ></el-radio>
                            <el-radio label="胰岛素" ></el-radio>
                            <el-input v-model="form.num" autocomplete="off"></el-input>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item >
                        <el-button type="primary" @click.native="submitToBackend">确定</el-button>
                    </el-form-item>
                </el-form>
                <el-table
                        :data="tableData"
                        style="width: 100%">
                    <el-table-column
                            prop="type"
                            label="类型"
                            width="400">
                    </el-table-column>
                    <el-table-column
                        prop="num"
                        label="数值"
                        width="400">
                    </el-table-column>
                    <el-table-column
                            prop="date"
                            label="时间">
                    </el-table-column>
                </el-table>
            </el-main>
        </el-container>
    </el-container>

</template>

<script>
import {UserHealth} from "@/api/record";

export default {
    data() {
        return {
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                health: '',
                desc: '',
                num: ''
            },
            param:{
                id:0,
                Health:''
            },
            tableData: []
        }
    },
    methods: {

        login(){
            this.$router.push('/');
        },
        home(){
          this.$router.push("/home")
        },
        userProfile(){
            this.$router.push('/information')
        },
        healthadd(){
            this.$router.push('/Healthadd')
        },
        activityadd(){
            this.$router.push('/Activityadd')
        },
        submitToBackend() {
            // alert(this.param.id)
            this.param.id = this.$store.getters.getId
            // alert(this.param.id)
            UserHealth(this.param).then(res => {
                // alert(JSON.stringify(res))
                if(res.code == 1) {
                    this.$message.success('填写成功')
                    this.tableData.push({
                        type: this.form.health,
                        num: this.form.num,
                        date: this.getNowDate()
                    })
                }else{
                    this.$message.error('填写失败');
                }
            });
        },
        handleRadioChange(){
            if (this.form.health == "并发症"){
                this.param.Health = 1
                // alert(this.param.Health)
            }else if(this.form.health == "血糖")
            {
                this.param.Health = 2
                // alert(this.param.Health)
            }else {
                this.param.Health = 3
                // alert(this.param.Health)
            }
        },
        getNowDate() {
            var myDate = new Date;
            var year = myDate.getFullYear(); //获取当前年
            var mon = myDate.getMonth() + 1; //获取当前月
            var date = myDate.getDate(); //获取当前日
            var hours = myDate.getHours(); //获取当前小时
            var minutes = myDate.getMinutes(); //获取当前分钟
            var seconds = myDate.getSeconds(); //获取当前秒
            var now = year + "-" + mon + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
            return now;
        },
        getTimestamp() {
            return new Date(this.getNowDate()).getTime();
        }

    }
}
</script>
<style>
.el-header {
    background-color: rgb(57,167,176);
    color: #333;
    line-height: 60px;
}
</style>