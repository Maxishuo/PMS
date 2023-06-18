<template>
    <el-container style="height: 700px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1', '3']">
                <el-menu-item index="1" @click = home>首页</el-menu-item>
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-message"></i>个人中心</template>
                    <el-menu-item-group>
                        <el-menu-item index="1-1" >个人资料</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-menu"></i>添加记录</template>
                    <el-menu-item-group>
                        <el-menu-item index="2-1" @click = healthadd>填写健康信息</el-menu-item>
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
<!--                <el-table :data="tableData">-->
<!--                    <el-table-column prop="date" label="日期" width="140">-->
<!--                    </el-table-column>-->
<!--                    <el-table-column prop="name" label="姓名" width="120">-->
<!--                    </el-table-column>-->
<!--                    <el-table-column prop="address" label="地址">-->
<!--                    </el-table-column>-->
<!--                </el-table>-->
                <el-descriptions title="个人信息" direction="vertical" :column="5" border>
                    <el-descriptions-item label="姓名">{{ userInfo.name }}</el-descriptions-item>
                    <el-descriptions-item label="性别">{{ userInfo.sex }}</el-descriptions-item>
                    <el-descriptions-item label="邮箱" :span="2">{{ userInfo.email }}</el-descriptions-item>
                    <el-descriptions-item label="生日">{{ userInfo.birthday }}</el-descriptions-item>
                    <el-descriptions-item label="可兑换积分">{{ userInfo.exchange }}</el-descriptions-item>
                    <el-descriptions-item label="成长积分">{{ userInfo.grows }}</el-descriptions-item>
                    <el-descriptions-item label="总积分">{{ userInfo.total }}</el-descriptions-item>
                    <el-descriptions-item label="等级评分">
                        <el-tag size="small">{{ userInfo.rate }}</el-tag>
                    </el-descriptions-item>
                    <el-descriptions-item label="积分截止日期" :span ="2">{{ userInfo.time }}</el-descriptions-item>

                </el-descriptions>
                <el-button type="text" @click="dialogFormVisible = true">修改个人资料</el-button>

                <el-dialog title="填写个人信息" :visible.sync="dialogFormVisible" >
                    <el-form :model="form" label-width="80px" >
                        <el-form-item label="姓名" style="width: 55%">
                            <el-input v-model="form.name" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="生日" >
                            <el-col :span="11">
                                <el-date-picker type="date" placeholder="选择日期" v-model="form.birthday" style="width: 100%;"></el-date-picker>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="性别" style="width: 55%">
                            <el-select v-model="form.sex" placeholder="请选择性别">
                                <el-option label="男" value="man"></el-option>
                                <el-option label="女" value="woman"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="邮箱" >
                            <el-input v-model="form.email" autocomplete="off"></el-input>
                        </el-form-item>

                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="dialogFormVisible = false">取 消</el-button>
                        <el-button type="primary" @click= reactFun >确 定</el-button>
                    </div>
                </el-dialog>
            </el-main>
        </el-container>
    </el-container>
</template>


<style>
.el-header {
    background-color: rgb(57,167,176);
    color: #333;
    line-height: 60px;
}

.el-aside {
    color: #333;
}
</style>

<script>
import {userProfile ,getUserProfile} from "@/api/userprofile"
import {GetPoint} from "@/api/record"
import {redeemedPoints,ratingFunction} from "@/api/extraequire"

export default {
    data() {
        const item = {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
        };
        return {
            tableData: Array(20).fill(item),
            dialogTableVisible: false,
            dialogFormVisible: false,
            form: {
                name: '',
                sex: '',
                email: '',
                birthday:'',
            },
            userInfo:{
                name:'',
                sex:'',
                email:'',
                exchange:0,
                grows:0,
                total:0,
                birthday:'',
                rate:'',
                time:''
            },
            param:{
               id: 0
            },
            react:{
                id: 0,
                name:'',
                sex:'',
                email:'',
                birthday:'',
            },
            rules:{
                date1: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                date2: [
                    { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
                ]
            },
            formLabelWidth: '120px'
        }
    },
    created() {
        this.param.id = this.$store.getters.getId;
        this.react.id = this.$store.getters.getId;
        this.fetchUserInfo();
    },
    methods: {
        fetchUserInfo() {
            redeemedPoints(this.param).then(res => {
                // alert(JSON.stringify(res))
                if(res.code != 1) {
                    this.$message.error('失败');
                }
            });
            ratingFunction(this.param).then(res => {
                // alert(JSON.stringify(res))
                if(res.code != 1) {
                    this.$message.error('失败');
                }
            });
            getUserProfile(this.param).then(res => {
                // alert(JSON.stringify(res))
                if(res.code == 1) {
                    this.userInfo.name = res.data.name
                    this.userInfo.email = res.data.email
                    this.userInfo.sex = res.data.sex
                    this.userInfo.birthday = res.data.birthday
                }else{
                    this.$message.error('填写失败');
                }
            });
            GetPoint(this.param).then(res => {
                // alert(JSON.stringify(res))
                if(res.code == 1) {
                    this.userInfo.exchange = res.data.exchangeScore
                    this.userInfo.grows = res.data.growScore
                    this.userInfo.total = res.data.totalScore
                    this.userInfo.rate = res.data.rate
                    this.userInfo.time = this.timestampToTime(res.data.exchangeTime /1000)
                }else{
                    this.$message.error('填写失败');
                }
            });


        },
        timestampToTime(timestamp) {
            var date = new Date(timestamp * 1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
            var Y = date.getFullYear() + '-';
            var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1):date.getMonth()+1) + '-';
            var D = (date.getDate()< 10 ? '0'+date.getDate():date.getDate())+ ' ';
            var h = (date.getHours() < 10 ? '0'+date.getHours():date.getHours())+ ':';
            var m = (date.getMinutes() < 10 ? '0'+date.getMinutes():date.getMinutes()) + ':';
            var s = date.getSeconds() < 10 ? '0'+date.getSeconds():date.getSeconds();
            return Y+M+D+h+m+s;
        },
        login(){
            this.$router.push('/');
        },
        userProfile(){
            this.$router.push('/information')
        },
        home(){
            this.$router.push("/home")
        },
        healthadd(){
            this.$router.push('/Healthadd')
        },
        activityadd(){
            this.$router.push('/Activityadd')
        },
        updateInfo(){

            userProfile({
                id: this.$store.getters.getId,
                name:this.form.name,
                sex:this.form.sex,
                email:this.form.email,
                birthday:this.form.birthday,
            }
            ).then(res => {
                if(res.code == 1) {
                    this.$message.success('填写成功')
                    this.fetchUserInfo()

                }else{
                    this.$message.error('填写失败');
                }
            });

        },
        reactFun(){
            this.dialogFormVisible = false
            this.updateInfo()
        }

    }
};
</script>