webpackJsonp([4],{Dxfg:function(t,e){},QTV6:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=a("ZQ6q"),l=a.n(s),n={computed:{username:function(){return l.a.get("id")}},data:function(){return{Selection:[],PassSelection:[],FailSelection:[],role:{id:"",name:"",date:"",isPass:""},routes:[],rolesListAll:[{id:"1",name:"1",date:"1",isPass:"1"}],rolesListPass:[{id:"1",name:"1",date:"1",isPass:"1"}],rolesListFail:[{id:"1",name:"1",date:"1",isPass:"1"}]}},mounted:function(){this.initStaff()},methods:{initStaff:function(){var t=this;this.$axios.post("/apply/transformation"),this.$axios.post("/apply/all?isPass=0").then(function(e){e&&200===e.data.code&&(t.rolesListAll=e.data.data)}),this.$axios.post("/apply/all?isPass=1").then(function(e){e&&200===e.data.code&&(t.rolesListPass=e.data.data)}),this.$axios.post("/apply/all?isPass=-1").then(function(e){e&&200===e.data.code&&(t.rolesListFail=e.data.data)})},handleSelection:function(t){var e=this;this.Selection=[],t&&t.forEach(function(t){t&&e.Selection.push(t.id)}),console.log(this.Selection)},handleSelectionFail:function(t){var e=this;this.FailSelection=[],t&&t.forEach(function(t){t&&e.FailSelection.push(t.id)}),console.log(this.FailSelection)},handleSelectionPass:function(t){var e=this;this.PassSelection=[],t&&t.forEach(function(t){t&&e.PassSelection.push(t.id)}),console.log(this.PassSelection)},check:function(t){var e=this;this.$axios.post("/apply/showPDF?id="+t,{}).then(function(a){e.$message({message:"成功打开pdf",type:"success"}),window.open("http://localhost:8002/apply/showPDF?id="+t)})},back:function(){for(var t=this,e=this,a=0;a<this.Selection.length;a++)this.$axios.post("/apply/update?isPass=-1&id="+this.Selection[a]).then(function(a){a&&200===a.data.code&&(t.$axios.post("/apply/all?isPass=0").then(function(t){t&&200===t.data.code&&(e.rolesListAll=t.data.data)}),t.$axios.post("/apply/all?isPass=-1").then(function(t){t&&200===t.data.code&&(e.rolesListFail=t.data.data)}))});this.$message({message:"成功退回",type:"success"})},pass:function(){for(var t=this,e=this,a=0;a<this.Selection.length;a++)this.$axios.post("/apply/update?isPass=1&id="+this.Selection[a]).then(function(a){a&&200===a.data.code&&(t.$axios.post("/apply/all?isPass=0").then(function(t){t&&200===t.data.code&&(e.rolesListAll=t.data.data)}),t.$axios.post("/apply/all?isPass=1").then(function(t){t&&200===t.data.code&&(e.rolesListPass=t.data.data)}))});this.$message({message:"成功通过",type:"success"})},revocationFail:function(){for(var t=this,e=this,a=0;a<this.FailSelection.length;a++)this.$axios.post("/apply/update?isPass=0&id="+this.FailSelection[a]).then(function(a){a&&200===a.data.code&&(t.$axios.post("/apply/all?isPass=0").then(function(t){t&&200===t.data.code&&(e.rolesListAll=t.data.data)}),t.$axios.post("/apply/all?isPass=-1").then(function(t){t&&200===t.data.code&&(e.rolesListFail=t.data.data)}))});this.$message({message:"成功撤销退回",type:"success"})},revocationPass:function(){for(var t=this,e=this,a=0;a<this.PassSelection.length;a++)this.$axios.post("/apply/update?isPass=0&id="+this.PassSelection[a]).then(function(a){a&&200===a.data.code&&(t.$axios.post("/apply/all?isPass=0").then(function(t){t&&200===t.data.code&&(e.rolesListAll=t.data.data)}),t.$axios.post("/apply/all?isPass=1").then(function(t){t&&200===t.data.code&&(e.rolesListPass=t.data.data)}))});this.$message({message:"成功撤销通过",type:"success"})},refreshing:function(){location.reload()}}},i={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{"text-align":"left"}},[a("br"),a("br"),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px","margin-top":"-80px"},attrs:{type:"primary"},on:{click:t.refreshing}},[t._v("刷新")]),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("p",{staticStyle:{"text-align":"center","font-weight":"bold",color:"#882929"}},[t._v("未通过简历")]),t._v(" "),a("el-table",{staticClass:"fail",staticStyle:{width:"100%","margin-top":"10px",float:"center","text-align":"center"},attrs:{data:t.rolesListFail,height:"500px","header-cell-style":{textAlign:"center"}},on:{"selection-change":t.handleSelectionFail}},[a("el-table-column",{attrs:{type:"selection",width:"40%",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{label:"姓名",width:"100%",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n                    "+t._s(e.row.name)+"\n                    ")]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"时间",width:"100%",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n                    "+t._s(e.row.date)+"\n                    ")]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(a){return t.check(e.row.id)}}},[t._v("简历")])]}}])})],1)],1),t._v(" "),a("el-col",{staticStyle:{"margin-top":"20%","margin-left":"30px"},attrs:{span:3}},[a("el-row",[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.back}},[t._v("﹤退回")])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"10px"}},[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.revocationFail}},[t._v("撤销﹥")])],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("p",{staticStyle:{"text-align":"center","font-weight":"bold",color:"#726f6f","margin-left":"-140px"}},[t._v("未审核简历")]),t._v(" "),a("el-table",{staticStyle:{width:"100%","margin-top":"10px","margin-left":"-70px",float:"center","text-align":"center"},attrs:{data:t.rolesListAll,height:"500px","header-cell-style":{textAlign:"center"}},on:{"selection-change":t.handleSelection}},[a("el-table-column",{attrs:{type:"selection",width:"40%"}}),t._v(" "),a("el-table-column",{attrs:{label:"姓名",width:"100%",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n                    "+t._s(e.row.name)+"\n                    ")]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"时间",width:"100%",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n                    "+t._s(e.row.date)+"\n                    ")]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(a){return t.check(e.row.id)}}},[t._v("简历")])]}}])})],1)],1),t._v(" "),a("el-col",{staticStyle:{"margin-top":"20%","margin-right":"-50px","margin-left":"-20px"},attrs:{span:3}},[a("el-row",[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.pass}},[t._v("通过﹥")])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"10px"}},[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.revocationPass}},[t._v("﹤撤销")])],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("p",{staticStyle:{"text-align":"center","font-weight":"bold",color:"#5e8862"}},[t._v("已通过简历")]),t._v(" "),a("el-table",{staticClass:"pass",staticStyle:{width:"100%","margin-top":"10px",float:"center","text-align":"center"},attrs:{data:t.rolesListPass,height:"500px","header-cell-style":{textAlign:"center"}},on:{"selection-change":t.handleSelectionPass}},[a("el-table-column",{attrs:{type:"selection",width:"40%"}}),t._v(" "),a("el-table-column",{attrs:{label:"姓名",width:"100%",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n                    "+t._s(e.row.name)+"\n                    ")]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"时间",width:"100%",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n                    "+t._s(e.row.date)+"\n                    ")]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(a){return t.check(e.row.id)}}},[t._v("简历")])]}}])})],1)],1)],1)],1)},staticRenderFns:[]};var o=a("VU/8")(n,i,!1,function(t){a("Dxfg")},"data-v-36eb45da",null);e.default=o.exports}});
//# sourceMappingURL=4.25517105d839d8464114.js.map