<template>
    <el-container style="height: 700px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1', '3']">
                <el-menu-item index="1">首页</el-menu-item>
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-message"></i>个人中心</template>
                    <el-menu-item-group>
                        <el-menu-item index="1-1" @click = userProfile>个人资料</el-menu-item>
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
<!--                <div class="demo-image">-->
<!--                    <div class="block" v-for="fit in fits" :key="fit">-->
<!--                        <span class="demonstration">{{ fit }}</span>-->
<!--                        <el-image-->
<!--                            style="width: 100px; height: 100px"-->
<!--                            :src="url"-->
<!--                            :fit="fit"></el-image>-->
<!--                    </div>-->
<!--                </div>-->
<!--                <div class="block">-->
<!--&lt;!&ndash;                    <span class="demonstration">默认 Hover 指示器触发</span>&ndash;&gt;-->
<!--                    <el-carousel height="150px">-->
<!--                        <el-carousel-item v-for="item in 4" :key="item">-->
<!--                            <h3 class="small">{{ item }}</h3>-->
<!--                        </el-carousel-item>-->
<!--                    </el-carousel>-->
<!--                </div>-->
<!--                <div class="block">-->
<!--                    <span class="demonstration"></span>-->
<!--                    <el-carousel trigger="click" height="150px">-->
<!--                        <el-carousel-item v-for="item in 4" :key="item">-->
<!--                            <h3 class="small">{{ item }}</h3>-->
<!--                        </el-carousel-item>-->
<!--                    </el-carousel>-->
<!--                </div>-->
                <el-calendar v-model="value">
                </el-calendar>
            </el-main>
        </el-container>
    </el-container>
</template>


<style>

</style>

<script>
import login from "@/views/login.vue";

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
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            rules:{
                date1: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                date2: [
                    { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
                ]
            },
            formLabelWidth: '120px',
            fits: ['scale-down'],
            url: "D:\\Code\\Web\\ims\\public\\1314617.jpg",
            value: new Date()
        }
    },
    computed: {
        globalId() {
            return this.$store.getters.getId;
        }
    },
    methods: {

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
        }

    }
};
</script>
<style>
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
}

.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}
.el-header {
    background-color: rgb(57,167,176);
    color: #333;
    line-height: 60px;
}
</style>