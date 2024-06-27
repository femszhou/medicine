import request from "@/utils/request"

//定义类型
type First<T>={
    config:T
    data:T
    headers:T
    request:T
    status:number
    statusText:string
}
type Common<T>={
    code:number
    data:T
    msg:string
}
type char<T>={
    rows:T
    total:number
}

export type Menu={
    clientNo:number
    clientName:string
    clientSex:number
    clientAge:number
    clientAddress:string
    clientPhone:string
    clientSymptom:string
    clientDate:string
    clientRemark:string
}

//获取所有信息
export const getClient=(page: number, pageSize: number)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/client",
        params: {
            page,
            pageSize
          }
    })
}

export const getClientByName=(clientName:string)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/client",
        params: {
            clientName
          }
    })
}

export const getClientByNo=(clientNo:number)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/client",
        params: {
            clientNo
          }
    })
}

//按序号查找
export const find =(clientNo:number)=>{
    return request({
        method:"GET",
        url:`/client/${clientNo}`,
    })
}

//添加信息

export type addMenu = Pick<Menu,"clientName"|"clientSex"|"clientAge"|"clientAddress"|"clientPhone"|"clientSymptom"|"clientRemark">

export const addclient = (addInfo:addMenu)=>{
    return request({
        method:"POST",
        url:"/client",
        data:addInfo,
    })
}


//修改药物信息

export type putMenu =Pick<Menu,"clientName"|"clientSex"|"clientAge"|"clientAddress"
|"clientPhone"|"clientSymptom"|"clientRemark"|"clientDate"|"clientNo">
export const getclient = ((clientNo:string) =>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:'/client',
        params:{
            clientNo,
        }
    })
})

export const putclient = ((putInfo:putMenu) =>{
    return request<Common<char<Menu[]>>>({
        method:'PUT',
        url:'/client',
        data:putInfo
    })
})