import request from '@/utils/request'


export function  redeemedPoints(query){
        return request({
            url:'redeemedPoints',
            method:'get',
            params:query
        });
    }
export function  ratingFunction(query){
        return request({
            url:'ratingFunction',
            method:'get',
            params:query
        });
    }