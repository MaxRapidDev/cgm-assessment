import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from './router'
import CKEditor from '@ckeditor/ckeditor5-vue2';
import api from "@/api/v1/api";

Vue.config.productionTip = false

Vue.use( CKEditor );

Vue.prototype.$api=api;
Date.prototype.toJSON=function(){
  return this.toISOString().substring(0,19)
}

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
