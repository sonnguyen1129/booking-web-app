import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)
/* eslint-disable */
export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '*',
      redirect: { name: 'home' }
    },
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (about.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    // },
    {
      path: '/login',
      name: 'login',
      component: () => import('./views/Login.vue')
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('./views/Admin.vue')
    },
    {
      path: '/profile',
      name: 'profile',
      component: () => import('./views/Profile.vue')
    },
    {
      path: '/booked-resource',
      name: 'booked-resource',
      component: () => import('./views/BookedResource.vue')
    },
    {
      path: '/list-room',
      name: 'list-room',
      component: () => import('./views/ListRoom.vue')
    },
    {
      path: '/list-resource',
      name: 'list-resource',
      component: () => import('./views/ListResource.vue')
    },
    {
      path: '/room-detail',
      name: 'room-detail',
      props: (route) => ({
        id: route.query.id
      }),
      component: () => import('./views/RoomDetail.vue')
    },


    // admin
    {
      path: '/admin-home',
      name: 'admin-home',
      props: (route) => ({
        id: route.query.id
      }),
      component: () => import('./views/admin/HomeAdmin.vue')
    },
  ]
})
