webpackJsonp([7],{JAmA:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o={data:function(){return{loadId:"",headers:{"Content-Type":"multipart/form-data"},imageUrl:"",fileList:[],time:"",postTime:""}},created:function(){var e=sessionStorage.getItem("userId2");this.loadId=e},methods:{uploadFileHandler:function(e){var t=this;console.log(e.words_result[8].words);var r=new Date,o=String(r.getDate()).padStart(2,"0"),s=String(r.getMonth()+1).padStart(2,"0");this.time=r.getFullYear()+"-"+s+"-"+o+" "+r.getHours()+":"+r.getMinutes()+":"+r.getSeconds(),this.postTime=r.getFullYear()+"-"+s+"-"+o,console.log(this.time),e.words_result[8].words===this.loadId?this.$axios.post("/checking/attendance?id="+e.words_result[8].words+"&date="+this.postTime,{}).then(function(r){r&&200===r.data.code?t.$confirm("工号为"+e.words_result[8].words+"的"+e.words_result[4].words+"，您好！</br>您已于"+t.time+"签到成功！</br>好好工作，天天加薪！","签到成功！",{confirmButtonText:"确定",dangerouslyUseHTMLString:!0,cancelButtonText:"取消",type:"success"}):t.$confirm("您今日已签到，谢谢！","签到失败！",{confirmButtonText:"确定",dangerouslyUseHTMLString:!0,cancelButtonText:"取消",type:"warning "})}):this.$confirm("您的工号与登录账号不符，请重试！","签到失败！",{confirmButtonText:"确定",dangerouslyUseHTMLString:!0,cancelButtonText:"取消",type:"error"})},beforeAvatarUpload:function(e){console.log("看看这个",this.fileList);var t="image/jpeg"===e.type,r=e.size/1024/1024<2;return t||this.$message.error("上传头像图片只能是 JPG 格式!"),r||this.$message.error("上传头像图片大小不能超过 2MB!"),this.file},uploadFileErrorHandler:function(e){this.$message.error("上传失败,请检查网络连接")},beforeRemove:function(e,t){this.$confirm("确定移除 "+e.name+"？")}}},s={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("br"),r("br"),e._v(" "),r("el-form",{ref:"editFormRef",attrs:{model:e.editForm,rules:e.editFormRules,"label-width":"80px"}}),e._v(" "),r("el-upload",{staticClass:"upload-demo",attrs:{drag:"",action:"/test/upload",multiple:"","auto-upload":!0,"file-list":e.fileList,"on-success":e.uploadFileHandler,"on-error":e.uploadFileErrorHandler,"before-upload":e.beforeAvatarUpload,"before-remove":e.beforeRemove}},[e.imageUrl?r("img",{staticClass:"avatar",attrs:{src:e.imageUrl}}):e._e(),e._v(" "),r("i",{staticClass:"el-icon-upload"}),e._v(" "),r("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),r("em",[e._v("点击上传")])]),e._v(" "),r("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传jpg文件，且不超过500kb")])])],1)},staticRenderFns:[]},a=r("VU/8")(o,s,!1,null,null,null);t.default=a.exports}});
//# sourceMappingURL=7.ac99e256bad36cbc7039.js.map