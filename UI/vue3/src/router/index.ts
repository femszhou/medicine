import { createRouter, createWebHistory } from 'vue-router'
import { useTokenStore } from '@/stores/Token'
import component from 'element-plus/es/components/tree-select/src/tree-select-option.mjs'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/login',
      name:"login",
      component: () => import('@/views/login.vue'),
    },
    {
      path:'/text',
      name:"text",
      component: () => import('@/views/text.vue'),
    },
    {
      path: '/',
      component: () => import('@/views/index.vue'),
      meta:{requiresAuth:true},
      children:[
        {
          path:"/",
          component: () => import('@/pages/index.vue'),
        },
        {
          path:"/buyer",
          component: () => import('@/pages/buyer.vue'),
        },
        {
          path:"/buyer/add",
          name:"addbuyer",
          component: () => import('@/pages/addbuyer.vue'),
        },        
        {
          path:"/buyer/:buyerNo",
          name:"buyerEdit",
          component: () => import('@/pages/editbuyer.vue'),
        },
        {
          path:"/operator",
          component: () => import('@/pages/operator.vue'),
        },        {
          path:"/operator/add",
          name:"addoperator",
          component: () => import('@/pages/addoperator.vue'),
        },    
        {
          path:"/operator/:operatorNo",
          name:"operatorEdit",
          component: () => import('@/pages/editoperator.vue'),
        },
      ]
    },
    {
      path:"/buyerindex",
      component: () => import('@/views/Buyer.vue'),
      children:[
        {
          path:"/buyerindex",
          name:"buyerindex",
          component: () => import('@/buyer/index.vue'),
        },
        {
          path:"/medicine/add",
          name:"addmedicine",
          component: () => import('@/buyer/addmedicine.vue'),
        },
        {
          path:"/medicine/:medicineNo",
          name:"medicineEdit",
          component: () => import('@/buyer/editmedicine.vue'),
        }
    ]
    }, 
    {
      path:'/operatorindex',
      component: () => import('@/views/Operator.vue'),
      children:[
        {
          path:'/operatorindex',
          name:"operatorindex",
          component: () => import('@/operator/index.vue')
        },
        {
          path:'/orders/index',
          name:"ordersindex",
          component: () => import('@/operator/orders.vue')
        },
        {
          path:"/orders/add",
          name:"addorders",
          component: () => import('@/operator/addorders.vue'),
        },
        {
          path:"/orders/:ordersNo",
          name:"ordersEdit",
          component: () => import('@/operator/editorders.vue'),
        },
        {
          path:"/orders/shop/:ordersNo",
          name:"shop",
          component: () => import('@/operator/shop.vue'),
        },
        {
          path:"/orders/editshop/:ordersNo",
          name:"editshop",
          component: () => import('@/operator/editshop.vue'),
        },
        {
          path:'/client/index',
          name:"clientindex",
          component: () => import('@/operator/client.vue')
        },        
        {
          path:"/client/add",
          name:"addclient",
          component: () => import('@/operator/addclient.vue'),
        },
        {
          path:"/client/:clientNo",
          name:"clientEdit",
          component: () => import('@/operator/editclient.vue'),
        }
      ]
    },
    { 
      path: '/:pathMatch(.*)*',
      name: 'NotFound',
      component: () => import('@/views/404.vue')
    },
  ]
})

router .beforeEach((to,from,next)=>{
  if(to.matched.some(r=>r.meta?.requiresAuth)){
    const store=useTokenStore()
    if(!store.token){
      next({name:"login"})
      return
    }
  }
  next()
})
export default router
