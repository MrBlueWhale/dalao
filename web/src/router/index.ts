import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/home.vue'
import About from '../views/about.vue'
import AdminApp from '../views/admin/admin-app.vue'
import AdminHome from '../views/admin/admin-home.vue'
import AdminContest from '../views/admin/admin-contest.vue'
import AdminDiscussion from '../views/admin/admin-discussion.vue'
import AdminNotification from '../views/admin/admin-notification.vue'
import AdminParticipant from '../views/admin/admin-participant.vue'
import AdminSponsor from '../views/admin/admin-sponsor.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/about.vue')
  },
  {
    path: '/admin/',
    name: 'AdminApp',
    component: AdminApp,
    redirect: '/admin/home',
    children: [
      {
        path: 'home',
        name: 'AdminHome',
        component: AdminHome
      },
      {
        path: 'contest',
        name: 'AdminContest',
        component: AdminContest
      },  {
        path: 'discussion',
        name: 'AdminDiscussion',
        component: AdminDiscussion
      },  {
        path: 'notification',
        name: 'AdminNotification',
        component: AdminNotification
      },  {
        path: 'participant',
        name: 'AdminParticipant',
        component: AdminParticipant
      },  {
        path: 'sponsor',
        name: 'AdminSponsor',
        component: AdminSponsor
      },
    ],
  },



]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
