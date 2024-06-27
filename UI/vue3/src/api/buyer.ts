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
    buyerClass:string
    buyerName:string
    buyerNo:number
    buyerPassword:string
    buyerPhone:string
    buyerRemark:string
    buyerSex:number
}

//获取所有采购人员信息
export const getBuyer=(page: number, pageSize: number)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/buyer",
        params: {
            page,
            pageSize
          }
    })
}

export const getBuyerByName=(buyerName:string)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/buyer",
        params: {
            buyerName
          }
    })
}

export const getBuyerByNo=(buyerNo:number)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/buyer",
        params: {
            buyerNo
          }
    })
}



//添加采购人员

export type addMenu = Pick<Menu,"buyerClass"|"buyerName"|"buyerPassword"|"buyerPhone"|"buyerSex"|"buyerRemark">

export const addbuyer = (addInfo:addMenu)=>{
    return request({
        method:"POST",
        url:"/buyer",
        data:addInfo,
    })
}

//删除采购人员
export const delMenu =(buyerNo:number)=>{
    return request({
        method:"DELETE",
        url:`/buyer/${buyerNo}`,
    })
}

//按序号查找
export const find =(buyerNo:number)=>{
    return request({
        method:"GET",
        url:`/buyer/${buyerNo}`,
    })
}

//获取采购人员信息

export type putMenu = Pick<Menu,"buyerNo"|"buyerName"|"buyerClass"|"buyerPhone"|"buyerPassword"|"buyerRemark"|"buyerSex">
export const getbuyer = ((buyerNo:string) =>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:'/buyer',
        params:{
            buyerNo,
        }
    })
})


//修改采购人员信息
export const putbuyer = ((putInfo:putMenu) =>{
    return request<Common<char<Menu[]>>>({
        method:'PUT',
        url:'/buyer',
        data:putInfo
    })
})