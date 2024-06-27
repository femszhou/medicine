import request from "@/utils/request"

//用户请求登录

//数据请求类型
type LoginInfo={
    administratorPhone:string
    administratorPassword:string
}

type BuyerLoginInfo={
    buyerPhone:string
    buyerPassword:string
}

type OperatorLoginInfo={
    operatorPhone:string
    operatorPassword:string
}

export const login=(loginInfo:LoginInfo)=>{
    return request({
        method:"POST",
        url:"/administratorLogin",
        data:loginInfo,
    })
}

export const buyerlogin=(buyerloginInfo:BuyerLoginInfo)=>{
    return request({
        method:"POST",
        url:"/buyerLogin",
        data:buyerloginInfo,
    })
}

export const operatorlogin=(operatorloginInfo:OperatorLoginInfo)=>{
    return request({
        method:"POST",
        url:"/operatorLogin",
        data:operatorloginInfo,
    })
}
