// store.js

import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        // 定义你的全局状态
        globalId: 0,

    },
    mutations: {
        setId(state, id) {
            state.globalId = id;
        }
    },
    getters: {
        getId(state) {
            return state.globalId;
        }
    }
});


