import request from '@/utils/request'


export function UserHealth(query){
        return request({
            url:'UserHealth',
            method:'get',
            params:query
        });
    }
export function Userattend(query){
        return request({
            url:'UserAttend',
            method:'get',
            params:query
        });
    }

export function GetPoint(query){
    return request({
        url:'GetPoint',
        method:'get',
        params:query
    });
}
