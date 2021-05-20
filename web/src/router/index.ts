import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/home.vue'
import About from '../views/about.vue'
import AdminApp from '../views/admin/admin-app.vue'
import AdminHome from '../views/admin/admin-home.vue'
import SponsorHome from '../views/sponsor/sponsor-home.vue'
import UserApp from '../views/user/user-app.vue'
import UserHome from '../views/user/user-home.vue'
import UserHelp from '../views/user/user-help.vue'
import UserRecord from '../views/user/user-record.vue'
import UserContest from '../views/user/user-contest.vue'
import UserDate from '../views/user/user-date.vue'
import UserMessage from '../views/user/user-message.vue'
import UserProfile from '../views/user/user-profile.vue'
import UserSafety from '../views/user/user-safety.vue'
import UserAbout from '../views/user/user-about.vue'
import UserDetails from '../views/user/user-details.vue'
import AdminContest from '../views/admin/admin-contest.vue'
import AdminDiscussion from '../views/admin/admin-discussion.vue'
import AdminNotification from '../views/admin/admin-notification.vue'
import AdminParticipant from '../views/admin/admin-participant.vue'
import AdminTeam from '../views/admin/admin-team.vue'
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
      },{
        path: 'team',
        name: 'AdminTeam',
        component: AdminTeam
      },
    ],
  },
  {
    path: '/sponsor/home',
    name: 'SponsorHome',
    component: SponsorHome
  },
  {
    path: '/user/',
    name: 'UserApp',
    component: UserApp,
    redirect: '/user/home',
    children: [{
      path: 'home',
      name: 'UserHome',
      component: UserHome,
    },{
      path: 'help',
      name: 'UserHelp',
      component: UserHelp,
    },{
      path: 'contest',
      name: 'UserContest',
      component: UserContest,
    },{
      path: 'record',
      name: 'UserRecord',
      component: UserRecord,
    },{
      path: 'date',
      name: 'UserDate',
      component: UserDate,
    },{
      path: 'message',
      name: 'UserMessage',
      component: UserMessage,
    },{
      path: 'profile',
      name: 'UserProfile',
      component: UserProfile,
    },{
      path: 'safety',
      name: 'UserSafety',
      component: UserSafety,
    },{
      path: 'about',
      name: 'UserAbout',
      component: UserAbout,
    },{
      path: 'home',
      name: 'UserHome',
      component: UserHome,
    },{
      path: 'details',
      name: 'UserDetails',
      component: UserDetails,
    },

    ]
  },



]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
