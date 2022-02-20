import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
    },
    {
        path: '/patients',
        name: 'Patients',
        component: () => import(/* webpackChunkName: "Patients" */ '../views/Patients.vue'),
        children: [
            {
                path: ':patientid/:visitid?',
                name: 'PatientDetail',
                component: () => import(/* webpackChunkName: "PatientDetail" */ '../views/PatientDetail.vue'),
            }
        ]
    },
]

const router = new VueRouter({
    routes
})

export default router
