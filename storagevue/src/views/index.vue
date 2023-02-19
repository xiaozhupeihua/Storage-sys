<template>
    <div>

        <!--标题-->
        <el-form class="title">
            仓库管理系统
        </el-form>

        <!--导航栏设计-->
        <el-form :inline="true" class="demo-form-inline">
            <el-form-item><!--搜索框-->
                <el-input v-model="search" class="search_id" size="mini" aria-placeholder="输入物品编码查询"></el-input>
            </el-form-item>

            <el-form-item><!--搜索按钮-->
                <el-button type="text" @click="onSearch()" class="el-icon-search">查询</el-button>
            </el-form-item>

            <el-form-item><!--刷新按钮-->
                <el-button class="el-icon-refresh" type="text" @click="refreshData">刷新</el-button>
            </el-form-item>

            <el-form-item><!--添加按钮-->
                <el-button class="el-icon-circle-plus-outline" type="text" @click="dialogVisible = true">添加</el-button>
            </el-form-item>

        </el-form>

        <el-table :data="tableData" highlight-current-row border style="width: 100%">

            <el-table-column label="物品ID">
                <!--template 通过scope/slot-scope 属性 调用组件 scope 的属性，以达到可以调用组件属性实现复杂的嵌套-->
                <template slot-scope="scope">
                    <el-popover trigger="hover" placement="right">
                        <p>物品ID: {{ scope.row.id }}</p>
                        <p>物品编码: {{ scope.row.num }}</p>
                        <p>物品名称: {{ scope.row.name }}</p>
                        <p>物品价格: {{ scope.row.price }}</p>
                        <p>物品重量: {{ scope.row.weight }}</p>
                        <p>生产日期: {{ scope.row.produce }}</p>
                        <p>保质期: {{ scope.row.save }}</p>
                        <p>入库时间: {{ scope.row.date }}</p>
                        <p>登记员: {{ scope.row.recorder }}</p>
                        <div slot="reference" class="name-wrapper">
                            <el-button type="text">{{ scope.row.id }}</el-button>
                        </div>
                    </el-popover>
                </template>
            </el-table-column>

            <el-table-column label="物品编码">
                <template slot-scope="scope">
                    <span>{{ scope.row.num }}</span>
                </template>
            </el-table-column>

            <el-table-column label="物品名称">
                <template slot-scope="scope">
                    <span>{{ scope.row.name }}</span>
                </template>
            </el-table-column>

            <el-table-column label="物品价格">
                <template slot-scope="scope">
                    <span>{{ scope.row.price }}</span>
                </template>
            </el-table-column>

            <el-table-column label="物品重量">
                <template slot-scope="scope">
                    <span>{{ scope.row.weight }}</span>
                </template>
            </el-table-column>

            <el-table-column label="生产日期">
                <template slot-scope="scope">
                    <i class="el-icon-time hidden-sm-and-down"></i>
                    <span>{{ scope.row.produce }}</span>
                </template>
            </el-table-column>

            <el-table-column label="保质期">
                <template slot-scope="scope">
                    <span>{{ scope.row.save }}</span>
                </template>
            </el-table-column>

            <el-table-column label="入库时间">
                <template slot-scope="scope">
                    <i class="el-icon-time hidden-sm-and-down"></i>
                    <span>{{ scope.row.date }}</span>
                </template>
            </el-table-column>

            <el-table-column label="登记员">
                <template slot-scope="scope">
                    <span>{{ scope.row.recorder }}</span>
                </template>
            </el-table-column>

            <el-table-column label="操作" fixed="right" width="190">
                <template slot-scope="scope">
                    <el-button size="mini" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">
                        编辑
                    </el-button>
                    <el-button size="mini" icon="el-icon-delete" type="danger" @click="handleDelete(scope.$index, scope.row)">
                        删除
                    </el-button>
                </template>
            </el-table-column>

        </el-table>

        <!--添加对话框开始-->

        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="70px" class="demo-ruleForm" size="medium">
            <el-dialog title="添加" :append-to-body='true' :visible.sync="dialogVisible" width="50%" :before-close="handleClose">
                <el-input type="hidden" v-model="ruleForm.id" />

                <el-form-item label="物品id" prop="id">
                    <el-input v-model="ruleForm.id"></el-input>
                </el-form-item>

                <el-form-item label="物品编码" prop="num">
                    <el-input v-model="ruleForm.num"></el-input>
                </el-form-item>

                <el-form-item label="物品名称" prop="name">
                    <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>

                <el-form-item label="物品价格" prop="name">
                    <el-input v-model="ruleForm.price"></el-input>
                </el-form-item>

                <el-form-item label="物品重量" prop="name">
                    <el-input v-model="ruleForm.weight"></el-input>
                </el-form-item>

                <el-form-item label="生产日期" prop="name">
                    <el-date-picker type="datetime" aria-placeholder="选择日期" v-model="ruleForm.produce" style="width: 100%;">
                    </el-date-picker>
                </el-form-item>

                <el-form-item label="保质期" prop="name">
                    <el-input v-model="ruleForm.save"></el-input>
                </el-form-item>

                <el-form-item label="入库时间" prop="name">
                    <el-date-picker type="datetime" aria-placeholder="选择日期" v-model="ruleForm.date" style="width: 100%;">
                    </el-date-picker>
                </el-form-item>

                <el-form-item label="登记员" prop="name">
                    <el-input v-model="ruleForm.recorder"></el-input>
                </el-form-item>

                <span slot="footer" class="dialog-footer">
                    <el-button @click="cancel()" size="medium">取 消</el-button>
                    <el-button @click="addArticle()" type="primary" size="medium">确 定</el-button>
                </span>

            </el-dialog>
        </el-form>

        <!--添加对话框结束-->

        <!--编辑对话框开始-->

        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="70dx" class="demo-ruleForm" size="medium">
            <el-dialog title="编辑" :append-to-body='true' :visible.sync="dialogUpdate" width="50%" :before-close="handleClose">
                <el-input type="hidden" v-model="ruleForm.id"/>

                <el-form-item label="物品编码" prop="num">
                    <el-input v-model="ruleForm.num"></el-input>
                </el-form-item>

                <el-form-item label="物品名称" prop="name">
                    <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>

                <el-form-item label="物品价格" prop="name">
                    <el-input v-model="ruleForm.price"></el-input>
                </el-form-item>

                <el-form-item label="物品重量" prop="name">
                    <el-input v-model="ruleForm.weight"></el-input>
                </el-form-item>

                <el-form-item label="生产日期" prop="name">
                    <el-date-picker type="datetime" aria-placeholder="选择日期" v-model="ruleForm.produce" style="width: 100%;">
                    </el-date-picker>
                </el-form-item>

                <el-form-item label="保质期" prop="name">
                    <el-input v-model="ruleForm.save"></el-input>
                </el-form-item>

                <el-form-item label="入库时间" prop="name">
                    <el-date-picker type="datetime" aria-placeholder="选择日期" v-model="ruleForm.date" style="width: 100%;">
                    </el-date-picker>
                </el-form-item>

                <el-form-item label="登记员" prop="name">
                    <el-input v-model="ruleForm.recorder"></el-input>
                </el-form-item>

                <span slot="footer" class="dialog-footer">
                    <el-button @click="cancel()" size="medium">取 消</el-button>
                    <el-button @click="updateArticle()" type="primary" size="medium">确 定</el-button>
                </span>
            </el-dialog>
        </el-form>

        <!--编辑对话框结束-->

        <br>
        <div class="pages">
            <!--分页显示-->
            <el-pagination background
                           :disabled="disablePage"
                           :current-page.sync="currentPage" small layout="prev, pager, next"
                           :page-size="pageSize" :total="total" @current-change="handleCurrentChange">
            </el-pagination>
        </div>

    </div>
</template>

<script>
    export default {
        name: "index",
        data() {
            return {
                ruleForm: {
                    id: '',
                    num: '',
                    name: '',
                    price: '',
                    weight: '',
                    produce: '',
                    save: '',
                    date: '',
                    recorder: ''
                },
                rules: {
                    name: [
                        { required: true, message: '请输入物品名称', trigger: 'blur' },
                        { min: 1, max: 10, message: '长度在1到10个字符', trigger: 'blur'}
                    ]
                },
                tableData: [],
                search: '',
                dialogVisible: false,
                dialogUpdate: false,
                pageSize: 5,
                currentPage: 1,
                total: 0,
                disablePage: false
            }
        },

        methods: {

            /*<!--处理编辑的函数-->*/
            handleEdit(index, row) {
                this.dialogUpdate = true;
                this.ruleForm = Object.assign({}, row);
            },

            /*<!--处理删除的函数-->*/
            handleDelete(index, row) {
                console.log(index, row);/*console.log 在控制台上输出信息*/
                console.log("======="+index);
                console.log("======"+row);
                this.$confirm('删除操作，是否继续？','提示',{
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let postData = this.qs.stringify({
                        id: row.id,
                    });
                    this.axios({
                        method: 'post',
                        url:'http://localhost:8081/delete',
                        data:postData
                    }).then(response =>
                    {
                        this.getPages();
                        this.currentPage = 1;
                        this.axios.post('http://localhost:8081/page').then(response =>
                        {
                            this.tableData = response.data;
                        }).catch(error =>
                        {
                            console.log(error);
                        });
                        this.$message({
                            type: 'success!',
                            message: '删除成功!'
                        });
                        console.log(response);
                    }).catch(error =>
                    {
                        console.log(error);
                    });

                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });

            },

            /*<!--处理关闭的函数-->*/
            handleClose(done) {
                this.$confirm('确认关闭？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {});
            },

           /* <!--处理页面改变的函数-->*/
            handleCurrentChange() {
                console.log('当前页: ${this.currentPage}');
                let postData = this.qs.stringify({
                    page: this.currentPage
                });
                this.axios({
                    method: 'post',
                    url: 'http://localhost:8081/page',
                    data:postData
                }).then(response =>
                {
                    this.tableData = response.data;
                }).catch(error =>
                {
                    console.log(error);
                });
            },

            /*<!--取消的函数-->*/
            cancel() {
                this.dialogUpdate = false;
                this.dialogVisible = false;
                this.emptyUserData();
            },

            /*表格清空函数*/
            emptyUserData(){
                this.ruleForm = {
                    id: '',
                    num: '',
                    name: '',
                    price: '',
                    weight: '',
                    produce: '',
                    save: '',
                    date: '',
                    recorder: ''
                }
            },

            addArticle() {//--------------------添加商品操作
                let postData = this.qs.stringify({
                    id: this.ruleForm.id,
                    num: this.ruleForm.num,
                    name: this.ruleForm.name,
                    price: this.ruleForm.price,
                    weight: this.ruleForm.weight,
                    produce: this.ruleForm.produce,
                    save: this.ruleForm.save,
                    date: this.ruleForm.date,
                    recorder: this.ruleForm.recorder
                });
                this.axios({
                    method: 'post',
                    url: 'http://localhost:8081/insert',
                    data: postData
                }).then(response =>
                {
                    this.axios.post('http://localhost:8081/page').then(response =>
                    {
                        this.tableData = response.data;
                        this.currentPage = 1;
                        this.$message({
                            type: 'success!',
                            message: '已添加!'
                        });
                    }).catch(error =>
                    {
                        console.log(error);
                    });
                    this.getPages();
                    this.dialogVisible = false
                    console.log(response);
                }).catch(error =>
                {
                    console.log(error);
                });
            },

            updateArticle() {//-------------------------更新操作
                let postData = this.qs.stringify({
                    id: this.ruleForm.id,
                    num: this.ruleForm.num,
                    name: this.ruleForm.name,
                    price: this.ruleForm.price,
                    weight: this.ruleForm.weight,
                    produce: this.ruleForm.produce,
                    save: this.ruleForm.save,
                    date: this.ruleForm.date,
                    recorder: this.ruleForm.recorder
                });
                this.axios({
                    method: 'post',
                    url: 'http://localhost:8081/update',
                    data: postData
                }).then(response =>
                {
                    this.handleCurrentChange();
                    this.cancel();
                    this.$message({
                        type: 'success!',
                        message: '更新成功!'
                    });
                    console.log(response);
                }).catch(error =>
                {
                    this.$message({
                        type: 'success!',
                        message: '更新失败...'
                    });
                    console.log(error);
                });
            },

            /*<!--查询操作-->*/
            onSearch() {
                let postData = this.qs.stringify({
                    num: this.search
                });
                this.axios({
                    method: 'post',
                    url: 'http://localhost:8081/ListById',
                    data: postData
                }).then(response =>
                {
                    this.tableData = response.data;
                    this.disablePage = true;
                }).catch(error =>
                {
                    console.log(error);
                });
            },

            /*<!--获取页面-->*/
            getPages() {
                this.axios.post('http://localhost:8081/rows').then(response =>
                {
                    this.total = response.data;
                }).catch(error =>
                {
                    console.log(error);
                });
            },

            /*<!--刷新页面-->*/
            refreshData() {
                location.reload();
            }
        },

        /*<!--抓取页面和行数-->*/
        created() {
            this.axios.post('http://localhost:8081/page').then(response =>
            {
                this.tableData = response.data;
            }).catch(error =>
            {
                console.log(error);
            });

            this.axios.post('http://localhost:8081/rows').then(response =>
            {
                this.total = response.data;
            }).catch(error =>
            {
                console.log(error);
            });

        },
    }
</script>

<!--使用 scoped 属性描述元素的样式：-->
<style scoped>

    .title{
        text-align: center;
        font-size:35px;
        color: #8cc5ff;
        font-weight: bold;
    }
    .search_id{
        width: 200px;
    }
    .pages{
        margin: 0px;
        padding: 0px;
        text-align: right;
    }

</style>