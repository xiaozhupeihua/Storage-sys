import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/display.css'


Vue.use(ElementUI)

import axios from "axios";
Vue.prototype.axios = axios/* 让axios在所有实例中都可以使用 */

import qs from 'qs'
Vue.prototype.qs=qs/* 让qs在所有实例中都可以使用 */

Vue.config.productionTip = false/* 阻止启动生产消息 */

new Vue({
router,
    render: h => h(App)
}).$mount("#app")
