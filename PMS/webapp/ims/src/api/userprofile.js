import request from '@/utils/request'


export function userProfile(query){
        return request({
            url:'/userProfile',
            method:'post',
            data:query

        });
}

export function getUserProfile(query){
    return request({
        url:'getUserProfile',
        method:'get',
        params:query
    });
}

