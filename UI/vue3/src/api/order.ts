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
    ordersNo:number
    clientNo:number
    ordersDate:string
    medicineNo:number
    operatorNo:number
    medicineList:[]
    totalPrice:number
}

export type Cart={
    medicineOrdersNo:number
    medicineNo:number
    ordersNo:number
    medicineName:string
    medicineImage:string
    medicineMode:string
    medicineEfficacy:string
    medicineNumber:number
    price:number
    medicineCount:number
}


export const getOrders = (page: number, pageSize: number) => {
    return request<Common<char<Menu[]>>>({
      method: 'GET',
      url: '/orders',
      params: {
        page,
        pageSize
      }
    })
}
export const getOrdersByNo=(ordersNo:number)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/orders",
        params: {
            ordersNo
          }
    })
}

//按序号查找
export const find =(ordersNo:number)=>{
    return request({
        method:"GET",
        url:`/orders/${ordersNo}`,
    })
}

//购物车
export type shoppingCart = Pick<Cart,"medicineOrdersNo"|"medicineCount"|"medicineEfficacy"|"medicineImage"|"medicineMode"|"medicineName"
|"medicineNo"|"medicineNumber"|"price"|"ordersNo">
export const shopping = ((ordersNo:string) =>{
    return request<Common<Cart[]>>({
        method:'GET',
        url:'/shoppingCart/list',
        params:{
            ordersNo,
        }
    })
})

//添加购物车
export const addshop = (ordersNo:string,medicineNo:string,price:string) => {
    return request<Common<any>>({
      method: 'POST',
      url: '/shoppingCart/add',
      data:{
        ordersNo,
        medicineNo,
        price
    }
    })
}

export const subshop = (ordersNo:string,medicineNo: string,price:string) => {
    return request<Common<any>>({
      method: 'DELETE',
      url: '/shoppingCart/sub',
      data: { 
        ordersNo,
        medicineNo,
        price
        }
    })
}

//添加信息

export type addMenu = Pick<Menu,"clientNo"|"operatorNo"|"totalPrice"|"medicineList">

export const addorders = (addInfo:addMenu)=>{
    return request({
        method:"POST",
        url:"/orders",
        data:addInfo,
    })
}


//修改药物信息

export type putMenu = Pick<Menu,"ordersNo"|"clientNo"|"ordersDate"|"medicineNo"|"operatorNo">
export const getorders = ((ordersNo:string) =>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:'/orders',
        params:{
            ordersNo,
        }
    })
})

export const putorders = ((putInfo:putMenu) =>{
    return request<Common<char<Menu[]>>>({
        method:'PUT',
        url:'/orders',
        data:putInfo
    })
})