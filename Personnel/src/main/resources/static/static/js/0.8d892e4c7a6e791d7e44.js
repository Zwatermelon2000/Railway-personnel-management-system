webpackJsonp([0],{Af1W:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=i("ZQ6q"),n=i.n(a),o={computed:{username:function(){return n.a.get("id")}},data:function(){return{activeNames:[0],accordion:!0,role:{id:"",title:"",person:"",date:"",notice:""},routes:[],rolesList:[{title:"1",person:"2",date:"3",notice:"4"},{title:"1",person:"2",date:"3444-44-44 44:44:44",notice:"4"}]}},mounted:function(){this.initNotice()},methods:{initNotice:function(){var t=this;this.$axios.post("/notice/all").then(function(e){e&&200===e.data.code&&(t.rolesList=e.data.data)})},refreshing:function(){location.reload()}}},s={render:function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticStyle:{"text-align":"left"}},[i("br"),i("br"),t._v(" "),i("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.refreshing}},[t._v("刷新")]),t._v(" "),i("p",{staticStyle:{"text-align":"center","font-weight":"bold",color:"#726f6f","font-size":"2rem"}},[t._v("公 告 栏")]),t._v(" "),i("br"),t._v(" "),t._l(t.rolesList,function(e,a){return i("el-collapse",{key:a,staticClass:"notice",staticStyle:{width:"1200px"},attrs:{accordion:t.accordion,"accordion:true":""},model:{value:t.activeNames,callback:function(e){t.activeNames=e},expression:"activeNames"}},[i("el-collapse-item",{key:a,attrs:{name:a,disabled:t.disable}},[i("template",{slot:"title"},[i("el-col",{attrs:{span:12}},[t._v("\n          "+t._s(e.title)+"\n        ")]),t._v(" "),i("el-col",{attrs:{span:3,offset:6}},[i("i",{staticClass:"header-icon el-icon-user"}),t._v(" "+t._s(e.person)+"\n        ")]),t._v(" "),i("el-col",{staticStyle:{color:"#9c9a9a"},attrs:{span:4}},[i("i",{staticClass:"header-icon el-icon-date"}),t._v(" "+t._s(e.date)+"  \n        ")])],1),t._v(" "),i("div",{staticStyle:{"margin-top":"10px"}},[t._v(t._s(e.notice))])],2)],1)})],2)},staticRenderFns:[]};var c=i("VU/8")(o,s,!1,function(t){i("Rs4y")},"data-v-26f035fe",null);e.default=c.exports},Rs4y:function(t,e){}});
//# sourceMappingURL=0.8d892e4c7a6e791d7e44.js.map