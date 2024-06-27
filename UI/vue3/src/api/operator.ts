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
    operatorClass:string
    operatorName:string
    operatorNo:number
    operatorPassword:string
    operatorPhone:string
    operatorRemark:string
    operatorSex:number
}

//获取所有经办人员信息
export const getOperator=(page: number, pageSize: number)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/operator",
        params: {
            page,
            pageSize
          }
    })
}

export const getOperatorByName=(operatorName:string)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/operator",
        params: {
            operatorName
          }
    })
}

export const getOperatorByNo=(operatorNo:number)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/operator",
        params: {
            operatorNo
          }
    })
}

//按序号查找
export const find =(operatorNo:number)=>{
    return request({
        method:"GET",
        url:`/operator/${operatorNo}`,
    })
}

//添加经办人员

export type addMenu = Pick<Menu,"operatorClass"|"operatorName"|"operatorPassword"|"operatorPhone"|"operatorSex"|"operatorRemark">

export const addoperator = (addInfo:addMenu)=>{
    return request({
        method:"POST",
        url:"/operator",
        data:addInfo,
    })
}

//删除经办人员
export const delMenu =((operatorNo:number)=>{
    return request({
        method:"DELETE",
        url:`/operator/${operatorNo}`,
    })
})

//修改经办人员信息

export type putMenu = Pick<Menu,"operatorNo"|"operatorName"|"operatorClass"|"operatorPhone"|"operatorPassword"|"operatorRemark"|"operatorSex">
export const getoperator = ((operatorNo:string) =>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:'/operator',
        params:{
            operatorNo,
        }
    })
})

export const putoperator = ((putInfo:putMenu) =>{
    return request<Common<char<Menu[]>>>({
        method:'PUT',
        url:'/operator',
        data:putInfo
    })
})