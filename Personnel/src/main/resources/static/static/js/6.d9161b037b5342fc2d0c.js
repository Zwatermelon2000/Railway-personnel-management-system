webpackJsonp([6],{FuCC:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=a("Xxa5"),r=a.n(l),s=a("exGp"),o=a.n(s),i=a("woOf"),n=a.n(i),d=a("bOdI"),c=a.n(d),u=a("69NM"),p=a("7+uW"),m=a("ZQ6q"),h=a.n(m),f={job:"人事管理",sex:"男"},g=new p.default,b={components:{SearchBar:u.a},computed:{username:function(){return h.a.get("id")}},data:function(){var e;return{calendar:0,click:"all",myCommand:"",currentPage:1,drawer:!1,direction:"rtl",edit:!1,index:-1,keywords:"",titleName:"编辑",isShow:!0,pages:{pageNum:1,pageSize:10},totalPages:0,role:{job:"",id:"",name:"",sex:"",mail:"",phone:"",idCard:"",card:"",address:"",attendance:"",birthday:"",calendarData:[],today:new Date},list:{radio:"1"},rules:{name:[{required:!0,message:"请输入姓名",trigger:"blur"},{min:2,max:10,message:"长度在 2 到 10 个字符",trigger:"blur"}],idCard:[{required:!0,message:"请输入身份证号",trigger:"blur"},{min:18,max:18,message:"长度为18个数字",trigger:"blur"}],mail:[{required:!0,message:"请输入邮箱",trigger:"blur"},{validator:function(e,t,a){!1===/^\w{1,64}@[a-z0-9\-]{1,256}(\.[a-z]{2,6}){1,2}$/i.test(t)?a(new Error("邮箱格式错误")):a()},trigger:"blur"}],phone:[{required:!0,message:"请输入手机号码",trigger:"blur"},{validator:function(e,t,a){!1===/^1[34578]\d{9}$/.test(t)?a(new Error("手机号格式错误")):a()},trigger:"blur"}],staff:[{required:!0,message:"请选择管理权限",trigger:"blur"}],sex:[{required:!0,message:"请选择性别",trigger:"blur"}],job:[{required:!0,message:"请选择职务",trigger:"blur"}],card:[{required:!0,message:"请输入银行卡号",trigger:"blur"}]},routes:[],rolesList:[(e={id:"",calendarData:[],today:new Date,job:"1"},c()(e,"id","111111"),c()(e,"name","111"),c()(e,"sex","1"),c()(e,"mail","1"),c()(e,"phone","1"),c()(e,"idCard","1"),c()(e,"card","1"),c()(e,"address","1"),c()(e,"attendance","1"),c()(e,"birthday","1"),e)],dialogVisible:!1,dialogType:"edit",checkStrictly:!1}},mounted:function(){this.initStaff()},methods:{handleSizeChange:function(e){console.log("每页 "+e+" 条"),this.pages.pageSize=e,"search"===this.click?g.$emit("searchAll"):"command"==this.click?g.$emit("searchJob"):this.initStaff()},handleCurrentChange:function(e){this.currentPage=e,console.log("当前页: "+e),this.pages.pageNum=e,"search"===this.click?g.$emit("searchAll"):"command"==this.click?g.$emit("searchJob"):this.initStaff()},initStaff:function(){var e=this;this.$axios.post("/staff/page?page="+this.pages.pageNum+"&size="+this.pages.pageSize).then(function(t){t&&200===t.data.code&&(e.rolesList=t.data.data.list,e.totalPages=t.data.data.total)})},handleCommand:function(e){var t=this;this.myCommand=e,console.log(this.$refs.searchBar.keywords),this.click="全部"===e?"all":"command",g.$on("searchJob",function(){console.log("in command");var a=t;console.log(e),t.$axios.post("/staff/search?job="+e+"&page="+t.pages.pageNum+"&size="+t.pages.pageSize+"&keywords="+t.$refs.searchBar.keywords,{}).then(function(e){e&&200===e.data.code&&(a.rolesList=e.data.data.list,a.totalPages=e.data.data.total)})}),this.pages.pageNum=1;var a=this;console.log("out command"),this.$axios.post("/staff/search?job="+e+"&page="+this.pages.pageNum+"&size="+this.pages.pageSize+"&keywords="+this.$refs.searchBar.keywords,{}).then(function(e){e&&200===e.data.code&&(a.rolesList=e.data.data.list,a.totalPages=e.data.data.total)})},searchResult:function(){var e=this;this.click="search",g.$on("searchAll",function(){var t=e;e.$axios.get("/staff/search?keywords="+e.$refs.searchBar.keywords+"&page="+e.pages.pageNum+"&size="+e.pages.pageSize+"&job="+e.myCommand,{}).then(function(e){e&&200===e.data.code&&(t.rolesList=e.data.data.list,t.totalPages=e.data.data.total)})}),this.pages.pageNum=1;var t=this;this.$axios.get("/staff/search?keywords="+this.$refs.searchBar.keywords+"&page="+this.pages.pageNum+"&size="+this.pages.pageSize+"&job="+this.myCommand,{}).then(function(e){e&&200===e.data.code&&(t.rolesList=e.data.data.list,t.totalPages=e.data.data.total)})},handleAddRole:function(){this.role=n()({},f),this.$refs.tree&&this.$refs.tree.setCheckedNodes([]),this.isShow=!1,this.dialogType="new",this.titleName="添加用户",this.dialogVisible=!0},refreshing:function(){location.reload()},resetForm:function(e){this.$refs[e].resetFields()},openDrawer:function(e){var t=this;this.calendar=1,this.drawer=!0;var a=this,l=null;this.$axios.post("/staff/view?id="+e,{}).then(function(r){r&&200===r.data.code&&(a.role=r.data.data,console.log("_this.id="+a.id),console.log(e),a.id=e,console.log(t.id),t.$axios.all([t.$axios.post("/checking/count?id="+t.id,{}),t.$axios.post("/checking/all?id="+t.id,{})]).then(t.$axios.spread(function(e,r){if(e.data&&200===e.data.code&&(l=e.data.data,console.log("_count1="+l)),console.log("_count2="+l),r.data&&200===r.data.code)for(var s=0;s<l;s++)a.calendarData.push({day:[],status:"✔️"}),a.calendarData[s].day[0]=r.data.data[s].date;t.calendar=2})).catch(function(e){return console.log("Error: ",e)}))}),a.id="",a.calendarData=[],a.today=new Date},handleEdit:function(e){var t=this;this.$axios.post("/staff/detail?id="+e,{}).then(function(e){e&&200===e.data.code&&(t.role=e.data.data)}),this.isShow=!0,this.titleName="编辑信息",this.dialogVisible=!0,this.dialogType="edit"},handleDelete:function(e){var t=this;this.$confirm("确定删除此条信息吗?","警告",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(o()(r.a.mark(function a(){return r.a.wrap(function(a){for(;;)switch(a.prev=a.next){case 0:t,t.$axios.post("/staff/delete?id="+e,{}).then(function(e){200===e.data.code&&("search"===t.click?g.$emit("searchAll"):"command"===t.click?g.$emit("searchJob"):t.initStaff(),t.$message({type:"success",message:"删除成功!"}))});case 2:case"end":return a.stop()}},a,t)}))).catch(function(e){console.error(e)})},submit:function(e){var t=this;"new"===this.dialogType?this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;var a=t;t.$axios.post("/staff/add?name="+t.role.name+"&sex="+t.role.sex+"&idCard="+t.role.idCard+"&job="+t.role.job+"&phone="+t.role.phone+"&mail="+t.role.mail+"&card="+t.role.card+"&address="+t.role.address,{}).then(function(e){e&&200===e.data.code&&(a.rolesList=e.data.data,a.initStaff());for(var l=0;l<a.rolesList.length&&a.rolesList[l].idCard!=t.role.idCard;l++);console.log("i: ",l),console.log("rolesList[i]: ",a.rolesList[l]),t.$alert("此用户工号为："+a.rolesList[l].id+"</br>默认密码为：88888888","信息",{confirmButtonText:"确定",dangerouslyUseHTMLString:!0,center:!0,callback:function(e){t.$message({type:"success",message:"添加成功"})}}),t.dialogVisible=!1})}):this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;var a=t;t.$axios.post("/staff/edit?id="+t.role.id+"&name="+t.role.name+"&sex="+t.role.sex+"&idCard="+t.role.idCard+"&job="+t.role.job+"&phone="+t.role.phone+"&mail="+t.role.mail+"&card="+t.role.card+"&address="+t.role.address,{}).then(function(e){e&&200===e.data.code&&(a.rolesList=e.data.data)}),t.dialogVisible=!1})}}},v={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticStyle:{"text-align":"left"}},[a("br"),a("br"),e._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:e.handleAddRole}},[e._v("添加")]),e._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:e.refreshing}},[e._v("刷新")]),e._v(" "),a("search-bar",{ref:"searchBar",staticStyle:{width:"300px","margin-left":"10px",float:"right"},on:{onSearch:e.searchResult}}),e._v(" "),a("el-table",{staticStyle:{width:"100%","margin-top":"30px",float:"center","text-align":"center"},attrs:{data:e.rolesList,height:"450px","header-cell-style":{textAlign:"center"}}},[a("el-table-column",{attrs:{label:"工号",width:"100%",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n          "+e._s(t.row.id)+"\n        ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"姓名",width:"130%",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n          "+e._s(t.row.name)+"\n        ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"性别",width:"70%",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n          "+e._s(t.row.sex)+"\n        ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"邮箱",width:"200%",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n          "+e._s(t.row.mail)+"\n        ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"手机号",width:"120%",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n          "+e._s(t.row.phone)+"\n        ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"考勤（本月）",width:"130%",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n          "+e._s(t.row.attendance)+"天\n        ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"职务",width:"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n          "+e._s(t.row.job)+"\n        ")]}}])},[a("template",{slot:"header"},[a("el-dropdown",{attrs:{trigger:"click"},on:{command:e.handleCommand}},[a("span",{staticClass:"el-dropdown-link",staticStyle:{color:"#909399"}},[e._v("\n                职务"),a("i",{staticClass:"el-icon-arrow-down el-icon--right el-icon--right"})]),e._v(" "),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",{attrs:{command:"全部"}},[e._v("全部")]),e._v(" "),a("el-dropdown-item",{attrs:{command:"普通职员"}},[e._v("普通职员")]),e._v(" "),a("el-dropdown-item",{attrs:{command:"财务管理"}},[e._v("财务管理")]),e._v(" "),a("el-dropdown-item",{attrs:{command:"铁路管理"}},[e._v("铁路管理")]),e._v(" "),a("el-dropdown-item",{attrs:{command:"用户管理"}},[e._v("用户管理")]),e._v(" "),a("el-dropdown-item",{attrs:{command:"人事管理"}},[e._v("人事管理")])],1)],1)],1)],2),e._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(a){return e.openDrawer(t.row.id)}}},[e._v("详情")]),e._v(" "),a("el-button",{attrs:{type:"primary",plain:"",size:"small"},on:{click:function(a){return e.handleEdit(t.row.id)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{type:"danger",plain:"",size:"small"},on:{click:function(a){return e.handleDelete(t.row.id)}}},[e._v("删除")]),e._v(" "),a("el-drawer",{staticStyle:{float:"center"},attrs:{title:"详细信息",visible:e.drawer,direction:e.direction,size:800},on:{"update:visible":function(t){e.drawer=t}}},[a("el-descriptions",{staticClass:"margin-top",staticStyle:{"margin-left":"80px"},attrs:{labelStyle:{"font-size":"16px","font-weight":"bold"},column:2}},[a("el-descriptions-item",{attrs:{label:"工号"}},[e._v(e._s(e.role.id))]),e._v(" "),a("el-descriptions-item",{attrs:{label:"姓名"}},[e._v(e._s(e.role.name))]),e._v(" "),a("el-descriptions-item",{attrs:{label:"身份证号"}},[e._v(e._s(e.role.idCard))]),e._v(" "),a("el-descriptions-item",{attrs:{label:"生日"}},[e._v(e._s(e.role.birthday))]),e._v(" "),a("el-descriptions-item",{attrs:{label:"考勤（本月）"}},[e._v(e._s(e.role.attendance))]),e._v(" "),a("el-descriptions-item",{attrs:{label:"职务"}},[a("el-tag",{attrs:{size:"medium"}},[e._v(e._s(e.role.job))])],1),e._v(" "),a("el-descriptions-item",{attrs:{label:"性别"}},[e._v(e._s(e.role.sex))]),e._v(" "),a("el-descriptions-item",{attrs:{label:"联系方式"}},[e._v(e._s(e.role.phone))]),e._v(" "),a("el-descriptions-item",{attrs:{label:"邮箱"}},[e._v(e._s(e.role.mail))]),e._v(" "),a("el-descriptions-item",{attrs:{label:"银行卡号"}},[e._v(e._s(e.role.card))]),e._v(" "),a("el-descriptions-item",{attrs:{label:"联系地址"}},[e._v(e._s(e.role.address))])],1),e._v(" "),a("el-calendar",{key:e.calendar,scopedSlots:e._u([{key:"dateCell",fn:function(t){var l=t.data;return[a("p",[e._v(e._s(l.day.split("-").slice(1).join("-"))),a("br"),e._v(" "),a("br")]),e._v(" "),a("p",[e._v(e._s(l.day==e.today?"✔️":""))]),e._v(" "),e._l(e.calendarData,function(t,r){return a("div",{key:r},[l.day==t.day[0]&&l.day!==e.today?a("div",[e._v("\n                    "+e._s(t.status)+"\n                  ")]):e._e()])})]}}],null,!0)})],1)]}}])})],1),e._v(" "),a("el-dialog",{attrs:{title:e.titleName,visible:e.dialogVisible,width:"700px","destroy-on-close":""},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"ruleForm",attrs:{inline:!0,model:e.role,rules:e.rules,"label-width":"80px","label-position":"right"}},[a("el-span",{staticStyle:{color:"#FFF","font-size":"1px"},model:{value:e.role.id,callback:function(t){e.$set(e.role,"id",t)},expression:"role.id"}},[e._v(e._s(e.role.id))]),e._v(" "),a("el-form-item",{attrs:{label:"姓名",prop:"name"}},[a("el-input",{staticStyle:{width:"200px"},attrs:{disabled:e.isShow,placeholder:"请输入姓名"},model:{value:e.role.name,callback:function(t){e.$set(e.role,"name",t)},expression:"role.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"身份证号",prop:"idCard"}},[a("el-input",{staticStyle:{width:"270px"},attrs:{disabled:e.isShow,maxlength:"18",placeholder:"请输入身份证号"},model:{value:e.role.idCard,callback:function(t){e.$set(e.role,"idCard",t)},expression:"role.idCard"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"职务",prop:"job"}},[[a("el-radio",{staticClass:"job",attrs:{label:"人事管理"},model:{value:e.role.job,callback:function(t){e.$set(e.role,"job",t)},expression:"role.job"}}),e._v(" "),a("el-radio",{staticClass:"job",attrs:{label:"财务管理"},model:{value:e.role.job,callback:function(t){e.$set(e.role,"job",t)},expression:"role.job"}}),e._v(" "),a("el-radio",{staticClass:"job",attrs:{label:"铁路管理"},model:{value:e.role.job,callback:function(t){e.$set(e.role,"job",t)},expression:"role.job"}}),e._v(" "),a("el-radio",{staticClass:"job",attrs:{label:"用户管理"},model:{value:e.role.job,callback:function(t){e.$set(e.role,"job",t)},expression:"role.job"}}),e._v(" "),a("el-radio",{staticClass:"job",attrs:{label:"普通职员"},model:{value:e.role.job,callback:function(t){e.$set(e.role,"job",t)},expression:"role.job"}})]],2),e._v(" "),a("el-form-item",{staticStyle:{width:"450px"},attrs:{label:"性别",prop:"sex"}},[[a("el-radio",{staticClass:"sex",attrs:{disabled:e.isShow,label:"男"},model:{value:e.role.sex,callback:function(t){e.$set(e.role,"sex",t)},expression:"role.sex"}},[e._v("男")]),e._v(" "),a("el-radio",{staticClass:"sex",attrs:{disabled:e.isShow,label:"女"},model:{value:e.role.sex,callback:function(t){e.$set(e.role,"sex",t)},expression:"role.sex"}},[e._v("女")])]],2),e._v(" "),a("el-form-item",{attrs:{label:"联系方式",prop:"phone"}},[a("el-input",{staticStyle:{width:"200px"},attrs:{maxlength:"11",placeholder:"请输入联系方式"},model:{value:e.role.phone,callback:function(t){e.$set(e.role,"phone",t)},expression:"role.phone"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"邮箱",prop:"mail"}},[a("el-input",{staticStyle:{width:"270px"},attrs:{placeholder:"请输入邮箱"},model:{value:e.role.mail,callback:function(t){e.$set(e.role,"mail",t)},expression:"role.mail"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"银行卡号",prop:"card"}},[a("el-input",{staticStyle:{width:"230px"},attrs:{placeholder:"请输入银行卡号"},model:{value:e.role.card,callback:function(t){e.$set(e.role,"card",t)},expression:"role.card"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"联系地址",prop:"address"}},[a("el-input",{staticStyle:{width:"240px"},attrs:{autosize:{minRows:2,maxRows:4},type:"textarea",placeholder:"请输入联系地址"},model:{value:e.role.address,callback:function(t){e.$set(e.role,"address",t)},expression:"role.address"}})],1)],1),e._v(" "),a("div",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submit("ruleForm")}}},[e._v("提交")]),e._v(" "),a("el-button",{attrs:{type:"primary",plain:""},on:{click:function(t){return e.resetForm("ruleForm")}}},[e._v("重置")]),e._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取消")])],1)],1),e._v(" "),a("br"),a("br"),e._v(" "),a("div",{staticClass:"block"},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,20,30,40],"page-size":e.pages.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.totalPages},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)},staticRenderFns:[]};var _=a("VU/8")(b,v,!1,function(e){a("eLy1")},"data-v-26dbfe27",null);t.default=_.exports},eLy1:function(e,t){}});
//# sourceMappingURL=6.d9161b037b5342fc2d0c.js.map