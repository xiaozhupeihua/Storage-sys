import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/index'
import HelloWorld from "../components/HelloWorld";

Vue.use(VueRouter)
/*命名路由*/
const router = new VueRouter({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: "/index",
      name: "Index",
      component: Index
    }
  ]
})

export default router
