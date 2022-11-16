import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/store'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Layout',
        component: () => import('../views/Layout.vue'),
        redirect: '/home',
        children: [
            { path: 'home', name: '首页', component: () => import('../views/Home.vue'), },
            { path: 'bodyData', name: '学生信息管理', component: () => import('../views/BodyData.vue'), }
        ]
    },
    /*{
      path: '/**',
      name: '**',
      component: () => import(/!* webpackChunkName: "about" *!/ '../views/**.vue')
    },*/
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
    localStorage.setItem("currentPathName", to.name)  // 设置当前的路由名称，为了在Header组件中去使用
    store.commit("setPath")  // 触发store的数据更新
    next()  // 放行路由
})

export default router
