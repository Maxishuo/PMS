import request from '@/utils/request'

export function registerUser(data) {
    return request({
        url: '/registerUser',
        method: 'post',
        data
    })
}
export function loginUser(data) {
    return request({
        url: '/loginUser',
        method: 'post',
        data
    })
}
